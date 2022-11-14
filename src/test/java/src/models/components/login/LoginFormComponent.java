package src.models.components.login;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;

public class LoginFormComponent {
    private final AppiumDriver<MobileElement> appiumDriver;
    private static final By username = MobileBy.AccessibilityId("input-email");
    private static final By password = MobileBy.AccessibilityId("input-password");
    private static final By btnLogin = MobileBy.AccessibilityId("button-LOGIN");

    public LoginFormComponent(AppiumDriver<MobileElement> appiumDriver) {
        this.appiumDriver = appiumDriver;
    }

    public MobileElement usernameElem(){
        return appiumDriver.findElement(username);
    }
    public MobileElement passwordElem(){
        return appiumDriver.findElement(password);
    }
    public MobileElement btnLoginElem(){
        return appiumDriver.findElement(btnLogin);
    }
}