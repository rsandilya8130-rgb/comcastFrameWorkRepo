package DDT_Practice;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class GetExcelDataWithCondition {
	
	public static void main(String[] args) throws EncryptedDocumentException, IOException {
         String ExpectedCondition = "Tc_02";
         String data1 = "";
         String data2 = "";
         String data3 = "";
         boolean flag = false;
      
		FileInputStream fis = new FileInputStream("C:\\Users\\YINFO\\OneDrive\\Desktop\\TestScriptData.xlsx");

		Workbook wb = WorkbookFactory.create(fis);

		Sheet sh = wb.getSheet("TestScriptData");
		int rowCount = sh.getLastRowNum();
		for(int i = 0; i<=rowCount;i++) {
			   String data = "";
			try {
			data = sh.getRow(i).getCell(0).toString();
			if(data.equals(ExpectedCondition)) {
				flag = true;
				data1 = sh.getRow(i).getCell(1).toString();
				data2 = sh.getRow(i).getCell(2).toString();
				data3 = sh.getRow(i).getCell(3).toString();
			}
			}catch(Exception e) {
				
			}
			//System.out.println(data);
		}
		if(flag==true) {
			System.out.println(data1+"\t"+data2+"\t"+data3);
		}else {
			System.out.println(ExpectedCondition+" data is not available");
		}

		wb.close();
	}

}
