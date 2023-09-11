import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MyFirstTest {

    @Test
    public void MySecondTestcase(){
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        ChromeDriver driver1=new ChromeDriver();
        driver1.get("https://www.google.com/");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver1.quit();
    }
    @Test
    public void loginGitHub() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        ChromeDriver driver=new ChromeDriver();
        driver.get("https://github.com/login");
        Thread.sleep(2000);
        WebElement emailElement=driver.findElement(By.id("login_field"));
        emailElement.sendKeys("AstghikNik");
       WebElement password=driver.findElement(By.id("password"));
       password.sendKeys("astastast95");
       WebElement loginElement=driver.findElement(By.name("commit"));
        loginElement.click();
        driver.quit();
    }
    @Test
    public void invalidpassword() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        ChromeDriver driver=new ChromeDriver();
        driver.get("https://github.com/login");
        Thread.sleep(2000);
        WebElement emailElement=driver.findElement(By.id("login_field"));
        emailElement.sendKeys("AstghikNik");
        WebElement password=driver.findElement(By.id("password"));
        password.sendKeys("---95");
        WebElement loginElement=driver.findElement(By.name("commit"));
        WebElement errorElement = driver.findElement(By.className("js-flash-alert"));
        Assert.assertEquals(errorElement.getText(), "Incorrect username or password.");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        loginElement.click();
        driver.quit();
    }
    @Test
    public void emptypassword() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        ChromeDriver driver=new ChromeDriver();
        driver.get("https://github.com/login");
        WebElement emailElement=driver.findElement(By.id("login_field"));
        emailElement.sendKeys("nikoghosyan95@bk.ru");
        WebElement password=driver.findElement(By.id("password"));
        password.sendKeys("");
        WebElement signinElement=driver.findElement(By.name("commit"));
        signinElement.click();
        WebElement errorElement = driver.findElement(By.className("js-flash-alert"));
        Assert.assertEquals(errorElement.getText(), "Incorrect username or password.");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        signinElement.click();
        driver.quit();
    }
}

