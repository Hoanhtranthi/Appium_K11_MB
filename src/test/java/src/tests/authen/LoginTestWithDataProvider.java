package src.tests.authen;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import src.driver.DriverFactory;
import src.driver.Platform;
import src.test_data.models.LoginCreds;
import src.test_data.utils.DataObjectBuilder;
import src.test_flows.authentication.LoginFlow;

import java.util.ArrayList;
import java.util.List;

public class LoginTestWithDataProvider {
    @Test(dataProvider = "loginCredDataSet" )
    public void testLogin(LoginCreds loginCred) {
        AppiumDriver<MobileElement> appiumDriver = DriverFactory.getDriver(Platform.ANDROID);
        try {
                String username = loginCred.getUsername();
                String password = loginCred.getPassword();

                LoginFlow loginFlow = new LoginFlow(appiumDriver, username, password);
                loginFlow.goToLoginScreen();
                loginFlow.login();
                loginFlow.veryfiLogin();


        }
        catch (Exception e){
            e.printStackTrace();
        }
        appiumDriver.quit();
    }
    @DataProvider
    private LoginCreds[] loginCredDataSet(){
        String fileLocation = "/src/test/java/src/tests/gson/login.json";
        return DataObjectBuilder.buildDataObject(fileLocation, LoginCreds[].class);

    }
}
