package orangeHRM.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import orangeHRM.AbstractComponents.AbstractComponent;

public class LandingPage extends AbstractComponent {
	WebDriver driver;

	public LandingPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void goTo() {
		driver.get("https://nihar22-trials711.orangehrmlive.com/");
	}

	// username input field element
	@FindBy(css = "#txtUsername")
	WebElement userNameField;

	// password input field element
	@FindBy(css = "#txtPassword")
	WebElement passwordField;

	// login button for logged in to orangeHRM web app
	@FindBy(css = "button[type='submit']")
	WebElement submitButton;

	/*
	 * login functionality with valid inputs in username and password fields
	 */
	public DashboardPage getLoginToOrangeHRMWithValidInput(String userName, String password) {
		userNameField.sendKeys(userName);
		passwordField.sendKeys(password);
		submitButton.click();
		DashboardPage dashboardPage = new DashboardPage(driver);
		return dashboardPage;
	}

	/*
	 * login functionality with invalid inputs in username and password fields
	 */
	public RetryLoginPage getLoginToOrangeHRMWithInValidInput(String userName, String password) {
		userNameField.sendKeys(userName);
		passwordField.sendKeys(password);
		submitButton.click();
		RetryLoginPage retryLoginPage = new RetryLoginPage(driver);
		return retryLoginPage;
	}

	// empty password error message
	@FindBy(css = "#txtPassword-error")
	WebElement errorMsgPassword;

	// getting the error message after blank input in password field
	public String getErrorMsgPassword() {
		return errorMsgPassword.getText();
	}

	// empty username error message
	@FindBy(css = "#txtUsername-error")
	WebElement errorMsgUsername;

	// getting the error message after blank input in username field
	public String getErrorMsgUsername() {
		return errorMsgUsername.getText();
	}

	/*
	 * login functionality with blank inputs in one fields
	 */
	public void getLoginToOrangeHRMWithBlankInputInOneField(String userName, String password) {
		userNameField.sendKeys(userName);
		passwordField.sendKeys(password);
		submitButton.click();
	}
}
