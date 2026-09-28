package DDT_Practice;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Excel_Extra {

	public static void main(String[] args) throws EncryptedDocumentException, IOException  {
		// Step 1  : get the Excel path location and java object of the physical Excelfile...
		FileInputStream fis = new FileInputStream("C:\\Users\\YINFO\\OneDrive\\Desktop\\TestScriptData.xlsx");
		// Step 2 : open workbook in read mode 
		Workbook wb = WorkbookFactory.create(fis);
		// Step 3 : get the control of the sheet
		Sheet sh = wb.getSheet("Mobile");
		// Step 4 : get the control of the Row
		Row ro = sh.getRow(0);
		// Step 5 : Get the control of the Cell 
		Cell cl = ro.getCell(0);
		// Step 6 Get the value  form cell 
	//	 String  value = cl.toString();
		String value = cl.getStringCellValue();
		
		System.out.println(value);
		wb.close();
	}

}
