package tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.BaseClass;
import pages.DealsPage;
import pages.LoginPage;

public class DealsTest extends BaseClass {
	LoginPage lp;
	DealsPage dp;

	public DealsTest() throws IOException {
		super();

	}

	@BeforeTest
	public void setUp() throws IOException {
		intialization();
		lp = new LoginPage();
		dp = new DealsPage();

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
	public void testMoveToDeals() throws InterruptedException {
		driver.switchTo().frame("mainpanel");
		Logger.info("mouse hover to the Deals");
		dp.moveToDeals();
	}

	@Test(priority = 3)
	public void testNewDeal() {
		Logger.info("Enter the details in new deal");
		dp.fillDetailsOfNewDeal(prop.getProperty("Title"), prop.getProperty("companyName"),
				prop.getProperty("contactDetails"), prop.getProperty("amount"), prop.getProperty("quantity"),
				prop.getProperty("Type"), prop.getProperty("Source"), prop.getProperty("Description"),
				prop.getProperty("step"));
	}

	@Test(priority = 4)
	public void testContactName() {
		Logger.info("verify the entered owner name label is present or not");
		Assert.assertTrue(dp.validateOwnerName());
	}

	@AfterTest
	public void tearDown() {
		driver.close();
	}

}
