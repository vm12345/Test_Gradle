import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

/**
 * Created by malinovskiyv on 22.06.2017.
 */
public class MyTenthTest {
    private WebDriver driver;
    private WebDriverWait wait;

    @Before
    public void start() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 20);
    }

    @Test
    public void checkLogs() {
        loginTest();
        driver.get("http://localhost/litecart/admin/?app=catalog&doc=catalog&category_id=1");
        getBrowserLogs();
        List<WebElement> elements = driver.findElements(By.cssSelector(".row"));
        for (int i = 3; i < elements.size(); i++) {
            elements = clickUpClickDown(elements, i);
            getBrowserLogs();
            getDriverLogs();
            getClientLogs();
        }
    }

    private List<WebElement> clickUpClickDown(List<WebElement> elements, int i) {
        elements.get(i).findElement(By.cssSelector("a")).click();
        driver.get("http://localhost/litecart/admin/?app=catalog&doc=catalog&category_id=1");
        List<WebElement> elements1 = driver.findElements(By.cssSelector(".row"));
        elements = elements1;
        return elements;
    }

    private void getBrowserLogs() {
        Assert.assertFalse(driver.manage().logs().get("browser").getAll().size() < 0);
    }

    private void getDriverLogs() {
        Assert.assertFalse(driver.manage().logs().get("driver").getAll().size() < 0);
    }

    private void getClientLogs() {
        Assert.assertFalse(driver.manage().logs().get("client").getAll().size() < 0);
    }

    private void loginTest() {
        driver.get("http://localhost/litecart/admin");
        driver.findElement(By.cssSelector("input[name=username]")).sendKeys("admin");
        driver.findElement(By.cssSelector("input[name=password]")).sendKeys("admin");
        driver.findElement(By.cssSelector("button[name=login]")).click();
    }

    @After
    public void close() {
        driver.quit();
        driver = null;
    }
}
