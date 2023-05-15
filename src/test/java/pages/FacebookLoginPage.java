package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class FacebookLoginPage {

    public FacebookLoginPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(id = "email")
    public WebElement emailInput;

    @FindBy(id = "pass")
    public WebElement passwordInput;

    @FindBy(xpath = "//button")//*[@name='login']
    public WebElement loginButton;

    @FindBy (xpath = "//*[.=\"Friends\"]")
    public WebElement friendsElement;
}
