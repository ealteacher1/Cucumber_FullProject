package ListenersPack;

import javax.swing.text.Utilities;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;

import Utilities.baseClass;

public class TestListeners extends baseClass implements ITestListener {

	
	@Override
	public void onStart(ITestContext context) {
		log.info("**************************  Configuring extent Report ************************"); 
		System.out.println("**************************  On Start ************************");
		configureReport();		
		System.out.println("On-Start Listner");
		
	}

	@Override
	public void onFinish(ITestContext context) {
		log.info("**************************  Finishing Report ************************"); 
		System.out.println("**************************  On Finish ************************");
		reports.flush();
		System.out.println("On Finish Listner");
	}
	
	@Override
	public void onTestStart(ITestResult result) {
//		test=reports.createTest(result.getName());
//		test.info("starting test method: "+ result.getName());
		
		
		System.out.println("on Test Start: "+ result.getName());
		
		
	  
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		this.driver= ((baseClass)result.getInstance()).driver;

		test=reports.createTest(result.getName());
		test.log(Status.PASS, MarkupHelper.createLabel("Name of the method that passed is: "+result.getName(), ExtentColor.GREEN));
		
		test.addScreenCaptureFromPath(CaptureScreenshotForER("er_ss"));
		
		System.out.println("Success listner:"+result.getName());
	}

	@Override
	public void onTestFailure(ITestResult result) {
		test=reports.createTest(result.getName());
		test.log(Status.FAIL, MarkupHelper.createLabel("Name of the method that failed is: "+result.getName(), ExtentColor.RED));
		
		System.out.println("Failure Listener:"+result.getName());
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		
		test=reports.createTest(result.getName());
		test.log(Status.SKIP, MarkupHelper.createLabel("Name of the method that Skipped is: "+result.getName(), ExtentColor.ORANGE));
		
		
		System.out.println("Skipped listener:"+result.getName());
		
		
	}


	

}
