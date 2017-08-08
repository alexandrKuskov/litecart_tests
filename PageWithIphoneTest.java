import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class PageWithIphoneTest {

    private WebDriver driver;
    PageWithIphone pwi;
    PageWithIphoneCart pwiCart;

    @BeforeSuite()
    public void beforeSuite(){
        driver = new FirefoxDriver();
        pwi = new PageWithIphone(driver);
        pwiCart = new PageWithIphoneCart(driver);
        System.setProperty("webdriver.firefox.marionette", "C:\\ll\\geckodrivergeckodriver.exe");
    }

    @Test
    public void openPage(){
        driver.get("https://rozetka.com.ua/apple_iphone_7_plus_256gb_jet_black/p11256788/");

        pwi.waitForMainBlockWithProduct();

        pwi.clickBuyButton();

        pwiCart.waitForPopUp();

        String goodsLinkText = pwiCart.getNameProduct();

        pwiCart.clickOnCloseButton();

        pwi.clickOnCartWithProd();

        pwiCart.waitForPopUp();

        Assert.assertTrue(goodsLinkText.equals(pwiCart.getNameProduct()));

        pwiCart.clickOnFirstBtnDel();
        pwiCart.clickOnSecondBtnDel();

        Assert.assertTrue(pwiCart.emptyCartDispl());

        pwiCart.clickOnCloseBtnCart();
        pwi.clickOnEmptyCart();
        pwiCart.waitForEmptyCart();

        Assert.assertTrue(pwiCart.emptyCartDispl());
    }

    @AfterSuite()
    public void afterSuite(){
        driver.quit();
    }
}
