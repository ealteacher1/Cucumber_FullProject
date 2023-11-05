package PagePOM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import Utilities.baseClass;

public class DashBoardPage extends baseClass {
	// Page factory Constructor: 
		public DashBoardPage(WebDriver driver) {
			this.driver=driver;
			PageFactory.initElements(driver, this);
		}
		
		
	//	Locators:
		
		 By CustomersMenue = By.xpath("//a[@href='#']//p[contains(text(),'Customers')]");
		 By Customersbtn = By.xpath("(//a[@class='nav-link']//p[contains(text(),' Customers')])[1]");
		 
		 
		 public void clickOn_CustomersMenu() throws InterruptedException {
			 driver.findElement(CustomersMenue).click();
			 Thread.sleep(2000); 
		 }
		 
		 public void click_customersButton() throws InterruptedException {
			 driver.findElement(Customersbtn).click();
			 Thread.sleep(2000); 
		 }
		 
		 
		 
		 
		
}
