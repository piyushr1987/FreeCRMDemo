package tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.BaseClass;
import pages.ContactsPage;
import pages.LoginPage;

public class ContactsTest extends BaseClass {
	LoginPage lp;
	ContactsPage cp;

	public ContactsTest() throws IOException {
		super();

	}

	@BeforeTest
	public void setUp() throws IOException {
		intialization();
		lp = new LoginPage();
		cp = new ContactsPage();

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
		cp.moveToContacts();
	}

	@Test(priority = 3)
	public void testContactsDetails() {
		Logger.info("Enter the companies details");
		cp.fillContactsDetails(prop.getProperty("title"), prop.getProperty("firstName"), prop.getProperty("lastName"),
				prop.getProperty("suffix"), prop.getProperty("company"), prop.getProperty("Supervisor"),
				prop.getProperty("Assistant"), prop.getProperty("RefferBy"), prop.getProperty("Category"),
				prop.getProperty("Status"), prop.getProperty("Mobile"), prop.getProperty("Network"),
				prop.getProperty("Source"), prop.getProperty("Address"), prop.getProperty("City"),
				prop.getProperty("Time"), prop.getProperty("Country"));
	}

	@Test(priority = 4)
	public void testContactName() {
		Logger.info("verify the entered contact name label is present or not");
		Assert.assertTrue(cp.validateName());
	}

	@AfterTest
	public void tearDown() {
		driver.close();
	}

}
