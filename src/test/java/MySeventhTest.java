import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

/**
 * Created by Vitaliy on 6/17/2017.
 */
public class MySeventhTest {
    private WebDriver driver;
    private WebDriverWait wait;

    @Before
    public void start() {
        driver = new FirefoxDriver();
        wait = new WebDriverWait(driver, 20);
    }

    @Test
    public void checkRecycle() {
//.product - любая уточка
// .//*[@id='cart']/a[2]/span[1] - цифирка
        addProduct();
        addProduct();
        addProduct();
        addProduct();
        addProduct();
        String textContent = driver.findElement(By.xpath(".//*[@id='cart']/a[2]/span[1]")).getAttribute("textContent");
        System.out.println(textContent);
//2) открыть первый товар из списка
//2) добавить его в корзину (при этом может случайно добавиться товар, который там уже есть, ничего страшного)
//3) подождать, пока счётчик товаров в корзине обновится
//4) вернуться на главную страницу, повторить предыдущие шаги ещё два раза, чтобы в общей сложности в корзине было 3 единицы товара
//5) открыть корзину (в правом верхнем углу кликнуть по ссылке Checkout)
//6) удалить все товары из корзины один за другим, после каждого удаления подождать, пока внизу обновится таблица
    }

    private void addProduct() {
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("http://localhost/litecart/en/");
        WebElement until = wait.until(driver1 -> driver.findElement(By.cssSelector(".content .link")));
        Actions action = new Actions(driver);
        action.moveToElement(until).click().perform();
        WebElement until1 = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".quantity>button")));
        action.moveToElement(until1).click().perform();
        until1.click();
    }

    //    @After
    public void close() {
        driver.close();
        driver = null;
    }
}

