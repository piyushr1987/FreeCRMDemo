package pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import base.BaseClass;

public class RegistrationPage extends BaseClass {

	public RegistrationPage() throws IOException {
		super();
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[text()='Sign Up']")
	WebElement lnkSignUp;

	@FindBy(id = "payment_plan_id")
	WebElement drpEdition;

	@FindBy(name = "first_name")
	WebElement txtFirstName;

	@FindBy(name = "surname")
	WebElement txtLastName;

	@FindBy(name = "email")
	WebElement txtEmail;

	@FindBy(name = "email_confirm")
	WebElement txtConfirmEmail;

	@FindBy(name = "username")
	WebElement txtUsername;

	@FindBy(name = "password")
	WebElement txtPassword;

	@FindBy(name = "passwordconfirm")
	WebElement txtConfirmPassword;

	@FindBy(name = "agreeTerms")
	WebElement chkAgreeTerms;

	@FindBy(id = "submitButton")
	WebElement btnSubmit;

	public void clickOnSignUp() {
		lnkSignUp.click();
	}

	public void selectEdition(String value) {
		Select sel = new Select(drpEdition);
		sel.selectByVisibleText(value);
	}

	public void enterFirstName(String fname) {
		txtFirstName.sendKeys(fname);
	}

	public void enterLastName(String lname) {
		txtLastName.sendKeys(lname);
	}

	public void enterEmail(String email) {
		txtEmail.sendKeys(email);
	}

	public void enterConfirmEmail(String cemail) {
		txtConfirmEmail.sendKeys(cemail);
	}

	public void enterUsername(String uname) {
		txtUsername.sendKeys(uname);
	}

	public void enterPassword(String pwd) {
		txtPassword.sendKeys(pwd);
	}

	public void enterConfirmPassword(String cpwd) {
		txtConfirmPassword.sendKeys(cpwd);
	}

	public void clickOnAgree() {
		chkAgreeTerms.click();
	}

	public void clickOnSubmit() {
		btnSubmit.click();
	}

	public boolean validatePageTitle() {
		return driver.getCurrentUrl().contains("register");
	}
}
