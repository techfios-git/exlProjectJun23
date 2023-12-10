package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;


public class DashboardPage extends BasePage{
	
	WebDriver driver;
	
	public DashboardPage(WebDriver driver) {
		this.driver = driver;
	}
	
	@FindBy(how = How.XPATH, using = "//strong[contains(text(), 'Dashboard')]") WebElement dashboardHeaderElement;
	@FindBy(how = How.XPATH, using = "/html/body/div[1]/aside[1]/div/nav/ul[2]/li[2]/a/span") WebElement customerMenuElement;
	@FindBy(how = How.XPATH, using = "//*[@id=\"customers\"]/li[2]/a/span") WebElement addCustomerMenuElement;

	public void validateDashboardPage(String dashboard) {
		validateElement(dashboardHeaderElement.getText(), dashboard, "Dashboard Page is not available!");
	}
	
	public void clickOnCustomerMenuButton() {
		customerMenuElement.click();
	}
	public void clickOnAddCustomerMenuButton() {
		addCustomerMenuElement.click();
	}

	
	
	
}
