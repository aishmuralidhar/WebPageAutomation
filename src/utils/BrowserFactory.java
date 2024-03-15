

package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class BrowserFactory {
    private static WebDriver driver = null;
    
    public static WebDriver getDriver() {
        return driver;
    }
    
  
    public static WebDriver setup(String browserName) {
        System.out.println("Browser name is: " + browserName);
        
        if(browserName.equalsIgnoreCase("chrome")) {
            driver = new ChromeDriver();
        } else if(browserName.equalsIgnoreCase("firefox")) {
            driver = new FirefoxDriver();
        } else if(browserName.equalsIgnoreCase("edge")) {
            driver = new EdgeDriver();
        }
        driver.manage().window().maximize();
		return driver;
    }

}
