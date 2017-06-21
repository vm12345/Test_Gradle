import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class MyEighthTest {
    WebDriver driver;
    WebDriverWait wait;

    @Before
    public void start() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 20);
    }

    @Test
    public void checkLinks() {
        loginTest();
        driver.get("http://localhost/litecart/admin/?app=countries&doc=edit_country&country_code=AF");
        List<WebElement> elements = driver.findElements(By.cssSelector("td#content a[target=_blank]"));
        for (int i = 0; i < elements.size(); i++) {
            clickAndClose(elements.get(i));
        }
    }

    private void clickAndClose(WebElement webElement) {
        webElement.click();
        Set<String> windowHandles = driver.getWindowHandles();
        List<String> strings = new ArrayList<>();
        strings.addAll(windowHandles);
        wait.until(driver -> driver.switchTo().window(strings.get(strings.size() - 1)));
        driver.close();
        driver.switchTo().window(strings.get(0));
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
