package tests;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObject.GoogleCalculator;
import pageObject.Pastebin;

import java.util.concurrent.TimeUnit;

public class HurtMePlentyTests {

    private WebDriver driver;


    @Before
    public void browserSetup() {
        System.setProperty("webdriver.chrome.driver", "C:\\Autotests\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://cloud.google.com/");
    }

    @Test
    public void createNewPaste() {

        GoogleCalculator g = new GoogleCalculator(driver);

        // Поиск "Google Cloud Platform Pricing Calculator"
        g.searchCalculator("Google Cloud Platform Pricing Calculator", Keys.ENTER);
        new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@class='gs-title']/b")));

        // Переход на страницу калькулятора
        g.openCalculator();

        // Активируем раздел COMPUTE ENGINE вверху страницы
        g.activeFrame();
        g.activeComputeEngine();

        // Заполняем форму
        // Number of instances: 4
        g.numberOfInstances("4");

        // Operating System / Software: Free: Debian, CentOS, CoreOS, Ubuntu, or other User Provided OS
        g.selectOs();

        // VM Class: Regular
        g.selectVm();

        // Instance type: n1-standard-8    (vCPUs: 8, RAM: 30 GB)
        g.selectInstance();

        // Выбрать Add GPUs
        g.selectAddGPU();

        // Number of GPUs: 1
        g.selectNumberofGPU();

        // GPU type: NVIDIA Tesla V100
        g.selectGPUType();

        // Local SSD: 2x375 Gb
        g.selectSSD();

        // Datacenter location: Frankfurt (europe-west3)
        g.selectDatacenter();

        // Commited usage: 1 Year
        g.selectCommitedUsage();

        // Click 'Add to Estimate'
        g.clickAddEstimate();

       // Проверка VM Class
        Assert.assertTrue("VM Class is incorrect", g.getvmClass().equals("VM class: regular"));

        // Проверка Instance type
        Assert.assertTrue("Instance type is incorrect", g.getInstanceType().equals("Instance type: n1-standard-8"));

        // Проверка Region
        Assert.assertTrue("Region is incorrect", g.getRegionCheck().equals("Region: Frankfurt"));

        // Проверка local SSD
        Assert.assertTrue("local SSD is incorrect", g.getLocalSSD().equals("Total available local SSD space 2x375 GiB"));

        // Проверка commitment term
        Assert.assertTrue("Commitment term is incorrect", g.getCommitment().equals("Commitment term: 1 Year"));

        // Проверка Суммы аренды в месяц
        Assert.assertTrue("Summ is incorrect", g.getSummCheck().equals("Estimated Component Cost: USD 1,082.77 per 1 month"));
    }

    @After
    public void browserDown() {
        driver.quit();
        driver=null;
    }
}
