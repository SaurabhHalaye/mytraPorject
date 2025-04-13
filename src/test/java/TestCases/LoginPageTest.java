package TestCases;

import Pages.Basepage;
import io.qameta.allure.Step;
import org.testng.annotations.Test;

public class LoginPageTest extends Basepage {

    @Test(priority = 1)
    @Step("Test Case 1 - Login Page")
    public void Loginpage() throws InterruptedException {
        System.out.println("Login Page");
        Thread.sleep(2000);
    }

    @Test(priority = 2)
    @Step("Test Case 2 - Login Page 2")
    public void Loginpage2() throws InterruptedException {
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
