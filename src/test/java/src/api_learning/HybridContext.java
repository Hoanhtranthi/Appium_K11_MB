package src.api_learning;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import src.context.Contexts;
import src.context.WaitMoreThanOneContext;
import src.driver.DriverFactory;
import src.driver.Platform;

import java.util.ArrayList;
import java.util.List;

public class HybridContext {
    public static void main(String[] args) {
        AppiumDriver<MobileElement> appiumDriver = DriverFactory.getDriver(Platform.ANDROID);
        try {
            // Navigate to Web view
            MobileElement navWebview = appiumDriver.findElement(MobileBy.AccessibilityId("Webview"));
            navWebview.click();

            // Implicitwait
            WebDriverWait wait = new WebDriverWait(appiumDriver, 5L);
            wait.until(new WaitMoreThanOneContext(appiumDriver));


            // Get all context
            for (String contextHandle : appiumDriver.getContextHandles()) {
                System.out.println("Context " + contextHandle);
            }

            // Switch to Web view

            appiumDriver.context(Contexts.WEB_VIEW);

            WebElement navToggleBtnElem = appiumDriver.findElementByCssSelector(".navbar__toggle");
            navToggleBtnElem.click();

            List<MobileElement> menuItemElems = appiumDriver.findElementsByCssSelector(".menu__list li a");
            if (menuItemElems.isEmpty()){
                throw new RuntimeException("[ERROR] Menu item notfound");
            }
            List<MenuData> menuItemDataList = new ArrayList<>();


            for (MobileElement menuItemElem : menuItemElems) {
                String itemText = menuItemElem.getText();
                String itemHref = menuItemElem.getAttribute("href");
                if(itemText.isEmpty()){
                    menuItemDataList.add(new MenuData("Github",itemHref));
                }
                else {
                    menuItemDataList.add(new MenuData(itemText,itemHref));
                }

            }
            System.out.println(menuItemDataList);
            // Switch to Native app
            appiumDriver.context(Contexts.NATIVE);

            appiumDriver.findElement(MobileBy.AccessibilityId("Home")).click();

            Thread.sleep(3000);

        } catch (Exception e) {
            e.printStackTrace();
        }
        appiumDriver.quit();
    }
    public static class MenuData {
        private final String name;
        private final String href;

        public MenuData(String name, String href) {
            this.name = name;
            this.href = href;
        }

        public String getName() {
            return name;
        }

        public String getHref() {
            return href;
        }

        @Override
        public String toString() {
            return "MenuData{" +
                    "name='" + name + '\'' +
                    ", href='" + href + '\'' +
                    '}';
        }
    }

}
