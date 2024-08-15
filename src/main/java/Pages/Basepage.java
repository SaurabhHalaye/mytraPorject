package Pages;

import io.qameta.allure.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.net.URL;

import static io.qameta.allure.SeverityLevel.CRITICAL;

public class Basepage {


    WebDriver driver;
    String url = "https://www.myntra.com/";

    @BeforeMethod(alwaysRun = true)
    public void setUp() throws Exception {
        // Set DesiredCapabilities for the browser you want to use
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setBrowserName("chrome"); // Use "firefox" for Firefox

        // Connect to the Selenium Hub
        driver = new RemoteWebDriver(new URL("http://192.168.1.112:4444/wd/hub"), capabilities);
        //new
        // Open the desired URL
        driver.get(url);
    }

    @AfterMethod(alwaysRun = true)
    @Step("Quit the Browser")
    public void tearDown() throws Exception {
        if (driver != null) {
            driver.quit();
        }
    }
}

