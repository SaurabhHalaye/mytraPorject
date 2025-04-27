package Pages;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestContext;
import org.testng.annotations.BeforeMethod;

import java.net.URL;

public class Basepage {

    protected WebDriver driver;
    String url = "https://www.myntra.com/";

    @BeforeMethod(alwaysRun = true)
    public void setUp(ITestContext context) throws Exception {
        String env = System.getProperty("env", "local").toLowerCase();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");

        if (env.equals("remote")) {
            System.out.println("___________Connect to the Selenium Hub_______________");
            URL remoteUrl = new URL("http://192.168.195.76:4444");
            driver = new RemoteWebDriver(remoteUrl, options);
        } else {
            System.out.println("___________Running Locally_______________");
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver(options);

            System.out.println("Login driver page"+driver);
            System.out.println("Login driver page"+driver);
            System.out.println("Login driver page"+driver);
            System.out.println("Login driver page"+driver);

        }

        driver.manage().window().maximize();
        driver.get(url);

        // Store the WebDriver instance in the ITestContext
        context.setAttribute("WebDriver", driver);
    }
}
