package pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import base.BaseClass;

public class TasksPage extends BaseClass {

	public TasksPage() throws IOException {
		super();
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//a[text()='Tasks']")
	WebElement lnkTasks;

	@FindBy(xpath = "//a[text()='New Task']")
	WebElement lnkNewTasks;

	@FindBy(name = "sequence")
	WebElement txtTaskNo;

	@FindBy(id = "title")
	WebElement txtTitle;

	@FindBy(xpath = "//select[@name='status']")
	WebElement drpStatus;

	@FindBy(id = "completion")
	WebElement txtComplete;

	@FindBy(xpath = "//select[@name='task_type']")
	WebElement drpTask;

	@FindBy(xpath = "//select[@name='priority']")
	WebElement drpPriority;

	@FindBy(name = "prospect_lookup")
	WebElement txtDeal;

	@FindBy(name = "client_lookup")
	WebElement txtKeyCompany;

	@FindBy(xpath = "//input[@value='Save']")
	WebElement btnSave;

	@FindBy(xpath = "//td[@class='datatitle']//strong[text()='Owner']")
	WebElement lblOwner;

	public void moveToTasks() throws InterruptedException {
		Actions act = new Actions(driver);
		act.moveToElement(lnkTasks).build().perform();
		Thread.sleep(3000);
		act.moveToElement(lnkNewTasks).build().perform();
		lnkNewTasks.click();
		txtTaskNo.getAttribute("value").isEmpty();
	}

	public boolean validateOwnerName() {
		return lblOwner.isDisplayed();

	}

	public void fillDetailsOfNewTask(String title, String status, String completion, String task, String priority,
			String deal, String company) {
		txtTitle.sendKeys(title);
		selectDropDownValues(drpStatus, status);
		txtComplete.sendKeys(completion);
		selectDropDownValues(drpTask, task);
		selectDropDownValues(drpPriority, priority);
		txtDeal.sendKeys(deal);
		txtKeyCompany.sendKeys(company);
		btnSave.click();
	}

	public static void selectDropDownValues(WebElement element, String value) {
		Select sel = new Select(element);
		sel.selectByVisibleText(value);
	}

}
