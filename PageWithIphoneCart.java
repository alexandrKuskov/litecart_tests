import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageWithIphoneCart {
    WebDriver driver;
    private WebDriverWait driverWait;

    By emptyCart = By.cssSelector("div.wrap-cart-empty");
    By popUpCart = By.name("kits_items");
    By goodsLink = By.cssSelector("div.cart-i-title > a[name=\"goods-link\"]");

    public PageWithIphoneCart(WebDriver driver){
        this.driver = driver;
        driverWait = new WebDriverWait(driver, 10);
    }

    //wait for pop up
    public void waitForPopUp(){
        driverWait.until(ExpectedConditions.visibilityOfElementLocated(popUpCart));
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

    //click on close btn in cart
    public void clickOnCloseBtnCart(){
        WebElement element = driverWait.until(ExpectedConditions.presenceOfElementLocated(By.name("close")));
        element.click();
    }

    //click on close button
    public void clickOnCloseButton(){
        driver.findElement(By.cssSelector("a.btn-link-i[name='close']")).click();
    }

    //add value to the variable
    public String getNameProduct(){
        return driver.findElement(goodsLink).getText();
    }
}
