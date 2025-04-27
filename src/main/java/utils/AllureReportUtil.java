package utils;

import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;

public class AllureReportUtil implements ITestListener {

    // Capture screenshot as PNG
//    @Attachment(value = "Page screenshot", type = "image/png")
//    public byte[] saveScreenshotPNG(WebDriver driver) {
//        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
//    }

    @Attachment(value = "Screenshot of {0}", type = "image/png")
    public byte[] saveScreenshot(WebDriver driver) {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }

    @Attachment(value = "Screenshot of {0}", type = "image/png")
    public byte[] saveScreenshotAll(WebDriver driver) {
        byte[] screenshotBytes = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);

        // Also save manually to a folder
        saveScreenshotToFolder(screenshotBytes);

        return screenshotBytes;
    }

    private void saveScreenshotToFolder(byte[] screenshotBytes) {
        try {
            // Create a folder "screenshots" if it doesn't exist
            File folder = new File("screenshots");
            if (!folder.exists()) {
                folder.mkdirs();
            }

            // Create a unique file name with timestamp
            String fileName = "screenshots/screenshot_" + System.currentTimeMillis() + ".png";
            FileOutputStream fos = new FileOutputStream(fileName);
            fos.write(screenshotBytes);
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Attach plain text logs
    @Attachment(value = "{0}", type = "text/plain")
    public static String saveTextLog(String message) {
        return message;
    }

    // Attach raw HTML if needed
    @Attachment(value = "{0}", type = "text/html")
    public static String attachHtml(String html) {
        return html;
    }

    private static String getTestMethodName(ITestResult iTestResult) {
        return iTestResult.getMethod().getConstructorOrMethod().getName();
    }

    @Override
    public void onStart(ITestContext iTestContext) {
        System.out.println("🟢 onStart: " + iTestContext.getName());
    }

    @Override
    public void onFinish(ITestContext iTestContext) {
        System.out.println("🔵 onFinish: " + iTestContext.getName());
    }

    @Override
    public void onTestStart(ITestResult iTestResult) {
        System.out.println("🟡 onTestStart: " + getTestMethodName(iTestResult));
    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        System.out.println("✅ onTestSuccess: " + getTestMethodName(iTestResult));
    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        System.out.println("❌ onTestFailure: " + getTestMethodName(iTestResult));

        WebDriver driver = (WebDriver) iTestResult.getTestContext().getAttribute("WebDriver");

        if (driver != null) {
            System.out.println("📸 Capturing screenshot for: " + getTestMethodName(iTestResult));
            saveScreenshot(driver);
        } else {
            System.out.println("⚠️ WebDriver is null, cannot capture screenshot.");
        }

        saveTextLog(getTestMethodName(iTestResult) + " failed and screenshot taken!");
    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {
        System.out.println("⚠️ onTestSkipped: " + getTestMethodName(iTestResult));
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {
        System.out.println("⚠️ onTestFailedButWithinSuccessPercentage: " + getTestMethodName(iTestResult));
    }
}
