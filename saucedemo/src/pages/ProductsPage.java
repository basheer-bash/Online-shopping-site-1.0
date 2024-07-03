package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

import static org.junit.Assert.assertEquals;
public class ProductsPage {

    @FindBy(css = ".title")
    private WebElement productsTitle;
    @FindBy(xpath = "//*[@id=\"item_4_title_link\"]/div")
    private WebElement itemName;
    @FindBy(css = ".inventory_item_desc")
    private WebElement itemDescription;
    @FindBy(xpath = "//*[@id=\"inventory_container\"]/div/div[1]/div[2]/div[2]/div")
    private WebElement price;
    @FindBy(css = "#add-to-cart-sauce-labs-backpack")
    private WebElement addToCartBtn;
    @FindBy(css = "#remove-sauce-labs-backpack")
    private WebElement removeBtn;
    @FindBy(css = ".product_sort_container")
    private WebElement filterBtn;
    @FindBy(css = "#shopping_cart_container")
    private WebElement cartIcon;
    @FindBy(css = ".btn_primary.btn_small.btn_inventory")
    private List<WebElement> addToCartButtons;
    @FindBy(css = ".shopping_cart_badge")
    private WebElement cartBadge;



    public ProductsPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    public void clickAddToCartBtn(){
        sleep(250);
        addToCartBtn.click();
    }

    public void clickCartIcon(){
        sleep(250);
        cartIcon.click();
    }

    public void clickRemoveBtn(){
        sleep(100);
        removeBtn.click();
    }

    public String getProductTitle(){
        return productsTitle.getText();
    }

    public void asserTitle(String exe){
        assertEquals(exe,productsTitle.getText());
    }

    public void addAllItem(){
        for(int i=0; i<addToCartButtons.size(); i++){
            addToCartButtons.get(i).click();
            sleep(1000);
        }
        System.out.println("List size is: " +addToCartButtons.size());
        //addToCartButtons.get(0).click(); // Add first item
    }

    public void addEachItem(int index){
        addToCartButtons.get(index).click();
        sleep(1000);
        //addToCartButtons.get(1).click();
    }

    public String getCartBadge(){
        if(cartBadge.getText() != null)
            return cartBadge.getText();
        return null;
        // TODO: maybe return int
    }


    public void sleep(int seconds){
        try {
            Thread.sleep(seconds);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }





}
