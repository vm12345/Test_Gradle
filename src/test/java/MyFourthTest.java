import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

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
        WebElement YellowDuck = driver.findElement(By.cssSelector("html/body/div[2]/div/div[2]/div/div[2]/div[2]/div[4]/div/ul/li/a[1]/div[2]"));
        WebElement RegularPrice = driver.findElement(By.cssSelector("div#box-campaigns>s.regular-price"));
        WebElement CampaignPrice = driver.findElement(By.cssSelector("#box-campaigns>strong.campaign-price"));

        System.out.println(YellowDuck.getAttribute("textContent"));
        System.out.println(RegularPrice.getCssValue("color"));
        System.out.println(CampaignPrice.getCssValue("color"));

        System.out.println("WOW");
    }

    @After
    public void close() {
        driver.close();
        driver = null;

    }
}
