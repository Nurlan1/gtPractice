package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import pages.DemoBlazeLoginPage;
import utilities.Config;
import utilities.Driver;
import utilities.Flow;
import utilities.MyLogger;

import java.util.Random;

public class DemoBlazeSignUpSteps {
    DemoBlazeLoginPage demoBlazeLoginPage=new DemoBlazeLoginPage();
    @Given("user on the DemoBlaze application")
    public void user_on_the_demo_blaze_application() {
        MyLogger.info("User is on the demo blaze website");
        Driver.getDriver().get(Config.getValue("demoBlazeURL"));
    }
    @Given("user clicks on sign up button")
    public void user_clicks_on_sign_up_button() {
        MyLogger.warn("Clicking the sign up link");
        demoBlazeLoginPage.signUpButton.click();
        Flow.wait(500);
    }
    @When("user enters {string}  and {string} and clicks sign up")
    public void user_enters_and_and_clicks_sign_up(String userName, String password) {

        if(userName.equals("placeholder")){
            userName=userName+new Random().nextInt(10000);

        }
        MyLogger.warn("Entering Credentials. User name:  "+userName+" password: "+password);
            demoBlazeLoginPage.UserNameInputBox.sendKeys(userName);
            demoBlazeLoginPage.passwordInputBox.sendKeys(password);
            demoBlazeLoginPage.signUpInputButton.click();
             Flow.wait(1000);
    }
    @Then("user should see alert message {string}")
    public void user_should_see_alert_message(String alertMessage) {
        MyLogger.info("Verifying alert messages");
        Alert alert=Driver.getDriver().switchTo().alert();
        System.out.println(alert.getText());
        String actualAlert=alert.getText();
        Assert.assertEquals(alertMessage,actualAlert);
        //Assert.assertTrue("Alert verification failed",actualAlert.equals(alertMessage));
    }


}
