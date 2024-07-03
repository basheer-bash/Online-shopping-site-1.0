package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
public class FinishPage {

    @FindBy(css = ".complete-header")
    private WebElement finishMessage;
    @FindBy(css = "#back-to-products")
    private WebElement backToHomeBtn;


    public FinishPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    public String getFinishMessage(){
        return finishMessage.getText();
    }

    public void clickBackToHome(){
        sleep(100);
        backToHomeBtn.click();
    }




    public void sleep(int seconds){
        try {
            Thread.sleep(seconds);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
