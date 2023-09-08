package tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.BaseClass;
import pages.CompaniesPage;
import pages.LoginPage;

public class CompaniesTest extends BaseClass {
	LoginPage lp;
	CompaniesPage cp;

	public CompaniesTest() throws IOException {
		super();

	}

	@BeforeTest
	public void setUp() throws IOException {
		intialization();
		lp = new LoginPage();
		cp = new CompaniesPage();

	}

	@Test(priority = 1)
	public void enterLoginData() throws Exception {
		Logger.info("URL is opened");
		Logger.info("username is entered");
		lp.enterUsername(prop.getProperty("username"));
		Logger.info("password is entered");
		lp.enterPassword(prop.getProperty("password"));
		Thread.sleep(3000);
		Logger.info("click on login button");
		lp.clickOnLogin();
		if (driver.getTitle().equals("CRMPRO")) {
			Assert.assertTrue(true);
			Logger.info("Login test passed");
		} else {
			captureScreen(driver, "loginTest");
			Assert.assertTrue(false);
			Logger.info("Login test failed");
		}
	}

	@Test(priority = 2)
	public void testMoveToCompanies() throws InterruptedException {
		driver.switchTo().frame("mainpanel");
		Logger.info("mouse hover to the companies");
		cp.moveToCompanies();
	}

	@Test(priority = 3)
	public void testCompanyDetails() {
		Logger.info("Enter the companies details");
		cp.fillNewCompanyDetail(prop.getProperty("company"), prop.getProperty("industry"),
				prop.getProperty("annualRevnue"), prop.getProperty("employee"), prop.getProperty("status"),
				prop.getProperty("category"), prop.getProperty("priority"), prop.getProperty("source"),
				prop.getProperty("vatno"), prop.getProperty("addressTitle"), prop.getProperty("type"),
				prop.getProperty("address"), prop.getProperty("city"), prop.getProperty("state"),
				prop.getProperty("postalCode"), prop.getProperty("country"), prop.getProperty("description"));
	}

	@Test(priority = 4)
	public void testCompanyName() {
		Logger.info("verify the entered company name is present or not");
		Assert.assertTrue(cp.validateCompanyLogo());
	}

	@AfterTest
	public void tearDown() {
		driver.close();
	}

}
