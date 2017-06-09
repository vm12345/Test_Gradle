import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by malinovskiyv on 08.06.2017.
 */
public class MyFourthTest {
    private WebDriver driver;
    private WebDriverWait wait;

    @Before
    public void start() {
        driver = new FirefoxDriver(new DesiredCapabilities());
        wait = new WebDriverWait(driver, 10);
    }

    public void loginTest() {
        driver.get("http://localhost/litecart/admin");
        driver.findElement(By.cssSelector("input[name=username]")).sendKeys("admin");
        driver.findElement(By.cssSelector("input[name=password]")).sendKeys("admin");
        driver.findElement(By.cssSelector("button[name=login]")).click();
    }

    @Test
    public void checkGoodies() {
        loginTest();
        List<WebElement> stringList = new ArrayList<>();
        driver.get("http://localhost/litecart/en/");
        WebElement element = driver.findElement(By.xpath(".//*[@id='box-campaigns']/div/ul/li"));
        for (WebElement webElement : element.findElements(By.xpath(".//div"))) {
            stringList.add(webElement);
        }
        System.out.println(stringList.get(2).getAttribute("textContent"));
        System.out.println(stringList.get(3).getAttribute("textContent"));
        System.out.println(stringList.get(4).getAttribute("textContent"));
        element.findElement(By.cssSelector("a")).click();
        System.out.println("WOW");

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        WebElement element1 = driver.findElement(By.xpath("//*[@class='content']//h1"));
        WebElement element2 = driver.findElement(By.xpath(".//*[@id='box-product']/div[2]/div[2]/div[1]"));
        WebElement element3 = driver.findElement(By.xpath(".//*[@id='box-product']/div[2]/div[2]/div[2]"));
        List<WebElement> elements = new ArrayList<>();
        elements.add(element1);
        elements.add(element2);
        elements.add(element3);
        System.out.println(elements.get(0).getAttribute("textContent"));
        System.out.println(elements.get(1).getAttribute("textContent"));
        System.out.println(elements.get(2).getAttribute("textContent"));
        Assert.assertNotEquals(stringList,elements);
        System.out.println("WOW");
    }

    @After
    public void close() {
        driver.close();
        driver = null;

    }
}
