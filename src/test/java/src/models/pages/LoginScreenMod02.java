package src.models.pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import src.models.components.global.BottomNavComponent;
import src.models.components.login.LoginFormComponent02;

public class LoginScreenMod02 {
    private final AppiumDriver<MobileElement> appiumDriver;

    public LoginScreenMod02(AppiumDriver<MobileElement> appiumDriver) {
        this.appiumDriver = appiumDriver;
    }

    public LoginFormComponent02 loginFormComp(){
        return new LoginFormComponent02(appiumDriver);
    }

    public BottomNavComponent bottomNavComp(){
        return new BottomNavComponent(appiumDriver);
    }
}