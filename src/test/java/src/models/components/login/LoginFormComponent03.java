package src.models.components.login;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;

public class LoginFormComponent03 {
    private final AppiumDriver<MobileElement> appiumDriver;
    private static final By usernameSel = MobileBy.AccessibilityId("input-email");
    private static final By iscorrectUsernameTxtSel = MobileBy.xpath("//*[contains(@text,'Please enter a valid email address')]");
    private static final By passwordSel = MobileBy.AccessibilityId("input-password");
    private static final By iscorrectPasswordTxtSel = MobileBy.xpath("//*[contains(@text,'Please enter at least 8 characters')]");
    private static final By btnLoginSel = MobileBy.AccessibilityId("button-LOGIN");

    private static final By alertLoginSuccessTxtSel = MobileBy.id("android:id/alertTitle");

    public LoginFormComponent03(AppiumDriver<MobileElement> appiumDriver) {
        this.appiumDriver = appiumDriver;
    }

    public LoginFormComponent03 inputUsernameElem(String username){
        MobileElement usernameElem = appiumDriver.findElement(usernameSel);
        usernameElem.clear();
        usernameElem.sendKeys(username);

        return this;
    }

    public String invalidEmailTxt(){
        return appiumDriver.findElement(iscorrectUsernameTxtSel).getText();
    }

    public String invalidPasswordTxt(){
        return appiumDriver.findElement(iscorrectPasswordTxtSel).getText();
    }

    public String alertLoginSuccessTxtSel(){
        return appiumDriver.findElement(alertLoginSuccessTxtSel).getText();
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
