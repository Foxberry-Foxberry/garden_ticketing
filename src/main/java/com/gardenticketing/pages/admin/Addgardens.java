package com.gardenticketing.pages.admin;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.gardenticketing.base.BaseTestclass;

public class Addgardens extends BaseTestclass {

    private WebDriver driver;

    public Addgardens(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    //  ALL YOUR ORIGINAL LOCATORS – NOT MODIFIED 

    @FindBy(xpath = "//div[@class='flex-1 flex flex-col items-center overflow-y-auto scrollbar-thin scrollbar-thumb-gray-500 scrollbar-track-gray-300 px-8 mt-5']//div[2]//button[1]//span[1]//*[name()='svg']")
    WebElement clickongardens;

    @FindBy(xpath = "//a[@href='/dashboard/garden/add-details']")
    WebElement AddgardenButton;

    @FindBy(xpath="//label[contains(normalize-space(.), 'Garden Name')]/preceding-sibling::input")
    WebElement gardenname;

    @FindBy(xpath="//label[contains(normalize-space(), '*उद्यानाचे नाव')]/preceding-sibling::input")
    WebElement udyanname;

    @FindBy(xpath="//div[3]//div[1]//div[1]//div[1]")
    WebElement selectareafield;

    @FindBy(xpath="//div[normalize-space(text())='Chinchwad']")
    WebElement selectArea;

    @FindBy(xpath="//label[normalize-space()='*Area Code']/parent::div//input")
    WebElement areacode;

    @FindBy(xpath="//label[normalize-space()='*Zone']/preceding-sibling::div[contains(@class,'block')]")
    WebElement SelectZone;

    @FindBy(xpath="//div[contains(@class,'text-sm cursor-pointer px-4 py-2 transition-all whitespace-pre-wrap break-words')][normalize-space()='A']")
    WebElement selectAzone;

    @FindBy(xpath="//label[normalize-space()='*Location']/preceding-sibling::input")
    WebElement Location;

    @FindBy(xpath="//div//label[normalize-space()='*स्थान']/preceding-sibling::input")
    WebElement Stan;

    @FindBy(xpath="//div//label[normalize-space()='*GMap URL']/preceding-sibling::input")
    WebElement GMPmap;

    @FindBy(xpath="//div//label[normalize-space()='*Latitude']/preceding-sibling::input")
    WebElement Latitude;

    @FindBy(xpath="//div//label[normalize-space()='*Longitude']/preceding-sibling::input")
    WebElement Longitude;

    @FindBy(xpath="//div//label[normalize-space()='*Max Capacity']/preceding-sibling::input")
    WebElement maxcapicity;

    @FindBy(xpath="//div//label[normalize-space()='*Adult Entry Price']/preceding-sibling::input")
    WebElement adultentrypricefield;

    @FindBy(xpath="//div//label[normalize-space()='*Child Entry Price']/preceding-sibling::input")
    WebElement childentrypricefield;

    @FindBy(xpath="//label[normalize-space()='*Description']/preceding-sibling::textarea")
    WebElement description;

    @FindBy(xpath="//label[normalize-space()='*Description']/following::textarea[1]")
    WebElement varnan;

    
    
 //Upload Image
    @FindBy(id = "activityImg")
    WebElement uploadimage;

    @FindBy(xpath="//button[@id='uploadBtn']")
    WebElement cropimage;
    
    @FindBy(xpath="//button[normalize-space()='Upload Image']")
    WebElement uploadimg;
    
  //Upload vidios  
    @FindBy(id = "activityVideo")
    WebElement vidioupload;

    @FindBy(xpath="//label[normalize-space()='*Start Time']/parent::div//input[@type='time']")
    WebElement starttime;

    @FindBy(xpath="//label[normalize-space()='*End Time']/parent::div//input[@type='time']")
    WebElement endtime;

    @FindBy(xpath="//button//span[@class='text-xs']")
    WebElement savebutton;

    @FindBy(xpath="//div[contains(@class,'w-5') and contains(@class,'bg-white')]")
    WebElement creatorallowtoggle;

    @FindBy(xpath="//div[@class='w-full sm:w-[250px]'][1]//input")
    WebElement photographyprice;

    @FindBy(xpath="//label[normalize-space()='*Photography Price']/following::input[1]")
    WebElement vidiographyprice;

    @FindBy(xpath="//button[@class='btn-primary']")
    WebElement Submitgarden;
    
    //Update garden Details
    
    
    
    
    

    //  METHODS

    public void clickOnGardensMenu() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(clickongardens));
        clickongardens.click();
        wait.until(ExpectedConditions.visibilityOf(AddgardenButton));
    }

    public void clickAddGardenButton() {
        new WebDriverWait(driver, Duration.ofSeconds(6))
            .until(ExpectedConditions.elementToBeClickable(AddgardenButton));
        AddgardenButton.click();
    }

    public void enterGardenName(String gname) {
        gardenname.clear();
        gardenname.sendKeys(gname);
    }

    public void enterUdyanName(String uname) {
        udyanname.clear();
        udyanname.sendKeys(uname);
    }

    public void selectAreaField() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", selectareafield);
    }

    public void selectAreaChinchwad() {
        selectArea.click();
    }

    public void addareacode(String acode) {
        areacode.sendKeys(acode);
    }

    public void clickZone() {
        SelectZone.click();
    }

    public void selectAZone() {
        selectAzone.click();
    }

    public void clickLocationField(String location) {
        Location.sendKeys(location);
    }

    public void clickStanField(String inputstan) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement stanInput = wait.until(ExpectedConditions.elementToBeClickable(Stan));
        stanInput.clear();
        stanInput.sendKeys(inputstan);
    }

    public void enterGMapURL(String mapurl) {
        GMPmap.clear();
        GMPmap.sendKeys(mapurl);
    }

    public void enterLatitude(String lat) {
        Latitude.clear();
        Latitude.sendKeys(lat);
    }

    public void enterLongitude(String lng) {
        Longitude.clear();
        Longitude.sendKeys(lng);
    }

    public void enterMaxCapacity(String maxCap) {
        maxcapicity.clear();
        maxcapicity.sendKeys(maxCap);
    }

    public void enterAdultPrice(String price) {
        adultentrypricefield.clear();
        adultentrypricefield.sendKeys(price);
    }

    public void enterChildPrice(String price) {
        childentrypricefield.clear();
        childentrypricefield.sendKeys(price);
    }

    public void enterDescription(String desc) {
        description.clear();
        description.sendKeys(desc);
    }

    public void enterVarnan(String txt) {
        varnan.clear();
        varnan.sendKeys(txt);
    }

    // Upload Image Methods
    public void uploadImage(String path) {
        new WebDriverWait(driver, Duration.ofSeconds(10))
            .until(ExpectedConditions.presenceOfElementLocated(
                org.openqa.selenium.By.id("activityImg")
            ));
        uploadimage.sendKeys(path);
    }
    public void clickCropImage() {
        cropimage.click();
    }

    public void clickUploadImage() {
        uploadimg.click();
    }
    
    //Upload Vidios Methods
    
    public void uploadVideo(String path) {
        new WebDriverWait(driver, Duration.ofSeconds(10))
            .until(ExpectedConditions.presenceOfElementLocated(
                org.openqa.selenium.By.id("activityVideo")
            ));
        vidioupload.sendKeys(path);
    }

    //Start Time 
    
// // Method 1 — Click on time input
    public void clickStartTime() {
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", starttime);
    }
//
//    // Method 2 — Set time value directly
//    public void setStartTime(String timeValue) {
//        ((JavascriptExecutor) driver).executeScript("arguments[0].value = arguments[1];", starttime, timeValue);
//    }
   
    public void setStartTime(String timeValue) {
        starttime.click();
        starttime.sendKeys(Keys.CONTROL + "a");
        starttime.sendKeys(Keys.DELETE);
        starttime.sendKeys(timeValue);
        starttime.sendKeys(Keys.TAB);   // very important → triggers blur + validation
    }

    


    
    
    //End Time
 // Method 1 — Click End Time
    public void clickEndTime() throws InterruptedException {
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", endtime);
        Thread.sleep(3000);
    }
//
//    // Method 2 — Set End Time (21:00)
//    public void setEndTime(String timeValue) {
//        ((JavascriptExecutor) driver).executeScript("arguments[0].value = arguments[1];", endtime, timeValue);
//    }

    public void setEndTime(String timeValue) {
        endtime.click();
        endtime.sendKeys(Keys.CONTROL + "a");
        endtime.sendKeys(Keys.DELETE);
        endtime.sendKeys(timeValue);
        endtime.sendKeys(Keys.TAB);     // important
    }
    

    
    
    public void clickSaveButton() throws InterruptedException {
    Thread.sleep(3000);
        savebutton.click();
    }

    public void toggleCreatorAllow() {
        creatorallowtoggle.click();
    }

    public void enterPhotographyPrice(String price) {
        photographyprice.sendKeys(price);
    }

    public void enterVideographyPrice(String price) {
        vidiographyprice.sendKeys(price);
    }

    public void submitGardenForm() {
        Submitgarden.click();
    }
    
    
    
    
    //Update garden Methods
    
    
    public void updateMaxCapacity() {
        maxcapicity.clear();
    }
    
    
    public void updatePhotographyPrice() {
        photographyprice.clear();;
    }

    public void updateVideographyPrice() {
        vidiographyprice.clear();;
    }
    
    
    public void clickLastGardenAndUpdate() {
        // Locate all gardens
        List<WebElement> gardens = driver.findElements(
            By.xpath("//div[contains(@class,'cursor-pointer') and contains(@class,'shadow')]")
        );

        // Get last
        WebElement lastGarden = gardens.get(gardens.size() - 1);

        // Scroll into view
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", lastGarden);

        // Click last garden
        lastGarden.click();

       
    }

    public void clickonupdatebutton()
    {
    	WebElement updateBtn = driver.findElement(By.xpath("//button[contains(text(),'Update')]"));
        updateBtn.click();
    }
    
    //Delete garden
    
 // Locate & Open Last Garden
    public void openLastGarden() {
        List<WebElement> gardens = driver.findElements(
            By.xpath("//div[contains(@class,'cursor-pointer') and contains(@class,'shadow')]")
        );

        WebElement lastGarden = gardens.get(gardens.size() - 1);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", lastGarden);
        lastGarden.click();
    }

    // Click Delete Button
    public void clickDeleteButton() {
        WebElement deleteBtn = driver.findElement(
            By.xpath("//button[contains(text(),'Delete')]")
        );
        deleteBtn.click();
    }

    // Confirm Delete in Popup
    public void confirmDelete() {
        WebElement confirmBtn = driver.findElement(
            By.xpath("//button[@class='btn-danger ']")
        );
        confirmBtn.click();
    }

//    // Get Delete Success Message
//    public String getDeleteSuccessMessage() {
//        WebElement toast = driver.findElement(
//            By.xpath("//div[contains(@class,'toast') or contains(text(),'deleted')]")
//        );
//        return toast.getText();
//    }

    
    
    

}
