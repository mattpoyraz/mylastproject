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





        if(browserName.equals("macchrome")){

            System.setProperty("webdriver.chrome.driver","drivers/mac/chromedriver");
            driver = new ChromeDriver();

        }
        else if (browserName.equals("macfirefox")){

            System.setProperty("webdriver.gecko.driver","drivers/mac/geckodriver 2");
            driver = new FirefoxDriver();


        }
        else if (browserName.equals("windowschrome")){

            System.setProperty("webdriver.chrome.driver","drivers/windows/chromedriver.exe");
            driver = new ChromeDriver();
        }

        else{

            System.out.println("please go to data.properties file and make sure that you provide correct browser name" +
                    "if youre using windows system just put windowschrome or macchrome!!");
        }

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        return driver;





    }


}
