import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class HardCoreTests {

    private WebDriver driver;

    @Before
    public void browserSetup() {
        System.setProperty("webdriver.chrome.driver", "C:\\Autotests\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    @Test
    public void createNewPaste() {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://cloud.google.com/");

        // Search "Google Cloud Platform Pricing Calculator"
        WebElement searchinput = driver.findElement(By.xpath("/html/body//devsite-header//input"));
        searchinput.click();
        searchinput.sendKeys("Google Cloud Platform Pricing Calculator", Keys.ENTER);
        new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@class='gs-title']/b")));

        // Open Google Calculator page
        WebElement searchCalculator = driver.findElement(By.xpath("//*[@class='gs-title']/b"));
        searchCalculator.click();

        // Active COMPUTE ENGINE section at the top of the page
        driver.switchTo().frame(0);
        driver.switchTo().frame(0);
        WebElement findComputeEngine = driver.findElement(By.xpath("//md-tab-item[1]"));
        findComputeEngine.click();
        //  driver.findElement(By.xpath("//md-tab-item/div/div/div[contains(@class, 'name ng-binding') and contains(.,'Compute Engine')]")).click();

        // Fill out the form
        // Number of instances: 4
        WebElement instanceNumber = driver.findElement(By.xpath("//*[@id='input_66']"));
        instanceNumber.sendKeys("4");

        // Operating System / Software: Free: Debian, CentOS, CoreOS, Ubuntu, or other User Provided OS
        WebElement operatinSystem = driver.findElement(By.xpath("//*[@id='select_value_label_59']/span[1]/div"));
        operatinSystem.click();
        WebElement operatinSystemDebian = driver.findElement(By.xpath("//*[@id='select_option_68']/div[1]"));
        operatinSystemDebian.click();

        // VM Class: Regular
        WebElement vmClass = driver.findElement(By.xpath("//*[@id='select_value_label_60']/span[1]/div"));
        vmClass.click();
        WebElement vmClassSelect = driver.findElement(By.xpath("//*[@id='select_option_81']/div[1]"));
        vmClassSelect.click();

        // Instance type: n1-standard-8    (vCPUs: 8, RAM: 30 GB)
        WebElement instanceType = driver.findElement(By.xpath("//*[@id='select_value_label_62']"));
        instanceType.click();
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='select_option_195']/div[1]")));
        WebElement instanceTypeSelect = driver.findElement(By.xpath("//*[@id='select_option_195']/div[1]"));
        instanceTypeSelect.click();
        WebElement machineType = driver.findElement(By.xpath("//*[@id='select_value_label_63']"));
        machineType.click();
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='select_option_376']/div")));
        WebElement standart8click = driver.findElement(By.xpath("//*[@id='select_option_376']/div"));
        standart8click.click();

        // Выбрать Add GPUs
        WebElement addGPU = driver.findElement(By.xpath("//*[@id='mainForm']/div[2]/div/md-card/md-card-content/div/div[1]/form/div[8]/div[1]/md-input-container/md-checkbox"));
        addGPU.click();

        // Number of GPUs: 1
        WebElement numberofGPU = driver.findElement(By.xpath("//*[@id='select_value_label_408']/span[1]/div"));
        numberofGPU.click();
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()=1]")));
        WebElement number1 = driver.findElement(By.xpath("//*[text()=1]"));
        number1.click();

        // GPU type: NVIDIA Tesla V100
        WebElement gpuType = driver.findElement(By.xpath("//md-select/md-select-value/span/div[contains(.,'NVIDIA Tesla K80')]"));
        gpuType.click();
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='select_option_422']/div")));
        WebElement typeNVIDIA100 = driver.findElement(By.xpath("//*[@id='select_option_422']/div"));
        typeNVIDIA100.click();

        // Local SSD: 2x375 Gb
        WebElement localSSD = driver.findElement(By.xpath("//div[10]/div[1]/md-input-container/md-select/md-select-value/span[1]/div"));
        localSSD.click();
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='select_option_397']/div")));
        WebElement localSSDselect = driver.findElement(By.xpath("//*[@id='select_option_397']/div"));
        localSSDselect.click();

        // Datacenter location: Frankfurt (europe-west3)
        WebElement dataCenterLocation = driver.findElement(By.xpath("//div[11]/div[1]/md-input-container/md-select/md-select-value/span[1]/div[normalize-space()='Iowa (us-central1)']"));
        dataCenterLocation.click();
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='select_option_212']/div")));
        WebElement dataCenterLocationSelect = driver.findElement(By.xpath("//*[@id='select_option_212']/div"));
        dataCenterLocationSelect.click();

        // Commited usage: 1 Year
        WebElement commitedUsage = driver.findElement(By.xpath("//div[14]/div[1]/md-input-container/md-select/md-select-value/span[1]/div[contains(.,'None')]"));
        commitedUsage.click();
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='select_option_100']/div")));
        WebElement commitedUsageSelect = driver.findElement(By.xpath("//*[@id='select_option_100']/div"));
        commitedUsageSelect.click();

        // Click 'Add to Estimate'
        WebElement addToEstimate = driver.findElement(By.xpath("//div[1]/form/div[15]/button[@aria-label='Add to Estimate']"));
        addToEstimate.click();

        // Click 'EMAIL ESTIMATE'
        WebElement emailEstimate = driver.findElement(By.xpath("//*[@id='email_quote']"));
        emailEstimate.click();

        //Open New tab, Copy e-mail and Paste e-mail on Calculator
        String email = getAddressEmail();
        driver.switchTo().frame(0);
        driver.switchTo().frame(0);
        WebElement emailField = driver.findElement(By.xpath("//*[@id='input_493']"));

        JavascriptExecutor je = (JavascriptExecutor) driver;
        je.executeScript("arguments[0].scrollIntoView(false);", emailField);

        emailField.click();
        emailField.sendKeys(email);

        // Click SEND EMAIL
        WebElement emailSend = driver.findElement(By.xpath("//form/md-dialog-actions/button[2]"));
        emailSend.click();

        //Receive sum from e-mail
        String priceFromEmail = getPriceFromEmail();

        //Receive sum from Google Calculator
        driver.switchTo().frame(0);
        driver.switchTo().frame(0);
        WebElement getPrice = driver.findElement(By.xpath("//*[@id='resultBlock']/md-card/md-card-content/div/div/div/h2"));
        String price = getPrice.getText();
        System.out.println(price);

        //Check that text from Google Calculator contains summ
        Assert.assertTrue("Суммы не совпадают", price.matches(".*?\\b" + priceFromEmail + "\\b.*?"));
    }

    // Open tab with E-mail
    public String getAddressEmail() {
        ((JavascriptExecutor)driver).executeScript("window.open()");
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        driver.get("https://10minutemail.info/");
        String email = driver.findElement(By.xpath("//*[@id='fe_text']")).getAttribute("value");
        driver.switchTo().window(tabs.get(0));
        return email;
    }

    // Switch on the tab with E-mail
    public String getPriceFromEmail() {
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));

        // Waiting and opening e-mail from Google Calculator
        new WebDriverWait(driver, 180).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Google Cloud Sales <noreply@google.com>']")));
        WebElement letter = driver.findElement(By.xpath("//*[text()='Google Cloud Sales <noreply@google.com>']"));
        letter.click();

        //Receive text with the sum
        WebElement getPrice = driver.findElement(By.xpath("//*[@id='tab1']/div[1]/div[1]/table/tbody/tr[2]/td/table/tbody/tr[2]/td[2]/h3"));
        String price = getPrice.getText();
        System.out.println(price);

        //Delete all letters and white spaces
        price = price.replaceAll("[a-zA-Zа-яА-Я]*\\s", "");
        System.out.println(price);

        //Switch to the tab
        driver.switchTo().window(tabs.get(0));

        //Return sum
        return price;
    }

    @After
    public void browserDown() {
        driver.quit();
        driver=null;
    }
}
