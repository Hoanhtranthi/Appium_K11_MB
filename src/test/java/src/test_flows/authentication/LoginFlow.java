package src.test_flows.authentication;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.apache.commons.validator.routines.EmailValidator;
import org.testng.Assert;
import src.models.components.login.LoginFormComponent03;
import src.models.pages.LoginScreenMod03;
import src.test_flows.BaseFlow;
import sun.security.util.Password;

public class LoginFlow extends BaseFlow{
    private final String username;
    private final String password;

    public LoginFlow(AppiumDriver<MobileElement> appiumDriver, String username, String password) {
        super(appiumDriver);
        this.username = username;
        this.password = password;
    }

    public void login(){
        LoginScreenMod03 loginScreen = new LoginScreenMod03(appiumDriver);
        LoginFormComponent03 loginFormComp = loginScreen.loginFormComp();
        if (!username.isEmpty()) loginFormComp.inputUsernameElem(username);
        if (!password.isEmpty()) loginFormComp.inputPasswordElem(password);
        loginFormComp.clickBtnLoginElem();


    }
    public void veryfiLogin(){
        boolean isEmailValid = isEmailValid();
        boolean isPasswordValid = isPasswordValid();

        LoginFormComponent03 loginFormComp = new LoginScreenMod03(appiumDriver).loginFormComp();

        if(isEmailValid && isPasswordValid){
            verifyCorrectLoginCreds(loginFormComp);
        }
        if(!isEmailValid){
            verifyInCorrectEmailLogin(loginFormComp);
        }
        if(!isPasswordValid){
            verifyInCorrectPasswordLogin(loginFormComp);
        }


    }

    private boolean isEmailValid() {
        return EmailValidator.getInstance().isValid(username);
    }
    private boolean isPasswordValid() {
        return password.length() >=8;
    }
    private void verifyInCorrectEmailLogin(LoginFormComponent03 loginFormComp) {

        String actualInvalidEmailTxt = loginFormComp.invalidEmailTxt();
        String expectedInvalidEmailTxt = "Please enter a valid email address";

        Assert.assertEquals(actualInvalidEmailTxt,expectedInvalidEmailTxt, "[ERR] Actual Invalid Email Text is not correct!");
    }

    private void verifyInCorrectPasswordLogin(LoginFormComponent03 loginFormComp) {
        String actualInvalidPasswordTxt = loginFormComp.invalidPasswordTxt();
        String expectedInvalidPasswordTxt = "Please enter at least 8 characters";

        Assert.assertEquals(actualInvalidPasswordTxt,expectedInvalidPasswordTxt, "[ERR] Actual Invalid Password Text is not correct!");
    }
    private void verifyCorrectLoginCreds(LoginFormComponent03 loginFormComp) {
        String actualAlertLoginSuccessTxt = loginFormComp.alertLoginSuccessTxtSel();
        String expectedAlertLoginSuccess = "Success";

        Assert.assertEquals(actualAlertLoginSuccessTxt,expectedAlertLoginSuccess, "[ERR] Login unsuccessful!");
    }
}
