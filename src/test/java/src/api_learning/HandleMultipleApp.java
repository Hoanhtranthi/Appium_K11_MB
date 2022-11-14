package src.api_learning;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import src.driver.AppPackages;
import src.driver.DriverFactory;
import src.driver.Platform;

import java.time.Duration;

public class HandleMultipleApp {
    public static void main(String[] args) {
        AppiumDriver<MobileElement> appiumDriver = DriverFactory.getDriver(Platform.ANDROID);
        try {
            //Navigate to login page
            MobileElement navloginBtnElem = appiumDriver.findElement(MobileBy.AccessibilityId("Login"));
            navloginBtnElem.click();
            // Find element
            MobileElement emailInputElem = appiumDriver.findElement(MobileBy.AccessibilityId("input-email"));
            MobileElement passwordInputElem = appiumDriver.findElement(MobileBy.AccessibilityId("input-password"));
            MobileElement loginBtnElem = appiumDriver.findElement(MobileBy.AccessibilityId("button-LOGIN"));
            //interact
            emailInputElem.sendKeys("teo@sth.com");
            passwordInputElem.sendKeys("12345678");
            //loginBtnElem.click();

            // Run app in background
            //appiumDriver.runAppInBackground(Duration.ofMillis(5000));

            // Open setting app
            appiumDriver.activateApp(AppPackages.SETTINGS);
            WebDriverWait wait = new WebDriverWait(appiumDriver, 5L);
            wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.xpath("//*[@text='Network & internet']")));

            appiumDriver.findElement(MobileBy.xpath("//*[@text='Network & internet']")).click();
            appiumDriver.findElement(MobileBy.xpath("//*[@text='Internet']")).click();

            boolean isWifiOn = appiumDriver.findElements(MobileBy.xpath("//*[@text='Add network']")).isEmpty();
            int timeToToggle = isWifiOn ? 1 : 2;

            MobileElement btnToggle = appiumDriver.findElement(MobileBy.id("android:id/switch_widget"));

            for (int clicktime = 0; clicktime < timeToToggle; clicktime++) {
                btnToggle.click();
            }



            Thread.sleep(3000);

            // Come back to the main app

            appiumDriver.activateApp(AppPackages.WEBDRIVER_IO);
        }
        catch (Exception e){
            e.printStackTrace();
        }

        appiumDriver.quit();
    }
}
