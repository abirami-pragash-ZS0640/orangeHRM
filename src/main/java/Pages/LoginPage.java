package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.ElementUtils;

import java.time.Duration;

public class LoginPage extends ElementUtils {
    private final WebDriver driver;

    @FindBy(name="username")
    private WebElement usernameTextBox;

    // Locators
    private final By usernameField = By.name("username");
    private final By passwordField = By.name("password");
    private final By loginButton   = By.cssSelector("button[type='submit']");

    public LoginPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }
    public void enterUserName(String username)
    {
        waitForElementVisible(usernameField,30);
        WebElement usernameTextBox = driver.findElement(usernameField);
        setText(usernameField,username);
    }
    public void enterPassword(String password)
    {
        waitForElementVisible(passwordField,30);
        driver.findElement(passwordField);
        setText(passwordField,password);
    }

    public void clickLoginButton()
    {
        clickElement(loginButton);
    }

    public String getLoginErrorMessage() {
        By errorLocator = By.xpath("//p[contains(@class, 'oxd-alert-content-text')]");
        new WebDriverWait(driver, Duration.ofSeconds(60))
                .until(ExpectedConditions.visibilityOfElementLocated(errorLocator));
        return driver.findElement(errorLocator).getText();
    }

    public void loginAsAdmin(String username, String password) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("username")));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("password")));
        setText(usernameField,username);
        setText(passwordField,password);
        clickLoginButton();
    }
}
