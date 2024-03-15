package tests;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.DateOfBirthPage;
import pages.HomePage;
import pages.MenuPage;
import utils.BrowserFactory;

public class NewYorkerUITest {
    private WebDriver driver;
    private HomePage homePage;
    private MenuPage menuPage;
    private DateOfBirthPage dateOfBirthPage;


    @BeforeClass
    public void setUp(){
        driver= BrowserFactory.createChromeDriver();
        homePage=new HomePage(driver);
        menuPage=new MenuPage(driver);
        dateOfBirthPage=new DateOfBirthPage(driver);
        //Female = driver.findElement(By.cssSelector("a.cg-select[onclick*=\"setCustomerGroup('FEMALE')\"]"));
    }

    @Test(priority = 1)
    public void navigateAndTestNewYorkerWebsite() throws InterruptedException {
        homePage.navigateToHomePage("https://www.newyorker.de/");
    }

 
     @Test(priority = 3)  
      public void selectMenu() throws InterruptedException {
        Map<String, String> categoryXPaths = new HashMap<>();
        categoryXPaths.put("Produkte", "//*[@id=\"fashion\"]/div[1]/div[1]/hamburger-menu/div[2]/div[2]/div[2]/menu-item[1]");
        categoryXPaths.put("InstaFasion", "//*[@id=\"fashion\"]/div[1]/div[1]/hamburger-menu/div[2]/div[2]/div[2]/menu-item[3]");
        categoryXPaths.put("Lifestyle", "//*[@id=\"fashion\"]/div[1]/div[1]/hamburger-menu/div[2]/div[2]/div[2]/menu-item[7]");
        
        // Select categories
        menuPage.selectCategory(categoryXPaths);
        }
      @Test(priority = 4)
      public void DoB() throws InterruptedException
      {
        dateOfBirthPage.enterCredentials("prismbetter@gmail.com","Prism123++");
        dateOfBirthPage.enterDateOfBirth();
        dateOfBirthPage.printDateOfBirthPromptStatus();
    }
    


    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}