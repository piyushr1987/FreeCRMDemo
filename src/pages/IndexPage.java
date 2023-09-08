package pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.BaseClass;

public class IndexPage extends BaseClass {

	public IndexPage() throws IOException {
		super();
		PageFactory.initElements(driver, this);
	}

	@FindBy(className = "img-responsive")
	WebElement imgCRMPRO;

	@FindBy(xpath = "//a[text()='Home']")
	WebElement lnkHome;

	@FindBy(xpath = "//a[text()='Sign Up']")
	WebElement lnkSignUp;

	@FindBy(xpath = "//a[text()='Pricing']")
	WebElement lnkPricing;

	@FindBy(xpath = "//a[text()='Features']")
	WebElement lnkFeatures;

	@FindBy(xpath = "//a[text()='Customers']")
	WebElement lnkCustomers;

	@FindBy(xpath = "//a[text()='Contact']")
	WebElement lnkContacts;

	@FindBy(name = "username")
	WebElement textUsername;

	@FindBy(name = "password")
	WebElement textPassword;

	@FindBy(xpath = "//input[@value='Login']")
	WebElement btnLogin;

	public boolean companyLogo() {
		return imgCRMPRO.isDisplayed();

	}

	public boolean homeLink() {
		return lnkHome.isDisplayed();

	}

	public boolean signUpLink() {
		return lnkSignUp.isDisplayed();

	}

	public boolean pricingLink() {
		return lnkPricing.isDisplayed();

	}

	public boolean featureLink() {
		return lnkFeatures.isDisplayed();

	}

	public boolean customersLink() {
		return lnkCustomers.isDisplayed();

	}

	public boolean contactsLink() {
		return lnkContacts.isDisplayed();

	}

	public boolean usernameTextbox() {
		return textUsername.isDisplayed();

	}

	public boolean passwordTextbox() {
		return textPassword.isDisplayed();

	}

	public boolean loginButton() {
		return btnLogin.isDisplayed();

	}

	public boolean validatePageTitle() {
		return driver.getCurrentUrl().contains("index");
	}

}
