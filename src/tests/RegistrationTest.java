package tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.BaseClass;
import pages.IndexPage;
import pages.RegistrationPage;

public class RegistrationTest extends BaseClass {

	RegistrationPage rp;

	public RegistrationTest() throws IOException {
		super();

	}

	@Test(priority = 1)
	public void testSignUpLink() {
		rp.clickOnSignUp();
	}

	@Test(priority = 2)
	public void testPageNavigation() {
		Assert.assertTrue(rp.validatePageTitle());
	}

	@Test(priority = 3)
	public void testEdition() {
		rp.selectEdition(prop.getProperty("text"));
	}

	@Test(priority = 4)
	public void testFirstName() {
		rp.enterFirstName(prop.getProperty("FirstName"));
	}

	@Test(priority = 5)
	public void testLastName() {
		rp.enterLastName(prop.getProperty("Surname"));
	}

	@Test(priority = 6)
	public void testEmail() {
		rp.enterEmail(prop.getProperty("email"));
	}

	@Test(priority = 7)
	public void testConfirmEmail() {
		rp.enterConfirmEmail(prop.getProperty("confirmemail"));
		if (prop.getProperty("confirmemail").equalsIgnoreCase(prop.getProperty("email"))) {
			Assert.assertTrue(true);
		} else {
			Assert.assertTrue(false);
		}
	}

	@Test(priority = 8)
	public void testUsername() {
		rp.enterUsername(prop.getProperty("username"));
	}

	@Test(priority = 9)
	public void testPassword() {
		rp.enterPassword(prop.getProperty("password"));
	}

	@Test(priority = 10)
	public void testConfirmPassword() {
		rp.enterConfirmPassword(prop.getProperty("confirmpassword"));
		if (prop.getProperty("confirmpassword").equalsIgnoreCase(prop.getProperty("password"))) {
			Assert.assertTrue(true);
		} else {
			Assert.assertTrue(false);
		}
	}

	@Test(priority = 11)
	public void testAgreeCheckBox() {
		rp.clickOnAgree();
	}

	@Test(priority = 12)
	public void testSubmitButton() {
		rp.clickOnSubmit();
	}

}
