package steps;

import com.google.j2objc.annotations.Weak;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import pages.DemoBlazeProductsPage;
import utilities.Driver;
import utilities.Flow;
import utilities.MyLogger;

import java.util.List;

public class DemoBlazeAddProductsSteps {

    DemoBlazeProductsPage demoBlazeProductsPage=new DemoBlazeProductsPage();

    @Given("user add to cart {string}")
    public void user_add_to_cart(String product) {
        MyLogger.info("Clicking on product: "+product);
        boolean check=false;
        Flow.scrollDown(300);
        List<WebElement> listOfProducts1 = demoBlazeProductsPage.listOfProducts;
        for (WebElement item : listOfProducts1) {
            if (item.getText().equalsIgnoreCase(product)) {
                item.click();
                Flow.wait(300);
                demoBlazeProductsPage.addToCartButton.click();
                break;
            }
        }
    }


    @When("user sees {string}")
    public void user_sees(String message) {
        MyLogger.info("User sees alert message");
        Flow.wait(500);
        Alert alert = Driver.getDriver().switchTo().alert();
        String actualMessage= alert.getText();
        Assert.assertEquals("Alert message didn't match", message,actualMessage);
        alert.accept();
    }

    @When("user clicks on  Cart")
    public void user_clicks_on_cart() {
        MyLogger.info("Going to cart");
        demoBlazeProductsPage.cartHeader.click();
    }
    @Then("user should be able to see the same {string}, {string} of added product")
    public void user_should_be_able_to_see_the_same_of_added_product(String products, String price) {
     MyLogger.info("Verification of details of products");
     List<WebElement> listOfTitle=demoBlazeProductsPage.listOfProductsTitle;
     List<WebElement> listOfPrice=demoBlazeProductsPage.listOfProductsPrice;
     for(WebElement title:listOfTitle) {
         String actualTitle=title.getText().trim();
         Assert.assertTrue("Title of products didn't pass",actualTitle.equalsIgnoreCase(products) );
     }

     for(WebElement price1:listOfPrice){
         String actualPrice=price1.getText().trim();
         Assert.assertTrue("Price of products didn't pass",actualPrice.equalsIgnoreCase(price));
     }
    }


    @Given("user add to cart products and sees {string}")
    public void user_add_to_cart_products_and_sees(List<String> list,String message) {
        Flow.scrollDown(300);
        List<WebElement> listOfProducts1 = demoBlazeProductsPage.listOfProducts;
        for (WebElement item : listOfProducts1) {
            if (list.contains(item.getText().trim())){
                item.click();
                Flow.wait(300);
                demoBlazeProductsPage.addToCartButton.click();
                Flow.wait(500);
                Alert alert = Driver.getDriver().switchTo().alert();
                String actualMessage= alert.getText();
                Assert.assertEquals("Alert message didn't match", message,actualMessage);
                alert.accept();
                Driver.getDriver().navigate().back();
            }
        }
    }

    @Then("user should be able to see the same {string}, {string} of added products")
    public void user_should_be_able_to_see_the_same_of_added_products(String products, String price) {
        List<WebElement> listOfTitle=demoBlazeProductsPage.listOfProductsTitle;
        List<WebElement> listOfPrice=demoBlazeProductsPage.listOfProductsPrice;
        for(WebElement title:listOfTitle) {
            String actualTitle=title.getText().trim();
            Assert.assertTrue("Title of products didn't pass",actualTitle.equalsIgnoreCase(products) );
        }

        for(WebElement price1:listOfPrice){
            String actualPrice=price1.getText().trim();
            Assert.assertTrue("Price of products didn't pass",actualPrice.equalsIgnoreCase(price));
        }
    }


}
