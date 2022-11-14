package src.api_learning;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import src.driver.DriverFactory;
import src.driver.Platform;

import java.time.Duration;

public class SwipeHorizontal {
    public static void main(String[] args) {
        AppiumDriver<MobileElement> appiumDriver = DriverFactory.getDriver(Platform.ANDROID);
        try {
            // Navigate to Swipe screen
            MobileElement navBtnSwipe = appiumDriver.findElement(MobileBy.AccessibilityId("Swipe"));
            navBtnSwipe.click();
            // Wait Swipe screen
            WebDriverWait wait = new WebDriverWait(appiumDriver, 5L);
            wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.AndroidUIAutomator("new UiSelector().textContains(\"Swipe horizontal\")")));
            //Get window screen
            Dimension windowSize = appiumDriver.manage().window().getSize();
            // Get Height and Width
            int screenHeight = windowSize.getHeight();
            int screenWidth = windowSize.getWidth();
            // Calculate Touch point
            int xStartPoint = 90 * screenWidth / 100;
            int xEndPoint = 10 * screenWidth / 100;
            int yStartPoint = 90 * screenWidth / 100;
            int yEndPoint = 90 * screenWidth / 100;

            // Convert to coordinate
            PointOption startPoint = new PointOption<>().withCoordinates(xStartPoint, yStartPoint);
            PointOption endPoint = new PointOption<>().withCoordinates(xEndPoint, yEndPoint);

            // Get element Text of slide


            String textStopSlide = "SUPPORT VIDEOS";
            // TouchAction
            TouchAction touchAction = new TouchAction<>(appiumDriver);
            final int MAX_SWIPE_TIME = 5;
            for (int i = 0; i <=MAX_SWIPE_TIME ; i++) {

                touchAction
                        .press(startPoint)
                        .waitAction(new WaitOptions().withDuration(Duration.ofMillis(500)))
                        .moveTo(endPoint)
                        .release()
                        .perform();
            }

        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
