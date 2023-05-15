package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import pages.FacebookLoginPage;
import utilities.Driver;

public class FacebookLoginSteps {

    FacebookLoginPage facebookLoginPage=new FacebookLoginPage();



    @Given("User is on the Facebook login page")
    public void user_is_on_the_facebook_login_page() {

        Driver.getDriver().get("https://www.facebook.com/");

    }
    @When("User enters {string} and {string} and tries to log in")
    public void user_enters_and_and_tries_to_log_in(String email, String password) {
        facebookLoginPage.emailInput.sendKeys(email);
        facebookLoginPage.passwordInput.sendKeys(password);
        facebookLoginPage.loginButton.click();

    }
    @Then("user should be provided to main profile page and verifies by element {string}")
    public void user_should_be_provided_to_main_profile_page_and_verifies_by_element(String expected) {
        System.out.println(Driver.getDriver().getCurrentUrl());
        String actual=facebookLoginPage.friendsElement.getText();
        Assertions.assertEquals(expected,actual);
    }

}
