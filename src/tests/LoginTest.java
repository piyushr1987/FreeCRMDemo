package tests;

import java.io.IOException;

import org.junit.AfterClass;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.BaseClass;
import pages.LoginPage;
import utilities.XLUtils;

public class LoginTest extends BaseClass {

	LoginPage lp;

	public LoginTest() throws IOException {
		super();

	}

	@Test(priority = 1, dataProvider = "LoginData")
	public void enterUserData(String user, String pwd) throws IOException, InterruptedException {
		lp = new LoginPage();
		lp.enterUsername(user);
		lp.enterPassword(pwd);
		lp.clickOnLogin();

		Thread.sleep(3000);

	}

	@Test(priority = 2)
	public void pageNavigation() {
		Assert.assertTrue(lp.validatePageTitle());
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}

	@DataProvider(name = "LoginData")
	String[][] getData() throws Exception {
		String path = System.getProperty("user.dir") + "/src/resources/TestDataExcel.xlsx";
		int rownum = XLUtils.getRowCount(path, "Sheet1");
		int colcount = XLUtils.getCellCount(path, "Sheet1", 1);
		String logindata[][] = new String[rownum][colcount];
		for (int i = 1; i < rownum; i++) {
			for (int j = 0; j < colcount; j++) {
				logindata[i - 1][j] = XLUtils.getCellData(path, "Sheet1", i, j);
			}
		}
		return logindata;
	}

}
