package com.gardenticketing.pages.admin;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {

    private WebDriver driver;
    private WebDriverWait wait; // default wait (10s)

    // Constructor
    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // default wait
    }

    // WebElements
    @FindBy(xpath = "//input[@id='_r_0_']")
    private WebElement mobileNumberInput;

    @FindBy(xpath = "//div[@class='flex items-center justify-center gap-1']")
    private WebElement sendotp;

    @FindBy(xpath = "//div[@class='flex justify-center gap-4 mb-6']//input")
    private List<WebElement> otpInputs;

    @FindBy(xpath = "//div[text()='Verify OTP']")
    private WebElement verifyotp;

    // Page Actions

    public void enterMobileNumber(String mobile) {
        try {
        
            WebDriverWait shortWait = new WebDriverWait(driver, Duration.ofSeconds(4));
            shortWait.until(ExpectedConditions.visibilityOf(mobileNumberInput));
            shortWait.until(ExpectedConditions.elementToBeClickable(mobileNumberInput));

            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", mobileNumberInput);

            mobileNumberInput.clear();
            mobileNumberInput.sendKeys(mobile);
            System.out.println(" Mobile number entered successfully: " + mobile);

        } catch (Exception e) {
            throw new RuntimeException("Unable to enter mobile number: " + e.getMessage());
        }
    }

    public void clickSendOtp() {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(sendotp)).click();
            System.out.println(" Clicked on Send OTP");
        } catch (Exception e) {
            throw new RuntimeException("Unable to click Send OTP button: " + e.getMessage());
        }
    }

    public void enterOTP(String otp) {
        try {
            if (otpInputs == null || otpInputs.isEmpty()) {
                throw new RuntimeException("OTP input fields not found.");
            }

            for (int i = 0; i < otp.length() && i < otpInputs.size(); i++) {
                wait.until(ExpectedConditions.elementToBeClickable(otpInputs.get(i)));
                otpInputs.get(i).clear();
                otpInputs.get(i).sendKeys(String.valueOf(otp.charAt(i)));
            }
            System.out.println(" OTP entered successfully");

        } catch (Exception e) {
            throw new RuntimeException("Unable to enter OTP: " + e.getMessage());
        }
    }

    public void loginAs(String mobile, String otp) {
        enterMobileNumber(mobile);
        clickSendOtp();
        enterOTP(otp);
        
    }
    public void verifyotp() {
    	verifyotp.click();
    }

    public String getPageTitle() {
        return driver.getTitle();
    }
}
