import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class MySecondTest {
    private WebDriver driver;
    private WebDriverWait wait;

    @Before
    public void start() {
        driver = new FirefoxDriver(new DesiredCapabilities());
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void loginTest() {
        driver.get("http://localhost/litecart/admin");
        driver.findElement(By.cssSelector("input[name=username]")).sendKeys("admin");
        driver.findElement(By.cssSelector("input[name=password]")).sendKeys("admin");
        driver.findElement(By.cssSelector("button[name=login]")).click();
    }

    @Test
    public void checkMenu() {
        loginTest();

        driver.findElements(By.cssSelector("ul#box-apps-menu li#app-")).get(0).click();
        driver.findElement(By.cssSelector("li#doc-template.selected"));
        driver.findElement(By.cssSelector("li#doc-logotype")).click();

        driver.findElements(By.cssSelector("ul#box-apps-menu li#app-")).get(1).click();
        driver.findElement(By.cssSelector("li#doc-catalog.selected"));
        driver.findElement(By.cssSelector("li#doc-product_groups")).click();
        driver.findElement(By.cssSelector("li#doc-manufacturers")).click();
        driver.findElement(By.cssSelector("li#doc-suppliers")).click();
        driver.findElement(By.cssSelector("li#doc-delivery_statuses")).click();
        driver.findElement(By.cssSelector("li#doc-sold_out_statuses")).click();
        driver.findElement(By.cssSelector("li#doc-quantity_units")).click();
        driver.findElement(By.cssSelector("li#doc-csv")).click();


        driver.findElements(By.cssSelector("ul#box-apps-menu li#app-")).get(2).click();
        driver.findElement(By.cssSelector("li#app-.selected"));

        driver.findElements(By.cssSelector("ul#box-apps-menu li#app-")).get(3).click();
        driver.findElement(By.cssSelector("li#doc-customer.selected")).click();
        driver.findElement(By.cssSelector("li#doc-csv")).click();
        driver.findElement(By.cssSelector("li#doc-newsletter")).click();

        driver.findElements(By.cssSelector("ul#box-apps-menu li#app-")).get(4).click();
        driver.findElement(By.cssSelector("li#app-.selected"));

        driver.findElements(By.cssSelector("ul#box-apps-menu li#app-")).get(5).click();
        driver.findElement(By.cssSelector("li#app-.selected"));
        driver.findElement(By.xpath(".//*[@id='doc-csv']/a/span")).click();

        driver.findElements(By.cssSelector("ul#box-apps-menu li#app-")).get(6).click();
        driver.findElement(By.cssSelector("li#app-.selected"));
//        driver.findElement(By.cssSelector("ul.docs li#doc-customer")).click();
//        driver.findElement(By.cssSelector("ul.docs li#doc-shipping")).click();
//        driver.findElement(By.cssSelector("ul.docs li#doc-payment")).click();
//        driver.findElement(By.cssSelector("ul.docs li#doc-order-total")).click();
//        driver.findElement(By.cssSelector("ul.docs li#doc-order-success")).click();
//        driver.findElement(By.cssSelector("ul.docs li#doc-order-action")).click();

        driver.findElements(By.cssSelector("ul#box-apps-menu li#app-")).get(7).click();
        driver.findElement(By.cssSelector("li#app-.selected"));

        driver.findElements(By.cssSelector("ul#box-apps-menu li#app-")).get(8).click();
        driver.findElement(By.cssSelector("li#app-.selected"));

        driver.findElements(By.cssSelector("ul#box-apps-menu li#app-")).get(9).click();
        driver.findElement(By.cssSelector("li#app-.selected"));

        driver.findElements(By.cssSelector("ul#box-apps-menu li#app-")).get(10).click();
        driver.findElement(By.cssSelector("li#app-.selected"));

        driver.findElements(By.cssSelector("ul#box-apps-menu li#app-")).get(11).click();
        driver.findElement(By.cssSelector("li#app-.selected"));

        driver.findElements(By.cssSelector("ul#box-apps-menu li#app-")).get(12).click();
        driver.findElement(By.cssSelector("li#app-.selected"));

        driver.findElements(By.cssSelector("ul#box-apps-menu li#app-")).get(13).click();
        driver.findElement(By.cssSelector("li#app-.selected"));

        driver.findElements(By.cssSelector("ul#box-apps-menu li#app-")).get(14).click();
        driver.findElement(By.cssSelector("li#app-.selected"));

        driver.findElements(By.cssSelector("ul#box-apps-menu li#app-")).get(15).click();
        driver.findElement(By.cssSelector("li#app-.selected"));

        driver.findElements(By.cssSelector("ul#box-apps-menu li#app-")).get(16).click();
        driver.findElement(By.cssSelector("li#app-.selected"));

    }

    @After
    public void close() {
        driver.quit();
        driver = null;
    }
}
