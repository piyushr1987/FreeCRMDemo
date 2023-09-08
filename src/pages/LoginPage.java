package pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.BaseClass;

public class LoginPage extends BaseClass {

	public LoginPage() throws IOException {
		super();
		PageFactory.initElements(driver, this);

	}

	@FindBy(name = "username")
	WebElement textUserName;

	@FindBy(name = "password")
	WebElement textPassword;

	@FindBy(xpath = "//input[@type='submit']")
	WebElement btnLogin;


	public void enterUsername(String uname) {
		textUserName.sendKeys(uname);
	}

	public void enterPassword(String pwd) {
		textPassword.sendKeys(pwd);
	}

	public void clickOnLogin() {
		btnLogin.click();
	}

	public boolean validatePageTitle() {
		return driver.getCurrentUrl().contains("index.cfm?CFID");
	}

	

}
