package src.api_learning;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import org.aspectj.util.FileUtil;
import org.openqa.selenium.OutputType;
import src.driver.DriverFactory;
import src.driver.Platform;

import java.io.File;

public class TakingScreenShot {
    public static void main(String[] args) {
        AppiumDriver<MobileElement> appiumDriver = DriverFactory.getDriver(Platform.ANDROID);
        try {
            //Navigate to login page
            MobileElement navloginBtnElem = appiumDriver.findElement(MobileBy.AccessibilityId("Login"));
            navloginBtnElem.click();

            // Whole file
            File base64ScreenShotData = appiumDriver.getScreenshotAs(OutputType.FILE);
            String fileLocation = System.getProperty("user.dir").concat("/screenshots/").concat("/Loginscreen.png");
            FileUtil.copyFile(base64ScreenShotData, new File(fileLocation));
            // An area
            MobileElement loginFormElem = appiumDriver.findElement(MobileBy.AccessibilityId("Login-screen"));
            File base64LoginFormData = loginFormElem.getScreenshotAs(OutputType.FILE);
            String loginFormFileLocation = System.getProperty("user.dir").concat("/screenshots/").concat("/LoginFormscreen.png");
            FileUtil.copyFile(base64LoginFormData, new File(loginFormFileLocation));

            // An element
            MobileElement loginBtnElem = appiumDriver.findElement(MobileBy.AccessibilityId("button-LOGIN"));
            File base64LoginBtnData = loginBtnElem.getScreenshotAs(OutputType.FILE);
            String loginBtnFileLocation = System.getProperty("user.dir").concat("/screenshots/").concat("/LoginBtncreen.png");
            FileUtil.copyFile(base64LoginBtnData, new File(loginBtnFileLocation));

        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
