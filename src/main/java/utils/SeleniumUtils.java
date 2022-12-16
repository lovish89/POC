package utils;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;

import com.way2.Poc.TestBaseClass;

public class SeleniumUtils extends TestBaseClass {
	
	
	public void click(String locator) {
		
		WebElement source = febl(locator);
		explicitWait(source);
		
		source.click();
		Reporter.log(locator+" Clicked");
			
		
		
	}
	public void explicitWait(WebElement source) {
		wait.until(ExpectedConditions.visibilityOf(source));
		
		
		
	}
	public void sendText(String locator, String text) {
		WebElement source = febl(locator);
		
		
		
		source.sendKeys(text);
		Reporter.log(text+" Entered in "+locator);
	}
	
	public void selectValueFromDropDown(String locator, String value, String methodOfSelection) {
		WebElement source = febl(locator);
		Select s = new Select(source);
		if(methodOfSelection.contains("vt")) {
			
			s.selectByVisibleText(value);
		}
		else if(methodOfSelection.contains("index")) {
			s.selectByIndex(Integer.parseInt(value));
		}
		else {
			
			s.selectByValue(value);
		}
		
		
	}
	
	public WebElement febl(String locator) {
		WebElement source = driver.findElement(By.xpath(locator));
		explicitWait(source);
		return source;
		
	}
	public String takeScreenShot() throws IOException {
		
		File scr = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String time = String.valueOf(System.currentTimeMillis());
		String path = System.getProperty("user.dir")+"\\src\\main\\resources\\screenshots\\"+time+".png";
		FileUtils.copyFile(scr, new File(path));
		
		return path;
		
	}
public void clearTextBox(String locator) {
		
		WebElement source = febl(locator);
		explicitWait(source);
		
		source.clear();
		Reporter.log(locator+" Cleared");
			
		
		
	}
	
	
	
	
	

}
