package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
public class OverviewPage {

    @FindBy(css = ".title")
    private WebElement title;
    @FindBy(css = ".cart_quantity")
    private WebElement quantity;
    @FindBy(css = ".inventory_item_name")
    private WebElement itemTitle;
    @FindBy(css = ".inventory_item_desc")
    private WebElement itemDesc;
    @FindBy(css = ".inventory_item_price")
    private WebElement price;
    @FindBy(css = "#cancel")
    private WebElement cancelBtn;
    @FindBy(css = "#finish")
    private WebElement finishBtn;
    @FindBy(css = ".summary_total_label")
    private WebElement totalPrice;



    public OverviewPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }


    public void clickFinishBtn(){
        sleep(250);
        finishBtn.click();
    }

    public String getOverViewTitle(){
        return title.getText();
    }

    public void clickCancelBtn(){
        sleep(250);
    }

    public String getTotalPrice(){
        return totalPrice.getText();
    }

    public void printTotalPrice(){
        System.out.println(totalPrice.getText());
    }

    public void sleep(int seconds){
        try {
            Thread.sleep(seconds);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
