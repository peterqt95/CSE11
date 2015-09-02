import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * runProduct button action that takes in the .xlsx files entered from using the
 * master and vendor button and outputs a new .xlsx file in the selected
 * directory with two sheets. The first sheet contains the original information
 * and the second sheet containing the updated sheet.
 * 
 * @author peter
 *
 */
public class runAction implements ActionListener {

	/**
	 * Prints out the current sheet into the XSSFWorkbook
	 * 
	 * @param sheet
	 *            - XSSFSheet current sheet used
	 * @param index
	 *            - int value for the index to stop reading in data
	 */
	public void printOut(XSSFSheet sheet, int index) {
		Row row;
		for (int i = 0; i < Excel.output.size(); i++) {
			row = sheet.createRow(i);
			for (int j = 0; j < index; j++) {
				switch (Excel.output.get(i).getCell(j).getCellType()) {
				case Cell.CELL_TYPE_STRING:
					row.createCell(j).setCellValue(
							Excel.output.get(i).getCell(j)
									.getRichStringCellValue().getString());
					break;
				case Cell.CELL_TYPE_NUMERIC:
					row.createCell(j).setCellValue(
							Excel.output.get(i).getCell(j)
									.getNumericCellValue());
					break;
				case Cell.CELL_TYPE_FORMULA:
					row.createCell(j).setCellFormula(
							Excel.output.get(i).getCell(j).getCellFormula());
					break;
				}
			}

		}
		for (int i = 0; i < index; i++) {
			sheet.autoSizeColumn(i);
		}
	}

	/**
	 * Adds the last column named Details to the updatedMaster sheet and then
	 * cycles through the data from the master and vendor sheet and updating the
	 * MAP and SKU
	 * 
	 */
	public void createDetails() {
		String msku = "";
		String vsku = "";
		double mmap = 0;
		double vmap = 0;

		int lastCell = Excel.output.get(0).getLastCellNum();
		for (int i = 0; i < Excel.output.size(); i++) {
			Excel.output.get(i).createCell(lastCell);
		}
		Excel.output.get(0).getCell(lastCell).setCellValue("Details");

		for (int i = 1; i < Excel.master.size(); i++) {
			for (int j = 1; j < Excel.vendor.size(); j++) {
				msku = Excel.master.get(i).getCell(Excel.mskuLocation)
						.getRichStringCellValue().getString();
				vsku = Excel.vendor.get(j).getCell(Excel.vskuLocation)
						.getRichStringCellValue().getString();
				mmap = Excel.master.get(i).getCell(Excel.mmapLocation)
						.getNumericCellValue();
				vmap = Excel.vendor.get(j).getCell(Excel.vmapLocation)
						.getNumericCellValue();
				if (msku.equals(vsku)) {
					Excel.output.get(i).getCell(Excel.mmapLocation)
							.setCellValue(vmap);
					if (mmap > vmap) {
						Excel.output.get(i).getCell(lastCell)
								.setCellValue("MAP Decreased");
					} else if (mmap < vmap) {
						Excel.output.get(i).getCell(lastCell)
								.setCellValue("MAP Increased");
					} else {
						Excel.output.get(i).getCell(lastCell)
								.setCellValue("MAP Unchanged");
					}
				}
			}
			if (Excel.output.get(i).getCell(lastCell).getCellType() == Cell.CELL_TYPE_BLANK) {
				Excel.output.get(i).getCell(lastCell).setCellValue("Not found");
			}
		}
	}

	/**
	 * Prints out and updates text field next to "Run" button when updating is
	 * complete.
	 */
	public void actionPerformed(ActionEvent e) {

		try {
			XSSFWorkbook output = new XSSFWorkbook();
			XSSFSheet sheetOrig = output.createSheet("Original Sheet");
			XSSFSheet sheetOut = output.createSheet("Updated Sheet");

			// Creates new "Details" tab and assigns it the new contents
			createDetails();

			// Creates the original master sheet to the first sheet of the new
			// file and the updated master sheet to the second sheet of the new
			// file

			printOut(sheetOrig, Excel.output.get(0).getLastCellNum() - 1);
			printOut(sheetOut, Excel.output.get(0).getLastCellNum());

			// Writes out the file to the selected location
			FileOutputStream out = new FileOutputStream(new File(
					Excel.outLocation + "//updatedMaster.xlsx"));
			output.write(out);
			Excel.runProduct.setText("Complete!");
			out.close();
			output.close();
		} catch (IndexOutOfBoundsException bounds) {
			Excel.runProduct.setText("Empty master or vendor file");
		} catch (FileNotFoundException f) {
			Excel.runProduct.setText("No output location chosen");
		} catch (IOException io) {
			Excel.runProduct.setText("Invalid input");
		}
	}
}
