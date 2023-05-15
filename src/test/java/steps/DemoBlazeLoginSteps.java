package steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.DemoBlazeLoginPage;
import utilities.Config;
import utilities.Driver;
import utilities.Flow;
import utilities.TempStorage;

public class DemoBlazeLoginSteps {

    DemoBlazeLoginPage demoBlazeLoginPage=new DemoBlazeLoginPage();

    @When("user click on the logIn button for demo blaze")
    public void user_click_on_the_log_in_button_for_demo_blaze() {
        demoBlazeLoginPage.loginButton.click();
        Flow.wait(500);

    }
    @When("user enters credentials {string} and {string} and clicks login")
    public void user_enters_credentials_and_and_clicks_login(String userName, String password) {
        TempStorage.addData("userName",userName);

        demoBlazeLoginPage.logInUserNameInputBox.sendKeys(userName);
        demoBlazeLoginPage.loginPasswordInputBox.sendKeys(password);
        demoBlazeLoginPage.logInButtonInput.click();
    }
    @Then("user should successfully login to application")
    public void user_should_successfully_login_to_application() {
       String userName=TempStorage.getData("userName");
        String linkText="Welcome "+userName;
        WebElement welcomeUser=Driver.getDriver().findElement(By.linkText(linkText));
        Assert.assertTrue(welcomeUser.isDisplayed());
    }

}
