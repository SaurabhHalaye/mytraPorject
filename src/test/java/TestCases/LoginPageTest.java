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

    @Test(priority = 1)
    @Step("Test Case 1 - Login Page")
    public void Loginpage() throws InterruptedException {
        System.out.println("Login Page");
        assert false;
        Thread.sleep(2000);
    }

    @Test(priority = 2)
    @Step("Test Case 2 - Login Page 2")
    public void Loginpage2() throws InterruptedException {
        loginPage lp = new loginPage(driver);
        lp.clickOnSerchBox();
        System.out.println("Login Page 2");
        Thread.sleep(2000);
    }

    @Test(priority = 3)
    @Step("Test Case 3 - Login Page 3")
    public void Loginpage3() throws InterruptedException {
        System.out.println("Login Page 3");
        Thread.sleep(2000);
    }
}
