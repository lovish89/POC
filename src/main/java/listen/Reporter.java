package listen;




import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import utils.SeleniumUtils;

public class Reporter implements ITestListener{
	
	
	SeleniumUtils sel =null;

	public void onTestStart(ITestResult result) {
		
		
		
	}

	public void onTestSuccess(ITestResult result) {
sel=new SeleniumUtils();
		
		try {
			String path= sel.takeScreenShot();
			org.testng.Reporter.log("<img src="+path+"width=500 height=500>");
			
			
		} catch (IOException e) {
			
			e.printStackTrace();
			
			
		}}

	public void onTestFailure(ITestResult result) {
		
		
		sel=new SeleniumUtils();
		
		try {
			String path= sel.takeScreenShot();
			org.testng.Reporter.log("<img src="+path+"width=500 height=500>");
			
		} catch (IOException e) {
			
			e.printStackTrace();
			
			
		}
		
	}

	public void onTestSkipped(ITestResult result) {
		
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
		
	}

	public void onStart(ITestContext context) {
		
		
	}

	public void onFinish(ITestContext context) {
		
		
	}
	
	
	

}
