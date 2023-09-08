package pages;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.BaseClass;

public class CalenderPage extends BaseClass {

	public CalenderPage() throws IOException {
		super();
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[text()='Calendar']")
	WebElement lnkCalendar;

	@FindBy(xpath = "//a[text()='New Event']")
	WebElement lnkNewEvent;

	@FindBy(id = "title")
	WebElement txtTitle;

	@FindBy(id = "f_trigger_c_start")
	WebElement dateFrom;

	@FindBy(id = "f_trigger_c_end")
	WebElement dateTo;

	@FindBy(xpath = "//select[@name='category']")
	WebElement drpCategory;

	@FindBy(xpath = "//input[@value='==ADD==>']")
	WebElement buttonAdd;

	@FindBy(name = "contact_lookup")
	WebElement txtContact;

	@FindBy(name = "client_lookup")
	WebElement txtCompany;

	@FindBy(name = "prospect_lookup")
	WebElement txtDeal;

	@FindBy(name = "task_lookup")
	WebElement txtTask;

	@FindBy(name = "case_lookup")
	WebElement txtCase;

	@FindBy(id = "tags")
	WebElement txtTags;

	@FindBy(name = "location")
	WebElement txtLocation;

	@FindBy(name = "notes")
	WebElement txtNotes;

	@FindBy(name = "meeting_notes")
	WebElement txtMinutes;

	@FindBy(xpath = "//input[@fdprocessedid='rmfkqt']")
	WebElement btnSave;

	@FindBy(xpath = "//input[@value='<=REMOVE=']")
	WebElement btnRemove;

	@FindBy(xpath = "//tbody/tr[3]/td[2]/img[2]")
	WebElement btnClear1;

	@FindBy(xpath = "//tbody/tr[4]/td[2]/img[2]")
	WebElement btnClear2;

	public void moveToCalender() throws InterruptedException {
		Actions act = new Actions(driver);
		act.moveToElement(lnkCalendar).build().perform();
		Thread.sleep(3000);
		act.moveToElement(lnkNewEvent).build().perform();
		lnkNewEvent.click();

	}

	public void enterTitle(String title) {
		txtTitle.sendKeys(title);
	}

	public void enterFromDate() throws InterruptedException {
		String year = "2023";
		String month = "September";
		String date = "15";
		dateFrom.click();
		
		while (true) {
			WebElement monthYear = driver.findElement(By.xpath("//div[@class='calendar']//table//thead//tr[1]//td[2]"));
			String monyr = monthYear.getText();
			String arr[] = monyr.split(" , ");
			String mon = arr[0];
			String yr = arr[1];

			if (mon.equalsIgnoreCase(month) && yr.equals(year)) {
				break;
			} else {
				driver.findElement(By.xpath(
						"//td[@class='hilite hilite hilite nav button hilite']//div[@unselectable='on'][contains(text(),'›')]"))
						.click();
			}

		}
		List<WebElement> allDates = driver.findElements(By.xpath("//html/body/div[7]/table/tbody/tr/td"));
		for (WebElement ele : allDates) {
			String dt = ele.getText();
			if (dt.equalsIgnoreCase(date)) {
				ele.click();
				break;
			}
		}

		WebElement time = driver.findElement(By.xpath("//span[@class='hilite hour hilite']"));
		time.click();

	}

	public void enterToDate() throws InterruptedException {

		String year = "2023";
		String month = "September";
		String date = "16";
		dateTo.click();
		
		while (true) {
			WebElement monthYear = driver.findElement(By.xpath("//div[@class='calendar']//table//thead//tr[1]//td[2]"));
			String monyr = monthYear.getText();
			String arr[] = monyr.split(",");
			String mon = arr[0];
			String yr = arr[1];

			if (mon.equalsIgnoreCase(month) && yr.equals(year)) {
				break;
			} else {
				driver.findElement(By.xpath(
						"//td[@class='hilite hilite hilite nav button hilite']//div[@unselectable='on'][contains(text(),'›')]"))
						.click();
			}

		}
		List<WebElement> allDates = driver.findElements(By.xpath("//html/body/div[7]/table/tbody/tr/td"));
		for (WebElement ele : allDates) {
			String dt = ele.getText();
			if (dt.equalsIgnoreCase(date)) {
				ele.click();
				break;
			}
		}

		WebElement time = driver.findElement(By.xpath("//span[@class='hilite hour hilite']"));
		time.click();

	}

	public void selectCategory(String value) {
		Select sel = new Select(drpCategory);
		sel.selectByVisibleText(value);
	}

	public void clickOnAssignedTo() {
		buttonAdd.click();
	}

	public void enterContact(String contact) {
		txtContact.sendKeys(contact);
	}

	public void enterDeal(String deal) {
		txtDeal.sendKeys(deal);
	}

	public void enterCompany(String company) {
		txtCompany.sendKeys(company);
	}

	public void enterTask(String task) {
		txtTask.sendKeys(task);
	}

	public void enterCase(String cases) {
		txtCase.sendKeys(cases);
	}

	public void enterTags(String tags) {
		txtTags.sendKeys(tags);
	}

	public void enterLocations(String location) {
		txtLocation.sendKeys(location);
	}

	public void enterNotes(String notes) {
		txtNotes.sendKeys(notes);
	}

	public void enterMinutes(String minutes) {
		txtMinutes.sendKeys(minutes);
	}

	public void clickOnSave() {
		btnSave.click();
	}

	public boolean validateRemoveButton() {
		return btnRemove.isDisplayed();
	}

}
