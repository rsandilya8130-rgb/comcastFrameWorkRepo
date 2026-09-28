package DDT_Practice;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadDataBackToExcelTest {
	
	public static void main(String[] args) throws EncryptedDocumentException, IOException {

		FileInputStream fis = new FileInputStream("C:\\Users\\YINFO\\OneDrive\\Desktop\\TestScriptData.xlsx");

		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet("TestScriptData");
		Row ro = sh.getRow(1);
		Cell cl = ro.createCell(4);
		cl.setCellType(CellType.STRING);
		cl.setCellValue("PASS");
		
		FileOutputStream fos = new FileOutputStream("C:\\\\Users\\\\YINFO\\\\OneDrive\\\\Desktop\\\\TestScriptData.xlsx");
		wb.write(fos);
		wb.close();
		System.out.println("Program is completed");
		
	}
}
