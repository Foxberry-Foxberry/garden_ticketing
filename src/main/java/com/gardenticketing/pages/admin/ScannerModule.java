package com.gardenticketing.pages.admin;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ScannerModule {

private WebDriver driver;


public ScannerModule(WebDriver driver) {
	this.driver=driver;
	PageFactory.initElements(driver, this);
}




//WebElements

@FindBy(xpath="//button[normalize-space()='Scanner']")
private WebElement clickScannerfield;

@FindBy(xpath="//button[@title='OFF']")
private WebElement ClickOffcamera;

@FindBy(xpath="//button[@title='ON']")
private WebElement clickONCamera;

@FindBy(xpath="//div[contains(@class,'w-8 h-8 rounded-full flex justify-center items-center bg-gray-500')]")
private WebElement  clickOnprofile;

@FindBy(xpath="//div[contains(@class,'flex items-center gap-1 mb-6')]//*[name()='svg']")
private WebElement profilebackarrow;


//Methods 

public void clickScanner() {
    clickScannerfield.click();
}

public void turnOffCamera() {
    ClickOffcamera.click();
}

public void turnOnCamera() {
    clickONCamera.click();
}

public void openProfile() {
    clickOnprofile.click();
}

public void clickProfileBackArrow() {
    profilebackarrow.click();
}









}
