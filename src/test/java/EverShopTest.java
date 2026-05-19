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

    @Before
    public void setup() throws MalformedURLException {
        FirefoxOptions options = new FirefoxOptions();

        this.driver = new RemoteWebDriver(new URL("http://selenium:4444/wd/hub"), options);
        this.driver.manage().window().maximize();
    }

    @Test
    public void testLoginNavigationAndForm() {
        AccessoriesPage accessoriesPage = new AccessoriesPage(this.driver);
        LoginPage loginPage = new LoginPage(this.driver);

        String base = ConfigReader.getProperty("baseUrl");

        this.driver.get(base + "/accessories");

        String pageTitle = this.driver.getTitle();
        System.out.println("The page title is: " + pageTitle);

        String price = accessoriesPage.getPriceOfThermos();
        System.out.println("The price of the thermos is " + price);

        accessoriesPage.clickLoginIcon();

        String testEmail = ConfigReader.getProperty("email");
        String testPassword = ConfigReader.getProperty("password");

        loginPage.login(testEmail, testPassword);
    }

    @After
    public void close() {
        if (this.driver != null) {
            this.driver.quit();
        }
    }
}