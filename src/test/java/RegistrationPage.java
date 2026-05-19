import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegistrationPage extends BasePage {

    private final By nameField = By.id("field-full_name");
    private final By emailField = By.id("field-email");
    private final By passwordField = By.id("field-password");
    private final By signUpButton = By.xpath("//button[text()='Sign Up']");

    public RegistrationPage(WebDriver driver) {
        super(driver);
    }

    public void fillRegistrationForm(String name, String email, String password) {

        waitAndReturnElement(nameField).sendKeys(name);
        waitAndReturnElement(emailField).sendKeys(email);
        waitAndReturnElement(passwordField).sendKeys(password);
        waitAndReturnElement(signUpButton).click();
    }
}