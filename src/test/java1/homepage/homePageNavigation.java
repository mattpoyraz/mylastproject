package homepage;

import org.openqa.selenium.NoSuchElementException;
import org.testng.annotations.*;
import pageobjects.LandingPage;
import resource.BasePage;

import java.io.IOException;

public class homePageNavigation extends BasePage {

    @BeforeClass
    public void beforeClass() throws IOException {

        initializeDriver();
        String Url=properties.getProperty("url");
        driver.get(Url);
    }


    @AfterClass
    public void tearDown(){
        driver.quit();
    }


    @Test
    public void homePageNavigation1() throws IOException {

        LandingPage landingPage=new LandingPage(driver);

        try {
            landingPage.getSearcButton().sendKeys("ismetpoyraz");
            landingPage.getSearcButtonClear().clear();

        }catch (NoSuchElementException e){

            System.out.println("Element is not found");

            //throw (e);
        }



    }

    @Test(groups = {"Smoke"})
    public void groups() {

        System.out.println("ismet poyraz");
    }

    @Parameters({"url","username","password"})
    @Test(groups = {"Regression"})
    public void groups2(String username, String url , String password) {
        System.out.println(username);
        System.out.println(url);
        System.out.println(password);

    }

    @Test(enabled = false)
    public void enable() {

        System.out.println("please skip this test method");
    }

    @Test
    public void dependsOnMethods() {
        System.out.println("hh222");

    }


    @Test(dependsOnMethods ={"dependsOnMethods","groups"} )//that means just excute them before this run
    public void dependsOnMethods2() {

        System.out.println("hhhhhh");
    }

    @Parameters({"url"})
    @Test
    public void parameters(String urlname) {

        System.out.println(urlname);

    }
}
