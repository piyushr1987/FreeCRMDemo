package pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import base.BaseClass;

public class DealsPage extends BaseClass {

	public DealsPage() throws IOException {
		super();
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[text()='Deals']")
	WebElement lnkDeals;

	@FindBy(xpath = "//a[text()='New Deal']")
	WebElement lnkNewDeals;

	@FindBy(id = "title")
	WebElement txtTitle;

	@FindBy(name = "client_lookup")
	WebElement txtCompany;

	@FindBy(name = "contact_lookup")
	WebElement txtPrimaryContact;

	@FindBy(name = "amount")
	WebElement txtAmount;

	@FindBy(id = "quantity")
	WebElement txtQuantity;

	@FindBy(xpath = "//select[@name='type']")
	WebElement drpType;

	@FindBy(xpath = "//select[@name='source']")
	WebElement drpSource;

	@FindBy(name = "description")
	WebElement txtDescription;

	@FindBy(name = "next_step")
	WebElement txtNextStep;

	@FindBy(xpath = "//input[@value='Save']")
	WebElement btnSave;

	@FindBy(xpath = "//td[@align='right']//strong[contains(text(),'Owner')]")
	WebElement lblOwner;

	public void moveToDeals() throws InterruptedException {
		Actions act = new Actions(driver);
		act.moveToElement(lnkDeals).build().perform();
		Thread.sleep(3000);
		act.moveToElement(lnkNewDeals).build().perform();
		lnkNewDeals.click();
	}

	public boolean validateOwnerName() {
		return lblOwner.isDisplayed();

	}

	public void fillDetailsOfNewDeal(String title, String comapny, String contact, String amount, String quantity,
			String type, String source, String description, String step) {
		txtTitle.sendKeys(title);
		txtCompany.sendKeys(comapny);
		txtPrimaryContact.sendKeys(contact);
		txtAmount.sendKeys(amount);
		txtQuantity.sendKeys(quantity);
		selectDropDownValues(drpType, type);
		selectDropDownValues(drpSource, source);
		txtDescription.sendKeys(description);
		txtNextStep.sendKeys(step);
		btnSave.click();
	}

	public static void selectDropDownValues(WebElement element, String value) {
		Select sel = new Select(element);
		sel.selectByVisibleText(value);
	}

}
