import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage extends BasePage {
    By emailFieldLocator = By.name("login");
    By passwordFieldLocator = By.name("password");
    By loginButtonLocator = By.name("commit");

    public HomePage(WebDriver driver) {
        super(driver);
    }

        public void login1 (String email, String password) {
        WebElement emailElement = driver.findElement(emailFieldLocator);
        emailElement.sendKeys(email);
        WebElement passwordElement = driver.findElement(passwordFieldLocator);
        passwordElement.sendKeys(password);
        WebElement button = driver.findElement(loginButtonLocator);
        button.click();
    }

    @Override
    public boolean isDisplayed(){

        return false;
    }

    public void driver(String mail, String pass) {
    }
}
