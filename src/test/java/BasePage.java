import org.openqa.selenium.WebDriver;

public class BasePage implements Leadable{
    protected WebDriver driver;
    protected SeleniumActions actions;
    public BasePage(WebDriver driver){
        this.driver=driver;
    }

    @Override
    public boolean isDisplayed() {
        return true;
    }
}
