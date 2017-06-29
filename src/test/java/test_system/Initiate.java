package test_system;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

/**
 * Created by malinovskiyv on 29.06.2017.
 */
public class Initiate {
    protected WebDriver driver;
    protected WebDriverWait wait;
    private Select select;

    @Before
    public void start() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 20);
    }

    @After
    public void close() {
        driver.close();
        driver = null;
    }

    protected void getAddress(String url) {
        driver.get(url);
    }

    protected void ClickWebElement(List<WebElement> elements) {
        WebElement button = wait.until(ExpectedConditions.elementToBeClickable(elements.get(0)));
        button.click();
    }

    protected void SelectAndClick() {
        WebElement element = driver.findElement(By.cssSelector("#box-product > div.content > div.information > div.buy_now > form > table > tbody > tr:nth-child(1) > td > select"));

        select = new Select(element);
        select.selectByIndex(1);
    }

    protected void waitUntilFind(String s) {
        wait.until(ExpectedConditions.attributeContains(driver.findElement(By.cssSelector("#cart > a.content > span.quantity")), "innerText", s));
    }

    protected class FindersForRemove {
        private List<WebElement> until;
        private List<WebElement> elements;

        public List<WebElement> getUntil() {
            return until;
        }

        public List<WebElement> getElements() {
            return elements;
        }

        public MySeventhTest.FindersForRemove invoke() {
            until = Initiate.this.wait.until(driver -> driver.findElements(By.xpath("//*[@id='box-checkout-cart']/div/ul/li/form")));
            elements = Initiate.this.driver.findElements(By.xpath(".//form[@name='cart_form']//button[@name='remove_cart_item']"));
            return this;
        }
    }

    protected class FindersForCart {
        public List<WebElement> invoke() {
            WebElement element = Initiate.this.driver.findElement(By.cssSelector("#box-most-popular > div > ul > li:nth-child(1)"));
            element.click();
            return Initiate.this.wait.until(driver1 -> Initiate.this.driver.findElements(By.cssSelector("form[name=buy_now_form]>table>tbody>tr")));
        }
    }
}
