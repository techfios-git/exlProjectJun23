package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginPage extends BasePage{

	WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	// WebElements/Attributes
	@FindBy(how = How.XPATH, using = "//*[@id=\"user_name\"]")
	WebElement userNameElement;
	@FindBy(how = How.XPATH, using = "//*[@id=\"password\"]")
	WebElement passwordElement;
	@FindBy(how = How.XPATH, using = "//*[@id=\"login_submit\"]")
	WebElement signinButtonElement;

	// Intractable Methods
	public void insertUserName(String userName) {
		userNameElement.sendKeys(userName);
	}

	public void insertPassword(String password) {
		passwordElement.sendKeys(password);
	}

	public void clickOnSigninButton() {
		signinButtonElement.click();
	}
	
	public void validateUserAlertMsg(String alertValidationText) {
		String actualAlertUserText = driver.switchTo().alert().getText();
		validateElement(actualAlertUserText, alertValidationText, "Alert msg is not available!!");
		driver.switchTo().alert().accept();
	}
	
	public void validatePasswordAlertMsg(String alertValidationText) {
		String actualAlertPasswordText = driver.switchTo().alert().getText();
		validateElement(actualAlertPasswordText, alertValidationText, "Alert msg is not available!!");
		driver.switchTo().alert().accept();
	}

}
