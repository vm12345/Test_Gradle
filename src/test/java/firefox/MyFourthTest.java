package firefox;
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
    public void checkGoodiesFirefox() {
        driver.get("http://localhost/litecart/en/");
        WebElement element = driver.findElement(By.cssSelector("div#box-campaigns.box"));
        WebElement element4 = element.findElement(By.cssSelector(".name"));
        WebElement element5 = element.findElement(By.cssSelector(".regular-price"));
        WebElement element6 = element.findElement(By.cssSelector(".campaign-price"));
        String textContent = element4.getAttribute("textContent");
        String color = element5.getCssValue("color");
        String color1 = element6.getCssValue("color");
        element.findElement(By.cssSelector(".link")).click();
        System.out.println("WOW");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebElement element1 = driver.findElement(By.cssSelector("#box-product>div>h1.title"));
        WebElement element2 = driver.findElement(By.cssSelector("div.content div.price-wrapper s.regular-price"));
        WebElement element3 = driver.findElement(By.cssSelector("div.content div.price-wrapper strong.campaign-price"));
        String textContent1 = element1.getAttribute("textContent");
        String color2 = element2.getCssValue("color");
        String color3 = element3.getCssValue("color");
        System.out.println("WOW");
        Assert.assertEquals(textContent, textContent1);
        Assert.assertNotEquals(color, color2);
        Assert.assertEquals(color1, color3);

    }


    @After
    public void close() {
        driver.close();
        driver = null;

    }
}

