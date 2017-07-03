package chrome;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

/**
 * Created by Vitaliy on 6/10/2017.
 */
public class ChromeTest {
    private WebDriver driver;
    private WebDriverWait wait;

    @Before
    public void start() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 10);
    }


    @Test
    public void checkGoodiesChrome() {
        driver.get("http://localhost/litecart/en/");
        WebElement element = driver.findElement(By.cssSelector("div#box-campaigns.box"));
        WebElement element4 = element.findElement(By.cssSelector(".name"));
        WebElement element5 = element.findElement(By.cssSelector(".regular-price"));
        WebElement element6 = element.findElement(By.cssSelector(".campaign-price"));
        String textContent = element4.getAttribute("textContent");
        String color = element5.getCssValue("color");
        String color1 = element6.getCssValue("color");

        Assert.assertTrue(element5.getCssValue("text-decoration-line").contentEquals("line-through"));
        Assert.assertTrue(element5.getCssValue("font-weight").contentEquals("normal"));
        Assert.assertEquals(element5.getCssValue("font-size"),"14.4px");
        Assert.assertTrue(element6.getCssValue("font-weight").contentEquals("bold"));
        Assert.assertTrue(element6.getCssValue("text-decoration-style").contentEquals("solid"));
        Assert.assertEquals(element6.getCssValue("font-size"), "18px");


        element.findElement(By.cssSelector(".link")).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebElement element1 = driver.findElement(By.cssSelector("#box-product>div>h1.title"));
        WebElement element2 = driver.findElement(By.cssSelector("div.content div.price-wrapper s.regular-price"));
        WebElement element3 = driver.findElement(By.cssSelector("div.content div.price-wrapper strong.campaign-price"));
        String textContent1 = element1.getAttribute("textContent");
        String color2 = element2.getCssValue("color");
        String color3 = element3.getCssValue("color");

        Assert.assertTrue(element2.getCssValue("text-decoration-line").contentEquals("line-through"));
        Assert.assertTrue(element2.getCssValue("font-weight").contentEquals("normal"));
        Assert.assertEquals(element2.getCssValue("font-size"), "16px");
        Assert.assertTrue(element3.getCssValue("font-weight").contentEquals("bold"));
        Assert.assertTrue(element3.getCssValue("text-decoration-style").contentEquals("solid"));
        Assert.assertEquals(element3.getCssValue("font-size"), "22px");
        Assert.assertEquals(textContent, textContent1);
        Assert.assertNotEquals(color, color2);
        Assert.assertEquals(color1, color3);
        Assert.assertTrue(color.contentEquals("rgba(119, 119, 119, 1)"));
        Assert.assertTrue(color1.contentEquals("rgba(204, 0, 0, 1)"));
        Assert.assertTrue(color2.contentEquals("rgba(102, 102, 102, 1)"));
        Assert.assertTrue(color3.contentEquals("rgba(204, 0, 0, 1)"));

    }

    @After
    public void close() {
        driver.close();
        driver = null;

    }
}