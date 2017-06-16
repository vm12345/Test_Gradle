import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by malinovskiyv on 15.06.2017.
 */
public class MySixthTest {

    private WebDriver driver;
    private WebDriverWait wait;
    private WebElement driverElement;
    private Actions actions;
    private Select select;

    @Before
    public void start() {
        driver = new FirefoxDriver(new DesiredCapabilities());
        wait = new WebDriverWait(driver, 10);
    }

    @Test
    public void checkGoodiesFromAdmin() {
        loginTest();
        driver.get("http://localhost/litecart/admin/?app=catalog&doc=catalog");
        driverElement = driver.findElement(By.xpath("//*[@class='button'][2]"));
        actions = new Actions(driver);
        actions.moveToElement(driverElement).click().perform();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driverElement = driver.findElement(By.xpath("//div[@id='tab-general']/table/tbody"));
        List<WebElement> elements = driverElement.findElements(By.xpath(".//tr"));
        actions.moveToElement(elements.get(0).findElement(By.xpath(".//input"))).click().perform();
        actions.moveToElement(elements.get(1).findElement(By.xpath(".//td/span/input"))).click().sendKeys("new Product").perform();
        actions.moveToElement(elements.get(2).findElement(By.xpath(".//td/input"))).click().sendKeys("123123").perform();
        actions.moveToElement(elements.get(3).findElement(By.xpath("./td/div/table/tbody/tr[3]/td[1]/input"))).click().perform();
        actions.moveToElement(elements.get(3).findElement(By.xpath("./td/div/table/tbody/tr[2]/td[1]/input"))).click().perform();
        actions.moveToElement(elements.get(9).findElement(By.xpath("./td/div/table/tbody/tr[3]/td[1]/input"))).click().perform();
        actions.moveToElement(elements.get(14).findElement(By.xpath(".//input[@name='quantity']"))).click().sendKeys("999").perform();
        select = new Select(elements.get(14).findElement(By.xpath(".//td/table/tbody/tr/td[4]/select")));
        select.selectByValue("2");
        String workingDir = System.getProperty("user.dir");
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        actions.pause(3);
        jse.executeScript("window.scrollBy(0,250)", "");
        String filepath = workingDir + "\\src\\test\\java\\black-rubber-duck.jpg";
        elements.get(16).findElement(By.xpath(".//input[@type='file']")).sendKeys(filepath);
        actions.moveToElement(elements.get(19).findElement(By.xpath(".//input[@name='date_valid_from']"))).click().sendKeys("1991-12-12").perform();
        actions.moveToElement(elements.get(20).findElement(By.xpath(".//input[@name='date_valid_to']"))).click().sendKeys("1991-12-12").perform();
        actions.sendKeys(Keys.PAGE_UP);
        actions.sendKeys(Keys.PAGE_UP);
        actions.sendKeys(Keys.PAGE_UP);
        jse.executeScript("window.scrollBy(0,-250)", "");
        goToInformation();
    }

    private void goToInformation() {
        WebElement element = driver.findElement(By.xpath(".//*[@id='content']/form/div/ul/li[2]/a"));
        element.click();
        actions.pause(10);
        List<WebElement> elements = element.findElements(By.xpath("//div[@id='tab-information']//tr"));
        select = new Select(elements.get(0).findElement(By.xpath("./td/select")));
        select.selectByValue("1");
        actions.moveToElement(elements.get(2)).click().sendKeys("BBlack").perform();
        actions.moveToElement(elements.get(3)).click().sendKeys("Very Black Duck").perform();
        actions.moveToElement(elements.get(4)).click().sendKeys("Duck for ritual games in baths, waterpools and other").perform();
        actions.moveToElement(elements.get(5)).click().sendKeys("Ritual Duck").perform();
        actions.moveToElement(elements.get(6)).click().sendKeys("Gaming").perform();
        goToPrices();
    }

    private void goToPrices() {
        WebElement element = driver.findElement(By.xpath(".//*[@id='content']/form/div/ul/li[4]/a"));
        element.click();
        List<WebElement> elements = element.findElements(By.xpath("//div[@id='tab-prices']/table"));
        actions.moveToElement(elements.get(0).findElement(By.xpath(".//tbody/tr/td/input"))).click().pause(2).sendKeys("45").perform();
        select = new Select(elements.get(0).findElement(By.xpath(".//tbody/tr/td/select")));
        select.selectByValue("EUR");
        actions.moveToElement(elements.get(2).findElement(By.xpath(".//tr[2]/td[1]/span/input"))).click().sendKeys("50").perform();
        actions.pause(250);
        actions.moveToElement(elements.get(2).findElement(By.xpath(".//tr[3]/td[1]/span/input"))).click().sendKeys("70").perform();
        actions.pause(250);
        pressSave();
    }

    private void pressSave() {
        driver.findElement(By.xpath(".//form/p/span/button")).click();
        actions.pause(250);
        try {
            driver.get("http://localhost/litecart/admin/?app=catalog&doc=catalog&category_id=0");
            driver.findElement(By.xpath(".//*[@id='content']/form/table/tbody/tr[4]/td[3]/a"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void loginTest() {
        driver.get("http://localhost/litecart/admin");
        driver.findElement(By.cssSelector("input[name=username]")).sendKeys("admin");
        driver.findElement(By.cssSelector("input[name=password]")).sendKeys("admin");
        driver.findElement(By.cssSelector("button[name=login]")).click();
    }

    @After
    public void close() {
        driver.close();
        driver = null;
    }
}
