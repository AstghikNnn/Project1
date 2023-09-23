package Pages;

import Pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class HomePage extends BasePage {
   public HomePage(WebDriver driver){
       super(driver);
   }
   public HomePage(FirefoxDriver gekodriver){
       super(gekodriver);
   }
   By avatarLocator= new By.ByCssSelector(".Button-label .avatar.circle");

    @Override
    public boolean isDisplayed(){
     boolean isAvatarDisplayed= actions.isDisplayed(avatarLocator,10);
        return isAvatarDisplayed;
    }
}
