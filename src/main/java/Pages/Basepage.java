package Pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utils.AllureReportUtil;

import java.net.URL;

public class Basepage {

    protected static WebDriver driver;
    String url = "https://www.myntra.com/";

    @BeforeMethod(alwaysRun = true)
    public void setUp() throws Exception {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        System.out.println("___________Connect to the Selenium Hub_______________");
        URL remoteUrl = new URL("http://192.168.195.76:4444");
        driver = new RemoteWebDriver(remoteUrl, options); // Corrected assignment
        driver.manage().window().maximize();
        driver.get(url);
    }

    @AfterMethod(alwaysRun = true)
    @Step("Quit the Browser")
    public void tearDown(ITestResult result) throws Exception {
        AllureReportUtil.captureOnFailure(driver, result);  // Automatically called after each test
        if (driver != null) {
            driver.quit();
        }
    }
}
