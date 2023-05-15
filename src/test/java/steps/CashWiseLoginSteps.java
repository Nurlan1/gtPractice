package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import pages.CashWiseLoginPage;
import utilities.Config;
import utilities.Driver;
import utilities.Flow;

import java.util.List;

public class CashWiseLoginSteps {

CashWiseLoginPage cashWiseLoginPage=new CashWiseLoginPage();


    @Given("I am on the CahWise login page")
    public void i_am_on_the_cah_wise_login_page() {
        Driver.getDriver().get(Config.getValue("cashWiseURL"));
    }
    @Given("I Click on signIn button")
    public void i_click_on_sign_in_button() {
     cashWiseLoginPage.signInButton.click();

    }
    @When("I input  {string} and {string}")
    public void i_input_and(String email, String password) {
     cashWiseLoginPage.emailInputBox.sendKeys(email);
     cashWiseLoginPage.passwordInputBox.sendKeys(password);
     cashWiseLoginPage.signInInputButton.click();
    }
    @Then("I should land on {string} page")
    public void i_should_land_on_page(String url) {
        Flow.wait(2000);
     String actualURL=Driver.getDriver().getCurrentUrl();

        Assert.fail("on purpose");
    }

    @Then("User sees error message {string} and {string}")
    public void user_sees_error_message_and(String emailError, String passwordError) {
      String actualEmailError=cashWiseLoginPage.emailErrorMessage.getText().trim();
      String actualPasswordError=cashWiseLoginPage.passwordErrorMessage.getText().trim();
      Assert.assertEquals(emailError,actualEmailError);
      Assert.assertEquals(passwordError, actualPasswordError);
    }


    @When("User scrolls down to four offer benefits on homepage")
    public void user_scrolls_down_to_four_offer_benefits_on_homepage() {
        Flow.scrollDown(500);
    }
    @Then("User should see four offers")
    public void user_should_see_four_offers(List<String> benefits) {
      List <WebElement> list=cashWiseLoginPage.benefitsList;
      for(WebElement benefit: list){
         String benefitInString= benefit.getText().trim();
          Assert.assertTrue(benefits.contains(benefitInString));
      }
    }
}
