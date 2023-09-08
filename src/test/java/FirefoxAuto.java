import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class FirefoxAuto {
    @Test
    public void  Firefox() throws InterruptedException {
        System.setProperty("webdriver.gecko.driver", "src/test/resources/geckodriver.exe");

        FirefoxDriver driver2= new FirefoxDriver();
        driver2.get("https://www.facebook.com/login/device-based/regular/login/?login_attempt=1&lwv=100");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver2.quit();
    }
    }

