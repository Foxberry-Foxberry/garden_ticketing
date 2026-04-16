package com.gardenticketing.pages.admin;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.gardenticketing.utils.Utilclass;

public class ChallanPage {

	private WebDriver driver;

	public ChallanPage(WebDriver Driver) {
		this.driver=driver;
		PageFactory.initElements(Driver, this);
	}
	
	
	//Locaters
	@FindBy(xpath="//span[contains(text(),'Challan')]")
	WebElement clickonchallan;
	
	@FindBy(xpath="//label[text()='Select Month']/preceding::span[.//*[name()='svg']][1]")
	WebElement SelectMonth;
	
	@FindBy(xpath="//div[text()='November']")
	WebElement month;
	
	@FindBy(xpath="//label[normalize-space()='Select Year']/preceding::span[.//*[name()='svg']][1]")
	WebElement selectyear;
	
	@FindBy(xpath="//div[text()='2025']")
	WebElement Year;
	
	@FindBy(xpath="//button[@class='btn-primary']")
	WebElement getchallanbutton;
	
	@FindBy(xpath="//div[@class='pt-3 mb-6']")
	WebElement calendertable;
	
	
	
	
	
	
	//Methods
	
	
	public void clickonchallanbutton() {
		clickonchallan.click();
	}
	
	public void clickOnChallan() {
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    wait.until(ExpectedConditions.elementToBeClickable(clickonchallan));
	    clickonchallan.click();
	}
	
	public void clickonselectmonthDD() {
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    wait.until(ExpectedConditions.elementToBeClickable(SelectMonth));
	    SelectMonth.click();
	}
	
	public void Month() {
		month.click();
	}
	
//	public void selectbyTextmonth(String value) {
//		Utilclass.selectByText(SelectMonth, value);
//	}
	
	public void selectYearDD() {
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    wait.until(ExpectedConditions.elementToBeClickable(selectyear));
	    selectyear.click();
	}
	public void Year() {
		Year.click();
	}
	
//	public void selectbyTextYear(String value) {
//		Utilclass.selectByText(selectyear, value);
//	}
	
	
	public void clickongetchallanbutton() {
		getchallanbutton.click();
	}
	
	public boolean getcalender() {
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    wait.until(ExpectedConditions.visibilityOf(calendertable));
	    return calendertable.isDisplayed();
	}

	
}
