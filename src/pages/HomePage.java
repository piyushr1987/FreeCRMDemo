package pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.BaseClass;

public class HomePage extends BaseClass {

	public HomePage() throws IOException {
		super();
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[text()='Home']")
	WebElement lnkHome;

	@FindBy(xpath = "//a[text()='Calendar']")
	WebElement lnkCalender;

	@FindBy(xpath = "//a[text()='Companies']")
	WebElement lnkCompanies;

	@FindBy(xpath = "//a[text()='Contacts']")
	WebElement lnkContacts;

	@FindBy(xpath = "//a[text()='Deals']")
	WebElement lnkDeals;

	@FindBy(xpath = "//a[text()='Tasks']")
	WebElement lnkTasks;

	@FindBy(xpath = "//a[text()='Cases']")
	WebElement lnkCases;

	@FindBy(xpath = "//a[text()='Call']")
	WebElement lnkCall;

	@FindBy(xpath = "//a[text()='Email']")
	WebElement lnkEmail;

	@FindBy(xpath = "//a[text()='Text/SMS']")
	WebElement lnkText;

	@FindBy(xpath = "//a[text()='Print']")
	WebElement lnkPrint;

	@FindBy(xpath = "//a[text()='Campaigns']")
	WebElement lnkCampaigns;

	@FindBy(xpath = "//a[text()='Docs']")
	WebElement lnkDocs;

	@FindBy(xpath = "//a[text()='Forms']")
	WebElement lnkForms;

	@FindBy(xpath = "//a[text()='Reports']")
	WebElement lnkReports;

	public boolean homeLink() {
		return lnkHome.isDisplayed();

	}

	public boolean calenderLink() {
		return lnkCalender.isDisplayed();

	}

	public boolean companiesLink() {
		return lnkCompanies.isDisplayed();

	}

	public boolean contactsLink() {
		return lnkContacts.isDisplayed();

	}

	public boolean dealsLink() {
		return lnkDeals.isDisplayed();

	}

	public boolean tasksLink() {
		return lnkTasks.isDisplayed();

	}

	public boolean casesLink() {
		return lnkCases.isDisplayed();

	}

	public boolean callLink() {
		return lnkCall.isDisplayed();

	}

	public boolean emailLink() {
		return lnkEmail.isDisplayed();

	}

	public boolean textLink() {
		return lnkText.isDisplayed();

	}

	public boolean printLink() {
		return lnkPrint.isDisplayed();

	}

	public boolean campaignLink() {
		return lnkCampaigns.isDisplayed();

	}

	public boolean docsLink() {
		return lnkDocs.isDisplayed();

	}

	public boolean formsLink() {
		return lnkForms.isDisplayed();

	}

	public boolean reportsLink() {
		return lnkReports.isDisplayed();

	}

}
