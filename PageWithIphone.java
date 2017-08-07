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
    By popUpCart = By.name("kits_items");
    By goodsLink = By.cssSelector("div.cart-i-title > a[name=\"goods-link\"]");
    By cartBtnWithProd = By.cssSelector("a.hub-i-cart-link-count");
    By cartBtnEmpty = By.cssSelector("a.hub-i-cart-link");
    By emptyCart = By.cssSelector("div.wrap-cart-empty");

    //wait for main block with a product
    public void waitForMainBlockWithProduct() {
        driverWait.until(ExpectedConditions.visibilityOfElementLocated(mainBlockWithProduct));
    }

    //click to add the product to the cart
    public void clickBuyButton(){
        driver.findElement(buyButton).click();
    }

    //wait for pop up
    public void waitForPopUp(){
        driverWait.until(ExpectedConditions.visibilityOfElementLocated(popUpCart));
    }

    //add value to the variable
    public String getNameProduct(){
        return driver.findElement(goodsLink).getText();
    }

    //click on close button
    public void clickOnCloseButton(){
        driver.findElement(By.cssSelector("a.btn-link-i[name='close']")).click();
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

    //click on first button delete
    public void clickOnFirstBtnDel(){
        WebElement element = driverWait.until(ExpectedConditions.visibilityOfElementLocated(By.name("before_delete")));
        element.click();
    }

    //click on second button delete
    public void clickOnSecondBtnDel(){
        WebElement element = driverWait.until(ExpectedConditions.visibilityOfElementLocated(By.name("delete")));
        element.click();
    }

    //empty cart is displayed
    public boolean emptyCartDispl(){
        driverWait.until(ExpectedConditions.visibilityOfElementLocated(emptyCart));
        return driver.findElement(emptyCart).isDisplayed();
    }

    //wait for empty cart
    public void waitForEmptyCart(){
        driverWait.until(ExpectedConditions.visibilityOfElementLocated(emptyCart));
    }

    //click on close btn in cart
    public void clickOnCloseBtnCart(){
        WebElement element = driverWait.until(ExpectedConditions.presenceOfElementLocated(By.name("close")));
        element.click();
    }
}
