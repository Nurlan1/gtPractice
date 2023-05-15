package pages;

import io.cucumber.java.hu.De;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class DemoBlazeProductsPage {

    public DemoBlazeProductsPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

@FindBy (xpath = "(//div[@class='card-block'])[3]//a")

    public WebElement nexus6;

    @FindBy(xpath = "(//div[@class='card-block'])[2]//a")

    public WebElement nokia1520;

    @FindBy (xpath = "//a[.='Add to cart']")
    public WebElement addToCartButton;

    @FindBy (xpath = "//a[@id='cartur']")
    public WebElement cartHeader;

    @FindBy (xpath = "//tbody//td[2]")
    public List<WebElement> listOfProductsTitle;

    @FindBy(xpath = "//tbody//td[3]")

    public List <WebElement> listOfProductsPrice;

    @FindBy(xpath = "//h4[@class='card-title']//a")
    public  List<WebElement> listOfProducts;

}
