package orangeHRM.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import orangeHRM.AbstractComponents.AbstractComponent;

public class DashboardPage extends AbstractComponent {

	WebDriver driver;

	public DashboardPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// validate logo
	@FindBy(css = "div[id='ohrm-small-logo'] div")
	WebElement logoValidation;

	// get text of dashborad element
	public WebElement getLogoOfDashboardPage() {
		return logoValidation;
	}

}
