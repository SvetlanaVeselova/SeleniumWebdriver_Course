import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class ICanWinTests {

    @Test
    public void createNewPaste()  {
        System.setProperty("webdriver.chrome.driver", "C:\\Autotests\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://pastebin.com");

        // Код: "Hello from WebDriver"
        WebElement searchinput = driver.findElement(By.id("postform-text"));
        searchinput.sendKeys("Hello from WebDriver");

        // Paste Expiration: "10 Minutes"
        WebElement searchExpiration = driver.findElement(By.xpath("//*[@id='select2-postform-expiration-container']"));
        searchExpiration.click();
        WebElement search10Minutes = driver.findElement(By.xpath("//*[@id='select2-postform-expiration-results']/li[3]"));
        search10Minutes.click();

        // Paste Name / Title: "helloweb"
        WebElement searchName = driver.findElement(By.xpath("//*[@id='postform-name']"));
        searchName.sendKeys("helloweb");
        WebElement searchCreateBtn = driver.findElement(By.xpath("//*[@id='w0']//button"));
        searchCreateBtn.click();

        driver.quit();
    }
}
