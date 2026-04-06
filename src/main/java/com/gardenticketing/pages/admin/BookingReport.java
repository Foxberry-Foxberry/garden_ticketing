package com.gardenticketing.pages.admin;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class BookingReport {

	private WebDriver driver;

	public BookingReport(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	//  WebElements 

	@FindBy(xpath="//span[normalize-space()='Booking Reports']")
	private WebElement clickonbookingreporttab;

	@FindBy(xpath="//button//span[contains(normalize-space(),'General')]")
	private WebElement choosegenralPass;

	@FindBy(xpath="//span[contains(translate(text(),'ABCDEFGHIJKLMNOPQRSTUVWXYZ','abcdefghijklmnopqrstuvwxyz'),'general pass')]")
	private WebElement genralpassdisaplytext;

	@FindBy(xpath="//span[normalize-space()='Creator']")
	private WebElement choosecreatorPass;

	@FindBy(xpath="//span[normalize-space()='creator pass']")
	private WebElement creatorpassdisaplytext;

	@FindBy(xpath="//span[normalize-space()='Event']")
	private WebElement chooseEvent;

	@FindBy(xpath="//span[normalize-space()='event pass']")
	private WebElement Eventpassdisplaytext;

	@FindBy(xpath="//th[normalize-space()='Ticket Category']")
	private WebElement ticketcategory;

	@FindBy(xpath="//table//tr//button[@data-action='view']")
	private WebElement viewactionbitton;

	@FindBy(xpath="//button[contains(@class,'rounded-tr-xl') and contains(@class,'rounded-bl-xl')]")
	private WebElement cancelticketicon;

	@FindBy(xpath="//label[normalize-space()='From Date']/preceding-sibling::input")
	private WebElement selectFromdate;

	@FindBy(xpath="//label[normalize-space()='To Date']/preceding-sibling::input")
	private WebElement ToDate;

	@FindBy(xpath="//div[@class='flex gap-1']")
	private WebElement searchdatewisedataButton;

	@FindBy(xpath="//button[@title='Reset Date']")
	private WebElement resetdatebutton;

	@FindBy(xpath="//button[@class='btn-success ml-auto']")
	private WebElement ClickonExportButton;

	@FindBy(xpath="//select[@class='text-sm p-2 text-gray-600']")
	private WebElement selectpagination;


	//  Methods

	public void clickBookingReportTab() {
		clickonbookingreporttab.click();
	}

	public void clickGeneralPass() {
		choosegenralPass.click();
	}

	public String getGeneralPassText() {
		return genralpassdisaplytext.getText().trim();
	}

	public void clickCreatorPass() {
		choosecreatorPass.click();
	}

	public String getCreatorPassText() {
		return creatorpassdisaplytext.getText().trim();
	}

	public void clickEventPass() {
		chooseEvent.click();
	}

	public String getEventPassText() {
		return Eventpassdisplaytext.getText().trim();
	}

	public String getTicketCategoryHeader() {
		return ticketcategory.getText().trim();
	}

	public void clickViewActionButton() {
		viewactionbitton.click();
	}

	public void clickCancelTicketIcon() {
		cancelticketicon.click();
	}

	public void clickFromDate() {
		selectFromdate.click();
		selectFromdate.sendKeys("01012025");
	}

	public void clickToDate() {
//		ToDate.click();
//		selectFromdate.sendKeys("2025-12-03");
		ToDate.sendKeys(Keys.CONTROL + "a");
		ToDate.sendKeys("2025-12-03");
		ToDate.sendKeys(Keys.TAB);

	}

	public void clickSearchDateWiseButton() {
		searchdatewisedataButton.click();
	}

	public void clickResetDateButton() {
		resetdatebutton.click();
	}

	public void clickExportButton() {
		ClickonExportButton.click();
	}
//
//	public void selectPaginationByVisibleText(String value) {
//		new Select(selectpagination).selectByVisibleText(value);
//	}

	public void selectPaginationByValue(String value) {
		new Select(selectpagination).selectByValue(value);
	}

//	public void selectPaginationByIndex(int index) {
//		new Select(selectpagination).selectByIndex(index);
//	}
}
