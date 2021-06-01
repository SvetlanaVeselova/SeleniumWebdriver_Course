package tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageObject.Pastebin;

import java.util.concurrent.TimeUnit;

public class ICanWinTests {

    private WebDriver driver;

    @Before
    public void browserSetup() {
        System.setProperty("webdriver.chrome.driver", "C:\\Autotests\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://pastebin.com");
    }

    @Test
    public void createNewPaste()  {

        // Код: "Hello from WebDriver"
        Pastebin p = new Pastebin(driver);
        p.setValueSearch("Hello from WebDriver");

        // Paste Expiration: "10 Minutes"
        p.setValueExpiration ();

        // Paste Name / Title: "helloweb"
        p.setTitle("helloweb");
    }

    @After
    public void  browserDown() {
        driver.quit();
        driver=null;
    }
}
