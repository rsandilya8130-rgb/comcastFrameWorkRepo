package DDT_Practice;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class GetMultipleDataFromExcel {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {

		FileInputStream fis = new FileInputStream("C:\\Users\\YINFO\\OneDrive\\Desktop\\TestScriptData.xlsx");

		Workbook wb = WorkbookFactory.create(fis);

		Sheet sh = wb.getSheet("Mobile");
		int rowCount = sh.getLastRowNum();

		for (int i = 1; i <= rowCount; i++) {
			Row ro = sh.getRow(i);
			String value0 = ro.getCell(0).toString();
			String value = ro.getCell(1).toString();
			System.out.println(value0 + "\t" + value);
		}
		wb.close();
	}
}
