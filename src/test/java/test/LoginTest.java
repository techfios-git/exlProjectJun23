package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import page.DashboardPage;
import page.LoginPage;
import util.BrowserFactory;
import util.ExcelReader;

public class LoginTest {

	WebDriver driver;

	ExcelReader exlRead = new ExcelReader("src\\main\\java\\testData\\TF_TestData.xlsx");

	// Login Data
	String userName = exlRead.getCellData("LoginInfo", "UserName", 2);
	String password = exlRead.getCellData("LoginInfo", "Password", 2);
	String dashboardValidationText = exlRead.getCellData("DashboardInfo", "DashboardHeader", 2);
	String alertUserValidationText = exlRead.getCellData("LoginInfo", "alertUserValidationText", 2);
	String alertPasswordValidationText = exlRead.getCellData("LoginInfo", "alertPasswordValidationText", 2);
	
	
	

	@Test
	public void validUserShouldBeAbleToLogin() {

		driver = BrowserFactory.init();
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		loginPage.insertUserName(userName);
		loginPage.insertPassword(password);
		loginPage.clickOnSigninButton();
		DashboardPage dashboardPage = PageFactory.initElements(driver, DashboardPage.class);
		dashboardPage.validateDashboardPage(dashboardValidationText);
		BrowserFactory.tearDown();
	}
	
	@Test
	public void validateLoginAlertMesg() {
		driver = BrowserFactory.init();
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		loginPage.clickOnSigninButton();
		loginPage.validateUserAlertMsg(alertUserValidationText);
		loginPage.insertUserName(userName);
		loginPage.clickOnSigninButton();
		loginPage.validatePasswordAlertMsg(alertPasswordValidationText);
		BrowserFactory.tearDown();
	}

}
