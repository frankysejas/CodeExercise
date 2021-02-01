package code.automation.pageobjects;


import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class IndexPage extends AbstractPage
{

    @NameOfElement("BEST SELLERS")
    @FindBy(xpath = ".//*[@href='#blockbestsellers']")
    public SelenideElement BestSeller;

    @NameOfElement("Printed Chiffon Dress")
    @FindBy(xpath = ".//*[@id='blockbestsellers']//*[@title='Printed Chiffon Dress']")
    public SelenideElement PrintedChiffonDress;

    @NameOfElement("Printed Chiffon Dress percent display")
    @FindBy(xpath = "(.//ul[@id='blockbestsellers'][.//a[@title='Printed Summer Dress']]//div[@class='right-block']//span[@class='price-percent-reduction'])[1]")
    public SelenideElement PrintedChiffonDressPercentDisplay;

    @NameOfElement("Printed Chiffon Dress Image")
    @FindBy(xpath = ".//ul[@id='blockbestsellers'][.//a[@title='Printed Summer Dress']]//div[@class='right-block']")
    public SelenideElement PrintedChiffonDressImage;

    @NameOfElement("Add to cart button")
    @FindBy(xpath = ".//ul[@id='blockbestsellers'][.//a[@title='Add to cart']]//div[@class='right-block']//a[@title='Printed Chiffon Dress']")
    public SelenideElement AddToCartButton;

    @NameOfElement("Summary Table")
    @FindBy(xpath = ".//table[@id='cart_summary']/tbody")
    public SelenideElement SummaryTable;

    @NameOfElement("Total Price")
    @FindBy(xpath = ".//td[@id='total_price_container']/span[@id='total_price']")
    public SelenideElement TotalPriceText;

    public SelenideElement hoverOverDress(String dress)
    {
        return $(byXpath(".//ul[@id='blockbestsellers']//a[@title='" + dress + "']"));
    }

    public SelenideElement clickOnAddCartButton(String button, String dress)
    {
        return $(byXpath("(//a[@title='"+ dress +"']/../ancestor::div[@class='right-block'])[2]//span[text()='" + button + "']"));
    }

    public SelenideElement clickOnContinueButton(String button)
    {
        return  $(byXpath(".//span[@title='"+ button +"']"));
    }

    public SelenideElement hoverDropdownAndClickOnButton(String dropdown, String button)
    {
        $(byXpath(".//a[@title='" + dropdown + "']")).hover();
        return $(byXpath(".//a[@title='" + button + "']"));
    }

    public Boolean findADressInTheTable(int index, String dress)
    {
        WebElement table = SummaryTable;
        return table.findElements(By.tagName("td")).get(index).getText().contains(dress);
    }

    public SelenideElement removeDressFromTheList(String dress)
    {
        return  $(byXpath("(//a[text()='" + dress + "'])[2]/ancestor::tr/td[@class='cart_delete text-center']/div/a[@title='Delete']"));
    }
}
