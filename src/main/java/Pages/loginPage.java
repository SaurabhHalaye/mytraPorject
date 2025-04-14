package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class loginPage extends Basepage{

    public loginPage(WebDriver driver){
        this.driver = driver;
    }

    //xpth

    By searchBox = By.xpath("//input[@placeholder='Search for products, and more']");


    public void clickOnSerchBox(){
        driver.findElement(searchBox).click();
    }


}
