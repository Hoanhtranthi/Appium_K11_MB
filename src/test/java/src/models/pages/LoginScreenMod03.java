package src.models.pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import src.models.components.global.BottomNavComponent;
import src.models.components.login.LoginFormComponent02;
import src.models.components.login.LoginFormComponent03;

public class LoginScreenMod03 {
    private final AppiumDriver<MobileElement> appiumDriver;

    public LoginScreenMod03(AppiumDriver<MobileElement> appiumDriver) {
        this.appiumDriver = appiumDriver;
    }

    public LoginFormComponent03 loginFormComp(){
        return new LoginFormComponent03(appiumDriver);
    }

    public BottomNavComponent bottomNavComp(){
        return new BottomNavComponent(appiumDriver);
    }
}
