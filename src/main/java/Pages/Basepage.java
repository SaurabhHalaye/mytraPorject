package Pages;

import io.qameta.allure.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import static io.qameta.allure.SeverityLevel.CRITICAL;

public class Basepage {



    WebDriver driver;
    String url = "https://www.myntra.com/";


    @BeforeMethod(alwaysRun = true)
    public  void setUp() throws Exception {
        driver = new ChromeDriver();
        driver.get(url);
    }

    @AfterMethod(alwaysRun = true)
    @Step("Quite the Browser")
    public  void tearDown() throws Exception {
        driver.quit();
    }

}
