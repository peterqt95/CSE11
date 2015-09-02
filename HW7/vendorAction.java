import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JFileChooser;
import org.apache.poi.POIXMLException;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;

/**
 * Vendor button action that reads in the .xlsx content only if it contains an
 * SKU and MAP and assigns it to a corresponding array
 * 
 * @author peter
 *
 */
public class vendorAction implements ActionListener {

	/**
	 * Checks to see if the String check is present in the first row of the
	 * sheet
	 * 
	 * @param sheet
	 *            - XSSFSheet of master file
	 * @param check
	 *            - String that will determine if file is valid
	 * @return boolean - true if check is in file, false otherwise
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
	 * @return int - location where check appears in file
	 */
	public int getLocation(String check) {
		for (int i = 0; i < Excel.vendor.get(0).getLastCellNum(); i++) {
			if (Excel.vendor.get(0).getCell(i).getRichStringCellValue()
					.getString().equals(check)) {
				return i;
			}
		}
		return 0;
	}

	/**
	 * Selects file location of the vendor file and saves its content to an
	 * ArrayList
	 */
	public void actionPerformed(ActionEvent e) {
		JFileChooser fc = new JFileChooser();
		int returnVal = fc.showOpenDialog(null);
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			Excel.vendorLocation
					.setText(fc.getSelectedFile().getAbsolutePath());

			try {
				FileInputStream file = new FileInputStream(fc.getSelectedFile());
				XSSFWorkbook vendorBook = new XSSFWorkbook(file);
				XSSFSheet vendorSheet = vendorBook.getSheetAt(0);
				Excel.vendor = new ArrayList<Row>();
				boolean sku = false;
				boolean map = false;

				// Checks if sheet is valid by seeing if there is an SKU and MAP
				sku = validFile(vendorSheet, "SKU");
				map = validFile(vendorSheet, "MAP");

				if (!sku || !map) {
					vendorBook.close();
					throw new IOException();
				}

				// Fill the array with the sheet's content and then
				// find and save the MAP and SKU location of the master file
				int maxRow = vendorSheet.getLastRowNum();
				for (int i = 0; i <= maxRow; i++) {
					Excel.vendor.add(vendorSheet.getRow(i));
				}

				Excel.vskuLocation = getLocation("SKU");
				Excel.vmapLocation = getLocation("MAP");

				file.close();
				vendorBook.close();
			}

			catch (POIXMLException poi) {
				Excel.vendorLocation.setText("Invalid file type, choose .xlsx");
			} catch (FileNotFoundException f) {
				Excel.vendorLocation.setText("File not found");
			} catch (IOException io) {
				Excel.vendorLocation.setText("Incorrect file format");
			} catch (IllegalStateException text) {
				Excel.vendorLocation.setText("Incorrect file format");
			}

		}
	}
}
