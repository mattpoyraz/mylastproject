package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage {

    public WebDriver driver;

    private By applyNow= By.xpath("//*[@id='menu-item-654']/a");
    private By signin=By.xpath("//a[@class='page-scroll btn btn-xl mr30 btn-primary'][contains(text(),'Sign-in')]");
    private @FindBy(css =".ubermenu-search-input")
    WebElement searcButton;

    private @FindBy(css =".ubermenu-search-input")
    WebElement searcButtonClear;





    public LandingPage(WebDriver driver){
        this.driver=driver;//this is for By notation
        PageFactory.initElements(driver,this);//this is for @FindBy notation

    }

    public WebElement getLogin(){
        return driver.findElement(applyNow);
    }

    public WebElement getSignin(){

        return driver.findElement(signin);
    }

    public WebElement getSearcButton(){
        return searcButton;
    }

    public WebElement getSearcButtonClear(){
        return searcButtonClear;
    }
}
