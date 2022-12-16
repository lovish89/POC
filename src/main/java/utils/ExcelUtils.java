package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {
	public Object[][] readExcel() throws IOException {
		File file = new File(System.getProperty("user.dir") + "\\src\\main\\resources\\excel\\input.xlsx");
		
		FileInputStream fis = new FileInputStream(file);
		// XSSFWorkbook wb = new XSSFWorkbook(fis);
		Workbook wb = new XSSFWorkbook(fis);
		Sheet sh = wb.getSheetAt(0);
		int rowCount = sh.getLastRowNum();
		Row headerRow = sh.getRow(0);
		int colCount = headerRow.getLastCellNum();
		Object excelObj[][] = new Object[rowCount][colCount];
		for (int i = 1; i <= rowCount; i++) {
			
			Row rowdata = sh.getRow(i);

			for (int j = 0; j < colCount; j++) {

				Cell cell = rowdata.getCell(j);
				excelObj[i-1][j] = cell.getStringCellValue();

			}
		

		}
		
		
		
		return excelObj;

	}

}
