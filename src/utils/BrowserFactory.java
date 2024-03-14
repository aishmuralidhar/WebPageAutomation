package utils;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserFactory {
    public static WebDriver createChromeDriver(){
    	WebDriver driver = new ChromeDriver();
    	driver.manage().window().maximize();// Maximize the browser window
        return driver;
        
    }
}
//*[@id="fashion"]/cookie-banner//div/div[2]/button[1]