package pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import base.BaseClass;

public class CompaniesPage extends BaseClass {

	public CompaniesPage() throws IOException {
		super();
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[text()='Companies']")
	WebElement lnkCompanies;

	@FindBy(xpath = "//a[text()='New Company']")
	WebElement lnkNewCompany;

	@FindBy(xpath = "//td[normalize-space()='Google']")
	WebElement companyLogo;

	@FindBy(id = "company_name")
	WebElement textComapanyName;

	@FindBy(name = "industry")
	WebElement textIndustry;

	@FindBy(id = "annual_revenue")
	WebElement textAnnualRevenue;

	@FindBy(id = "num_of_employees")
	WebElement textNoOfEmployee;

	@FindBy(xpath = "//select[@name='status']")
	WebElement drpStatus;

	@FindBy(xpath = "//select[@name='category']")
	WebElement drpCategory;

	@FindBy(xpath = "//select[@name='priority']")
	WebElement drpPriority;

	@FindBy(xpath = "//select[@name='source']")
	WebElement drpSource;

	@FindBy(id = "vat_number")
	WebElement txtVatNo;

	@FindBy(name = "address_title")
	WebElement txtAddressTitle;

	@FindBy(xpath = "//select[@name='type']")
	WebElement drpType;

	@FindBy(name = "address")
	WebElement txtAddress;

	@FindBy(name = "city")
	WebElement txtCity;

	@FindBy(name = "state")
	WebElement txtState;

	@FindBy(name = "postcode")
	WebElement txtPostcode;

	@FindBy(name = "country")
	WebElement txtCountry;

	@FindBy(id = "service")
	WebElement txtDescription;

	@FindBy(xpath = "//tbody/tr[8]/td[1]/input[1]")
	WebElement btnSave;

	public void moveToCompanies() throws InterruptedException {
		Actions act = new Actions(driver);
		act.moveToElement(lnkCompanies).build().perform();
		Thread.sleep(3000);
		act.moveToElement(lnkNewCompany).build().perform();
		lnkNewCompany.click();
	}

	public boolean validateCompanyLogo() {
		return companyLogo.isDisplayed();

	}

	public void fillNewCompanyDetail(String cname, String iname, String rev, String emp, String stat, String catego,
			String prio, String src, String vat, String address, String type, String addr, String city, String state,
			String post, String country, String desc) {

		textComapanyName.sendKeys(cname);
		textIndustry.sendKeys(iname);
		textAnnualRevenue.sendKeys(rev);
		textNoOfEmployee.sendKeys(emp);
		selectDropDownValues(drpStatus, stat);
		selectDropDownValues(drpCategory, catego);
		selectDropDownValues(drpPriority, prio);
		selectDropDownValues(drpSource, src);
		txtVatNo.sendKeys(vat);
		txtAddressTitle.sendKeys(address);
		selectDropDownValues(drpType, type);
		txtAddress.sendKeys(addr);
		txtCity.sendKeys(city);
		txtState.sendKeys(state);
		txtPostcode.sendKeys(post);
		txtCountry.sendKeys(country);
		txtDescription.sendKeys(desc);
		btnSave.click();

	}

	public static void selectDropDownValues(WebElement element, String value) {
		Select sel = new Select(element);
		sel.selectByVisibleText(value);
	}

}
