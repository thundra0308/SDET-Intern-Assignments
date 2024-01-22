package baseClasses;

import org.openqa.selenium.*;
import java.util.ArrayList;
import java.util.List;

public class ElementFunction extends ReportManager {

    /****************** Send Keys Function ******************/
    public void input(WebElement input, String value, String inputFieldName) {
        int attempts = 0;
        while (attempts < 10) {
            try {
                reportInfo("Entering Input in : " + inputFieldName);
                expWait_VisibilityClickable(input);
                input.sendKeys(Keys.chord(Keys.CONTROL, "a"), value); // Selects existing text and enters new value
                System.out.println(input.getAttribute("value"));
                if(input.getAttribute("value").equals(value)) {
                    reportPass("Entered Input Successfully in : " + inputFieldName);
                    break;
                } else {
                    attempts++;
                }
            } catch (StaleElementReferenceException | ElementNotInteractableException | NoSuchElementException e) {
                reportWarning("Stale Element Reference Exception occurred. Retrying input action...");
                attempts++;
            } catch (Exception e) {
                reportFail(e.getMessage());
                break;
            }
        }
    }

    /****************** Click Function ******************/
    public void click(WebElement btn, String btnName) {
        int attempts = 0;
        while (attempts < 10) {
            try {
                reportInfo("Clicking on : " + btnName);
                expWait_VisibilityClickable(btn);
                btn.click();
                reportPass("Clicked : " + btnName);
                break;
            } catch (StaleElementReferenceException | ElementNotInteractableException | NoSuchElementException e) {
                reportWarning("Stale Element Reference Exception occurred. Retrying click action...");
                attempts++;
            } catch (Exception e) {
                reportFail(e.getMessage());
                break;
            }
        }
    }

    /****************** Select the Item from Drop-Down Menu ******************/
    public void select(String value, WebElement searchBox, List<WebElement> searchResult, String inputFieldName) {
        input(searchBox, value, inputFieldName);
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
