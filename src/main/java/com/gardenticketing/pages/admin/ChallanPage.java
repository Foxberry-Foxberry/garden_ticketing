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
	
	@FindBy(xpath="//span[contains(@class,'select-none') and contains(@class,'rotate-180')] ")
	WebElement SelectMonth;
	
	@FindBy(xpath="//span[contains(@class,'select-none') and contains(@class,'rotate-0')]")
	WebElement selectyear;
	
	
	
	
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
	
	public void selectYearDD() {
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    wait.until(ExpectedConditions.elementToBeClickable(selectyear));
	    selectyear.click();
	}
	
	public void selectbyTextmonth(String value) {
		Utilclass.selectByText(SelectMonth, value);
	}
	
	public void selectbyTextYear(String value) {
		Utilclass.selectByText(selectyear, value);
	}
}
