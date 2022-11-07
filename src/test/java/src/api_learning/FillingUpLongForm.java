package src.api_learning;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import src.driver.DriverFactory;
import src.driver.Platform;

import java.util.List;

public class FillingUpLongForm {
    public static void main(String[] args) {
        AppiumDriver<MobileElement> appiumDriver = DriverFactory.getDriver(Platform.ANDROID);
        try {
            // Navitage to Forms
            MobileElement navBtnForm = appiumDriver.findElement(MobileBy.xpath("//android.widget.Button[@content-desc=\"Forms\"]"));
            navBtnForm.click();

            // Waiting Form appear
            WebDriverWait wait = new WebDriverWait(appiumDriver, 10L);
            wait.until(ExpectedConditions.
                    visibilityOfElementLocated(MobileBy.AndroidUIAutomator("new UiSelector().textContains(\"Form components\")")));

            // Find elements
            MobileElement inputFieldText = appiumDriver.findElement(MobileBy.AccessibilityId("text-input"));
            MobileElement inputTextResultYouHaveTyped = appiumDriver.findElement(MobileBy.AccessibilityId("input-text-result"));
            MobileElement btnSwitch = appiumDriver.findElement(MobileBy.AccessibilityId("switch"));
            MobileElement dropdown = appiumDriver.findElement(MobileBy.xpath("//android.view.ViewGroup[@content-desc=\"Dropdown\"]"));

            // Filling up all and interact

            inputFieldText.sendKeys("ABC");
            btnSwitch.click();
            dropdown.click();

            // Find list element Dropdown
            List<MobileElement> dropdownListelem = appiumDriver.findElements(MobileBy.xpath("//android.widget.CheckedTextView"));
            final int SEARCH_ITEM = 0;
            final int OPTION_1 = 1;
            final int OPTION_2 = 2;
            final int OPTION_3 = 3;
            dropdownListelem.get(OPTION_1).click();

            // Check disable button Inactive
            //MobileElement btnInactiveElem = appiumDriver.findElement(MobileBy.xpath("//android.view.ViewGroup[@content-desc=\"button-Inactive\"]"));

            // Choose button Active
            MobileElement btnActiveElem = appiumDriver.findElement(MobileBy.xpath("//android.view.ViewGroup[@content-desc=\"button-Active\"]"));
            btnActiveElem.click();
            // Print Dialog Active

            wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.id("android:id/message")));

            MobileElement messageDialogElem = appiumDriver.findElement(MobileBy.id("android:id/message"));
            System.out.println("Message of Dialog Active is " + messageDialogElem.getText());

            // Close Dialog
            List<MobileElement> listBtnDialogActive = appiumDriver.findElements(MobileBy.xpath("//android.widget.Button"));
            final int ASK_ME_LATER = 0;
            final int CANCEL = 1;
            final int OK = 2;

            listBtnDialogActive.get(OK).click();

            // Check disable button Inactive
            MobileElement btnInactiveElem = appiumDriver.findElement(MobileBy.xpath("//android.view.ViewGroup[@content-desc=\"button-Inactive\"]"));

            System.out.println(btnInactiveElem.getAttribute("clickable"));





        }
        catch ( Exception e ){
            e.printStackTrace();
        }
    }
}
