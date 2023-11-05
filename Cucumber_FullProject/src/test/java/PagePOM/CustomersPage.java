package PagePOM;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import Utilities.baseClass;

public class CustomersPage extends baseClass {
	
	
//Page Factory Constructor	
	public CustomersPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	//lcoators : 
	@FindBy(how = How.ID,using = "SearchEmail" ) WebElement searchEmail_Field;
	
	@FindBy(how = How.ID,using = "search-customers" ) WebElement searchBTN;
	
	@FindBy(how = How.XPATH,using="//table[@id='customers-grid']") WebElement table;  //this is the table , which contains all element inside it
	
	@FindBy (how = How.XPATH,using="//table[@id='customers-grid']/tbody/tr") List<WebElement> tableRows; 
	
//	@FindBy (how = How.XPATH,using="//table[@id='customers-grid']/tbody/tr/td") List<WebElement> tableColumns; 
	
	@FindBy(how = How.XPATH,using = "//table[@id='customers-grid']/tbody/tr/td") List<WebElement> tableColumns; 
	
	//Action Methods:
	
	
	public void insert_SearchEmail(String search_Email) {
		
		searchEmail_Field.click();
		searchEmail_Field.clear();
		searchEmail_Field.sendKeys(search_Email);
	}
	
	
	public void searchBtn_Click() {
		searchBTN.click();
	}
	

//	
	public int getNoOfRows() {
		return(tableRows.size());
	}
	

	
	
	public boolean searchCustomerByEmail(String expected_email) {
		
		boolean flag=false;
		
		for (int i=1;i<=getNoOfRows();i++) {
			String ActualEmailID=table.findElement(By.xpath("//table[@id='customers-grid']/tbody/tr["+i+"]/td[2]")).getText();
			
			System.out.println(ActualEmailID );
			
			if(ActualEmailID.equals(expected_email)) {
				flag=true;
				
				System.out.println("********************* element Found *********************");
			}}
		
		return flag;
	}
	
	
	
}
