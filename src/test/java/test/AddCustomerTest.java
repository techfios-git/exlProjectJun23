package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import page.AddCustomerPage;
import page.DashboardPage;
import page.LoginPage;
import util.BrowserFactory;
import util.ExcelReader;

public class AddCustomerTest {

	WebDriver driver;
	
	// Login Data
	ExcelReader exlRead = new ExcelReader("src\\main\\java\\testData\\TF_TestData.xlsx");
	String userName = exlRead.getCellData("LoginInfo", "UserName", 2);
	String password = exlRead.getCellData("LoginInfo", "Password", 2);
	String dashboardValidationText = exlRead.getCellData("DashboardInfo", "DashboardHeader", 2);
	String alertUserValidationText = exlRead.getCellData("LoginInfo", "alertUserValidationText", 2);
	String alertPasswordValidationText = exlRead.getCellData("LoginInfo", "alertPasswordValidationText", 2);
	String addCustomerHeaderValidationText = exlRead.getCellData("AddContactInfo", "AddContactValidationText", 2);
	String fullName = exlRead.getCellData("AddContactInfo", "FullName", 2);
	String companyName = exlRead.getCellData("AddContactInfo", "CompanyName", 2);
	String emailAddress = exlRead.getCellData("AddContactInfo", "Email", 2);
	String phoneNum = exlRead.getCellData("AddContactInfo", "Phone", 2);
	String address = exlRead.getCellData("AddContactInfo", "Address", 2);
	String city = exlRead.getCellData("AddContactInfo", "City", 2);
	String zip = exlRead.getCellData("AddContactInfo", "Zip", 2);
	String countryName = exlRead.getCellData("AddContactInfo", "Country", 2);

	@Test
	public void userShouldBeAbleToAddNewCustomer() {

		driver = BrowserFactory.init();
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		loginPage.insertUserName(userName);
		loginPage.insertPassword(password);
		loginPage.clickOnSigninButton();
		
		DashboardPage dashboardPage = PageFactory.initElements(driver, DashboardPage.class);
		dashboardPage.validateDashboardPage(dashboardValidationText);
		dashboardPage.clickOnCustomerMenuButton();
		dashboardPage.clickOnAddCustomerMenuButton();
		
		AddCustomerPage addCustomerPage = PageFactory.initElements(driver, AddCustomerPage.class);
		addCustomerPage.validateAddCustomerPage(addCustomerHeaderValidationText);
		addCustomerPage.insertFullName(fullName);
		addCustomerPage.selectCompany(companyName);
		addCustomerPage.insertEmail(emailAddress);
		addCustomerPage.insertPhone(phoneNum);
		addCustomerPage.insertAdderss(address);
		addCustomerPage.insertCity(city);
		addCustomerPage.insertZip(zip);
		addCustomerPage.selectCountry(countryName);
		addCustomerPage.clickOnSaveButton();
		
		addCustomerPage.validateInsertedNameAndDelete();
		
	}

}
