package test_system;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

/**
 * Created by Vitaliy on 6/17/2017.
 */
public class MySeventhTest extends Initiate {

    private String url;

    @Test
    public void checkCart() {
//        добавить объекты
        int usersValue = 10;
        for (int i = 1; i < usersValue; i++) {
            String s = String.valueOf(i);
            addParameters();
            addElementAndCheck(s, selectors.button, selectors.itemFound, selectors.buyNow, selectors.counter, selectors.item);
        }
//        удалить объекты
        getAddress("http://localhost/litecart/");
        for (int i = 1; i < usersValue; i++) {
            url = "http://localhost/litecart/en/checkout";
            addXPathParameters();
            checkRemoved(url, selectors.formRemove, selectors.itemRemove);
        }
    }

    private void checkRemoved(String url, String xpathExpression, String xpathExpression1) {
        getAddress(url);
        Initiate.FindersForRemove finders = new Initiate.FindersForRemove().invoke(xpathExpression, xpathExpression1);
        List<WebElement> until = finders.getUntil();
        List<WebElement> elements = finders.getElements();
        if (until.size() > 0) {
            ClickWebElement(elements);
        } else System.out.println(until.size());
    }

    private void addElementAndCheck(String s, String selector, String selector1, String selector11, String selector2, String selector3) {
        getAddress("http://localhost/litecart/");
        List<WebElement> elements = new Initiate.FindersForCart().invoke(selector1, selector11);
        if (elements.size() > 1) {
            SelectAndClick(selector3);
        }
        elements.get(elements.size() - 1).findElement(By.cssSelector(selector)).click();
        waitUntilFind(s, selector2);
    }
}