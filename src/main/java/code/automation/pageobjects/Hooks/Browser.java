package code.automation.pageobjects.Hooks;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.close;

public class Browser {

    private WebDriver driver;

    @Before
    public Browser setUp() {
        Configuration.timeout = 10000;
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        Configuration.browser = "chrome";
        System.setProperty("selenide.browser", "Chrome");
        return Browser.this;
    }

    @Test
    public void test() {
        WebDriverRunner.setWebDriver(driver);
        Selenide.open("http://automationpractice.com/index.php");
        Assert.assertTrue(Selenide.title().equals("CodeExercise"));
    }

    @After
    public void tearDown() {
        close();
    }

    static class ExamplePage {
        @FindBy(tagName = "a")
        public SelenideElement moreInfoLink;
    }
}
