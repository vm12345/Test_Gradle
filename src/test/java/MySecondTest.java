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
import java.util.concurrent.TimeUnit;

public class MySecondTest {
    private WebDriver driver;
    private WebDriverWait wait;

    @Before
    public void start() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
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
        List<WebElement> elements = driver.findElements(By.xpath("//ul[@id='box-apps-menu']//li[@id='app-']"));
        for (int i = 0; i < elements.size(); i++) {
            checkClicks(elements.get(i));
            elements = driver.findElements(By.xpath("//ul[@id='box-apps-menu']//li[@id='app-']"));
        }
    }

    private void checkClicks(WebElement elements) {
        elements.click();
        List<WebElement> webElements = driver.findElements(By.xpath("//ul[@id='box-apps-menu']//li/ul/li"));
        System.out.println(webElements.size());
        for (int i = 0; i < webElements.size(); i++) {
            webElements.get(i).click();
            webElements = driver.findElements(By.xpath("//ul[@id='box-apps-menu']//li/ul/li"));
        }
    }

    @Test
    public void checkStickers() {
        driver.get("http://localhost/litecart/en/");
        List<WebElement> elements = driver.findElements(By.cssSelector("li.product"));
        List<WebElement> webElements = driver.findElements(By.cssSelector("div.sticker"));
        Assert.assertTrue(hasSticker(elements));
        isEquals(elements, webElements);

    }

    private boolean hasSticker(List<WebElement> elements) {
        for (WebElement webElement : elements) {
            List<WebElement> webElements = webElement.findElements(By.cssSelector(".sticker"));
            if (webElements.size() == 0 || webElements.size() > 1) {
                return false;
            }
        }
        return true;
    }

    public boolean isEquals(List<WebElement> elements, List<WebElement> webElements) {
        if (elements.size() == webElements.size()) return true;
        else return false;
    }

    @After
    public void close() {
        driver.quit();
        driver = null;
    }
}
