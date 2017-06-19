import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

/**
 * Created by Vitaliy on 6/17/2017.
 */
public class MySeventhTest {
    private WebDriver driver;
    private WebDriverWait wait;
    private WebElement element;

    @Before
    public void start() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 20);
    }

    @Test
    public void checkRecycle() {
//        добавить объекты
        addElementAndCheck("1");
        addElementAndCheck("2");
        addElementAndCheck("3");
//        удалить боъекты
        driver.get("http://localhost/litecart/");
        driver.findElement(By.cssSelector("div#cart > a.link")).click();
        wait.until(driver1 -> driver1.findElement(By.cssSelector("#box-checkout-summary > h2")));
        driver.findElements(By.cssSelector("#order_confirmation-wrapper > table > tbody > tr"));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(("#box-checkout-cart > div > ul > li:nth-child(1) > form > div > p:nth-child(4) > button"))));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(("#box-checkout-cart > div > ul > li:nth-child(2) > form > div > p:nth-child(4) > button"))));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(("#box-checkout-cart > div > ul > li:nth-child(3) > form > div > p:nth-child(4) > button"))));
        System.out.println("WOW");
    }

    private void addElementAndCheck(String s) {
        driver.get("http://localhost/litecart/");
        WebElement element = driver.findElement(By.cssSelector("#box-most-popular > div > ul > li:nth-child(1)"));
        element.click();
        List<WebElement> elements = wait.until(driver1 -> driver.findElements(By.cssSelector("form[name=buy_now_form]>table>tbody>tr")));
        if (elements.size() > 1) {
            Select select = new Select(driver.findElement(By.cssSelector("#box-product > div.content > div.information > div.buy_now > form > table > tbody > tr:nth-child(1) > td > select")));
            select.selectByIndex(1);
        }
        elements.get(elements.size() - 1).findElement(By.cssSelector("button[name=add_cart_product]")).click();
        wait.until(ExpectedConditions.attributeContains(driver.findElement(By.cssSelector("#cart > a.content > span.quantity")), "innerText", s));
    }

    @After
    public void close() {
        driver.close();
        driver = null;
    }
}

