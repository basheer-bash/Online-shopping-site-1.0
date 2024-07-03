import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.LoginPage;
import pages.ProductsPage;

import static org.junit.Assert.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args){

        System.setProperty("webdriver.chrome.driver","C:\\ChromeDriver\\chromedriver-win64\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        driver.manage().window().maximize();
        sleep(200);

        LoginPage loginPage = new LoginPage(driver);
        ProductsPage productsPage = new ProductsPage(driver);

        loginPage.enterUserName("");


        String expected = "Login";
        String title = "Swag Labs";


        WebElement loginBtn = driver.findElement(By.id("login-button"));
        sleep(300);
        WebElement userNameField = driver.findElement(By.id("user-name"));
        WebElement passwordField = driver.findElement(By.id("password"));


        /*// Click login button to get an error
        loginBtn.click();
        sleep(800);
        //================================================
        // User name error message
        String userNameErrExpected = "Epic sadface: Username is required";
        WebElement errorMessage = driver.findElement(By.xpath("//*[@id=\"login_button_container\"]/div/form/div[3]/h3"));
        WebElement errorXBtn = driver.findElement(By.xpath("//*[@id=\"login_button_container\"]/div/form/div[3]/h3/button"));
        String userNameErrActual = errorMessage.getText();
        assertEquals(userNameErrExpected, userNameErrActual);
       // error-message-container error



        //================================================
        //WebElement userNameField = driver.findElement(By.id("user-name"));
        userNameField.sendKeys("standard_user");
        sleep(800);
        loginBtn.click();


        //================================================
        // Password error message
        String passwordErrExpected = "Epic sadface: Password is required";
        //WebElement passwordErr = driver.findElement(By.xpath("//*[@id=\"login_button_container\"]/div/form/div[3]/h3"));
        String passwordErrActual = errorMessage.getText();
        assertEquals(passwordErrExpected, passwordErrActual);


        //WebElement passwordField = driver.findElement(By.id("password"));
        passwordField.sendKeys("standard_user");
        loginBtn.click();


        // user name and password error
        //========================================================
        String incorrectUserNameAndPassword = "Epic sadface: Username and password do not match any user in this service";
        String incorrectUserNameAndPasswordActual = errorMessage.getText();
        assertEquals(incorrectUserNameAndPassword, incorrectUserNameAndPasswordActual);
        sleep(1500);
        errorXBtn.click();*/


        //
        //==================================================
        userNameField.clear();
        userNameField.sendKeys("standard_user");
        sleep(200);
        passwordField.clear();
        passwordField.sendKeys("secret_sauce");
        sleep(200);
        loginBtn.click();


        // Products page validation
        String productsTitleExpected = "Products";
        WebElement currentPageTitle = driver.findElement(By.className("title"));
        String productsTitleActual = currentPageTitle.getText();
        assertEquals(productsTitleExpected, productsTitleActual);
        sleep(500);

        // Add product to cart button
        //=======================================================
        WebElement addToCartBtn = driver.findElement(By.id("add-to-cart-sauce-labs-backpack"));
        addToCartBtn.click();
        sleep(1200);

        // TODO: assert button text after adding to cart

        // Remove from cart button
        //=======================================================
        /*WebElement removeBtn = driver.findElement(By.id("remove-sauce-labs-backpack"));
        removeBtn.click();
        sleep(1200);
        addToCartBtn.click();*/



        // Click cart icon and move to cart page
        //=======================================================
        WebElement cartIcon = driver.findElement(By.className("shopping_cart_link"));
        cartIcon.click();
        sleep(1000);
        driver.navigate().back(); // Return from cart page
        sleep(1000);

        WebElement itemNameInProducts = driver.findElement(By.className("inventory_item_name"));
        String itemNameInProductPageExpected = itemNameInProducts.getText(); // Sauce Labs Backpack

        sleep(1000);
        driver.navigate().forward(); // move to cart page


        /*sleep(2000);
        String itemNameInCartExpected = itemNameInProducts.getText();
        assertEquals(itemNameInProductPageExpected, itemNameInCartExpected);*/


        sleep(1000);
        /*String yourCartTitleExpected = "Your Cart";
        String yourCartTitleActual = currentPageTitle.getText();
        assertEquals(yourCartTitleExpected, yourCartTitleActual);*/

        WebElement checkOutBtn = driver.findElement(By.name("checkout"));
        checkOutBtn.click();

        // TODO: check error message on  checkout page



        // TODO: enter first name
        WebElement firstName = driver.findElement(By.id("first-name"));
        firstName.clear();
        firstName.sendKeys("myName");

        // TODO: enter last name
        WebElement lastName = driver.findElement(By.name("lastName"));
        lastName.clear();
        lastName.sendKeys("myLastName");

        // TODO: enter zip code
        WebElement zipCode = driver.findElement(By.name("postalCode"));
        zipCode.clear();
        zipCode.sendKeys("234324");

        // TODO: continue button
        WebElement continueBtn = driver.findElement(By.id("continue"));
        continueBtn.click();


        WebElement finishBtn = driver.findElement(By.id("finish"));
        finishBtn.click();

        WebElement thankYouText = driver.findElement(By.className("complete-header"));
        String thankYouTextExpected = "Thank you for your order!";
        assertEquals(thankYouTextExpected, thankYouText.getText());

        WebElement backToHomeBtn =  driver.findElement(By.name("back-to-products"));
        backToHomeBtn.click();

        // TODO: get products title after clicking back to home button

        driver.quit();


    }


    public static void sleep(int seconds){
        try {
            Thread.sleep(seconds);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }


}