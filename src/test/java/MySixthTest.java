import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
        Actions actions = new Actions(driver);
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
        Select select = new Select(elements.get(14).findElement(By.xpath(".//td/table/tbody/tr/td[4]/select")));
        select.selectByValue("2");

System.out.println(elements.get(14).getText());

    }

    private void loginTest() {
        driver.get("http://localhost/litecart/admin");
        driver.findElement(By.cssSelector("input[name=username]")).sendKeys("admin");
        driver.findElement(By.cssSelector("input[name=password]")).sendKeys("admin");
        driver.findElement(By.cssSelector("button[name=login]")).click();
    }

//    @After
    public void close() {
        driver.close();
        driver = null;
    }
}
