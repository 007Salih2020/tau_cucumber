package Runners;

@RunWith (Cucumber.class)
@CucumberOptions (
        glue={"com.tau_cucumber.Steps"},
        feature ="src/test/resources",
        plugin ={"pretty", "html:target/site/cucumber-pretty",
                "json:target/cucumber.json"})

public class RunCucumberTests {

}
