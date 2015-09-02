import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import org.apache.poi.POIXMLException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import javax.swing.JFileChooser;

/**
 * Master button action that reads in the .xlsx content only if it contains an
 * SKU and MAP and assigns it to a corresponding array
 * 
 * @author peter
 *
 */
public class masterAction implements ActionListener {

	/**
	 * Checks to see if the String check is present in the first row of the
	 * sheet
	 * 
	 * @param sheet
	 *            - XSSFSheet of master file
	 * @param check
	 *            - String that will determine if file is valid
	 * @return boolean - true if check is located in file, false otherwise
	 */
	public boolean validFile(XSSFSheet sheet, String check) {
		for (int i = 0; i < sheet.getRow(0).getLastCellNum(); i++) {
			if (sheet.getRow(0).getCell(i).getRichStringCellValue().getString()
					.equals(check)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Saves the location of the String check that is present in the first row
	 * 
	 * @param check
	 *            - String that determines validity of file
	 * @return int - location of check in the file
	 */
	public int getLocation(String check) {
		for (int i = 0; i < Excel.master.get(0).getLastCellNum(); i++) {
			if (Excel.master.get(0).getCell(i).getRichStringCellValue()
					.getString().equals(check)) {
				return i;
			}
		}
		return 0;
	}

	/**
	 * Selects file location of the master file and saves its content to an
	 * ArrayList
	 */
	public void actionPerformed(ActionEvent e) {
		JFileChooser fc = new JFileChooser();
		int returnVal = fc.showOpenDialog(null);
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			Excel.masterLocation
					.setText(fc.getSelectedFile().getAbsolutePath());

			try {
				FileInputStream file = new FileInputStream(fc.getSelectedFile());
				XSSFWorkbook workbook = new XSSFWorkbook(file);
				XSSFSheet sheet = workbook.getSheetAt(0);
				Excel.master = new ArrayList<Row>();
				boolean sku = false;
				boolean map = false;

				// Checks if sheet is valid by seeing if there is an SKU and MAP
				sku = validFile(sheet, "SKU");
				map = validFile(sheet, "MAP");

				if (!sku || !map) {
					workbook.close();
					throw new IOException();
				}

				// Fill the array with the sheet's content and then
				// find and save the MAP and SKU location of the master file
				int maxRow = sheet.getLastRowNum();
				for (int i = 0; i <= maxRow; i++) {
					Excel.master.add(sheet.getRow(i));
					Excel.output.add(sheet.getRow(i));
				}

				Excel.mskuLocation = getLocation("SKU");
				Excel.mmapLocation = getLocation("MAP");

				file.close();
				workbook.close();

			} catch (POIXMLException poi) {
				Excel.masterLocation.setText("Invalid file type, choose .xlsx");
			} catch (FileNotFoundException f) {
				Excel.masterLocation.setText("File not found");
			} catch (IOException io) {
				Excel.masterLocation.setText("Incorrect file format");
			} catch (IllegalStateException text) {
				Excel.masterLocation.setText("Incorrect file format");
			}

		}

	}
}
