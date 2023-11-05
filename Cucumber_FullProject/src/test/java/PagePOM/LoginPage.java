package PagePOM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.baseClass;

public class LoginPage extends baseClass {
	
	
	public LoginPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	//Locators
	@FindBy(id = "Email") WebElement emailField;

	@FindBy(id = "Password") WebElement PasswordField;
	
	@FindBy(xpath = "//button[text()='Log in']") WebElement login_btn;
	
	
	 // Action Methods
		public void Provide_EmailId(String Given_email) throws InterruptedException {
		
	       waitforelementclickable(emailField);
			emailField.click();
			emailField.clear();
			emailField.sendKeys(Given_email);

			Thread.sleep(2000);
		}	
	
		public void Provide_Password(String Given_Password) throws InterruptedException {
			
		       waitforelementclickable(PasswordField);
				PasswordField.click();
				PasswordField.clear();
				PasswordField.sendKeys(Given_Password);

				Thread.sleep(2000);
			}
			
			public void clickon_Loginbtn() {
				
				login_btn.click();
			}

	

}
