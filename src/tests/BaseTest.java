package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import java.util.Random;
import java.util.concurrent.TimeUnit;


public class BaseTest {
    public WebDriver driver;
    public WebDriverWait wait;
    private static String pathToFF = "/Users/nacho15vega/Documents/Automation Practice/src/libs/geckodriver";
    private static String pathToChrome = "/Users/nacho15vega/Documents/Automation Practice/src/libs/chromedriver";


//    @BeforeMethod
//    public void setup () {
//        //Sets path to Firefox driver
//        System.setProperty("webdriver.gecko.driver", pathToFF);
//
//        //Create a Firefox driver. All test and page classes use this driver.
//        driver = new FirefoxDriver();
//
//        //Create a wait. All test and page classes use this wait.
//        wait = new WebDriverWait(driver,15);
//
//        //Maximize Window
//        driver.manage().window().maximize();
//    }

    /**
     * This function will execute before each Test tag in testng.xml
     * @param browser
     * @throws Exception
     */
    @BeforeMethod
    @Parameters("browser")
    public void setup(String browser) throws Exception{
        //Check if parameter passed from TestNG is 'firefox'
        if(browser.equalsIgnoreCase("firefox")){
            //create firefox instance
            System.setProperty("webdriver.gecko.driver", pathToFF);
            driver = new FirefoxDriver();
        }
        //Check if parameter passed as 'chrome'
        else if(browser.equalsIgnoreCase("chrome")){
            //set path to chromedriver.exe
            System.setProperty("webdriver.chrome.driver", pathToChrome);
            //create chrome instance
            driver = new ChromeDriver();
        }
        //Check if parameter passed as 'safari'
        else if(browser.equalsIgnoreCase("Safari")){
            //create Safari instance
            driver = new SafariDriver();
        }
        else{
            //If no browser passed throw exception
            throw new Exception("Browser is not correct");
        }
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    protected static int getRandomNumberInRange(int min, int max) {
        if (min >= max) {
            throw new IllegalArgumentException("max must be greater than min");
        }
        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
    }

    @AfterMethod
    public void teardown () {
        driver.quit();
    }
}