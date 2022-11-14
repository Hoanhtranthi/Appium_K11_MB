package src.api_learning;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import src.driver.DriverFactory;
import src.driver.Platform;
import src.models.components.login.LoginFormComponent02;
import src.models.components.login.LoginFormComponent03;
import src.models.pages.LoginScreenMod02;
import src.models.pages.LoginScreenMod03;

public class LoginTestMod03 {
    public static void main(String[] args) {
        AppiumDriver<MobileElement> appiumDriver = DriverFactory.getDriver(Platform.ANDROID);
        try {
            LoginScreenMod03 loginScreen = new LoginScreenMod03(appiumDriver);
            loginScreen.bottomNavComp().loginIconSel().click();
            LoginFormComponent03 loginFormComp = loginScreen.loginFormComp();
            loginFormComp.inputUsernameElem("teo@sth.com")
                         .inputPasswordElem("12345678")
                         .clickBtnLoginElem();

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
