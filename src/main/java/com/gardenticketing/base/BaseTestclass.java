package com.gardenticketing.base;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;

import com.gardenticketing.pages.admin.LoginPage;
import com.gardenticketing.utils.ConfigReader;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTestclass {

    protected static WebDriver driver;

    @BeforeSuite
    
    public void setUpSuite() {
        String browserName = ConfigReader.getProperty("browser");
        boolean headless = Boolean.parseBoolean(ConfigReader.getProperty("headless"));
        int implicitWait = Integer.parseInt(ConfigReader.getProperty("implicitWait"));

        System.out.println("🚀 Starting browser: " + browserName);

        if (browserName.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();

            if (headless) {
                options.addArguments("--headless=new", "--window-size=1920,1080");
            }

            options.addArguments("--disable-notifications");
            options.addArguments("--use-fake-ui-for-media-stream");
            driver = new ChromeDriver(options);
        } else {
            throw new RuntimeException(" Browser not supported yet: " + browserName);
        }

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(implicitWait));
        System.out.println(" Browser launched successfully");
    }

    // 🔹 Method to open portals dynamically
    public static void openPortal(String userType) {
        String url;
        switch (userType.toLowerCase()) {
            case "admin":
                url = ConfigReader.getProperty("adminPortalURL");
                break;
            case "citizen":
                url = ConfigReader.getProperty("citizenPortalURL");
                break;
            default:
                throw new RuntimeException(" Invalid user type specified: " + userType);
        }
        System.out.println(" Navigating to: " + url);
        driver.get(url);
    }

    //  Perform login once before any admin test class starts
    @BeforeClass
    public void loginToAdminOnce() {
        openPortal("admin"); // Open admin URL once

        // Login using page object
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterMobileNumber("9562341785");
        loginPage.clickSendOtp();
        loginPage.enterOTP("9999");
        loginPage.verifyotp();

        System.out.println(" Logged in successfully to Admin Portal");
    }

    @AfterSuite
    public void tearDownSuite() {
        if (driver != null) {
            driver.quit();
            System.out.println(" Browser closed successfully after suite");
        }
    }
}
