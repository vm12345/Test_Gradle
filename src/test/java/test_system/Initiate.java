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
    protected final Selectors selectors = new Selectors();
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected String url;
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

    protected void SelectAndClick(String selector) {
        WebElement element = driver.findElement(By.cssSelector(selector));

        select = new Select(element);
        select.selectByIndex(1);
    }

    protected void waitUntilFind(String s, String selector) {
        wait.until(ExpectedConditions.attributeContains(driver.findElement(By.cssSelector(selector)), "innerText", s));
    }

    protected void addXPathParameters() {
        selectors.formRemove = "//*[@id='box-checkout-cart']/div/ul/li/form";
        selectors.itemRemove = ".//form[@name='cart_form']//button[@name='remove_cart_item']";
    }

    protected void addParameters() {
        selectors.button = "button[name=add_cart_product]";
        selectors.itemFound = "#box-most-popular > div > ul > li:nth-child(1)";
        selectors.buyNow = "form[name=buy_now_form]>table>tbody>tr";
        selectors.counter = "#cart > a.content > span.quantity";
        selectors.item = "#box-product > div.content > div.information > div.buy_now > form > table > tbody > tr:nth-child(1) > td > select";
    }

    protected void getMainPage() {
        getAddress("http://localhost/litecart/");
    }

    protected void getURL() {
        url = "http://localhost/litecart/en/checkout";
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

        public MySeventhTest.FindersForRemove invoke(String xpathExpression, String xpathExpression1) {
            until = Initiate.this.wait.until(driver -> driver.findElements(By.xpath(xpathExpression)));
            elements = Initiate.this.driver.findElements(By.xpath(xpathExpression1));
            return this;
        }
    }

    protected class FindersForCart {
        public List<WebElement> invoke(String selector, String selector1) {
            WebElement element = Initiate.this.driver.findElement(By.cssSelector(selector));
            element.click();
            return Initiate.this.wait.until(driver1 -> Initiate.this.driver.findElements(By.cssSelector(selector1)));
        }
    }
}
