package tests;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObject.GoogleCalculator;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class HardCoreTests {

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

        // Search "Google Cloud Platform Pricing Calculator"
        g.searchCalculator("Google Cloud Platform Pricing Calculator", Keys.ENTER);
        new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@class='gs-title']/b")));

        // Open Google Calculator page
        g.openCalculator();

        // Active COMPUTE ENGINE section at the top of the page
        g.activeFrame();
        g.activeComputeEngine();

        // Fill out the form
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

        // Click 'EMAIL ESTIMATE'
        g.clickOnEmailEstimate();

        //Open New tab, Copy e-mail and Paste e-mail on Calculator
         String email = g.getAddressEmail();
         ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
         driver.switchTo().window(tabs.get(0));
         g.activeFrame();
         g.scrollToEmail();
         g.pasteEmail(email);

        // Click SEND EMAIL
        g.clickSendEmail();

        //Receive sum from e-mail
         String priceFromEmail = g.getPriceFromEmail();

        //Switch to the tab
        driver.switchTo().window(tabs.get(0));

        //Receive sum from Google Calculator
        g.activeFrame();
        g.clickGetPrice();

        //Check that text from Google Calculator contains summ
         Assert.assertTrue("Суммы не совпадают", g.clickGetPrice().matches(".*?\\b" + priceFromEmail + "\\b.*?"));
   }

    @After
    public void browserDown() {
        driver.quit();
        driver=null;
    }
}
