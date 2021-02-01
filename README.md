# Introduction 

Automation Testing project for Code Exercise, covering UI acceptance in the site http://automationpractice.com/index.php.
Created with Selenide that is basically a wrapper for Selenium WebDriver
applications developed in PHP in the UI side.

# Getting Started

1.	Installation process
	* Install [Java JDK 8.0](https://www.oracle.com/java/technologies/javase-jdk8-downloads.html)
	* Install [IntelliJ Community Edition](https://www.jetbrains.com/idea/download/other.html)

	Clone Automation Repository locally:
  - At the moment just a POC was created.

### Configuration
## How to configure the executions
	Use properties same as the sample: login.properties to reuse and avoid hardcoded.

### Default config

Default configuration for Runner is done in a config file located in [SmokeTest.java](./SmokeTest.java) located in the (\src\test\java\code\automation\runners\).

### Modify Default Configuration

If you want to execute the tets on different browser(System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");) or different tags(  tags = "@smoketest"), there you are able to modify below information:
```
...
{{
@RunWith(Cucumber.class)

@CucumberOptions(
        plugin = {"pretty","html:target/cucumber-report/smoketest", "json:target/cucumber.json"},
        snippets = SnippetType.CAMELCASE,
        features = "src/test/java/code/automation/features",
        glue = "code/automation/steps",
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
}

}
...
```  


# Build and Test
###Command Line
To build the project execute:
Go to folder that contains the project that you downloaded from repository i.e: ```C:\CodeExercise ```
- mvn clean install
Note: Maven should be installed in your local environment

To run all feature test execute the following command:
- mvn test
###IntelliJ IDE
* From IntelliJ Go to the project from Solution Explorer and  Press ```Righ Click on Feature(by example: Index.feature) file and select Run 'Feature' option``` Key

## Running The tests

From IntelliJ  go to ```Project``` select 'runners' folder and  right click and execute the tests i.e.: ```SmokeTest```.

## Reports
Executing: Drive> mvn clean install	the report will be generated in the following directory of the project ../target/CodeExercise REPORTS and feature-overview.html report was generated.

# Contribute

### Codding Standards

Please refer to [Selenide](https://selenide.org/documentation.html)