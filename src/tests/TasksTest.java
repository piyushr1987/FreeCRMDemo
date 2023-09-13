package tests;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.BaseClass;
import pages.LoginPage;
import pages.TasksPage;

public class TasksTest extends BaseClass {
	LoginPage lp;
	TasksPage tp;

	public TasksTest() throws IOException {
		super();

	}

	@BeforeTest
	public void setUp() throws IOException {
		intialization();
		lp = new LoginPage();
		tp = new TasksPage();

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
	public void testMoveToTasks() throws Exception {
		driver.switchTo().frame("mainpanel");
		Logger.info("mouse hover to the tasks");
		tp.moveToTasks();
		WebElement task = driver.findElement(By.name("sequence"));
		if (task.isDisplayed()) {
			Assert.assertTrue(true);
			Logger.info("Task no value is displayed");
		} else {
			captureScreen(driver, "Task No");
			Assert.assertTrue(false);
			Logger.info("Task no value is not displayed");
		}
	}

	@Test(priority = 3)
	public void testNewTask() {
		tp.fillDetailsOfNewTask(prop.getProperty("taskTitle"), prop.getProperty("taskStatus"),
				prop.getProperty("completion"), prop.getProperty("taskType"), prop.getProperty("taskPriority"),
				prop.getProperty("taskDeal"), prop.getProperty("taskCompany"));
	}

	@Test(priority = 4)
	public void testOwnerName() {
		Logger.info("verify the entered owner name label is present or not");
		Assert.assertTrue(tp.validateOwnerName());
	}

	@AfterTest
	public void tearDown() {
		driver.close();
	}

}
