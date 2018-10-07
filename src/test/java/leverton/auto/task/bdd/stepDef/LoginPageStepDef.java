package leverton.auto.task.bdd.stepDef;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import leverton.auto.task.page.LoginPage;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.assertj.core.api.Assertions.assertThat;

public class LoginPageStepDef {

    private LoginPage page;
    private ChromeDriver driver;


    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:/Users/habibks/IdeaProjects/chromedriver.exe");
        driver = new ChromeDriver();
        page = new LoginPage(driver);
    }

    @Given("^user on leverton login page$")
    public void user_on_leverton_login_page() {
        page.goTo();
    }

    @When("^user fills random username$")
    public void user_fills_random_username() {
        page.fillRandomUserName();
    }

    @When("^user fills random password$")
    public void user_fills_random_password() {
        page.fillRandomPassword();
    }

    @When("^user submit login form$")
    public void user_submit_login_form() {
        page.submitLoginForm();
    }

    @Then("^redirection fails$")
    public void redirection_fails() {
        assertThat(page.isRedirectionSucceed()).isFalse();
    }

    @After
    public void tearDown() {
        driver.quit();
    }

}
