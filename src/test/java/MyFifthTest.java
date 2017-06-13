import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by malinovskiyv on 13.06.2017.
 */
public class MyFifthTest {
    private WebDriver driver;

    @Before
    public void start() {
        driver = new FirefoxDriver(new DesiredCapabilities());
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void checkCreateAccount() {
        driver.get("http://localhost/litecart/create_account");
        WebElement element = driver.findElement(By.cssSelector("form[name=customer_form]>table"));
        StringBuilder randString = getStringBuilder();
        List<WebElement> tdRequired = element.findElements(By.cssSelector("td>input[type=text]"));
        for (int i = 0; i < tdRequired.size() - 3; i++) tdRequired.get(i).sendKeys(randString);
        tdRequired.get(tdRequired.size() - 3).sendKeys(String.valueOf(100000 + (int) (Math.random() * 999999)));
        tdRequired.get(tdRequired.size() - 2).sendKeys(randString);
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
