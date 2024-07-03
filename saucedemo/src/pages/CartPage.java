package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage {

    @FindBy(css = ".title")
    private WebElement cartTitle;
    @FindBy(css = ".cart_quantity")
    private WebElement quantity;
    @FindBy(css = ".inventory_item_name")
    private WebElement itemTitle;
    @FindBy(css = ".inventory_item_desc")
    private WebElement itemDesc;
    @FindBy(css = ".inventory_item_price")
    private WebElement price;
    @FindBy(css = "#remove-sauce-labs-backpack")
    private WebElement removeBtn;
    @FindBy(css = "#continue-shopping")
    private WebElement continueBtn;
    @FindBy(css = "#checkout")
    private WebElement checkOutBtn;


    public CartPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }


    public void clickCheckout(){
        sleep(250);
        checkOutBtn.click();
    }

    public void clickContinueShoppingBtn(){
        sleep(200);
        continueBtn.click();
    }

    public String getCartTitle(){
        return cartTitle.getText();
    }

    public void sleep(int seconds){
        try {
            Thread.sleep(seconds);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
