package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;
import utilities.Flow;

import java.util.List;

public class CashWiseLoginPage {

    public CashWiseLoginPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "(//button[@type='button'])[1]")
    public WebElement signInButton;

    @FindBy(xpath = "(//input[@name='email'])[2]")
    public WebElement emailInputBox;

    @FindBy(name="password")
    public WebElement passwordInputBox;

    @FindBy(xpath = "(//button[@type='submit'])[2]")
    public WebElement signInInputButton;

    @FindBy(xpath = "((//form)[2]//p)[1]")
    public WebElement emailErrorMessage;

    @FindBy(xpath = "((//form)[2]//p)[2]")
    public WebElement passwordErrorMessage;


    public void signInCashWise(String email, String password){
        signInButton.click();
        Flow.wait(300);
        emailInputBox.sendKeys(email);
        passwordInputBox.sendKeys(password);
        signInInputButton.click();

    }

    @FindBy(xpath = "//h2[.='We offer']/..//h3")
    public List<WebElement> benefitsList;


}