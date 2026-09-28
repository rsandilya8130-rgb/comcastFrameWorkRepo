package DDT_extra;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class GetDataFromExcelFile {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		//Step 1 create the java rep object of the physical file
		FileInputStream fis = new FileInputStream("./src/test/resources/commondata.xlsx");
		
		
		//Step 2 get the access of workbook
		Workbook wb =	WorkbookFactory.create(fis);
		
		
		//Step 3 get the access of sheet
		Sheet sh = wb.getSheet("Sheets");
		
		
		//Step 4 get the access of row 
		Row row = sh.getRow(0);
		
		
		//Step 5 get the access of cell
		Cell cell = row.getCell(0);
		
		
		// Step 6 get the value
		String value = cell.getStringCellValue();
		
		
		System.out.println(value);
		
		
		//Step 7 don't forget to close the workbook
		wb.close();

	}

}
