package com.way2.Poc;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import io.github.bonigarcia.wdm.WebDriverManager;
import utils.SeleniumUtils;

public class TestBaseClass {

	public static WebDriver driver;
	public static WebDriverWait wait;
	public static Properties OR;

	@BeforeSuite
	public void openWebSite() throws IOException {
		try {
		FileUtils.forceDelete(new File(System.getProperty("user.dir")+"\\src\\main\\resources\\screenshots"));
		}catch (Exception e) {
			System.out.println("No folder found to Delete");
		}
		
		SeleniumUtils selUtils = new SeleniumUtils();

		Properties config = new Properties();
		FileInputStream fis = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\main\\resources\\config\\configu.properties");
		config.load(fis);
		OR = new Properties();
		fis = new FileInputStream(System.getProperty("user.dir") + "\\src\\main\\resources\\config\\OR.properties");
		OR.load(fis);
		String browser = config.getProperty("browser");

		if (browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			
			Reporter.log("Chrome Browser Opened");
			
		} else if (browser.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			
			Reporter.log("Firefox Browser Opened");
			
		}
		driver.get(config.getProperty("url"));
		
		selUtils.takeScreenShot();
		
		Reporter.log("url Opened: "+config.getProperty("url"));
		
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.manage().window().maximize();
		wait = new WebDriverWait(driver, 10);
		
		
		
	}

	@AfterSuite
	public void tearDown()  {
		try{
			Thread.sleep(3000);
		
		driver.close();
		Reporter.log("Browser Closed");
		
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("Driver cannot close");
		}
	}

}
