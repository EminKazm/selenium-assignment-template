import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

    private final By emailField = By.id("field-email");
    private final By passwordField = By.name("password");

    private final By signInButton = By.xpath("//button[text()='Sign In']");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void login(String email, String password) {
        waitAndReturnElement(emailField).sendKeys(email);
        waitAndReturnElement(passwordField).sendKeys(password);
        waitAndReturnElement(signInButton).click();
    }
}