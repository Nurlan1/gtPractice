package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class CashWiseProductAndServicesPage {
    public CashWiseProductAndServicesPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "(//button[@type='button'])[2]")
    public WebElement editButton;

    @FindBy (xpath = "(//h3)[2]")
    public WebElement afterEditBtnMessage;

    @FindBy(xpath = "(//button[@type='button'])[3]")
    public WebElement deleteButton;

    @FindBy(xpath = "//div[@type='MINI']//p")
    public WebElement afterDeleteBtnMessage;
}
