import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class BringItOnTests {

    private WebDriver driver;

    @Before
    public void browserSetup() {
        System.setProperty("webdriver.chrome.driver", "C:\\Autotests\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    @Test
    public void createNewPaste()  {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://pastebin.com");

        // Создание New Paste элемента
        WebElement searchinput = driver.findElement(By.id("postform-text"));
        searchinput.sendKeys("git config --global user.name  \"New Sheriff in Town\"\n" +
                "git reset $(git commit-tree HEAD^{tree} -m \"Legacy code\")\n" +
                "git push origin master --force");

        // Syntax Highlighting: "Bash"
        WebElement searchHighlighting = driver.findElement(By.xpath("//*[@id='select2-postform-format-container']"));
        searchHighlighting.click();
        WebElement searchBash = driver.findElement(By.xpath("//*[@class='select2-results__options select2-results__options--nested']/li[1]"));
        searchBash.click();

        // Paste Expiration: "10 Minutes"
        WebElement searchExpiration = driver.findElement(By.xpath("//*[@id='select2-postform-expiration-container']"));
        searchExpiration.click();
        WebElement search10Minutes = driver.findElement(By.xpath("//*[@id='select2-postform-expiration-results']/li[3]"));
        search10Minutes.click();

        // Paste Name / Title: "how to gain dominance among developers"
        WebElement searchName = driver.findElement(By.xpath("//*[@id='postform-name']"));
        searchName.sendKeys("how to gain dominance among developers");
        WebElement searchCreateBtn = driver.findElement(By.xpath("//button[text()='Create New Paste']"));
        searchCreateBtn.click();

        // Проверка заголовка
        WebElement header = driver.findElement(By.xpath("//h1[text()='how to gain dominance among developers']"));
        Assert.assertTrue("Header didn't found", header.getText().equals("how to gain dominance among developers"));

        // Синтаксис подсвечен для bash
        WebElement bash = driver.findElement(By.xpath("//a[contains(.,'Bash')]"));
        Assert.assertTrue("Bash didn't found", bash.getText().equals("Bash"));

        // Проверка что код соответствует введенному
        WebElement code = driver.findElement(By.xpath("//div[@class='source']"));
        String checkFieldCode = "git config --global user.name  \"New Sheriff in Town\"\n" +
                "git reset $(git commit-tree HEAD^{tree} -m \"Legacy code\")\n" +
                "git push origin master --force";
        Assert.assertTrue("Bash didn't found", code.getText().equals(checkFieldCode));
    }

    @After
    public void  browserDown() {
        driver.quit();
        driver=null;
    }
}
