package test_system;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

/**
 * Created by Vitaliy on 6/17/2017.
 */
public class MySeventhTest extends Initiate {
    @Test
    public void checkCart() {
//        добавить объекты
        int usersValue = 10;
        for (int i = 1; i < usersValue; i++) {
            String s = String.valueOf(i);
            addElementAndCheck(s);
        }
//        удалить объекты
        getAddress("http://localhost/litecart/");
        for (int i = 1; i < usersValue; i++) {
            checkRemoved();
        }
    }

    private void checkRemoved() {
        getAddress("http://localhost/litecart/en/checkout");
        Initiate.FindersForRemove finders = new Initiate.FindersForRemove().invoke();
        List<WebElement> until = finders.getUntil();
        List<WebElement> elements = finders.getElements();
        if (until.size() > 0) {
            ClickWebElement(elements);
        } else System.out.println(until.size());
    }

    private void addElementAndCheck(String s) {
        getAddress("http://localhost/litecart/");
        List<WebElement> elements = new Initiate.FindersForCart().invoke();
        if (elements.size() > 1) {
            SelectAndClick();
        }
        elements.get(elements.size() - 1).findElement(By.cssSelector("button[name=add_cart_product]")).click();
        waitUntilFind(s);
    }

}
