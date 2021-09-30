package excel;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class getAllExcelData {
	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		
		
		FileInputStream file = new FileInputStream("./files/poi.xlsx");
		
		Workbook wb = WorkbookFactory.create(file);  //present in apache.poi
		Sheet sheet = wb.getSheet("Sheet1");
		int totalNumOfROw = sheet.getLastRowNum();  //it will give total num of rows in sheet1

		for (int i = 0; i < totalNumOfROw; i++)  // this loop is for rows
		{
			int TotalNumOfCell = sheet.getRow(i).getLastCellNum(); // it will give total num of cell in specific row
		
			for (int j = 0; j < TotalNumOfCell; j++) //this loop is for cells
			{
				String AllData = sheet.getRow(i).getCell(j).getStringCellValue();
				System.out.print(" " + AllData);
			}
			System.out.println();
		}

	}

}
