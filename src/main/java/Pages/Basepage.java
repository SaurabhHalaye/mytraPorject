package Pages;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Step;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utils.AllureReportUtil;

import java.io.File;
import java.io.IOException;
import java.net.URL;

public class Basepage {

    public WebDriver driver;
    String url = "https://www.myntra.com/";
    public static ThreadLocal<WebDriver> tdriver = new ThreadLocal<WebDriver>();



    @BeforeMethod(alwaysRun = true)
    public WebDriver setUp() throws Exception {
        String env = System.getProperty("env", "local").toLowerCase();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        if(env.equals("remote")) {
            System.out.println("___________Connect to the Selenium Hub_______________");
            URL remoteUrl = new URL("http://192.168.195.76:4444");
            driver = new RemoteWebDriver(remoteUrl, options); // Corrected assignment

        }else{
            System.out.println("___________Running Locally_______________");
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver(options);
        }
        driver.manage().window().maximize();
        driver.get(url);
        tdriver.set(driver);
        return getDriver();
    }

    public static synchronized WebDriver getDriver() {
        return tdriver.get();
    }

//

    public String getScreenshot() {
        File src = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);
        String path = System.getProperty("user.dir") + "/screenshots/" + System.currentTimeMillis() + ".png";
        File destination = new File(path);
        try {
            FileUtils.copyFile(src, destination);
        } catch (IOException e) {
            System.out.println("Capture Failed " + e.getMessage());
        }
        return path;
    }
}
