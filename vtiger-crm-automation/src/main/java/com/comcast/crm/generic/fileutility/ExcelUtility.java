package com.comcast.crm.generic.fileutility;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility {

	public String getDataFromExcelFile(String SName, int RNumber, int CNumber)
			throws EncryptedDocumentException, IOException {
		FileInputStream file = new FileInputStream("./testScriptData/commondata.xlsx");
		Workbook wb = WorkbookFactory.create(file);
		Sheet sh = wb.getSheet(SName);
		Row row = sh.getRow(RNumber);
		String Data = row.getCell(CNumber).toString();
		wb.close();
		return Data;
	}

	public int getRowCount(String sheetName) throws IOException {
		FileInputStream file = new FileInputStream("./testScriptData/commondata.xlsx");
		Workbook Wb = WorkbookFactory.create(file);
		int RowCount = Wb.getSheet(sheetName).getLastRowNum();
		return RowCount;
	}

	
}
