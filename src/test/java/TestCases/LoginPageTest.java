package TestCases;

import Pages.Basepage;
import Pages.loginPage;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utils.AllureReportUtil;

@Listeners({AllureReportUtil.class})
public class LoginPageTest extends Basepage {


    @Test(priority = 1,enabled = true)
    @Step("Test Case 1 - Login Page 1")
    public void Loginpage2() throws InterruptedException {
        loginPage lp = new loginPage(driver);
        lp.clickOnSerchBox();
        lp.clickOnMobileTab();
        System.out.println("Login Page 2");
        Thread.sleep(2000);
    }


}
