package leverton.auto.task.bdd;

import cucumber.api.CucumberOptions;
import cucumber.api.java.Before;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/resources/feature/login.feature" },
        glue = { "leverton.auto.task.bdd.stepDef" },
        tags = { "@ToRun" })
public class RunCukesTest {
}