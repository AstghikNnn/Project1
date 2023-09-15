import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class GitHubLogin{


    //Login GitHub
    @Test
    public void loginGitHub() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://github.com/login");
        WebElement emailElement=driver.findElement(By.id("login_field"));
        emailElement.sendKeys("AstghikNik");
        WebElement password=driver.findElement(By.id("password"));
        password.sendKeys("astastast95");
        WebElement loginElement=driver.findElement(By.name("commit"));
        loginElement.click();
        Thread.sleep(3000);
        driver.quit();
    }


    //This method is validating that user cannot log in with wrong password.
    @Test
    public void invalidpassword() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        ChromeDriver driver=new ChromeDriver();
        driver.get("https://github.com/login");
        WebElement emailElement=driver.findElement(By.id("login_field"));
        emailElement.sendKeys("AstghikNik");
        WebElement password=driver.findElement(By.id("password"));
        password.sendKeys("---95");
        WebElement loginElement=driver.findElement(By.name("commit"));
        loginElement.click();
        WebElement errorElement = driver.findElement(By.className("js-flash-alert"));
        Assert.assertEquals(errorElement.getText(), "Incorrect username or password.");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.quit();
    }


    //This method is validating that user cannot log in with empty password.
    @Test
    public void testLoginWithEmptyPassword () throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.get("https://github.com/login");
        WebElement emailElement=driver.findElement(By.id("login_field"));
        emailElement.sendKeys("nikoghosyan95@bk.ru");
        WebElement signinElement=driver.findElement(By.name("commit"));
        signinElement.click();
        WebElement errorElement = driver.findElement(By.className("js-flash-alert"));
        Assert.assertEquals(errorElement.getText(), "Incorrect username or password.");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.quit();
    }

    //Login GitHub page
    @Test
    public void loginGitHub1 () {
        System.setProperty("webdriver.gecko.driver", "src/test/resources/geckodriver.exe");
       WebDriver driver2 = new FirefoxDriver();
        driver2.get("https://github.com/login");
        WebElement emailElement = driver2.findElement(By.name("login"));
        emailElement.sendKeys("nikoghosyan95@bk.ru");
        WebElement passwordElement = driver2.findElement(By.name("password"));
        passwordElement.sendKeys("astastast95");
        WebElement loginElement = driver2.findElement(By.name("commit"));
        loginElement.click();
        driver2.quit();
    }


    //This method is validating that user cannot log in with empty password.
    @Test
    public void testLoginWithEmptyPassword1() {
        System.setProperty("webdriver.gecko.driver", "src/test/resources/geckodriver.exe");
        WebDriver driver2= new FirefoxDriver();
        driver2.get("https://github.com/login");
        WebElement emailElement = driver2.findElement(By.name("login"));
        emailElement.sendKeys("nikoghosyan95@bk.ru");
        WebElement passwordElement = driver2.findElement(By.name("password"));
        passwordElement.sendKeys("----95");
        WebElement loginElement = driver2.findElement(By.name("commit"));
        loginElement.click();
        WebElement errorElement = driver2.findElement(By.className("js-flash-alert"));
        Assert.assertEquals(errorElement.getText(), "Incorrect username or password.");
        try {Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver2.quit();
    }

    //This method is validating that user cannot log in with wrong password
    @Test
    public void invalidPasswordEntering() {
        System.setProperty("webdriver.gecko.driver", "src/test/resources/geckodriver.exe");
        WebDriver driver2= new FirefoxDriver();
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
    @Test
    public void GitHubAvatar() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://github.com/login");
        WebElement emailElement=driver.findElement(By.id("login_field"));
        emailElement.sendKeys("AstghikNik");
        WebElement password=driver.findElement(By.id("password"));
        password.sendKeys("astastast95");
        WebElement loginElement=driver.findElement(By.name("commit"));
        loginElement.click();
        WebElement driver4= driver.findElement(By.cssSelector("img[data-view-component='true']"));
        driver4.click();
        Thread.sleep(3000);
        driver.quit();

    }
}
