package com.gardenticketing.pages.admin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashboardPage {

    private WebDriver driver;

    @FindBy(xpath = "//div[contains(@class,'grid') and contains(@class,'gap-6')]")
    private WebElement dashboardHeader;
    
    @FindBy(xpath="//button[@class='relative px-2 py-1 text-sm font-normal transition-colors duration-300 cursor-pointer text-black']")
    WebElement Piegraphbutton;

    public DashboardPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Get count dynamically from within parent
    public String getCardCount(String cardTitle) {
        WebElement countElement = dashboardHeader.findElement(
            By.xpath(".//h3[normalize-space()='" + cardTitle + "']/following-sibling::p")
        );
        return countElement.getText().trim();
    }

    // Click card dynamically from within parent
    public void clickCard(String cardTitle) {
        WebElement cardElement = dashboardHeader.findElement(
            By.xpath(".//h3[normalize-space()='" + cardTitle + "']")
        );
        cardElement.click();
    }

	public void clickPieGraph() {
		Piegraphbutton.click();
	}
}
