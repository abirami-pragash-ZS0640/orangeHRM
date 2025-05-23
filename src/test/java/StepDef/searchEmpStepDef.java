package StepDef;

import Pages.searchEmployeePage;
import Pages.LoginPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import utils.DriverFactory;

public class searchEmpStepDef {


    WebDriver driver = DriverFactory.getDriver();

    LoginPage loginPage = new LoginPage(driver);

    searchEmployeePage searchEmployeePage = new searchEmployeePage(driver);


    @Given("Admin is logged in")
    public void admin_is_logged_in() {
        driver.get("https://opensource-demo.orangehrmlive.com/");
        loginPage.loginAsAdmin("Admin", "admin123");
    }

    @When("Admin navigates to Add Employee page")
    public void admin_navigates_to_add_employee_page() {
        searchEmployeePage.navigateToAddEmployeePage();
    }


    @And("Admin enters employee name {string} and ID {string}")
    public void searchEmployeeByNameAndId(String empName, String empId) {
       searchEmployeePage.searchEmpDetails(empName,empId);
    }

    @And("Admin clicks on the Search button")
    public void adminClicksOnTheSearchButton() {
        searchEmployeePage.clickSearchButton();
    }

    @Then("Admin should see the employee details in the search results")
    public void adminShouldSeeTheEmployeeDetailsInTheSearchResults() {
        boolean result = searchEmployeePage.isEmployeeResultVisible();
        Assert.assertTrue("Employee not found in search results", result);
    }
}
