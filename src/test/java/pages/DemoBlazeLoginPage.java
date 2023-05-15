package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class DemoBlazeLoginPage {

    public DemoBlazeLoginPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "(//a[@class='nav-link'])[8]")
    public WebElement signUpButton;

    @FindBy(xpath = "//input[@id='sign-username']")
    public WebElement UserNameInputBox;

    @FindBy(xpath = "//input[@id='sign-password']")
    public WebElement passwordInputBox;

    @FindBy (xpath = "//button[.='Sign up']")
    public WebElement signUpInputButton;

    @FindBy(id="login2")
    public WebElement loginButton;

    @FindBy(id="loginusername")
    public WebElement logInUserNameInputBox;

    @FindBy(id="loginpassword")
    public WebElement loginPasswordInputBox;

    @FindBy(xpath = "//button[.='Log in']")
    public WebElement logInButtonInput;


}
