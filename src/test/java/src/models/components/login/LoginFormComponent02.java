package src.models.components.login;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;

public class LoginFormComponent02 {
    private final AppiumDriver<MobileElement> appiumDriver;
    private static final By usernameSel = MobileBy.AccessibilityId("input-email");
    private static final By passwordSel = MobileBy.AccessibilityId("input-password");
    private static final By btnLoginSel = MobileBy.AccessibilityId("button-LOGIN");

    public LoginFormComponent02(AppiumDriver<MobileElement> appiumDriver) {
        this.appiumDriver = appiumDriver;
    }

    public void inputUsernameElem(String username){
        appiumDriver.findElement(usernameSel).sendKeys(username);
    }
    public void inputPasswordElem(String password){
        appiumDriver.findElement(passwordSel).sendKeys(password);
    }
    public void clickBtnLoginElem(){
        appiumDriver.findElement(btnLoginSel).click();
    }
}
