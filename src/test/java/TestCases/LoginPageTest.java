package TestCases;

import Pages.Basepage;
import io.qameta.allure.*;
import org.testng.annotations.Test;

import static io.qameta.allure.SeverityLevel.CRITICAL;

public class LoginPageTest extends Basepage {
    @Test(priority = 1)
    @Step("First step")
    public void Loginpage() throws InterruptedException {
        System.out.println("Login Page");
        Thread.sleep(4);
    }


    @Test(priority = 2)
    @Step("First step")
    public void Loginpage2() throws InterruptedException {
        System.out.println("Login Page");
        Thread.sleep(4);
    }
    @Test(priority = 3)
    @Step("First step")
    public void Loginpage3() throws InterruptedException {
        System.out.println("Login Page");
        Thread.sleep(4);
    }
}
