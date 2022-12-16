package dataProvider;

import java.io.IOException;

import org.testng.annotations.DataProvider;

import utils.ExcelUtils;

public class CommanDP {
	
	
	
	@DataProvider
	public Object[][] inputData() throws IOException{
		ExcelUtils excelUtils = new ExcelUtils();
		Object[][] excelData = excelUtils.readExcel();
		for(int i =0;i<excelData.length;i++) {
				for(int j =0;j<excelData[i].length;j++) {
					System.out.println(excelData[i][j]);
				}
			}
		
		return excelData;
		}

}
