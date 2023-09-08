package tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.BaseClass;
import pages.IndexPage;

public class IndexTest extends BaseClass {

	IndexPage ip;

	public IndexTest() throws IOException {
		super();

	}

	@Test(priority = 1)
	public void testPageNavigation() {
		Assert.assertTrue(ip.validatePageTitle());
	}

	@Test(priority = 2)
	public void testCompanyBrand() {
		Assert.assertTrue(ip.companyLogo());
	}

	@Test(priority = 3)
	public void testHomeLink() {
		Assert.assertTrue(ip.homeLink());
	}

	@Test(priority = 4)
	public void testSignUpLink() {
		Assert.assertTrue(ip.signUpLink());
	}

	@Test(priority = 5)
	public void testPricingLink() {
		Assert.assertTrue(ip.pricingLink());
	}

	@Test(priority = 6)
	public void testFeatureLink() {
		Assert.assertTrue(ip.featureLink());
	}

	@Test(priority = 7)
	public void testCustomerLink() {
		Assert.assertTrue(ip.customersLink());
	}

	@Test(priority = 8)
	public void testContactsLink() {
		Assert.assertTrue(ip.contactsLink());
	}

	@Test(priority = 9)
	public void testUsernameTextBox() {
		Assert.assertTrue(ip.usernameTextbox());
	}

	@Test(priority = 10)
	public void testPasswordTextBox() {
		Assert.assertTrue(ip.passwordTextbox());
	}

	@Test(priority = 11)
	public void testLoginButton() {
		Assert.assertTrue(ip.loginButton());
	}

}
