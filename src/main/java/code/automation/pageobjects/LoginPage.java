package code.automation.pageobjects;


import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends AbstractPage
{

    @NameOfElement("Sign In")
    @FindBy(xpath = "//*[@title='Log in to your customer account']")
    public SelenideElement SignIn;

}
