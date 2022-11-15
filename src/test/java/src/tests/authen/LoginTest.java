package src.tests.authen;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.testng.annotations.Test;
import src.driver.DriverFactory;
import src.driver.Platform;
import src.test_data.models.LoginCreds;
import src.test_flows.authentication.LoginFlow;

import java.util.ArrayList;
import java.util.List;

public class LoginTest {
    @Test
    public void testLogin() {
        AppiumDriver<MobileElement> appiumDriver = DriverFactory.getDriver(Platform.ANDROID);
        List<LoginCreds> loginCredsData = new ArrayList<>();
        loginCredsData.add(new LoginCreds("", ""));
        loginCredsData.add(new LoginCreds("teo@sth.com", "1234567"));
        loginCredsData.add(new LoginCreds("teo@", "12345678"));
        loginCredsData.add(new LoginCreds("teo@sth.com", "12345678"));

        try {
            for (LoginCreds loginCred : loginCredsData) {
                String username = loginCred.getUsername();
                String password = loginCred.getPassword();

                LoginFlow loginFlow = new LoginFlow(appiumDriver, username, password);
                loginFlow.goToLoginScreen();
                loginFlow.login();
                loginFlow.veryfiLogin();
            }

        }
        catch (Exception e){
            e.printStackTrace();
        }
        appiumDriver.quit();
    }
}
