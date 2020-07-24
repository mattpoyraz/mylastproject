package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SigninPage {

    WebDriver driver;

    By email=By.cssSelector("#username");
    By password=By.xpath("//input[@id='password']");
    By siginButton=By.id("btnSubmitIn");
    By errorAlarm=By.xpath("//div[@id='_message_signin']//div");
    By textMessage=By.xpath("//div[@class='row']//div[2]//p");

    public SigninPage(WebDriver driver){

        this.driver=driver;
    }


    public WebElement getEmail(){

        return driver.findElement(email);
    }

    public WebElement getPassword(){

        return driver.findElement(password);
    }

    public WebElement getSigninButton(){

        return driver.findElement(siginButton);
    }

    public WebElement getErrorMessage(){

        return driver.findElement(errorAlarm);

    }

    public WebElement getTextMessage(){

        return driver.findElement(textMessage);
    }

}
