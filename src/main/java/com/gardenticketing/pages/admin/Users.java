package com.gardenticketing.pages.admin;
import com.gardenticketing.utils.Utilclass;



import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Users {

    private WebDriver driver;
    

    public Users(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // WebElements
    @FindBy(xpath = "//button[normalize-space()='Users']")
    private WebElement clickOnUsersField;

    @FindBy(xpath = "//a[contains(@class,'btn-primary text-xs')]")
    private WebElement clickOnAddOperator;

    @FindBy(xpath = "//label[contains(normalize-space(), 'Name')]/preceding-sibling::input")
    private WebElement addName;

    @FindBy(xpath = "//label[contains(normalize-space(), 'Email')]/preceding-sibling::input")
    private WebElement addEmail;

    @FindBy(xpath = "//label[contains(normalize-space(), 'Mobile No')]/preceding-sibling::input")
    private WebElement addMobilenumber;

    @FindBy(xpath = "//label[contains(normalize-space(), '*Date Of Birth')]/preceding-sibling::input")
    private WebElement sendDOB;

    @FindBy(xpath = "(//div[contains(@class,'cursor-pointer') and contains(@class,'justify-between')])[1]")
    private WebElement selectGender;

    @FindBy(xpath = "(//div[contains(@class,'cursor-pointer') and contains(@class,'justify-between')])[2]")
    private WebElement selectUserRole;
    
    @FindBy(xpath = "//div[contains(@class,'block px-3 pb-2 pt-3 w-full') and contains(@class,'cursor-pointer')]")
    private WebElement gardenDropdown;

    @FindBy(xpath = "//button[normalize-space()='Submit']")
    private WebElement clickOnSubmit;

    
    @FindBy(xpath="//select[contains(@class,'text-sm')]")
   private WebElement selectpaginationdropdown;

  
    @FindBy(xpath="(//button[@data-action='delete'])[last()]")
    private WebElement deleteuser;
    
    
    @FindBy(xpath="//button[contains(@class,'btn-danger ')]")
    private WebElement Deletecofirmation;
    
    @FindBy(xpath="//div[contains(text(),'User Deleted Sucessfully')]")
    private WebElement DeleteTostmessage;
    
    
    
    // METHODS
 

    public void openUsersModule() {
        clickOnUsersField.click();
    }

    public void clickAddOperator() {
        clickOnAddOperator.click();
    }

    public void enterName(String name) {
        addName.clear();
        addName.sendKeys(name);
    }

    public void enterEmail(String email) {
        addEmail.clear();
        addEmail.sendKeys(email);
    }

    public void enterMobileNumber(String mobile) {
        addMobilenumber.clear();
        addMobilenumber.sendKeys(mobile);
    }

    public void enterDOB(String dob) {
        sendDOB.clear();
        sendDOB.sendKeys(dob);
    }


 // Select Gender from Dropdown (Dynamic)
    public void selectGenderOption(String genderText) {
        selectGender.click();
        WebElement option = driver.findElement(
            By.xpath("//div[contains(@class,'cursor-pointer') and normalize-space()='" + genderText + "']")
        );
        option.click();
    }

//    // OR If your dropdown options are <li> or simple <div> text use below:
//    public void selectGenderValue(String value) {
//        selectGender.click();
//        driver.findElement(By.xpath("//div[normalize-space()='" + value + "']")).click();
//    }


 // Select User Role from Dropdown (Dynamic)
    public void selectUserRoleOption(String roleText) {
        selectUserRole.click();
        WebElement option = driver.findElement(
            By.xpath("//div[contains(@class,'cursor-pointer') and normalize-space()='" + roleText + "']")
        );
        option.click();
    }

    
    
    public void selectGarden(String gardenName) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // 1. Click the dropdown box to expand options
        WebElement dropdown = driver.findElement(By.xpath(
            "//label[normalize-space()='*Select Garden']/preceding-sibling::div"
        ));
        
        dropdown.click();

        
        
        // 2. Wait until the option is visible (after dropdown opens)
        WebElement option = wait.until(ExpectedConditions.visibilityOfElementLocated(
            By.xpath("//div[contains(@class,'text-sm cursor-pointer') and normalize-space(text())='" + gardenName + "']")
        ));

        // 3. Scroll to the option (if needed)
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", option);

        // 4. Click the option
        option.click();
    }

    public void clickSubmit() {
        clickOnSubmit.click();
    }
    
//	public void selectpagination() {
//		selectpaginationdropdown.click();
//	}
    
    public void selectPaginationByValue(String value) {
        Utilclass.selectByValue(selectpaginationdropdown, value);
    }
    
    public void clickondeletebutton() {
    	deleteuser.click();
    }
   
   public void deleteuserconfirmation() {
	   Deletecofirmation.click();
   }

   public String getSuccessMessage() {
	
	return null;
   }
   
   
   
	

}
