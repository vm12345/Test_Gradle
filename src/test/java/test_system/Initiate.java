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
    protected String xpathExpression;
    protected String xpathExpression1;
    protected String selector;
    protected String selector1;
    protected String selector11;
    protected String selector2;
    protected String selector3;
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
