import net.bytebuddy.description.annotation.AnnotationDescription;
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

public class GitHubLogin {


    //Login GitHub

    //Steps:
    //1. Open https://github.com/login page
    //2. Input valid email
    //3. Click on 'Sign In' button
    // 4. Validate user is  logged in.
    @Test
    public void loginGitHub() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://github.com/login");
        HomePage HomePage=new HomePage(driver);
        HomePage.driver("astghik.nikoghosyan.95@inbox.ru","");
        WebElement emailElement = driver.findElement(By.name("login"));
        emailElement.sendKeys("astghik.nikoghosyan.95@inbox.ru");
        WebElement passwordElement = driver.findElement(By.name("password"));
        passwordElement.sendKeys("----95");
        WebElement loginElement = driver.findElement(By.name("commit"));
        loginElement.click();
        driver.quit();
    }


    //This method is validating that user cannot log in with wrong password.

    //Steps:
    //1. Open https://github.com/login page
    //2. Input valid email
    //3. Click on 'Sign In' button
    // 4. Validate user is not logged in and "Password is wrong" error is displayed
    @Test
    public void invalidpassword() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://github.com/login");
        WebElement emailElement = driver.findElement(By.id("login_field"));
        emailElement.sendKeys("AstghikNik");
        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("---95");
        WebElement loginElement = driver.findElement(By.name("commit"));
        loginElement.click();
        WebElement errorElement = driver.findElement(By.className("js-flash-alert"));
        Assert.assertEquals(errorElement.getText(), "Incorrect username or password.");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.quit();
    }


    //This method is validating that user cannot log in with empty password.

    //Steps:
    //1. Open https://github.com/login page
    //2. Input valid email
    //3. Click on 'Sign In' button
    // 4. Validate user is not logged in and "Password field is empty" error is displayed
    @Test
    public void testLoginWithEmptyPassword() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://github.com/login");
        WebElement emailElement = driver.findElement(By.id("login_field"));
        emailElement.sendKeys("astghik.nikoghosyan.95@inbox.ru");
        WebElement signInElement = driver.findElement(By.name("commit"));
        signInElement.click();
        WebElement errorElement = driver.findElement(By.className("js-flash-alert"));
        Assert.assertEquals(errorElement.getText(), "Incorrect username or password.");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.quit();
    }

    //Login GitHub page

    //Steps:
    //1. Open https://github.com/login page
    //2. Input valid email
    //3. Click on 'Sign In' button
    // 4. Validate user is  logged in.
    @Test
    public void loginGitHub1() {
        System.setProperty("webdriver.gecko.driver", "src/test/resources/geckodriver.exe");
        FirefoxDriver firefox=new FirefoxDriver();
        SeleniumActions actions=new SeleniumActions(firefox);
        firefox.get("https://github.com/login");
        LoginPage loginPage = new LoginPage(firefox);
        Assert.assertTrue(loginPage.isDisplayed());
        loginPage.login("astghik.nikoghosyan.95@inbox.ru", "AstAstAst95");
        boolean variable = actions.isDisplayed(By.className("js-flash-alert"), 10);
        Assert.assertTrue(variable);
        HomePage HomePage=new HomePage(firefox);
        Assert.assertTrue(HomePage.isDisplayed());
        firefox.quit();
    }

    //This method is validating that user cannot log in with empty password.

    //Steps:
    //1. Open https://github.com/login page
    //2. Input valid email
    //3. Click on 'Sign In' button
    // 4. Validate user is not logged in and "Password is empty" error is displayed
    @Test
    public void testLoginWithEmptyPassword1() {
        System.setProperty("webdriver.gecko.driver", "src/test/resources/geckodriver.exe");
        WebDriver driver2 = new FirefoxDriver();
        driver2.get("https://github.com/login");
        HomePage HomePage=new HomePage(driver2);
        HomePage.driver("astghik.nikoghosyan.95@inbox.ru","");
        WebElement emailElement = driver2.findElement(By.name("login"));
        emailElement.sendKeys("astghik.nikoghosyan.95@inbox.ru");
        WebElement passwordElement = driver2.findElement(By.name("password"));
        passwordElement.sendKeys("----95");
        WebElement loginElement = driver2.findElement(By.name("commit"));
        loginElement.click();
        WebElement errorElement = driver2.findElement(By.className("js-flash-alert"));
        Assert.assertEquals(errorElement.getText(), "Incorrect username or password.");
        driver2.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver2.quit();
    }

    //This method is validating that user cannot log in with empty password.

    //Steps:
    //1. Open https://github.com/login page
    //2. Input valid email
    //3. Click on 'Sign In' button
    // 4. Validate user is not logged in and "Password field is empty" error is displayed

    @Test
    public void firefoxTestLoginEmptyPass(){
        //Tests the gitHub login with correct input in email and empty password fields in firefox browser
        System.setProperty("webdriver.gecko.driver", "src/test/resources/geckodriver.exe");
        FirefoxDriver firefox=new FirefoxDriver();
        SeleniumActions actions=new SeleniumActions(firefox);
        //Open https://github.com/login page
        firefox.get("https://github.com/login");
        LoginPage loginPage = new LoginPage(firefox);
        Assert.assertTrue(loginPage.isDisplayed());
        loginPage.login("astghik.nikoghosyan.95@inbox.ru", "");
        boolean variable = actions.isDisplayed(By.className("js-flash-alert"), 10);
        Assert.assertTrue(variable);
        WebElement errorMessageElement = firefox.findElement(By.className("js-flash-alert"));
        Assert.assertEquals(errorMessageElement.getText(), "Incorrect username or password.");
        firefox.quit();
    }
    //This method is validating that user cannot log in with wrong password

    //Steps:
    //1. Open https://github.com/login page
    //2. Input valid email
    //3. Click on 'Sign In' button
    // 4. Validate user is not logged in and "Password is wrong" error is displayed
    @Test
    public void invalidPasswordEntering() {
        System.setProperty("webdriver.gecko.driver", "src/test/resources/geckodriver.exe");
        WebDriver driver2 = new FirefoxDriver();
        driver2.get("https://github.com/login");
        WebElement emailElement = driver2.findElement(By.name("login"));
        emailElement.sendKeys("astghik.nikoghosyan.95@inbox.ru");
        WebElement passwordElement = driver2.findElement(By.name("password"));
        passwordElement.sendKeys("");
        WebElement loginElement = driver2.findElement(By.name("commit"));
        loginElement.click();
        WebElement errorElement = driver2.findElement(By.className("js-flash-alert"));
        Assert.assertEquals(errorElement.getText(), "Incorrect username or password.");
        driver2.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver2.quit();
    }

    @Test
    public void GitHubAvatar() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://github.com/login");
        WebElement emailElement = driver.findElement(By.id("login_field"));
        emailElement.sendKeys("astghik.nikoghosyan.95@inbox.ru");
        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("AstAstAst95");
        WebElement loginElement = driver.findElement(By.name("commit"));
        loginElement.click();
        By locatorOfAvatarElement = By.cssSelector("img[data-view-component='true']");
        SeleniumActions actions = new SeleniumActions(driver);
        boolean isLocatorOfAvatarElementDisplayed = actions.isDisplayed(locatorOfAvatarElement, 5);
        Assert.assertTrue(isLocatorOfAvatarElementDisplayed);
        driver.quit();
        //WebElement avatarElement = driver.findElement(By.cssSelector("img[data-view-component='true']"));
        //avatarElement.click();
        //Thread.sleep(3000);
        //driver.quit();

    }

    @Test
    public void loginGitHub2() {
        System.setProperty("webdriver.gecko.driver", "src/test/resources/geckodriver.exe");
        FirefoxDriver driver2 = new FirefoxDriver();
        driver2.get("https://github.com/login");
        WebElement emailElement = driver2.findElement(By.name("login"));
        emailElement.sendKeys("astghik.nikoghosyan.95@inbox.ru");
        WebElement passwordElement = driver2.findElement(By.name("password"));
        passwordElement.sendKeys("AstAstAst95");
        WebElement loginElement = driver2.findElement(By.name("commit"));
        loginElement.click();
        By locatorOfAvatarElement = By.cssSelector(".Button-label .avatar.circle");
        SeleniumActions actions = new SeleniumActions(driver2);
        boolean isLocatorOfAvatarElementDisplayed = actions.isDisplayed(locatorOfAvatarElement, 5);
        Assert.assertTrue(isLocatorOfAvatarElementDisplayed);
        driver2.quit();
    }
}
