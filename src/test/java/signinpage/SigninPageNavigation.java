package signinpage;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageobjects.LandingPage;
import pageobjects.SigninPage;
import resource.BasePage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;

public class SigninPageNavigation extends BasePage {

    @BeforeClass
    public void beforeClass() throws IOException {

        initializeDriver();
        String Url=properties.getProperty("url");
        driver.get(Url);
    }



    @Test(dataProvider ="getData")
    public void SigninPageNavigation1(String username, String password) throws IOException {

        LandingPage landingPage=new LandingPage(driver);
        landingPage.getLogin().click();

        Set<String> set= driver.getWindowHandles();
        Iterator<String> iterator= set.iterator();
        String parentWindow= iterator.next();
        String childWindow=iterator.next();
        driver.switchTo().window(childWindow);

        //driver.switchTo().window(parentWindow);



        landingPage.getSignin().click();//this is must be come after windows chanced

        SigninPage signinPage=new SigninPage(driver);
        signinPage.getEmail().sendKeys(username);
        signinPage.getPassword().sendKeys(password);
        signinPage.getSigninButton().click();

        //signinPage.getErrorMessage().isDisplayed();
        Assert.assertFalse( signinPage.getErrorMessage().isDisplayed());

    }


    @Test()
    public void handleSecondWayWindowsTag(String username, String password) {

        LandingPage landingPage=new LandingPage(driver);
        landingPage.getLogin().click();

        String parent=driver.getWindowHandle();
        System.out.println("Parent windows id is :"+parent);

        Set<String> set=driver.getWindowHandles();
        ArrayList<String> arrayList=new ArrayList<>(set);
        driver.switchTo().window(arrayList.get(1));
        System.out.println("Second window name is:"+driver.getCurrentUrl());

        landingPage.getSignin().click();//this is must be come after windows chanced

        SigninPage signinPage=new SigninPage(driver);
        signinPage.getEmail().sendKeys(username);
        signinPage.getPassword().sendKeys(password);
        signinPage.getSigninButton().click();
        //Assert.assertFalse( signinPage.getErrorMessage().isDisplayed());
        signinPage.getErrorMessage().isDisplayed();

        String getTitle=signinPage.getTextMessage().getText();
        Assert.assertEquals(getTitle,"Only @na.edu emails are accepted for Office 365 authentication");
        //to get a parent URL currentname
        driver.switchTo().window(arrayList.get(0));
        System.out.println("Parent name is :"+driver.getCurrentUrl());

    }

    @DataProvider
    public Object[][] getData(){

        Object[][] data= new Object[1][2];

        data[0][0]="ismet@mart.com";
        data[0][1]="23234";

        //data[1][0]="musti@foodi.com";
        //data[1][1]="121323";


        return data;





    }
}
