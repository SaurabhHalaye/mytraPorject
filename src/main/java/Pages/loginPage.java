package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.awt.*;
import java.util.List;

public class loginPage extends Basepage{

    public loginPage(WebDriver driver){
        this.driver = driver;
    }

    //xpth

    By searchBox = By.xpath("//input[@placeholder='Search for products, brands and more']");
    By mobileList = By.xpath("//li[@class='desktop-suggestion null']");
    By mobileCover = By.xpath("//h4[text()='iPhone 14 Phone Bumper']");

    public void clickOnSerchBox() throws InterruptedException {
        driver.findElement(searchBox).click();
        driver.findElement(searchBox).sendKeys("Mobile");
        Thread.sleep(3000);
    }

    public void clickOnMobileTab() throws InterruptedException {
        List<WebElement> ab =  driver.findElements(mobileList);
        for (WebElement mobile : ab) {
            if (mobile.getText().contains("Mobile Accessories Women")) {
                mobile.click();
                break; // exit the loop after clicking
            }
        }

        driver.findElement(mobileCover).click();
        Thread.sleep(5000);
    }


}
