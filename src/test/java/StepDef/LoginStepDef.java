package StepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import Pages.LoginPage;
import utils.DriverFactory;

public class LoginStepDef {

    WebDriver driver;
    LoginPage loginpage;

    @Given("User is on the login page")
    public void user_is_on_the_login_page()
    {
        driver= DriverFactory.getDriver();
        loginpage=new LoginPage(driver);
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

    }

    @And("user enters {string} and {string}")
    public void userEntersAnd(String username, String password) {
        loginpage.enterUserName(username);
        loginpage.enterPassword(password);
    }

    @Then("user should be successfully logged in")
    public void userShouldBeSuccessfullyLoggedIn() {
        loginpage.clickLoginButton();
    }

//    @Then("error message {String} should be displayed")
//    public void userShouldNotLoggedIn(String expectedMessage) {
//        loginpage.clickLoginButton();
//        String actualMessage = loginpage.getLoginErrorMessage();
//        Assert.assertEquals(expectedMessage, actualMessage);
//    }

    @Then("error message {string} should be displayed")
    public void errorMessageShouldBeDisplayed(String expectedMessage) {
        loginpage.clickLoginButton();
        String actualMessage = loginpage.getLoginErrorMessage();
        Assert.assertEquals(expectedMessage, actualMessage);
    }
}
