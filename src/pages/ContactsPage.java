package pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import base.BaseClass;

public class ContactsPage extends BaseClass {

	public ContactsPage() throws IOException {
		super();
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[text()='Contacts']")
	WebElement lnkContacts;

	@FindBy(xpath = "//a[text()='New Contact']")
	WebElement lnkNewContacts;

	@FindBy(xpath = "//select[@name='title']")
	WebElement drpTitle;

	@FindBy(id = "first_name")
	WebElement txtFirstName;

	@FindBy(id = "surname")
	WebElement txtLastName;

	@FindBy(xpath = "//select[@name='suffix']")
	WebElement drpSuffix;

	@FindBy(name = "client_lookup")
	WebElement txtCompany;

	@FindBy(name = "contact_lookup_sup")
	WebElement txtSupervisor;

	@FindBy(name = "contact_lookup_ass")
	WebElement txtAssistant;

	@FindBy(name = "contact_lookup_ref")
	WebElement txtRefferedBy;

	@FindBy(xpath = "//select[@name='category']")
	WebElement drpCategory;

	@FindBy(xpath = "//select[@name='status']")
	WebElement drpstatus;

	@FindBy(id = "mobile")
	WebElement txtMobile;

	@FindBy(xpath = "//select[@name='im_netowrk']")
	WebElement drpMessagerNetwork;

	@FindBy(xpath = "//select[@name='source']")
	WebElement drpSource;

	@FindBy(name = "address_title")
	WebElement txtAddress;

	@FindBy(name = "city")
	WebElement txtCity;

	@FindBy(xpath = "//select[@name='time_zone']")
	WebElement drpTimeZone;

	@FindBy(xpath = "//select[@name='country']")
	WebElement drpCountry;

	@FindBy(xpath = "//input[@value='Save']")
	WebElement btnSave;

	@FindBy(xpath = "//td[@align='right']//strong[contains(text(),'Name')]")
	WebElement logoName;

	public boolean validateName() {
		return logoName.isDisplayed();

	}

	public void moveToContacts() throws InterruptedException {
		Actions act = new Actions(driver);
		act.moveToElement(lnkContacts).build().perform();
		Thread.sleep(3000);
		act.moveToElement(lnkNewContacts).build().perform();
		lnkNewContacts.click();
	}

	public void fillContactsDetails(String title, String fname, String lname, String suffix, String company,
			String supervisor, String assistant, String reffer, String category, String status, String mobile,
			String network, String source, String address, String city, String time, String country) {
		selectDropDownValues(drpTitle, title);
		txtFirstName.sendKeys(fname);
		txtLastName.sendKeys(lname);
		selectDropDownValues(drpSuffix, suffix);
		txtCompany.sendKeys(company);
		txtSupervisor.sendKeys(supervisor);
		txtAssistant.sendKeys(assistant);
		txtRefferedBy.sendKeys(reffer);
		selectDropDownValues(drpCategory, category);
		selectDropDownValues(drpstatus, status);
		txtMobile.sendKeys(mobile);
		selectDropDownValues(drpMessagerNetwork, network);
		selectDropDownValues(drpSource, source);
		txtAddress.sendKeys(address);
		txtCity.sendKeys(city);
		selectDropDownValues(drpTimeZone, time);
		selectDropDownValues(drpCountry, country);
		btnSave.click();

	}

	public static void selectDropDownValues(WebElement element, String value) {
		Select sel = new Select(element);
		sel.selectByVisibleText(value);
	}

}
