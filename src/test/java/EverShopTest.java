import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import java.net.MalformedURLException;
import java.net.URL;

public class EverShopTest {
    private WebDriver driver;
    private String baseUrl;

    @Before
    public void setup() throws MalformedURLException {
        FirefoxOptions options = new FirefoxOptions();

        String gridUrl = ConfigReader.getProperty("gridUrl");
        this.driver = new RemoteWebDriver(new URL(gridUrl), options);
        this.driver.manage().window().maximize();

        this.baseUrl = ConfigReader.getProperty("baseUrl");
    }

    @Test
    public void testLoginNavigationAndForm() {
        AccessoriesPage accessoriesPage = new AccessoriesPage(this.driver);
        LoginPage loginPage = new LoginPage(this.driver);

        this.driver.get(this.baseUrl + "/accessories");

        String pageTitle = this.driver.getTitle();
        System.out.println("The page title is: " + pageTitle);

        String price = accessoriesPage.getPriceOfThermos();
        System.out.println("The price of the thermos is " + price);

        accessoriesPage.clickLoginIcon();

        String testEmail = ConfigReader.getProperty("email");
        String testPassword = ConfigReader.getProperty("password");

        loginPage.login(testEmail, testPassword);
    }
    @Test
    public void testRegistrationWithRandomData() {
        RegistrationPage registrationPage = new RegistrationPage(this.driver);

        this.driver.get(this.baseUrl + "/account/register");

        String randomEmail = "user" + System.currentTimeMillis() + "@test.com";

        registrationPage.fillRegistrationForm("Test User", randomEmail, "SecurePass123!");
    }
    @After
    public void close() {
        if (this.driver != null) {
            this.driver.quit();
        }
    }
}