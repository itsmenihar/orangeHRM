package orangeHRM.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import orangeHRM.AbstractComponents.AbstractComponent;

public class RetryLoginPage extends AbstractComponent {
	WebDriver driver;
	public RetryLoginPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css=".toast.toast-error")
	WebElement ToastMessageForInvalidLogin;
	
	public String getToastMessageForInvalidLogin() {
		return ToastMessageForInvalidLogin.getText();
	}
}
