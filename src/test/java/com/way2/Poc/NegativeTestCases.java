package com.way2.Poc;

import java.io.IOException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import dataProvider.CommanDP;
import utils.SeleniumUtils;

public class NegativeTestCases extends TestBaseClass {

	SeleniumUtils sel = null;

	@BeforeClass
	public void preRequ() {
		sel = new SeleniumUtils();
	//	sel.click(OR.getProperty("btn_bankManagerLogin"));
	}
	@Test(dataProvider = "inputData",dataProviderClass = CommanDP.class)
	public void emptyFirstName(String sn,String fn, String ln, String pc) throws IOException {

		Reporter.log("Adding Customer Without First Name");
		
		sel.click(OR.getProperty("btn_addCustomer"));
		
		sel.clearTextBox(OR.getProperty("txt_FirstName"));
		// sel.sendText(OR.getProperty("txt_FirstName"), fn);
		
		sel.clearTextBox(OR.getProperty("txt_LastName"));
		
		sel.sendText(OR.getProperty("txt_LastName"), ln);
		
		sel.clearTextBox(OR.getProperty("txt_postCode"));
		
		sel.sendText(OR.getProperty("txt_postCode"), pc);

		sel.takeScreenShot();
		

		sel.click(OR.getProperty("btn_submit"));
	
		
		try {
			wait.until(ExpectedConditions.alertIsPresent());
			Alert alert = driver.switchTo().alert();
			Assert.assertTrue(false, "Case Failed due to alert present");
			
			
				
			}catch(Exception e) {
				
				Assert.assertTrue(true, "Reg Failed as Expected");
				Reporter.log("Reg Failed as Expected");
				
			}

	}

	@Test(dataProvider = "inputData",dataProviderClass = CommanDP.class)
	public void emptyLastName(String sn,String fn, String ln, String pc) throws IOException {
		
		
		Reporter.log("Adding Customer Without Last Name");

		sel.click(OR.getProperty("btn_addCustomer"));
		
		sel.clearTextBox(OR.getProperty("txt_FirstName"));
		
		sel.sendText(OR.getProperty("txt_FirstName"), fn);
		
		sel.clearTextBox(OR.getProperty("txt_LastName"));
	//	sel.sendText(OR.getProperty("txt_LastName"), ln);
		sel.clearTextBox(OR.getProperty("txt_postCode"));
		
		sel.sendText(OR.getProperty("txt_postCode"), pc);

		sel.takeScreenShot();

		sel.click(OR.getProperty("btn_submit"));
		
		try {
			wait.until(ExpectedConditions.alertIsPresent());
			Alert alert = driver.switchTo().alert();
			Assert.assertTrue(false, "Case Failed due to alert present");
			
			
				
			}catch(Exception e) {
				
				Assert.assertTrue(true, "Reg Failed as Expected");
				Reporter.log("Reg Failed as Expected");
				
			}
	}

	

	@Test(dataProvider = "inputData",dataProviderClass = CommanDP.class)
	public void emptyPostCode(String sn, String fn, String ln, String pc) throws IOException {
		
		
		Reporter.log("Adding Customer Without Post Code");

		sel.click(OR.getProperty("btn_addCustomer"));
		
		sel.clearTextBox(OR.getProperty("txt_FirstName"));
		
		sel.sendText(OR.getProperty("txt_FirstName"), fn);
		
		sel.clearTextBox(OR.getProperty("txt_LastName"));
		
		sel.sendText(OR.getProperty("txt_LastName"), ln);
		
		sel.clearTextBox(OR.getProperty("txt_postCode"));
	//	sel.sendText(OR.getProperty("txt_postCode"), pc);

		sel.takeScreenShot();

		sel.click(OR.getProperty("btn_submit"));
		
		try {
			wait.until(ExpectedConditions.alertIsPresent());
			Alert alert = driver.switchTo().alert();
			Assert.assertTrue(false, "Case Failed due to alert present");
			
			
				
			}catch(Exception e) {
				
				Assert.assertTrue(true, "Reg Failed as Expected");
				Reporter.log("Reg Failed as Expected");
				
			}

	}

}
