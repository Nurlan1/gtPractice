package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class CashWiseUsersMainPage {

    public CashWiseUsersMainPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy (xpath = "(//aside//div[@role='button']/div/li)[1]")
    public WebElement salesButton;

    @FindBy(xpath = "//a[@id='active']/../a")
    public List<WebElement> salesButtonOptions;


}
