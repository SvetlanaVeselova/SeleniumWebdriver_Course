import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Locatable;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class HurtMePlentyTests {

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

        // Поиск "Google Cloud Platform Pricing Calculator"
        WebElement searchinput = driver.findElement(By.xpath("/html/body//devsite-header//input"));
        searchinput.click();
        searchinput.sendKeys("Google Cloud Platform Pricing Calculator", Keys.ENTER);
        new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@class='gs-title']/b")));

        // Переход на страницу калькулятора
        WebElement searchCalculator = driver.findElement(By.xpath("//*[@class='gs-title']/b"));
        searchCalculator.click();

        // Активируем раздел COMPUTE ENGINE вверху страницы
        driver.switchTo().frame(0);
        driver.switchTo().frame(0);
        WebElement findComputeEngine = driver.findElement(By.xpath("//md-tab-item[1]"));
        findComputeEngine.click();
        //  driver.findElement(By.xpath("//md-tab-item/div/div/div[contains(@class, 'name ng-binding') and contains(.,'Compute Engine')]")).click();

        // Заполняем форму
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

       // Проверка VM Class
        WebElement vmClassCheck = driver.findElement(By.xpath("//*[@id='compute']/md-list/md-list-item[2]/div"));
        Assert.assertTrue("VM Class is incorrect", vmClassCheck.getText().equals("VM class: regular"));

        // Проверка Instance type
        WebElement instanceTypeCheck = driver.findElement(By.xpath("//*[@id='compute']/md-list/md-list-item[3]/div"));
        Assert.assertTrue("Instance type is incorrect", instanceTypeCheck.getText().equals("Instance type: n1-standard-8"));

        // Проверка Region
        WebElement regionCheck = driver.findElement(By.xpath("//*[@id='compute']/md-list/md-list-item[4]/div"));
        Assert.assertTrue("Region is incorrect", regionCheck.getText().equals("Region: Frankfurt"));

        // Проверка local SSD
        WebElement localSSDCheck = driver.findElement(By.xpath("//*[@id='compute']/md-list/md-list-item[5]/div"));
        Assert.assertTrue("local SSD is incorrect", localSSDCheck.getText().equals("Total available local SSD space 2x375 GiB"));

        // Проверка commitment term
        WebElement commitCheck = driver.findElement(By.xpath("//*[@id='compute']/md-list/md-list-item[6]/div"));
        Assert.assertTrue("Commitment term is incorrect", commitCheck.getText().equals("Commitment term: 1 Year"));

        // Проверка Суммы аренды в месяц
        WebElement summCheck = driver.findElement(By.xpath("//*[@id='compute']/md-list/md-list-item[7]/div/b"));
        Assert.assertTrue("Summ is incorrect", summCheck.getText().equals("Estimated Component Cost: USD 1,082.77 per 1 month"));
    }

    @After
    public void browserDown() {
        driver.quit();
        driver=null;
    }
}
