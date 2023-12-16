package orangeHRM.tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import orangeHRM.TestComponents.BaseTest;
import orangeHRM.pageobjects.DashboardPage;
import orangeHRM.pageobjects.RetryLoginPage;

public class LoginFunctionalityTest extends BaseTest {
	public WebDriver driver;
	String userName = "Admin";
	String password = "2g3QZ@xYbU";
	String expectedTextOfDashboard = "Dashboard";
	String expectedToastMessage = "Invalid Credentials";
	String expectedErrorMsgUsername = "Username cannot be empty";
	String expectedErrorMsgPassword = "Password cannot be empty";

	// login to the app with valid inputs in username and password field
	@Test
	public void LF_TC_001() throws InterruptedException {
		DashboardPage dashboardPage = landingPage.getLoginToOrangeHRMWithValidInput(userName, password);
		Thread.sleep(5000);
		Assert.assertTrue(dashboardPage.getLogoOfDashboardPage().isDisplayed());
	}

	// login to the app with valid inputs in username and invalid input in password
	// field
	@Test
	public void LF_TC_002() {
		RetryLoginPage retryLoginPage = landingPage.getLoginToOrangeHRMWithInValidInput(userName, "2g3QZ@xYbt");
		String actualToastMessage = retryLoginPage.getToastMessageForInvalidLogin();
		Assert.assertTrue(actualToastMessage.contains(expectedToastMessage));
	}

	// login to the app with invalid inputs in username and valid input in password
	// field
	@Test
	public void LF_TC_003() {
		RetryLoginPage retryLoginPage = landingPage.getLoginToOrangeHRMWithInValidInput("Adminn", password);
		String actualToastMessage = retryLoginPage.getToastMessageForInvalidLogin();
		Assert.assertTrue(actualToastMessage.contains(expectedToastMessage));
	}

	// login to the app with invalid input in username and password field
	@Test
	public void LF_TC_004() {
		RetryLoginPage retryLoginPage = landingPage.getLoginToOrangeHRMWithInValidInput("adminn", "ghyHdvc7e");
		String actualToastMessage = retryLoginPage.getToastMessageForInvalidLogin();
		Assert.assertTrue(actualToastMessage.contains(expectedToastMessage));
	}

	// login to the app with valid inputs in username and blank input in password
	// field
	@Test
	public void LF_TC_005() {
		landingPage.getLoginToOrangeHRMWithBlankInputInOneField(userName, "");
		String actualErrorMsgPassword = landingPage.getErrorMsgPassword();
		Assert.assertEquals(actualErrorMsgPassword, expectedErrorMsgPassword);
	}

	// login to the app with blank input in username and valid input in password
	// field
	@Test
	public void LF_TC_006() {
		landingPage.getLoginToOrangeHRMWithBlankInputInOneField("", password);
		String actualErrorMsgUsername = landingPage.getErrorMsgUsername();
		Assert.assertEquals(actualErrorMsgUsername, expectedErrorMsgUsername);
	}

	// login to the app with blank input in both field
	@Test
	public void LF_TC_007() {
		landingPage.getLoginToOrangeHRMWithBlankInputInOneField("", "");
		String actualErrorMsgUsername = landingPage.getErrorMsgUsername();
		String actualErrorMsgPassword = landingPage.getErrorMsgPassword();
		Assert.assertEquals(actualErrorMsgPassword, expectedErrorMsgPassword);
		Assert.assertEquals(actualErrorMsgUsername, expectedErrorMsgUsername);
	}
	
	//login to the app with invalid username and blank input in password field
	public void LF_TC_008() {
		landingPage.getLoginToOrangeHRMWithBlankInputInOneField("adminn", "");
	}
}
