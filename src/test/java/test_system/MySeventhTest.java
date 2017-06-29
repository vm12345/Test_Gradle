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
            selector = "button[name=add_cart_product]";
            selector1 = "#box-most-popular > div > ul > li:nth-child(1)";
            selector11 = "form[name=buy_now_form]>table>tbody>tr";
            selector2 = "#cart > a.content > span.quantity";
            selector3 = "#box-product > div.content > div.information > div.buy_now > form > table > tbody > tr:nth-child(1) > td > select";
            addElementAndCheck(s, selector, selector1, selector11, selector2, selector3);
        }
//        удалить объекты
        getAddress("http://localhost/litecart/");
        for (int i = 1; i < usersValue; i++) {
            url = "http://localhost/litecart/en/checkout";
            xpathExpression = "//*[@id='box-checkout-cart']/div/ul/li/form";
            xpathExpression1 = ".//form[@name='cart_form']//button[@name='remove_cart_item']";
            checkRemoved(url, xpathExpression, xpathExpression1);
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