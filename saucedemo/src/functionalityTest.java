import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.*;

import static org.junit.Assert.assertEquals;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class functionalityTest {
    public static void main(String[] args){

        System.setProperty("webdriver.chrome.driver","C:\\ChromeDriver\\chromedriver-win64\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        driver.manage().window().maximize();

        LoginPage loginPage = new LoginPage(driver);
        ProductsPage productsPage = new ProductsPage(driver);
        CartPage cartPage = new CartPage(driver);
        InformationPage info = new InformationPage(driver);
        OverviewPage overviewPage = new OverviewPage(driver);
        FinishPage finishPage = new FinishPage(driver);

        loginPage.enterUserName("standard_user");
        loginPage.enterPassword("secret_sauce");
        loginPage.clickLoginBtn();

        String productsTitle = "Products";
        String productsTitleActual = productsPage.getProductTitle();
        assertEquals(productsTitle, productsTitleActual);

        productsPage.clickAddToCartBtn();

        productsPage.clickCartIcon();





        cartPage.clickCheckout();
        //info.enterDetails("user_name","last_name","4534534");
        overviewPage.clickFinishBtn();

        String expected = "Thank you for your order!";
        String actual = finishPage.getFinishMessage();
        assertEquals(expected, actual);
        System.out.println("Finish message is: " +actual);



        // TODO: assert current page -  get title text
        // TODO: assert quantity
        // TODO: check remove btn products page and cart page
        // TODO: check price before finishing process
        // TODO: remove item before finish process



        driver.quit();


    }




}