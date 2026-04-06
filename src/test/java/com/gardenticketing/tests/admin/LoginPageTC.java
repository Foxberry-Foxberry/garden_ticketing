package com.gardenticketing.tests.admin;

import org.testng.annotations.Test;
import com.gardenticketing.base.BaseTestclass;
import com.gardenticketing.pages.admin.LoginPage;

public class LoginPageTC extends BaseTestclass {

    @Test(priority = 1)
    public void verifyUserCanLoginWithValidOTP() throws InterruptedException {
        openPortal("admin");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterMobileNumber("9562341785");
        loginPage.clickSendOtp();
        loginPage.enterOTP("9999");
        Thread.sleep(2000);
        loginPage.verifyotp();
        System.out.println("✅ Page Title: " + loginPage.getPageTitle());
  
    }
    
    
    
}
