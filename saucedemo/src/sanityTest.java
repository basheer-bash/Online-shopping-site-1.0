import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.*;

import static org.junit.Assert.assertEquals;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class sanityTest {
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
        System.out.println("Products title is: " +productsTitleActual);
        productsPage.addAllItem();

        /*productsPage.addEachItem(0);
        productsPage.addEachItem(1);
        productsPage.addEachItem(2);
        productsPage.addEachItem(0);
        productsPage.addEachItem(1);
        productsPage.addEachItem(2);*/

        productsPage.clickCartIcon();

        cartPage.clickContinueShoppingBtn();
        assertEquals(productsTitle, productsTitleActual); // assert title

        productsPage.clickCartIcon();
        cartPage.clickCheckout();
        String infoTitleExpected = "Checkout: Your Information";
        String infoTitleActual = info.getTitle();
        assertEquals(infoTitleExpected, infoTitleActual);
        System.out.println("Info title is: " +infoTitleActual);
        //info.clickCancel();
        driver.navigate().back();
        String cartTitleExpected = "Your Cart";
        String cartTitleActual = cartPage.getCartTitle();
        assertEquals(cartTitleExpected, cartTitleActual);
        System.out.println("Cart title is: " +cartTitleActual);
        cartPage.clickCheckout();

        info.enterDetailsAndClickContinueBtn("my name","",""); // last name
        String lastNameErrorExpected = "Error: Last Name is required";
        String lastNameErrorActual = info.getErrorMessage();
        assertEquals(lastNameErrorExpected, lastNameErrorActual);

        info.enterDetailsAndClickContinueBtn("","my last name",""); // first name
        info.enterFirstName("");
        String firstNameErrorExpected = "Error: Postal Code is required";
        String firstNameErrorActual = info.getErrorMessage();
        assertEquals(firstNameErrorExpected, firstNameErrorActual);

        info.enterDetailsAndClickContinueBtn("my name","my last name",""); // zip code
        String zipCodeErrorExpected = "Error: Postal Code is required";
        String zipCodeErrorActual = info.getErrorMessage();
        assertEquals(zipCodeErrorExpected, zipCodeErrorActual);

        info.enterDetailsAndClickContinueBtn("my name","my last name","67453");

        String overViewTitleExpected = "Checkout: Overview";
        String overViewTitleActual = overviewPage.getOverViewTitle();
        assertEquals(overViewTitleExpected, overViewTitleActual);
        System.out.println("Over view title is: " +overViewTitleActual);
        overviewPage.printTotalPrice();

        overviewPage.clickFinishBtn();

        finishPage.clickBackToHome();
        assertEquals(productsTitle, productsTitleActual);
        System.out.println("Products title is: " +productsTitleActual);

        //System.out.println(productsPage.getCartBadge());
        /*cartPage.clickCheckout();
        info.enterDetails("user_name","last_name","4534534");
        overviewPage.clickFinishBtn();

        String expected = "Thank you for your order!";
        String actual = finishPage.getFinishMessage();
        assertEquals(expected, actual);
        System.out.println("Finish message is: " +actual);*/



        // TODO: assert current page -  get title text
        // TODO: assert quantity
        // TODO: check remove btn products page and cart page
        // TODO: check price before finishing process
        // TODO: remove item before finish process



        //driver.quit();


    }




}