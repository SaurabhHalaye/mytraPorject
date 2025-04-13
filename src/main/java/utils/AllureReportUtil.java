package utils;

import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;

public class AllureReportUtil {

    public static void captureOnFailure(WebDriver driver, ITestResult result) {
        if (result.getStatus() == ITestResult.FAILURE && driver != null) {
            saveScreenshotPNG(driver);
        } else if (driver == null) {
            System.out.println("Driver is null, cannot capture screenshot.");
        }
    }

    @Attachment(value = "Screenshot on failure", type = "image/png")
    public static byte[] saveScreenshotPNG(WebDriver driver) {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }
}
