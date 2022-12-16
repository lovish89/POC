package com.way2.Poc;

import java.io.IOException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import dataProvider.CommanDP;
import utils.ExcelUtils;
import utils.SeleniumUtils;

public class AddCustomerWithDP extends TestBaseClass {
	
	SeleniumUtils sel = null;
	
	@BeforeClass
	public void preRequ() {
		sel = new SeleniumUtils();
		sel.click(OR.getProperty("btn_bankManagerLogin"));
	}
	
	@Test(enabled = true,dataProvider = "inputData",dataProviderClass = CommanDP.class)
	public void addCustomer(String Srno, String fn,String ln, String pc) throws IOException {
		Reporter.log("Adding Customer");
		
		sel.click(OR.getProperty("btn_addCustomer"));
		sel.sendText(OR.getProperty("txt_FirstName"), fn);
		sel.sendText(OR.getProperty("txt_LastName"), ln);
		sel.sendText(OR.getProperty("txt_postCode"), pc);
		
		sel.takeScreenShot();
		
		sel.click(OR.getProperty("btn_submit"));
		
	
		
		/*
		 * driver.findElement(By.xpath(OR.getProperty("btn_bankManagerLogin"))).click();
		 * driver.findElement(By.xpath(OR.getProperty("btn_addCustomer"))).click();
		 * driver.findElement(By.xpath(OR.getProperty("txt_FirstName"))).sendKeys(
		 * "Lovish");
		 * driver.findElement(By.xpath(OR.getProperty("txt_LastName"))).sendKeys(
		 * "Bansal");
		 * driver.findElement(By.xpath(OR.getProperty("txt_postCode"))).sendKeys(
		 * "151001");
		 * driver.findElement(By.xpath(OR.getProperty("btn_submit"))).click();
		 */
		
		try {
		wait.until(ExpectedConditions.alertIsPresent());
		Alert alert = driver.switchTo().alert();
		String alertText = alert.getText();
		String expected = "Customer added successfully";
		alert.accept();
		if (alertText.contains(expected)) {
			Assert.assertTrue(true, "Successfully Reg");
			Reporter.log("Customer added successfully");
			
		}else {
			
			Assert.assertTrue(false, "Reg Failed");
			Reporter.log("Reg Failed");
		
		}
			
		}catch(Exception e) {
			
			System.out.println("No alert , So Reg Failed");
			Assert.assertTrue(false, "Reg Failed");
			Reporter.log("Reg Failed");
			
		}
		
		
		

	}
	
	
	
	@Test(dependsOnMethods = "addCustomer",enabled = true,dataProvider = "inputData",dataProviderClass = CommanDP.class)
	public void openAccount(String Srno, String fn,String ln, String pc) throws IOException {
		sel.click(OR.getProperty("btn_openAccount"));
		sel.selectValueFromDropDown(OR.getProperty("dd_selectCustomer"), fn+" "+ln, "vt");
		sel.selectValueFromDropDown(OR.getProperty("dd_currency"), "3", "index");
		
		sel.takeScreenShot();
		
		sel.click(OR.getProperty("btn_process"));
		
	
		
		
		//driver.findElement(By.xpath(OR.getProperty("btn_openAccount"))).click();
		//Select users = new Select(driver.findElement(By.xpath(OR.getProperty("dd_selectCustomer"))));
		//users.selectByVisibleText("Lovish Bansal");
		
		//Select currency = new Select(driver.findElement(By.xpath(OR.getProperty("dd_currency"))));
	//	currency.selectByIndex(3);
		
	//	driver.findElement(By.xpath(OR.getProperty("btn_process"))).click();
		
		try {
			wait.until(ExpectedConditions.alertIsPresent());
			Alert alert = driver.switchTo().alert();
			String alertText = alert.getText();
			String expected = "Account created successfully";
			alert.accept();
			if (alertText.contains(expected)) {
				Assert.assertTrue(true, "Account created successfully");
				
			}else {
				
				Assert.assertTrue(false, "Account creation Failed");
				
			}
				
			}catch(Exception e) {
				
				System.out.println("No alert , So Account creation Failed");
				Assert.assertTrue(false, "Account creation Failed");
			}
		
		
		
	}

	
	/*
	 * @DataProvider public Object[][] inputData() throws IOException{ ExcelUtils
	 * excelUtils = new ExcelUtils(); Object[][] excelData = excelUtils.readExcel();
	 * for(int i =0;i<excelData.length;i++) { for(int j
	 * =0;j<excelData[i].length;j++) { System.out.println(excelData[i][j]); } }
	 * 
	 * return excelData; }
	 */
	
	
}
