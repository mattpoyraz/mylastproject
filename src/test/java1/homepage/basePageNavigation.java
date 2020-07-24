package homepage;

import org.openqa.selenium.NoSuchElementException;
import org.testng.annotations.*;
import pageobjects.LandingPage;
import resource.BasePage;

import java.io.IOException;

public class basePageNavigation extends BasePage {

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
    public void basePageNavigation1() throws IOException {

        LandingPage landingPage=new LandingPage(driver);

        try {
            landingPage.getSearcButton().sendKeys("ismetpoyraz");
            landingPage.getSearcButtonClear().clear();

        }catch (NoSuchElementException e){

            System.out.println("Element is not found");

            //throw (e);
        }



    }


}
