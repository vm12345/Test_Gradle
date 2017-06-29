import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * Created by malinovskiyv on 13.06.2017.
 */
public class MyFifthTest {
    private WebDriver driver;
    private WebDriverWait wait;
    private String email;
    private StringBuilder randString;

    @Before
    public void start() {
        driver = new FirefoxDriver(new DesiredCapabilities());
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, 10);
    }

    @Test
    public void checkCreateAccount() {
        driver.get("http://localhost/litecart/create_account");
        createAccount();
        driver.get("http://localhost/litecart/en/logout");
        driver.findElement(By.cssSelector("input[name=email]")).sendKeys(email);
        driver.findElement(By.cssSelector("input[name=password]")).sendKeys(randString);
        driver.findElement(By.cssSelector("button[name=login]")).click();
    }

    private void createAccount() {
        WebElement element = driver.findElement(By.cssSelector("form[name=customer_form]>table"));
        randString = getStringBuilder();
        List<WebElement> tdRequired = element.findElements(By.cssSelector("td>input[type=text]"));
        for (int i = 0; i < tdRequired.size() - 2; i++) tdRequired.get(i).sendKeys(randString);
        tdRequired.get(tdRequired.size() - 1).sendKeys(randString);
        Select select = new Select(element.findElement(By.cssSelector(".select2-hidden-accessible")));
        select.selectByVisibleText("United States");
        driver.findElement(By.xpath(".//*[@id='create-account']/div/form/table/tbody/tr[5]/td[2]/select"));
        select = new Select(driver.findElement(By.xpath(".//*[@id='create-account']/div/form/table/tbody/tr[5]/td[2]/select")));
        select.selectByValue("WA");
        tdRequired.get(tdRequired.size() - 2).sendKeys(String.valueOf(10000 + (int) (Math.random() * 10000)));
        email = UUID.randomUUID().toString() + "@gmail.com";
        element.findElement(By.cssSelector("input[name=email]")).sendKeys(email);
        double floor = Math.floor(Math.random() * 1000000000);
        element.findElement(By.cssSelector("input[name=phone]")).sendKeys("+7" + (int) floor);
        element.findElement(By.cssSelector("input[name=password]")).sendKeys(randString);
        element.findElement(By.cssSelector("input[name=confirmed_password]")).sendKeys(randString);
        WebElement button = element.findElement(By.cssSelector("button"));
        button.click();
    }

    private StringBuilder getStringBuilder() {
        String symbols = "qwertyuiop";
        StringBuilder randString = new StringBuilder();
        int count = (int) (Math.random() * 10);
        for (int i = 0; i < count; i++)
            randString.append(symbols.charAt((int) (Math.random() * symbols.length())));
        return randString;
    }

    @After
    public void close() {
        driver.close();
        driver = null;
    }
}
