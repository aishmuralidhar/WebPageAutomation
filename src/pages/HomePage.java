package pages;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {
	private WebDriver driver;
	private acceptCookies acceptCookiesPage;
	public WebElement country;
	public WebElement Female;
	public WebElement popupClose;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		acceptCookiesPage = new acceptCookies(driver);

		
	}

	public void navigateToHomePage(String url) throws InterruptedException {
		// TODO Auto-generated method stub
		driver.get(url);

		country = driver.findElement(By.xpath("//*[@id=\"fashion\"]/country-picker/div[2]/div/div/div[3]/button"));
		Female = driver.findElement(By.cssSelector("a.cg-select[onclick*=\"setCustomerGroup('FEMALE')\"]"));
		country.click();
		acceptCookiesPage.acceptAllCookies();
        Female.click();
		popupClose = driver.findElement(By.id("close-button"));
		popupClose.click();
	}
}
