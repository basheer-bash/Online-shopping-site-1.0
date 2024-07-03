package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
public class InformationPage {

    @FindBy(css = ".title")
    private WebElement infoTitle;
    @FindBy(css = "#first-name")
    private WebElement firstName;
    @FindBy(css = "#last-name")
    private WebElement lastName;
    @FindBy(css = "#postal-code")
    private WebElement zipCode;
    @FindBy(css = "#cancel")
    private WebElement cancelBtn;
    @FindBy(css = "#continue")
    private WebElement continueBtn;
    @FindBy(css = ".error-message-container.error")
    private WebElement errorMsg;


    public InformationPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }


    public void enterDetailsAndClickContinueBtn(String name, String l_name, String zip){
        firstName.clear();
        sleep(250);
        firstName.sendKeys(name);
        sleep(230);
        lastName.clear();
        sleep(230);
        lastName.sendKeys(l_name);
        sleep(230);
        zipCode.clear();
        sleep(250);
        zipCode.sendKeys(zip);
        sleep(250);
        continueBtn.click();

    }


    public void enterFirstName(String f_name){
        firstName.clear();
        sleep(250);
        firstName.sendKeys(f_name);
    }

    public void enterLastName(String l_name){
        lastName.clear();
        sleep(230);
        lastName.sendKeys(l_name);
    }

    public void enterZipCode(String z_code){
        zipCode.clear();
        sleep(250);
        zipCode.sendKeys(z_code);
    }

    public void clickContinueBtn(){
        sleep(250);
        continueBtn.click();
    }

    public String getTitle(){
        return infoTitle.getText();
    }

    public void clickCancel(){
        sleep(250);
        cancelBtn.click();
    }

    public String getErrorMessage(){
        return errorMsg.getText();
    }

    public void sleep(int seconds){
        try {
            Thread.sleep(seconds);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
