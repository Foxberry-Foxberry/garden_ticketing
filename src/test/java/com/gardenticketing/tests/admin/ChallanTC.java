package com.gardenticketing.tests.admin;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.gardenticketing.base.BaseTestclass;
import com.gardenticketing.pages.admin.ChallanPage;

public class ChallanTC extends BaseTestclass {
//WebDriver driver;
private ChallanPage challanpagetc;

@BeforeClass
public void beforesetup() {
	challanpagetc=new ChallanPage(driver);
}

@Test
public void verify_User_GetChallanSheet() throws InterruptedException {
	
	Thread.sleep(6000);
	challanpagetc.clickonchallanbutton();
	challanpagetc.clickonselectmonthDD();
	challanpagetc.selectYearDD();
	challanpagetc.selectbyTextmonth("November");
	challanpagetc.selectbyTextYear("2025");
}



}
