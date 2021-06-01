package pageObject;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;

public class GoogleCalculator {

    private WebDriver driver;

    public GoogleCalculator(WebDriver driver) {
        this.driver = driver;
    }

    private By searchinput = By.xpath("/html/body//devsite-header//input");
    private By searchCalculator = By.xpath("//*[@class='gs-title']/b");
    private By findComputeEngine = By.xpath("//md-tab-item[1]");
    private By instanceNumber = By.xpath("//*[@id='input_66']");
    private By operatinSystem = By.xpath("//*[@id='select_value_label_59']/span[1]/div");
    private By operatinSystemDebian = By.xpath("//*[@id='select_option_68']/div[1]");
    private By vmClass = By.xpath("//*[@id='select_value_label_60']/span[1]/div");
    private By vmClassSelect = By.xpath("//*[@id='select_option_81']/div[1]");
    private By instanceType = By.xpath("//*[@id='select_value_label_62']");
    private By instanceTypeSelect = By.xpath("//*[@id='select_option_195']/div[1]");
    private By machineType = By.xpath("//*[@id='select_value_label_63']");
    private By standard8click = By.xpath("//*[@id='select_option_376']/div");
    private By addGPU = By.xpath("//*[@id='mainForm']/div[2]/div/md-card/md-card-content/div/div[1]/form/div[9]/div[1]/md-input-container/md-checkbox");
    private By numberofGPU = By.xpath("//*[@id='select_value_label_408']/span[1]/div");
    private By number1 = By.xpath("//*[text()=1]");
    private By gpuType = By.xpath("//md-select/md-select-value/span/div[contains(.,'NVIDIA Tesla K80')]");
    private By typeNVIDIA100 = By.xpath("//*[@id='select_option_422']/div");
    private By localSSD = By.xpath("//*[@id='select_value_label_370']");
    private By localSSDselect = By.xpath("//*[@id='select_option_397']/div");
    private By dataCenterLocation = By.xpath("//*[@id='select_value_label_64']/span[1]/div");
    private By dataCenterLocationSelect = By.xpath("//*[@id='select_option_212']/div");
    private By commitedUsage = By.xpath("//*[@id='select_value_label_65']/span[1]/div");
    private By commitedUsageSelect = By.xpath("//*[@id='select_option_100']/div");
    private By addToEstimate = By.xpath("//*[@id='mainForm']/div[2]/div/md-card/md-card-content/div/div[1]/form/div[16]/button");
    private By vmClassCheck = By.xpath("//*[@id='compute']/md-list/md-list-item[2]/div");
    private By instanceTypeCheck = By.xpath("//*[@id='compute']/md-list/md-list-item[3]/div");
    private By regionCheck = By.xpath("//*[@id='compute']/md-list/md-list-item[4]/div");
    private By localSSDCheck = By.xpath("//*[@id='compute']/md-list/md-list-item[5]/div");
    private By commitCheck = By.xpath("//*[@id='compute']/md-list/md-list-item[6]/div");
    private By summCheck = By.xpath("//*[@id='compute']/md-list/md-list-item[7]/div/b");
    private By emailEstimate = By.xpath("//*[@id='email_quote']");
    private By emailField = By.xpath("//*[@id='input_493']");
    private By emailSend = By.xpath("//form/md-dialog-actions/button[2]");
    private By getPrice = By.xpath("//*[@id='resultBlock']/md-card/md-card-content/div/div/div/h2");
    private By getEmail = By.xpath("//*[@id='fe_text']");
    private By letterElement = By.xpath("//*[text()='Google Cloud Sales <noreply@google.com>']");
    private By priceElement = By.xpath("//*[@id='tab1']//tr[2]/td[2]/h3");
    //*[@id="tab1"]/div/div/table/tbody/tr[2]/td/table/tbody/tr[2]/td[2]/h3

    public void searchCalculator(String value1, Keys value2) {
        driver.findElement(searchinput).click();
        driver.findElement(searchinput).sendKeys(value1, value2);
    }

    public void openCalculator() {
        driver.findElement(searchCalculator).click();
    }

    public void activeComputeEngine() {
        driver.findElement(findComputeEngine).click();
    }

    public void activeFrame() {
        driver.switchTo().frame(0);
        driver.switchTo().frame(0);
    }

    public void numberOfInstances(String value) {
        driver.findElement(instanceNumber).click();
        driver.findElement(instanceNumber).sendKeys(value);
    }

    public void selectOs() {
        driver.findElement(operatinSystem).click();
        driver.findElement(operatinSystemDebian).click();
    }

    public void selectVm() {
        driver.findElement(vmClass).click();
        driver.findElement(vmClassSelect).click();
    }

    public void selectInstance() {
        driver.findElement(instanceType).click();
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(instanceTypeSelect));
        driver.findElement(instanceTypeSelect).click();
        driver.findElement(machineType).click();
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(standard8click));
        driver.findElement(standard8click).click();
    }

    public void selectAddGPU() {
        driver.findElement(addGPU).click();
    }

    public void selectNumberofGPU() {
        driver.findElement(numberofGPU).click();
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(number1));
        driver.findElement(number1).click();
    }

    public void selectGPUType() {
        driver.findElement(gpuType).click();
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(typeNVIDIA100));
        driver.findElement(typeNVIDIA100).click();
    }

    public void selectSSD() {
        driver.findElement(localSSD).click();
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(localSSDselect));
        driver.findElement(localSSDselect).click();
    }

    public void selectDatacenter() {
        driver.findElement(dataCenterLocation).click();
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(dataCenterLocationSelect));
        driver.findElement(dataCenterLocationSelect).click();
    }

    public void selectCommitedUsage() {
        driver.findElement(commitedUsage).click();
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(commitedUsageSelect));
        driver.findElement(commitedUsageSelect).click();
    }

    public void clickAddEstimate() {
        driver.findElement(addToEstimate).click();
    }

    public String getvmClass() {
        return driver.findElement(vmClassCheck).getText();
    }

    public String getInstanceType() {
        return driver.findElement(instanceTypeCheck).getText();
    }

    public String getRegionCheck() {
        return driver.findElement(regionCheck).getText();
    }

    public String getLocalSSD() {
        return driver.findElement(localSSDCheck).getText();
    }

    public String getCommitment() {
        return driver.findElement(commitCheck).getText();
    }

    public String getSummCheck() {
        return driver.findElement(summCheck).getText();
    }

    public void clickOnEmailEstimate() {
        driver.findElement(emailEstimate).click();
    }

    public void pasteEmail(String value) {
        driver.findElement(emailField).click();
        driver.findElement(emailField).sendKeys(value);
    }

    public void scrollToEmail() {
        JavascriptExecutor je = (JavascriptExecutor) driver;
        je.executeScript("arguments[0].scrollIntoView(false);", driver.findElement(emailField));
    }

    public void clickSendEmail() {
        driver.findElement(emailSend).click();
    }

    public String clickGetPrice() {
        return driver.findElement(getPrice).getText();
    }

    public String getAddressEmail() {
        ((JavascriptExecutor) driver).executeScript("window.open()");
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        driver.get("https://10minutemail.info/");
        String email = driver.findElement(getEmail).getAttribute("value");
        return email;
    }

    // Switch on the tab with E-mail
    public String getPriceFromEmail() {
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));

        // Waiting and opening e-mail from Google Calculator
        new WebDriverWait(driver, 180).until(ExpectedConditions.visibilityOfElementLocated(letterElement));
        WebElement letter = driver.findElement(letterElement);
        letter.click();

        //Receive text with the sum
        WebElement getPrice = driver.findElement(priceElement);
        String price = getPrice.getText();
        System.out.println(price);

        //Delete all letters and white spaces
        price = price.replaceAll("[a-zA-Zа-яА-Я]*\\s", "");
        System.out.println(price);

        //Return sum
        return price;
    }
}
