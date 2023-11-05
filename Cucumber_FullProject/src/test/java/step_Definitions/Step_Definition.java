
package step_Definitions;



import org.testng.Assert;

import PagePOM.CustomersPage;
import PagePOM.DashBoardPage;
import PagePOM.LoginPage;
import PagePOM.Pages;
import Utilities.Hooks;
import Utilities.baseClass;
import io.cucumber.java.en.*;

public class Step_Definition extends Pages  {

	@Given("User Launch {string} browser with {string}")
	public void user_launch_browser_with(String browser, String url) throws InterruptedException {

		log.info("************ Starting Browser and Navigating to URL *********************");
		Ibrowser(browser, url);
	}
	@Then("user navigated to {string}")
	public void user_navigated_to(String ExpectedTitle) {

		log.info("************ Verifying login page Title *********************");

		VerifyPageTitle(ExpectedTitle);


	}
	@And("User enters Email as {string} and Password as {string}")
	public void user_enters_email_as_and_password_as(String email, String password) throws InterruptedException {
		log.info("************ Start Loggin in : Step 3 *********************");
		loginpage= new LoginPage(driver);


		loginpage.Provide_EmailId(email);
		loginpage.Provide_Password(password);




	}
	@Then("click on Login")
	public void click_on_login() {
		log.info("************ Click on Login Button : Step 3 *********************");
		loginpage.clickon_Loginbtn();
	}
	@Then("User land on {string} Page")
	public void user_land_on_page(String DashboardPageTitle) {
		log.info("************ Verify DashboardPage : Step 4 *********************");
		VerifyPageTitle(DashboardPageTitle);
	}

	@Then("User click on {string} menu")
	public void user_click_on_menu(String Menuitems) throws InterruptedException {

		log.info("************ Clicking on Customer Menu : Step 5 *********************");

		dashboardpage= new DashBoardPage(driver);

		dashboardpage.clickOn_CustomersMenu();



	}

	@When("User click on customer Button")
	public void user_click_on_customer_button() throws InterruptedException {
		log.info("************ Selecting Customer button : Step 6 *********************");


		dashboardpage.click_customersButton();
	}

	@Then("click on {string} Field")
	public void click_on_field(String EmailField) {
	
	
	}
	
	
	
	@Then("insert {string} as email")
	public void insert_as_email(String expectedEmail) throws InterruptedException {
		log.info("************ Insert Email *********************");
		customerPage= new CustomersPage(driver);
       customerPage.insert_SearchEmail(expectedEmail);
       Thread.sleep(2000);
	}
	@Then("click on Search button")
	public void click_on_search_button() throws InterruptedException {
       customerPage.searchBtn_Click();
       Thread.sleep(2000);
	}
	
	
	@Then("Email should be visible")
	public void email_should_be_visible() {
       Assert.assertTrue(customerPage.searchCustomerByEmail("james_pan@nopCommerce.com"),"Email Id is present");
	}


}
