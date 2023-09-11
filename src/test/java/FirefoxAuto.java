
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
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
    @Test
    public void loginGitHub() {
        System.setProperty("webdriver.gecko.driver", "src/test/resources/geckodriver.exe");
        FirefoxDriver driver2 = new FirefoxDriver();
        driver2.get("https://github.com/login");
        WebElement emailElement = driver2.findElement(By.name("login"));
        emailElement.sendKeys("nikoghosyan95@bk.ru");
        WebElement passwordElement = driver2.findElement(By.name("password"));
        passwordElement.sendKeys("astastast95");
        WebElement loginElement = driver2.findElement(By.name("commit"));
        loginElement.click();
        driver2.quit();
    }

    @Test
    public void emptyPassword() {
        System.setProperty("webdriver.gecko.driver", "src/test/resources/geckodriver.exe");
        FirefoxDriver driver2= new FirefoxDriver();
        driver2.get("https://github.com/login");
        WebElement emailElement = driver2.findElement(By.name("login"));
        emailElement.sendKeys("nikoghosyan95@bk.ru");
        WebElement passwordElement = driver2.findElement(By.name("password"));
        passwordElement.sendKeys("----95");
        WebElement loginElement = driver2.findElement(By.name("commit"));
        loginElement.click();
        WebElement errorElement = driver2.findElement(By.className("js-flash-alert"));
        Assert.assertEquals(errorElement.getText(), "Incorrect username or password.");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver2.quit();
    }
    @Test
    public void invalidPasswordEntering() {
        System.setProperty("webdriver.gecko.driver", "src/test/resources/geckodriver.exe");
        FirefoxDriver driver2= new FirefoxDriver();
        driver2.get("https://github.com/login");
        WebElement emailElement = driver2.findElement(By.name("login"));
        emailElement.sendKeys("nikoghosyan95@bk.ru");
        WebElement passwordElement = driver2.findElement(By.name("password"));
        passwordElement.sendKeys("");
        WebElement loginElement = driver2.findElement(By.name("commit"));
        loginElement.click();
        WebElement errorElement = driver2.findElement(By.className("js-flash-alert"));
        Assert.assertEquals(errorElement.getText(), "Incorrect username or password.");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver2.quit();
    }
    }

