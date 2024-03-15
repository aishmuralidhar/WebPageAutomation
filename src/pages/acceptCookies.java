package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class acceptCookies {
    private WebDriver driver;
    

    public acceptCookies(WebDriver driver){
        this.driver=driver;
    }
    
    public void acceptAllCookies() {
	
    JavascriptExecutor js = (JavascriptExecutor) driver;
    WebElement acceptCookies = (WebElement)js.executeScript("return document.querySelector('cookie-banner').shadowRoot.querySelector('div.cookie-banner-controls button')");
    acceptCookies.click();
    }
}
