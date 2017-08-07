import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class PageWithIphoneTest {

    private WebDriver driver;
    PageWithIphone pwi;

    @BeforeSuite()
    public void beforeSuite(){
        driver = new FirefoxDriver();
        pwi = new PageWithIphone(driver);
        System.setProperty("webdriver.firefox.marionette", "C:\\ll\\geckodrivergeckodriver.exe");
    }

    @Test
    public void openPage(){
        driver.get("https://rozetka.com.ua/apple_iphone_7_plus_256gb_jet_black/p11256788/");

        pwi.waitForMainBlockWithProduct();

        pwi.clickBuyButton();

        pwi.waitForPopUp();

        String goodsLinkText = pwi.getNameProduct();

        pwi.clickOnCloseButton();

        pwi.clickOnCartWithProd();

        pwi.waitForPopUp();

        Assert.assertTrue(goodsLinkText.equals(pwi.getNameProduct()));

        pwi.clickOnFirstBtnDel();
        pwi.clickOnSecondBtnDel();

        Assert.assertTrue(pwi.emptyCartDispl());

        pwi.clickOnCloseBtnCart();
        pwi.clickOnEmptyCart();
        pwi.waitForEmptyCart();

        Assert.assertTrue(pwi.emptyCartDispl());
    }

    @AfterSuite()
    public void afterSuite(){
        driver.quit();
    }
}
