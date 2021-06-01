package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Pastebin {

    private  WebDriver driver;

    public Pastebin (WebDriver driver) {
        this.driver = driver;
    }

    private By fieldSearchInput = By.id("postform-text");
    private By fieldSearchExpiration = By.xpath("//*[@id='select2-postform-expiration-container']");
    private By fieldSearch10Minutes = By.xpath("//*[@id='select2-postform-expiration-results']/li[3]");
    private By fieldSearchName = By.xpath("//*[@id='postform-name']");
    private By searchCreateBtn = By.xpath("//*[@id='w0']//button");
    private By searchHighlighting = By.xpath("//*[@id='select2-postform-format-container']");
    private By searchBash = By.xpath("//*[@class='select2-results__options select2-results__options--nested']/li[1]");
    private By header = By.xpath("//h1[text()='how to gain dominance among developers']");
    private By bash = By.xpath("//a[contains(.,'Bash')]");
    private By code = By.xpath("//div[@class='source']");

    public void setValueSearch(String val) {
        driver.findElement(fieldSearchInput).sendKeys(val);
    }

    public void setValueExpiration() {
        driver.findElement(fieldSearchExpiration).click();
        driver.findElement(fieldSearch10Minutes).click();
    }

    public void setTitle(String value) {
        driver.findElement(fieldSearchName).sendKeys(value);
        driver.findElement(searchCreateBtn).click();
    }

    public void setBash() {
        driver.findElement(searchHighlighting).click();
        driver.findElement(searchBash).click();
    }

    public String getHeader() {
        return driver.findElement(header).getText();
    }

    public String getBash() {
        return driver.findElement(bash).getText();
    }

    public String getCode() {
        return driver.findElement(code).getText();
    }
}
