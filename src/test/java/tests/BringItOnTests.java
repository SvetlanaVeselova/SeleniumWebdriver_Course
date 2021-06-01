package tests;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import pageObject.Pastebin;

import java.util.concurrent.TimeUnit;

public class BringItOnTests {

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

        // Создание New Paste элемента
        Pastebin p = new Pastebin(driver);
        p.setValueSearch("git config --global user.name  \"New Sheriff in Town\"\n" +
                "git reset $(git commit-tree HEAD^{tree} -m \"Legacy code\")\n" +
                "git push origin master --force");

        // Syntax Highlighting: "Bash"
        p.setBash();

        // Paste Expiration: "10 Minutes"
        p.setValueExpiration();

        // Paste Name / Title: "how to gain dominance among developers"
        p.setTitle("how to gain dominance among developers");

        // Проверка заголовка
        Assert.assertTrue("Header didn't found", p.getHeader().equals("how to gain dominance among developers"));

        // Синтаксис подсвечен для bash
        Assert.assertTrue("Bash didn't found", p.getBash().equals("Bash"));

        // Проверка что код соответствует введенному
        String checkFieldCode = "git config --global user.name  \"New Sheriff in Town\"\n" +
                "git reset $(git commit-tree HEAD^{tree} -m \"Legacy code\")\n" +
                "git push origin master --force";
        Assert.assertTrue("Bash didn't found", p.getCode().equals(checkFieldCode));
    }

    @After
    public void  browserDown() {
        driver.quit();
        driver=null;
    }
}
