import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by malinovskiyv on 06.06.2017.
 */
public class MyThirdTest {
    private WebDriver driver;

    @Before
    public void start() {
        driver = new FirefoxDriver(new DesiredCapabilities());
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    public void loginTest() {
        driver.get("http://localhost/litecart/admin");
        driver.findElement(By.cssSelector("input[name=username]")).sendKeys("admin");
        driver.findElement(By.cssSelector("input[name=password]")).sendKeys("admin");
        driver.findElement(By.cssSelector("button[name=login]")).click();
    }

    @Test
    public void checkCountries() {
        loginTest();
        driver.get("http://localhost/litecart/admin/?app=countries&doc=countries");
        List<WebElement> webElementList = new ArrayList<>();
        WebElement element = driver.findElement(By.xpath(".//*[@id='content']/form/table/tbody"));
        for (WebElement webElement : element.findElements(By.cssSelector(".row>td>a"))) {
            webElementList.add(webElement);
            System.out.println(webElement.getAttribute("textContent"));
        }
    }

    @After
    public void close() {
        driver.quit();
        driver = null;
    }
}
