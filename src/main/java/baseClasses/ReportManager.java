package baseClasses;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;
import utilities.DateUtil;
import java.io.File;
import java.io.IOException;

public class ReportManager extends WaitManager {

    public ExtentTest logger;
    public int testStep;

    /****************** Reporting Functions ***********************/
    public void reportFail(String reportString) {
        logger.log(Status.FAIL, "Step - "+testStep+" : Failed -> "+reportString);
        takeScreenShotOnFailure();
        Assert.fail(reportString);
    }

    public void reportPass(String reportString) {
        logger.log(Status.PASS, "Step - "+testStep+" : Successful -> "+reportString);
    }

    public void reportInfo(String reportString) {
        logger.log(Status.INFO, "Step - "+(++testStep)+" -> "+reportString);
    }

    /****************** Capture Screen Shot ***********************/
    public void takeScreenShotOnFailure() {
        TakesScreenshot takeScreenShot = (TakesScreenshot) driver;
        File sourceFile = takeScreenShot.getScreenshotAs(OutputType.FILE);
        File destFile = new File(System.getProperty("user.dir") + "/ScreenShots/" + DateUtil.getTimeStamp() + ".png");
        try {
            FileUtils.copyFile(sourceFile, destFile);
            logger.addScreenCaptureFromPath(System.getProperty("user.dir") + "/ScreenShots/" + DateUtil.getTimeStamp() + ".png");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
