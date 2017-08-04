import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.util.Set;

public class CheckIphone {

    private WebDriver driver;
    private WebDriverWait driverWait;
    String goodsLinkText;

    By mainBlockWithProduct = By.name("block_desc");
    By buyButton = By.name("topurchases");
    By popUpCart = By.id("cart-popup");
    By goodsLink = By.name("goods-link");
    By cart = By.cssSelector("a[class='sprite-side novisited hub-i-link hub-i-cart-link-count']");

    @BeforeSuite()
    public void beforeSuite(){
        driver = new FirefoxDriver();
        driverWait = new WebDriverWait(driver, 10);
        System.setProperty("webdriver.firefox.marionette", "C:\\ll\\geckodrivergeckodriver.exe");
    }

    @Test(description = "Open the page")
    public void openPage(){
        driver.get("https://rozetka.com.ua/apple_iphone_7_plus_256gb_jet_black/p11256788/");
        driverWait.until(ExpectedConditions.presenceOfElementLocated(mainBlockWithProduct));
    }

    @Test(description = "Add product to cart")
    public void addProductToCart() {
        driver.findElement(buyButton).click();
        driverWait.until(ExpectedConditions.presenceOfElementLocated(popUpCart));
        goodsLinkText = driver.findElement(goodsLink).getText();
        driver.findElement(By.cssSelector("a.btn-link-i[name='close']")).click();
    }

    @Test(description = "Check product in the cart")
    public void checkProductInCart(){
        driver.findElement(cart).click();
        driverWait.until(ExpectedConditions.presenceOfElementLocated(popUpCart));

        if(goodsLinkText.equals(driver.findElement(goodsLink).getText())){
            System.out.println("Right product");
        }else{
            System.out.println("Wrong product");
        }
    }

    @Test(description = "Delete product")
    public void deleteProduct(){
        driver.findElement(By.name("before_delete")).click();
        driver.findElement(By.name("delete")).click();
    }

    @Test(description = "Check cart")
    public void checkCart(){
        if(driver.findElement(By.id("drop-block")).isDisplayed()){
            System.out.println("Product is deleted from the cart");
        }else{
            System.out.println("Product in the cart");
        }

        driver.findElement(By.name("close")).click();
        driver.findElement(cart).click();
        driverWait.until(ExpectedConditions.presenceOfElementLocated(popUpCart));

        if(driver.findElement(By.id("drop-block")).isDisplayed()){
            System.out.println("Product is deleted from the cart");
        }else{
            System.out.println("Product in the cart");
        }
    }
    @AfterSuite()
    public void afterSuite(){
        driver.quit();
    }
}
