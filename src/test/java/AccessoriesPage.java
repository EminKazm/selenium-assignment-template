import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AccessoriesPage extends BasePage {

    private final By loginIconLocator = By.cssSelector("a[href*='login']");
    public AccessoriesPage(WebDriver driver) {
        super(driver);
    }

    public void clickLoginIcon() {
        WebElement loginIcon = waitAndReturnElement(loginIconLocator);
        loginIcon.click();
    }
    public String getPriceOfThermos() {
        By thermosPriceLocator = By.xpath("//*[contains(text(), 'Stainless Steel Thermos - Yellow')]/following::span[contains(@class, 'regular-price')][1]");

        WebElement priceElement = waitAndReturnElement(thermosPriceLocator);
        return priceElement.getText();
    }
}