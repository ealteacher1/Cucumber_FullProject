package Utilities;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import io.github.bonigarcia.wdm.WebDriverManager;



public class baseClass {
	
	public static WebDriver driver;
	public String ud= System.getProperty("user.dir");
	
	public Logger log = (Logger)LogManager.getLogger(baseClass.class);
	public ExtentSparkReporter htmlReporter=new ExtentSparkReporter("Results/shamsevanExtentRep_"+System.currentTimeMillis()+".html");
	public ExtentReports reports = new ExtentReports();
	public ExtentTest test;
	
	
	
public void configureReport() {
		
		//Attach Reporter
		reports.attachReporter(htmlReporter);
		
		//Add system information/Environment information to Report 
		reports.setSystemInfo("Machine", "TestPC1");
		reports.setSystemInfo("OS", "Windows11");
		reports.setSystemInfo("browser", "chrome");
		reports.setSystemInfo("userName : ", "shams");
		
		//configuration to change Look and Feel of Report : 
		htmlReporter.config().setDocumentTitle("Evan's report");
		htmlReporter.config().setReportName("Myntra Test report");
		htmlReporter.config().setTheme(Theme.DARK);

	}
	
	public void Screenshots(String folderName) throws IOException {	

		File SS=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File destinationFilePath=new File(ud+"\\Pictures\\"+folderName+"\\home"+System.currentTimeMillis()+".jpg");
		FileHandler.copy(SS,destinationFilePath );
		log.info("Screenshot Captured");
	}
	
	public void switchtoOpenedWindow(String Parent) throws InterruptedException {
		
		Set<String> wins=driver.getWindowHandles();
		for(String sesid:wins) {
			if (sesid!=Parent) {
				driver.switchTo().window(sesid);	
				log.info("Window switched- Driver is present in the new Window/Tab");
			}}}
	
	public void waitforelementclickable(WebElement elementvairable) {
		WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(30));
	    wait.until(ExpectedConditions.elementToBeClickable(elementvairable));
		log.info("waiting for element to be clickable");
	}
	
	
	public void waitforpageTitle(String pagetitle) {
		WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(30));
	    wait.until(ExpectedConditions.titleContains(pagetitle));
	}
	
	public void VerifyPageTitle(String expectedTitle) {
		String ActualPageTitle=driver.getTitle();
		Assert.assertEquals(ActualPageTitle,expectedTitle,"PageTitle is Verified");
		log.info("************ PageTitle verified *********************");
	}
	
	public String CaptureScreenshotForER(String folderName) {	

		File SS=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File destinationFilePath=new File(ud+"\\Pictures\\"+folderName+"\\home"+System.currentTimeMillis()+".jpg");  
		try {
			FileHandler.copy(SS,destinationFilePath );
		} catch (IOException e) {
			e.printStackTrace();
		}
		log.info("Screenshot Captured for extent Report");

		String absolutePathLocation=destinationFilePath.getAbsolutePath();  
		return absolutePathLocation;
	}
	
	public void tearDown() {
		driver.close();
		log.info("Browser Closed");
	}







public void Ibrowser(String BrowserName,String URL) throws InterruptedException {

	if (BrowserName.equalsIgnoreCase("chrome")) {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get(URL);	 	  
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		log.info("Chrome Browser Initilalized and went to the URL -" + URL);

		driver.manage().window().maximize();
		Thread.sleep(4000);	   
		log.info("Window Maximized");
	}

	else if(BrowserName.equalsIgnoreCase("edge")) {

		WebDriverManager.edgedriver().setup();

		driver = new EdgeDriver();
		driver.get(URL);		   
		driver.manage().window().maximize();
		Thread.sleep(4000);
		}}
    
	
	
	
	

}
