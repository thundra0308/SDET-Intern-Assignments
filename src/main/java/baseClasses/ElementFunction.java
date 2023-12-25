package baseClasses;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

public class ElementFunction extends ReportManager {

    public void input(WebElement input, String value, String inputFieldName) {
        try {
            reportInfo("Entering Input in : "+inputFieldName);
            expWait_VisibilityClickable(input);
            input.sendKeys(value);
            reportPass("Entered Input Successfully in : "+inputFieldName);
        } catch (Exception e) {
            reportFail(e.getMessage());
        }
    }

    public void click(WebElement btn, String inputFieldName) {
        try {
            reportInfo("Clicking on : "+inputFieldName);
            expWait_VisibilityClickable(btn);
            btn.click();
            reportPass("Clicked : "+inputFieldName);
        } catch (Exception e) {
            reportFail(e.getMessage());
        }
    }

    /****************** Select the Item from Drop-Down Menu ******************/
    public void select(String value, WebElement searchBox, List<WebElement> searchResult, String inputFieldName) {
        input(searchBox,value, inputFieldName);
        List<WebElement> result = new ArrayList<>();
        int i = 1;
        while (i != 10) {
            result = searchResult;
            if (!result.isEmpty() && !result.get(0).getText()
                    .equals("Sorry, no matching options.")) {
                break;
            } else {
                waitLoad(1);
            }
            i++;
        }
        if (!result.isEmpty()) {
            boolean found = false;
            for (WebElement e : result) {
                if (value.equals(e.getText())) {
                    found = true;
                    click(e,e.getText());
                    break;
                }
            }
            if (!found)
                reportFail("Given Input '" + value + "' is Not Present! --- Input Size " + result.size());
        } else {
            reportFail("Given Input '" + value + "' is Not Present!");
        }
    }

}
