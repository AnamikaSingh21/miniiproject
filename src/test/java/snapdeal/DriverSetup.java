package snapdeal;


import java. time. Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;


     public class DriverSetup {
    		 
     public static WebDriver driver;
     
     //selecting the browser
     public static WebDriver getBrowser(int ch) {
    	 
     if(ch==1) {
    	return getWebDriver ();
     }
     
     else {
    	return getWebDriverr ();
     }
     }
     
    //Driver setup for chrome browser
    public static WebDriver getWebDriver () {
    	WebDriverManager.chromedriver().setup () ;
        driver = new ChromeDriver ();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait (Duration. ofSeconds (5)) ;
        driver. manage().deleteAllCookies() ;
        return driver;
    }
     
    //Driver setup for Edge browser
    public static WebDriver getWebDriverr () {
    	WebDriverManager.edgedriver().setup () ;
        driver = new EdgeDriver ();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait (Duration. ofSeconds (5)) ;
        driver. manage().deleteAllCookies() ;
        return driver;
    }
     }
     