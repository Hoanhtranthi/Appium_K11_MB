package src.models.components.login;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;

public class LoginFormComponent03 {
    private final AppiumDriver<MobileElement> appiumDriver;
    private static final By usernameSel = MobileBy.AccessibilityId("input-email");
    private static final By passwordSel = MobileBy.AccessibilityId("input-password");
    private static final By btnLoginSel = MobileBy.AccessibilityId("button-LOGIN");

    public LoginFormComponent03(AppiumDriver<MobileElement> appiumDriver) {
        this.appiumDriver = appiumDriver;
    }

    public LoginFormComponent03 inputUsernameElem(String username){
        appiumDriver.findElement(usernameSel).sendKeys(username);
        return this;
    }
    public LoginFormComponent03 inputPasswordElem(String password){
        appiumDriver.findElement(passwordSel).sendKeys(password);
        return this;
    }
    public LoginFormComponent03 clickBtnLoginElem(){
        appiumDriver.findElement(btnLoginSel).click();
        return this;
    }
}
