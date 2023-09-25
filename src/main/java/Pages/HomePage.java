package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {
   public HomePage(WebDriver driver){
       super(driver);
   }
   By avatarLocator= new By.ByCssSelector(".Button-label .avatar.circle");

    @Override
    public boolean isDisplayed(){
     boolean isAvatarDisplayed= actions.isDisplayed(avatarLocator,10);
        return isAvatarDisplayed;
    }
}
