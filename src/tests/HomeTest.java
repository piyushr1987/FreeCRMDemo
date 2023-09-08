package tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.BaseClass;
import pages.HomePage;
import pages.LoginPage;

public class HomeTest extends BaseClass {

	HomePage hp;
	LoginPage lp;

	public HomeTest() throws IOException {
		super();
	}

	@BeforeTest
	public void setUp() throws IOException {
		intialization();
		lp = new LoginPage();
		hp = new HomePage();

	}

	@Test(priority = 1)
	public void enterLoginData() throws InterruptedException {
		lp.enterUsername(prop.getProperty("username"));
		lp.enterPassword(prop.getProperty("password"));
		Thread.sleep(3000);
		lp.clickOnLogin();
	}

	@Test(priority = 2)
	public void testHomeLink() {
		driver.switchTo().frame("mainpanel");
		Assert.assertTrue(hp.homeLink());

	}

	@Test(priority = 3)
	public void testCalenderLink() {
		Assert.assertTrue(hp.calenderLink());
	}

	@Test(priority = 4)
	public void testCompaniesLink() {
		Assert.assertTrue(hp.companiesLink());
	}

	@Test(priority = 5)
	public void testContactsLink() {
		Assert.assertTrue(hp.contactsLink());
	}

	@Test(priority = 6)
	public void testDealsLink() {
		Assert.assertTrue(hp.dealsLink());
	}

	@Test(priority = 7)
	public void testTasksLink() {
		Assert.assertTrue(hp.tasksLink());
	}

	@Test(priority = 8)
	public void testCasesLink() {
		Assert.assertTrue(hp.casesLink());
	}

	@Test(priority = 9)
	public void testCallsLink() {
		Assert.assertTrue(hp.callLink());
	}

	@Test(priority = 10)
	public void testEmailLink() {
		Assert.assertTrue(hp.emailLink());
	}

	@Test(priority = 11)
	public void testTextLink() {
		Assert.assertTrue(hp.textLink());
	}

	@Test(priority = 12)
	public void testPrintLink() {
		Assert.assertTrue(hp.printLink());
	}

	@Test(priority = 13)
	public void testCampaignLink() {
		Assert.assertTrue(hp.campaignLink());
	}

	@Test(priority = 14)
	public void testDocsLink() {
		Assert.assertTrue(hp.docsLink());
	}

	@Test(priority = 15)
	public void testFormsLink() {
		Assert.assertTrue(hp.formsLink());
	}

	@Test(priority = 16)
	public void testReportsLink() {
		Assert.assertTrue(hp.reportsLink());
	}
	

	@AfterTest
	public void tearDown() {
		driver.close();
	}

}
