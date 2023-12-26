package baseClasses;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitManager extends TestBaseClass {

    public WebDriverWait explicitWait;

    /****************** Explicit Wait ( Visibility and Clickable ) ******************/
    public void expWait_VisibilityClickable(WebElement webElement) {
        explicitWait.until(ExpectedConditions.visibilityOf(webElement));
        explicitWait.until(ExpectedConditions.elementToBeClickable(webElement));
    }

    /****************** Hard Coded Wait ( Thread.sleep() ) ******************/
    public void waitLoad(int i) {
        try {
            Thread.sleep(i * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
