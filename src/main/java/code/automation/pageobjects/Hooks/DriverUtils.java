package code.automation.pageobjects.Hooks;

import org.openqa.selenium.support.ui.Select;

public class DriverUtils {

    public void WaitForLoadDataInSelect(Select element, int timeout)
    {
        int i = 0;
        while(element.getOptions().size() > 0 || i <= timeout)
        {
            if (element.getOptions().size() <= 0) {
                i++;
            }
            else
            {
                break;
            }

        }
    }
}
