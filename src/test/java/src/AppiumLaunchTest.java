package src;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;

public class AppiumLaunchTest {
    public static void main(String[] args) throws InterruptedException {
        AppiumDriver<MobileElement> driver = null;
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("platformName","android");
        desiredCapabilities.setCapability("automationName","uiautomator2");
        desiredCapabilities.setCapability("udid","emulator-5554");
        desiredCapabilities.setCapability("appPackage","com.wdiodemoapp");
        desiredCapabilities.setCapability("appActivity","com.wdiodemoapp.MainActivity");

        URL appiumServer = null;
        try{
            appiumServer = new URL("http://localhost:4723/wd/hub");
        }
        catch (Exception e){
            e.printStackTrace();
        }

        if(appiumServer == null)
        {
            throw new RuntimeException("[ERR] Somehow, we couldn't construct Appium server URL ");
        }
        driver = new AppiumDriver<>(appiumServer,desiredCapabilities);

        Thread.sleep(10000);
        driver.quit();
    }
}
