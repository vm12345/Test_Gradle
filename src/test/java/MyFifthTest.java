import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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

    @Before
    public void start() {
        driver = new FirefoxDriver(new DesiredCapabilities());
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, 10);
    }

    @Test
    public void checkCreateAccount() {
        driver.get("http://localhost/litecart/create_account");
        WebElement element = driver.findElement(By.cssSelector("form[name=customer_form]>table"));
        StringBuilder randString = getStringBuilder();
        List<WebElement> tdRequired = element.findElements(By.cssSelector("td>input[type=text]"));
        for (int i = 0; i < tdRequired.size() - 3; i++) tdRequired.get(i).sendKeys(randString);
        tdRequired.get(tdRequired.size() - 3).sendKeys(String.valueOf(10000 + (int) (Math.random() * 10000)));
        tdRequired.get(tdRequired.size() - 2).sendKeys(randString);
        System.out.println("WOW");
        Select select = new Select(element.findElement(By.cssSelector(".select2-hidden-accessible")));
        select.selectByVisibleText("United States");
        wait.until(driver -> driver.findElement(By.xpath(".//*[@id='create-account']/div/form/table/tbody/tr[5]/td[2]/select")));
        select = new Select(driver.findElement(By.xpath(".//*[@id='create-account']/div/form/table/tbody/tr[5]/td[2]/select")));
        select.selectByValue("WA");
        String randomEmail = UUID.randomUUID().toString() + "@gmail.com";
        element.findElement(By.cssSelector("input[name=email]")).sendKeys(randomEmail);
        double floor = Math.floor(Math.random() * 1000000000);
        element.findElement(By.cssSelector("input[name=phone")).sendKeys("+7" + (int) floor);
        element.findElement(By.cssSelector("input[name=password]")).sendKeys(randString);
        element.findElement(By.cssSelector("input[name=confirmed_password]")).sendKeys(randString);
        WebElement img = element.findElement(By.cssSelector("img"));
        WebElement captcha = element.findElement(By.cssSelector("input[name=captcha]"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].setAttribute('valid','false')", img);
        js.executeScript("arguments[0].setAttribute('willValidate','false')", img);
        js.executeScript("arguments[0].setAttribute('value','1234');", captcha);
        System.out.println("WOW");
        WebElement button = element.findElement(By.cssSelector("button[name=create_account]"));
        js.executeScript("arguments[0].setAttribute('valid','false')", button);
        button.click();
        System.out.println("WOW");
    }

    private StringBuilder getStringBuilder() {
        String symbols = "qwertyuiop";
        StringBuilder randString = new StringBuilder();
        int count = (int) (Math.random() * 10);
        for (int i = 0; i < count; i++)
            randString.append(symbols.charAt((int) (Math.random() * symbols.length())));
        return randString;
    }

//    @After
    public void close() {
        driver.close();
        driver = null;
    }
}
