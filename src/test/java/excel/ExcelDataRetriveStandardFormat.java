package excel;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataRetriveStandardFormat {

	Workbook wb;

	public ExcelDataRetriveStandardFormat(String path) throws IOException {
		File src = new File(path);
		FileInputStream file = new FileInputStream(path);
		wb = WorkbookFactory.create(file);
	}

	public String getData(String sheetName, int row, int cell) {
		String data = wb.getSheet(sheetName).getRow(row).getCell(cell).getStringCellValue();

		return data;
	}

	public static void main(String[] args) throws IOException {

		ExcelDataRetriveStandardFormat excel = new ExcelDataRetriveStandardFormat("./files/poi.xlsx"); // inside the constructor add your excel file path
		String data = excel.getData("Sheet1", 0, 1);
		System.out.println(data);

	}

}
