package leverton.auto.task.page;

import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

import static leverton.auto.task.TestProperties.getLoginPageUrl;
import static leverton.auto.task.utils.StringUtils.randomString;
import static org.openqa.selenium.By.*;
import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;

public class LoginPage {

    private static final String LOGIN_FORM_ID = "loginForm";
    private static final String USERNAME_ID = "username";
    private static final String PASSWORD_ID = "password-field";
    private static final String SUBMIT_BTN_XPATH = "//input[@type='submit']";
    private final WebDriver driver;

    public LoginPage(WebDriver webDriver) {
        this.driver = webDriver;
    }

    public void goTo() {
        driver.get(getLoginPageUrl());
    }

    public void fillRandomUserName(){
        driver.findElement(id(USERNAME_ID)).sendKeys(randomString(8));
    }

    public void fillRandomPassword(){
        driver.findElement(id(PASSWORD_ID)).sendKeys(randomString(8));
    }

    public void submitLoginForm() {
        driver.findElement(id(LOGIN_FORM_ID)).findElement(xpath(SUBMIT_BTN_XPATH)).submit();
    }

    public boolean isRedirectionSucceed() {
        return !driver.getCurrentUrl().contains(getLoginPageUrl());
    }
}
