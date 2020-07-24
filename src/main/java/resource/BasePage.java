package resource;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class BasePage {

    public  WebDriver driver;
    public  Properties properties;

    public WebDriver initializeDriver() throws IOException {

        properties = new Properties();
        FileInputStream fileInputStream= new FileInputStream("src/main/dataproperties/data.properties");
        properties.load(fileInputStream);


        String browserName= properties.getProperty("browser");
        String url=properties.getProperty("url");

        if(browserName.equals("chrome")){

            System.setProperty("webdriver.chrome.driver","drivers/chromedriver");
            driver = new ChromeDriver();
            //driver.get(url);


        }
        else if (browserName.equals("firefox")){

            System.setProperty("webdriver.gecko.driver","drivers/geckodriver");
            driver = new FirefoxDriver();
            //driver.get(url);

        }
        else{

            System.out.println("something went wrong");
        }

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        return driver;





    }


}
