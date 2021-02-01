package code.automation.runners;

import com.codeborne.selenide.Configuration;
import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import static com.codeborne.selenide.Selenide.close;

@RunWith(Cucumber.class)

@CucumberOptions(
        plugin = {"pretty","html:target/cucumber-report/smoketest", "json:target/cucumber.json"},
        snippets = SnippetType.CAMELCASE,
        features = "src/test/java/code/automation/features",
        glue = {"code/automation/pageobjects/steps", "code/automation/pageobjects/Hooks"},
        tags = "@smoketest")

public class SmokeTest
{

    @BeforeClass
    static public void setupTimeout()
    {
        Configuration.timeout = 10000;
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        Configuration.browser = "chrome";
    }

    @AfterClass
    static public void teardown()
    {
        close();
    }
}
