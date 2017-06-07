import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class MySecondTest {
    private WebDriver driver;
//    private WebDriverWait wait;

    @Before
    public void start() {
        driver = new FirefoxDriver(new DesiredCapabilities());
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void loginTest() {
        driver.get("http://localhost/litecart/admin");
        driver.findElement(By.cssSelector("input[name=username]")).sendKeys("admin");
        driver.findElement(By.cssSelector("input[name=password]")).sendKeys("admin");
        driver.findElement(By.cssSelector("button[name=login]")).click();
    }

    @Test
    public void checkMenu() {
        loginTest();

        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

        //<editor-fold defaultstate="collapsed" desc="Apearence">
        driver.findElements(By.xpath(".//li[@id='app-']")).get(0).click();
        driver.findElement(By.xpath(".//li[@id='doc-template']")).click();
        driver.findElement(By.xpath("//h1[contains(.,'Template')]"));
        driver.findElement(By.xpath(".//li[@id='doc-logotype']")).click();
        driver.findElement(By.xpath("//h1[contains(.,'Logotype')]"));
        //</editor-fold>

        //<editor-fold defaultstate="collapsed" desc="Catalog">
        driver.findElements(By.xpath(".//li[@id='app-']")).get(1).click();
        driver.findElement(By.xpath(".//li[@id='doc-catalog']")).click();
        driver.findElement(By.xpath("//h1[contains(.,'Catalog')]"));
        driver.findElement(By.xpath(".//li[@id='doc-product_groups']")).click();
        driver.findElement(By.xpath("//h1[contains(.,'Product Groups')]"));
        driver.findElement(By.xpath(".//li[@id='doc-option_groups']")).click();
        driver.findElement(By.xpath("//h1[contains(.,'Option Groups')]"));
        driver.findElement(By.xpath(".//li[@id='doc-manufacturers']")).click();
        driver.findElement(By.xpath("//h1[contains(.,'Manufacturers')]"));
        driver.findElement(By.xpath(".//li[@id='doc-suppliers']")).click();
        driver.findElement(By.xpath("//h1[contains(.,'Suppliers')]"));
        driver.findElement(By.xpath(".//li[@id='doc-delivery_statuses']")).click();
        driver.findElement(By.xpath("//h1[contains(.,'Delivery Statuses')]"));
        driver.findElement(By.xpath(".//li[@id='doc-sold_out_statuses']")).click();
        driver.findElement(By.xpath("//h1[contains(.,'Sold Out Statuses')]"));
        driver.findElement(By.xpath(".//li[@id='doc-quantity_units']")).click();
        driver.findElement(By.xpath("//h1[contains(.,'Quantity Units')]"));
        driver.findElement(By.xpath(".//li[@id='doc-csv']")).click();
        driver.findElement(By.xpath("//h1[contains(.,'CSV Import/Export')]"));
        //</editor-fold>

        //<editor-fold defaultstate="collapsed" desc="Countries">
        driver.findElements(By.xpath(".//li[@id='app-']")).get(2).click();
        driver.findElement(By.xpath("//h1[contains(.,'Countries')]"));
        //</editor-fold>

        //<editor-fold defaultstate="collapsed" desc="Currencies">
        driver.findElements(By.xpath(".//li[@id='app-']")).get(3).click();
        driver.findElement(By.xpath("//h1[contains(.,'Currencies')]"));
        //</editor-fold>

        //<editor-fold defaultstate="collapsed" desc="Customers">
        driver.findElements(By.xpath(".//li[@id='app-']")).get(4).click();
        driver.findElement(By.xpath(".//li[@id='doc-customers']")).click();
        driver.findElement(By.xpath("//h1[contains(.,'Customers')]"));
        driver.findElement(By.xpath(".//li[@id='doc-csv']")).click();
        driver.findElement(By.xpath("//h1[contains(.,'CSV Import/Export')]"));
        driver.findElement(By.xpath(".//li[@id='doc-newsletter']")).click();
        driver.findElement(By.xpath("//h1[contains(.,'Newsletter')]"));
        //</editor-fold>

        //<editor-fold defaultstate="collapsed" desc="Geo Zones">
        driver.findElements(By.xpath(".//li[@id='app-']")).get(5).click();
        driver.findElement(By.xpath("//h1[contains(.,'Geo Zones')]"));
        //</editor-fold>

        //<editor-fold defaultstate="collapsed" desc="Laanguages">
        driver.findElements(By.xpath(".//li[@id='app-']")).get(6).click();
        driver.findElement(By.xpath(".//li[@id='doc-languages']")).click();
        driver.findElement(By.xpath("//h1[contains(.,'Languages')]"));
        driver.findElement(By.xpath(".//li[@id='doc-storage_encoding']")).click();
        driver.findElement(By.xpath("//h1[contains(.,'Storage Encoding')]"));
        //</editor-fold>

        //<editor-fold defaultstate="collapsed" desc="Modules">
        driver.findElements(By.xpath(".//li[@id='app-']")).get(7).click();
        driver.findElement(By.xpath(".//li[@id='doc-jobs']")).click();
        driver.findElement(By.xpath("//h1[contains(.,'Job Modules')]"));
        driver.findElement(By.xpath(".//li[@id='doc-customer']")).click();
        driver.findElement(By.xpath("//h1[contains(.,'Customer')]"));
        driver.findElement(By.xpath(".//li[@id='doc-shipping']")).click();
        driver.findElement(By.xpath("//h1[contains(.,'Shipping')]"));
        driver.findElement(By.xpath(".//li[@id='doc-payment']")).click();
        driver.findElement(By.xpath("//h1[contains(.,'Payment')]"));
        driver.findElement(By.xpath(".//li[@id='doc-order_total']")).click();
        driver.findElement(By.xpath("//h1[contains(.,'Order Total')]"));
        driver.findElement(By.xpath(".//li[@id='doc-order_success']")).click();
        driver.findElement(By.xpath("//h1[contains(.,'Order Success Modules')]"));
        driver.findElement(By.xpath(".//li[@id='doc-order_action']")).click();
        driver.findElement(By.xpath("//h1[contains(.,'Order Action Modules')]"));
        //</editor-fold>

        //<editor-fold defaultstate="collapsed" desc="Orders">
        driver.findElements(By.xpath(".//li[@id='app-']")).get(8).click();
        driver.findElement(By.xpath(".//li[@id='doc-orders']")).click();
        driver.findElement(By.xpath("//h1[contains(.,'Orders')]"));
        driver.findElement(By.xpath(".//li[@id='doc-order_statuses']")).click();
        driver.findElement(By.xpath("//h1[contains(.,'Order Statuses')]"));
        //</editor-fold>

        //<editor-fold defaultstate="collapsed" desc="Pages">
        driver.findElements(By.xpath(".//li[@id='app-']")).get(9).click();
        driver.findElement(By.xpath("//h1[contains(.,'Pages')]"));
        //</editor-fold>

        //<editor-fold defaultstate="collapsed" desc="Reports">
        driver.findElements(By.xpath(".//li[@id='app-']")).get(10).click();
        driver.findElement(By.xpath(".//li[@id='doc-monthly_sales']")).click();
        driver.findElement(By.xpath("//h1[contains(.,'Monthly Sales')]"));
        driver.findElement(By.xpath(".//li[@id='doc-most_sold_products']")).click();
        driver.findElement(By.xpath("//h1[contains(.,'Most Sold Products')]"));
        driver.findElement(By.xpath(".//li[@id='doc-most_shopping_customers']")).click();
        driver.findElement(By.xpath("//h1[contains(.,'Most Shopping Customers')]"));
        //</editor-fold>

        //<editor-fold defaultstate="collapsed" desc="Settings">
        driver.findElements(By.xpath(".//li[@id='app-']")).get(11).click();
        driver.findElement(By.xpath(".//li[@id='doc-store_info']")).click();
        driver.findElement(By.xpath("//h1[contains(.,'Settings')]"));
        driver.findElement(By.xpath(".//li[@id='doc-defaults']")).click();
        driver.findElement(By.xpath("//h1[contains(.,'Settings')]"));
        driver.findElement(By.xpath(".//li[@id='doc-general']")).click();
        driver.findElement(By.xpath("//h1[contains(.,'Settings')]"));
        driver.findElement(By.xpath(".//li[@id='doc-listings']")).click();
        driver.findElement(By.xpath("//h1[contains(.,'Settings')]"));
        driver.findElement(By.xpath(".//li[@id='doc-images']")).click();
        driver.findElement(By.xpath("//h1[contains(.,'Settings')]"));
        driver.findElement(By.xpath(".//li[@id='doc-checkout']")).click();
        driver.findElement(By.xpath("//h1[contains(.,'Settings')]"));
        driver.findElement(By.xpath(".//li[@id='doc-advanced']")).click();
        driver.findElement(By.xpath("//h1[contains(.,'Settings')]"));
        driver.findElement(By.xpath(".//li[@id='doc-security']")).click();
        driver.findElement(By.xpath("//h1[contains(.,'Settings')]"));
        //</editor-fold>

        //<editor-fold defaultstate="collapsed" desc="Slides">
        driver.findElements(By.xpath(".//li[@id='app-']")).get(12).click();
        driver.findElement(By.xpath("//h1[contains(.,'Slides')]"));
        //</editor-fold>

        //<editor-fold defaultstate="collapsed" desc="Tax">
        driver.findElements(By.xpath(".//li[@id='app-']")).get(13).click();
        driver.findElement(By.xpath(".//li[@id='doc-tax_classes']")).click();
        driver.findElement(By.xpath("//h1[contains(.,'Tax Classes')]"));
        driver.findElement(By.xpath(".//li[@id='doc-tax_rates']")).click();
        driver.findElement(By.xpath("//h1[contains(.,'Tax Rates')]"));
        //</editor-fold>

        //<editor-fold defaultstate="collapsed" desc="Transactions">
        driver.findElements(By.xpath(".//li[@id='app-']")).get(14).click();
        driver.findElement(By.xpath(".//li[@id='doc-search']")).click();
        driver.findElement(By.xpath("//h1[contains(.,'Search Translations')]"));
        driver.findElement(By.xpath(".//li[@id='doc-scan']")).click();
        driver.findElement(By.xpath("//h1[contains(.,'Scan Files For Translations')]"));
        driver.findElement(By.xpath(".//li[@id='doc-csv']")).click();
        driver.findElement(By.xpath("//h1[contains(.,'CSV Import/Export')]"));
        //</editor-fold>

        //<editor-fold defaultstate="collapsed" desc="Uers">
        driver.findElements(By.xpath(".//li[@id='app-']")).get(15).click();
        driver.findElement(By.xpath("//h1[contains(.,'Users')]"));
        //</editor-fold>

        //<editor-fold defaultstate="collapsed" desc="vQmods">
        driver.findElements(By.xpath(".//li[@id='app-']")).get(16).click();
        driver.findElement(By.xpath(".//li[@id='doc-vqmods']")).click();
        driver.findElement(By.xpath("//h1[contains(.,'vQmods')]"));
        //</editor-fold>
    }

    @Test
    public void checkStickers() {
        driver.get("http://localhost/litecart/en/");
        List<WebElement> elements = driver.findElements(By.cssSelector("li.product"));
        List<WebElement> webElements = driver.findElements(By.cssSelector("div.sticker"));
        Assert.assertTrue(hasSticker(elements));
        isEquals(elements, webElements);

    }

    private boolean hasSticker(List<WebElement> elements) {
        for (WebElement webElement : elements) {
            List<WebElement> webElements = webElement.findElements(By.cssSelector(".sticker"));
            if (webElements.size() > 1) {
                return false;
            }
        }
        return true;
    }

    public boolean isEquals(List<WebElement> elements, List<WebElement> webElements) {
        if (elements.size() == webElements.size()) return true;
        else return false;
    }

    @After
    public void close() {
        driver.quit();
        driver = null;
    }
}
