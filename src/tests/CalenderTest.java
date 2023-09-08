package tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.BaseClass;
import pages.CalenderPage;
import pages.LoginPage;

public class CalenderTest extends BaseClass {

	LoginPage lp;
	CalenderPage cp;

	public CalenderTest() throws IOException {
		super();

	}

	@BeforeTest
	public void setUp() throws IOException {
		intialization();
		lp = new LoginPage();
		cp = new CalenderPage();

	}

	@Test(priority = 1)
	public void enterLoginData() throws InterruptedException {
		lp.enterUsername(prop.getProperty("username"));
		lp.enterPassword(prop.getProperty("password"));
		Thread.sleep(3000);
		lp.clickOnLogin();
	}

	@Test(priority = 2)
	public void testMoveToCalander() throws InterruptedException {
		driver.switchTo().frame("mainpanel");
		cp.moveToCalender();
	}

	@Test(priority = 3)
	public void testEnterTitle() {
		cp.enterTitle(prop.getProperty("title"));
	}

	@Test(priority = 4)
	public void testFromDate() throws InterruptedException {
		cp.enterFromDate();
	}

	@Test(priority = 5)
	public void testToDate() throws InterruptedException {
		cp.enterToDate();
	}

	@Test(priority = 6)
	public void testCatogary() {
		cp.selectCategory(prop.getProperty("catogary"));
	}

	@Test(priority = 7)
	public void testAddButton() {
		cp.clickOnAssignedTo();
	}

	@Test(priority = 8)
	public void testContacts() {
		cp.enterContact(prop.getProperty("contact"));
	}

	@Test(priority = 9)
	public void testCompany() {
		cp.enterCompany(prop.getProperty("company"));
	}

	@Test(priority = 10)
	public void testDeal() {
		cp.enterDeal(prop.getProperty("deal"));
	}

	@Test(priority = 11)
	public void testTasks() {
		cp.enterTask(prop.getProperty("task"));
	}

	@Test(priority = 12)
	public void testCase() {
		cp.enterCase(prop.getProperty("case"));
	}

	@Test(priority = 13)
	public void testTags() {
		cp.enterTags(prop.getProperty("tags"));
	}

	@Test(priority = 14)
	public void testLocation() {
		cp.enterLocations(prop.getProperty("location"));
	}

	@Test(priority = 15)
	public void testNotes() {
		cp.enterNotes(prop.getProperty("notes"));
	}

	@Test(priority = 16)
	public void testMinutes() {
		cp.enterMinutes(prop.getProperty("minutes"));
	}

	@Test(priority = 17)
	public void testRemoveButton() {
		Assert.assertTrue(cp.validateRemoveButton());
	}

	@AfterTest
	public void tearDown() {
		driver.close();
	}

}
