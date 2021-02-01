package code.automation.pageobjects.steps;

import code.automation.pageobjects.Common.GetProperties;
import code.automation.pageobjects.IndexPage;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import static code.automation.pageobjects.utility.Constants.Timeout;
import static com.codeborne.selenide.Selenide.*;
import static org.hamcrest.MatcherAssert.assertThat;

public class IndexSteps
{
    /*Initialize the Pages*/
    IndexPage indexPage = page(IndexPage.class);

    /*Initialize the Logger*/
    Logger log = Logger.getLogger(Selenide.class.getName());


    @Given("^I open AutomationPractice website$")
    public void openAutomationWebApp()
    {
        //Get Url App properties
        GetProperties properties = new GetProperties();

        //Loading the URL application
        open(properties.getProperty("login.properties", "automationApp.url"));

        //Logger the actions
        log.log(Level.INFO,"Open the Web Site:  " + properties.getProperty("login.properties", "automationApp.url"));
    }

    @When("^I click on \"([^\"]*)\" link$")
    public void clickOnLink(String link)
    {
        //Switch case has an issue reported here: https://www.programmersought.com/article/71624700632/
        //For this reason was use the if selection case to extend more cases and re use this method
        if (link.contains(link))
        {
            indexPage.get(link).waitUntil(Condition.appears, Timeout);
            indexPage.get(link).click();
            log.log(Level.INFO,"Click on:  " + link);
        }
    }

    @When("^I hover \"([^\"]*)\" and click on \"([^\"]*)\" button$")
    public void hoverAndClickOnAddCart(String dress, String button)
    {
        //Using the parameter values to interact with the method
        indexPage.hoverOverDress(dress).hover();
        indexPage.clickOnAddCartButton(button, dress).click();
        log.log(Level.INFO,"Hover on:" + dress +" and click on:  " + button);
    }

    @When("^I click on \"([^\"]*)\" button$")
    public void clickOnContinueShopping(String button)
    {
        indexPage.clickOnContinueButton(button).waitUntil(Condition.appears, Timeout);
        indexPage.clickOnContinueButton(button).click();
        log.log(Level.INFO,"Click on:  " + button);
    }

    @When("^I go to the \"([^\"]*)\" dropdown and select \"([^\"]*)\"$")
    public void goToTheCartDropDownAndSelectCheckout(String cart, String button)
    {

        //Switch case has an issue reported here: https://www.programmersought.com/article/71624700632/
        //For this reason was use the if selection case to extend more cases and re use this method
        if (cart.contains("View my shopping cart"))
        {
            indexPage.hoverDropdownAndClickOnButton(cart, button).waitUntil(Condition.appears, Timeout);
            indexPage.hoverDropdownAndClickOnButton(cart, button).click();
            log.log(Level.INFO,"Hover on:" + cart +" and click on:  " + button);
        }
    }

    @When("^I remove \"([^\"]*)\" from the list$")
    public void removeItemFromTheList(String dress)
    {
        //Switch case has an issue reported here: https://www.programmersought.com/article/71624700632/
        //For this reason was use the if selection case, to extend more cases and re use this method
        if (dress.contains("Blouse"))
        {
            indexPage.removeDressFromTheList(dress).hover().click();
            log.log(Level.INFO,"Remove :  " + dress);
        }
        Selenide.refresh();
    }


    /*Verification Section*/

    @When("^I verify \"([^\"]*)\" is no longer displayed in the table$")
    public void verifyThatDressIsNotLongerDisplayedInTheTable(String dress)
    {

        //Switch case has an issue reported here: https://www.programmersought.com/article/71624700632/
        //For this reason was use the if selection case to extend more cases and re use this method
        if (dress.contains("Blouse"))
        {
            Selenide.refresh();
            indexPage.SummaryTable.waitUntil(Condition.appears, Timeout);
            WebElement table = indexPage.SummaryTable;
            indexPage.SummaryTable.waitUntil(Condition.appears, Timeout);
            Boolean removedDress = table.getText().contains(dress);
            Assert.assertTrue("Two items were found: " + dress , removedDress.equals(false));
            indexPage.SummaryTable.waitUntil(Condition.appears, Timeout);
            Selenide.refresh();
            log.log(Level.INFO,"Verify that  :  " + dress + "Is not displayed");
        }
    }

    @When("^I verify the total amount to pay is \"([^\"]*)\"$")
    public void verifyThatTheTotalAmountToPay(String price)
    {
        Assert.assertTrue("Total mount to pay it's displayed correctly" , indexPage.TotalPriceText.getText().equals(price));
        log.log(Level.INFO,"Verify that  :  " + price + "Is being displayed");
    }



    @When("^I verify \"([^\"]*)\" and \"([^\"]*)\" are displayed in the summary table and the availability displays \"([^\"]*)\"$")
    public void verifyThatItemsAreDisplayed(String dress1, String dress2, String section)
    {
        WebElement table = indexPage.SummaryTable;
        List<WebElement> rows_table = table.findElements(By.tagName("tr"));
        int rowNum = rows_table.size();
        List<WebElement> col_table = table.findElements(By.tagName("td"));
        int colNum = col_table.size();

        //Verify that 2 items were displayed and selected in the previous steps
        Assert.assertTrue("Two items were found: " + dress1 + " and " +  dress2 , rowNum == 2);

        //Need to be refactor to improve future verification with more than 2 items
        if(indexPage.findADressInTheTable(1, dress1) && indexPage.findADressInTheTable(2, section)) {
            Assert.assertTrue("The " + dress1 + "Was displayed" , indexPage.findADressInTheTable(1, dress1));
            Assert.assertTrue("The " + section + "Was displayed" , indexPage.findADressInTheTable(2, section));
        }

        if (indexPage.findADressInTheTable(8, dress2) && (indexPage.findADressInTheTable(9, section))) {
            Assert.assertTrue("The " + dress2 + "Was displayed" , indexPage.findADressInTheTable(8, dress2));
            Assert.assertTrue("The " + section + "Was displayed" , indexPage.findADressInTheTable(9, section));
        }

        log.log(Level.INFO,"Verify that  :  " + dress1 + dress2 + section + "were displayed");
    }

    @When("^I verify \"([^\"]*)\" has a discount of \"([^\"]*)\"$")
    public void verifyDiscount(String dress, String discount)
    {
        indexPage.get(dress).waitUntil(Condition.appears, Timeout);
        indexPage.PrintedChiffonDressPercentDisplay.waitUntil(Condition.appears, Timeout);

        Assert.assertTrue("The " + dress + "has a disccount of " + discount , indexPage.PrintedChiffonDressPercentDisplay.getText().contains(discount));
        log.log(Level.INFO,"Verify that  :  " + dress + "has discount of : " + discount);
    }

    /*Verification Sections*/
}
