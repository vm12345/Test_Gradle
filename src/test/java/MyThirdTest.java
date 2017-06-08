import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class MyThirdTest {
    private WebDriver driver;

    @Before
    public void start() {
        driver = new FirefoxDriver(new DesiredCapabilities());
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    public void loginTest() {
        driver.get("http://localhost/litecart/admin");
        driver.findElement(By.cssSelector("input[name=username]")).sendKeys("admin");
        driver.findElement(By.cssSelector("input[name=password]")).sendKeys("admin");
        driver.findElement(By.cssSelector("button[name=login]")).click();
    }

    @Test
    public void checkCountries() {
        loginTest();
        List<String> list = new ArrayList<>();
        driver.get("http://localhost/litecart/admin/?app=countries&doc=countries");
        WebElement element = driver.findElement(By.cssSelector(".dataTable>tbody"));
        for (WebElement webElement : element.findElements(By.xpath("//*[@class='row']/td[5]"))) {
            list.add(webElement.getAttribute("textContent"));
            System.out.println(webElement.getAttribute("textContent"));
        }
        equalsLists(list);
        System.out.println(list.size());
    }

    private void equalsLists(List<String> list) {
        List<String> temp = new ArrayList<>();
        temp.addAll(list);
//        list.remove(6);
//        System.out.println(list);
//        System.out.println(temp);
        Collections.sort(list);
//        Collections.sort(temp);
        if (temp.equals(list)) {
            System.out.println("Lists are equal");
        } else System.out.println("Lists are not equal");
    }

    @Test
    public void checkZones() {
        loginTest();
        List<String> list = new ArrayList<>();
        driver.get("http://localhost/litecart/admin/?app=countries&doc=countries");
        WebElement element = driver.findElement(By.cssSelector(".dataTable>tbody"));
        for (WebElement webElement : element.findElements(By.xpath("//*[@class='row']/td[6]"))) {
            list.add(webElement.getAttribute("textContent"));
        }
        System.out.println(list.size() + 1);
        for (String s : list) {
            int i = Integer.parseInt(s);
            if (i > 0) {
                element.findElement(By.xpath("//*[@class='row']/td[5]")).click();
//                goToPage(element);
            }

        }
    }

    private void goToPage(WebElement element) {
        element.findElement(By.xpath("//*[@class='row']/td[5]")).click();
        driver.findElement(By.xpath(".//*[@id='table-zones']"));
    }


    @After
    public void close() {
        driver.quit();
        driver = null;
    }
}
