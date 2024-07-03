package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
public class LoginPage {

    @FindBy(css = "#user-name")
    private WebElement userName;
    @FindBy(css = "#password")
    private WebElement password;
    @FindBy(css = "#login-button")
    private WebElement loginBtn;
    @FindBy(css = ".error-message-container.error")
    private WebElement errorMessage;
    @FindBy(css = ".error-button")
    private WebElement errorXBtn;





    public LoginPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    public WebElement getUserName() {
        return userName;
    }

    public void setUserName(WebElement userName) {
        this.userName = userName;
    }

    public WebElement getPassword() {
        return password;
    }

    public void setPassword(WebElement password) {
        this.password = password;
    }

    public WebElement getLoginBtn() {
        return loginBtn;
    }



    public WebElement getErrorMessage() {
        return errorMessage;
    }


    public WebElement getErrorXBtn() {
        return errorXBtn;
    }


    public void enterUserName(String name){
        userName.clear();
        sleep(300);
        userName.sendKeys(name);
    }

    public void enterPassword(String pass){
        password.clear();
        sleep(300);
        password.sendKeys(pass);
        sleep(300);
    }

    public void clickLoginBtn(){
        loginBtn.click();
    }

    public String loginBtnText(){
        return loginBtn.getText(); //
    }


    public void sleep(int seconds){
        try {
            Thread.sleep(seconds);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public String getErrorMsg(String expected, String actual){

        return "";
    }


}
