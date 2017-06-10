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


    @Test
    public void checkGoodies() {
        driver.get("http://localhost/litecart/en/");
        WebElement element = driver.findElement(By.xpath((".//*[@id='box-campaigns']//div//li")));

        String text = element.findElement(By.cssSelector(".name")).getAttribute("textContent");
        String color = element.findElement(By.cssSelector("s.regular-price")).getCssValue("color");
        String cssValue = element.findElement(By.cssSelector("strong.campaign-price")).getCssValue("color");
        System.out.println("WOW");
        driver.findElement(By.cssSelector(("div.content a.link"))).click();
        System.out.println("WOW");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebElement driverElement = driver.findElement(By.cssSelector("div#box-product"));
        System.out.println("WOW");
        WebElement DuckTitle = driverElement.findElement(By.cssSelector("div#box-product.box h1"));
        WebElement DuckRegularPrice = driverElement.findElement(By.cssSelector(".regular-price"));
        WebElement DuckCampignPrice = driverElement.findElement(By.cssSelector(".campaign-price"));

        Assert.assertEquals(text,DuckTitle.getAttribute("textContent"));
        Assert.assertEquals(color,DuckRegularPrice.getCssValue("color"));
        Assert.assertEquals(cssValue,DuckCampignPrice.getCssValue("color"));
        System.out.println("WOW");

    }

    @After
    public void close() {
        driver.close();
        driver = null;

    }
}
