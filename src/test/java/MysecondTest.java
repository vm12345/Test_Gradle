import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.sql.Driver;

public class MysecondTest {
    private WebDriver driver;
    //private WebDriverWait wait;

    @Before
    public void start() {
        driver = new FirefoxDriver();
        //private WebDriverWait wait;
    }

    @Test
    public void MysecondTest() {
        driver.get("http://localhost/litecart/admin/login.php");
        driver.findElement(By.name("username")).sendKeys("admin");
        driver.findElement(By.name("password")).sendKeys("admin");
        driver.findElement(By.name("login")).click();
    }

    @After
    public void close() {
        driver.quit();
        driver = null;
    }
}
