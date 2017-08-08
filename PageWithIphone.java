import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageWithIphone {
    private WebDriver driver;
    private WebDriverWait driverWait;

    public PageWithIphone(WebDriver driver){
        this.driver = driver;
        driverWait = new WebDriverWait(driver, 10);
    }

    By mainBlockWithProduct = By.name("block_desc");
    By buyButton = By.name("topurchases");
    By cartBtnWithProd = By.cssSelector("a.hub-i-cart-link-count");
    By cartBtnEmpty = By.cssSelector("a.hub-i-cart-link");

    //wait for main block with a product
    public void waitForMainBlockWithProduct() {
        driverWait.until(ExpectedConditions.visibilityOfElementLocated(mainBlockWithProduct));
    }

    //click to add the product to the cart
    public void clickBuyButton(){
        driver.findElement(buyButton).click();
    }


    //click on the cart with product
    public void clickOnCartWithProd(){
        WebElement element = driverWait.until(ExpectedConditions.presenceOfElementLocated(cartBtnWithProd));
        element.click();
    }

    //click on the empty cart
    public void clickOnEmptyCart(){
        WebElement element = driverWait.until(ExpectedConditions.presenceOfElementLocated(cartBtnEmpty));
        element.click();
    }
}
