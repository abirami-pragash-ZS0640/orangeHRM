package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.ElementUtils;

import java.time.Duration;

public class searchEmployeePage extends ElementUtils {
    private final WebDriver driver;

    public searchEmployeePage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }
    public void navigateToAddEmployeePage() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        WebElement pimMenu = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//span[text()='PIM']")
        ));
        pimMenu.click();

        WebElement addEmployeeMenu = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//span[contains(@class, 'oxd-main-menu-item--name') and text()='PIM']")
        ));
        addEmployeeMenu.click();

    }
    By employeeNameField = By.xpath("//label[text()='Employee Name']/following::input[1]");
    By employeeIdField = By.xpath("//label[text()='Employee Id']");
    By searchButton = By.xpath("//button[@type='submit']");

    public void searchEmpDetails(String empName, String empId) {

        //Enter Employee name
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//input[@placeholder='Type for hints...']")
        ));
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@placeholder='Type for hints...']")));
        setText(employeeNameField,empName);


        // Enter employee ID
        WebElement idInput = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("(//input[@class='oxd-input oxd-input--active'])[2]")
        ));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", idInput);
        idInput.clear();
        idInput.sendKeys(empId);
    }

    public void clickSearchButton()
    {
        clickElement(searchButton);
    }

    public boolean isEmployeeResultVisible() {
        try {
            By resultRow = By.xpath("//div[@class='oxd-table-body']//div[contains(text(), 'bala kumar') or contains(text(), '0303')]");
            waitForElementVisible(resultRow, 30);
            return driver.findElement(resultRow).isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

}
