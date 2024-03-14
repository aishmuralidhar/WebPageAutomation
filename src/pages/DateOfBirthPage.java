package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DateOfBirthPage {
	private WebDriver driver;

	public DateOfBirthPage(WebDriver driver) {

		this.driver = driver;

	}

	public void enterCredentials(String email, String password) throws InterruptedException {
		//Click on the HamburgerMenu
		driver.findElement(By.xpath("/html/body/div[1]/div[1]/hamburger-menu")).click();
		//Clcik on the Get More Club item from the Menu
		WebElement getMoreClub=driver.findElement(By.xpath("//*[@id=\"fashion\"]/div[1]/div[1]/hamburger-menu/div[2]/div[2]/div[2]/menu-item[5]"));
				getMoreClub.click();
		Thread.sleep(2000);
		//Click on Login Button
		WebElement Anmeldung=driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div/div[1]/div[2]/div[2]/button[1]"));
		Anmeldung.click();
		Thread.sleep(2000);
		//Enter the email

		WebElement emailInput = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div/div/div[2]/div/input"));
		emailInput.sendKeys(email);

		// Find and send password
		WebElement passwordInput = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div/div/div[3]/div/input"));
		passwordInput.sendKeys(password);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0, 200);");
		Thread.sleep(2000);
		//Click on login button
		WebElement login = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div/div/div[5]/div[2]/button"));
		login.click();
		Thread.sleep(2000);
		
		//To find the DOB click on the customer widget on the top right
		driver.findElement(By.xpath("//*[@id=\"fashion\"]/div[1]/div[2]/customer-widget")).click();
		Thread.sleep(2000);
	}

	public void enterDateOfBirth() throws InterruptedException {

		// to click on MeinKonto under the customer widget
		// Execute JavaScript to access the shadow root
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		WebElement meinKonto = (WebElement) jse
				.executeScript("return document.querySelector('customer-widget').shadowRoot.querySelector('a')");
		meinKonto.click();
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0, 500);");
	}
	
	public void printDateOfBirthPromptStatus() {
	    // Check if the Date of Birth prompt is displayed
	    boolean isDisplayed = isDateOfBirthPromptDisplayed();
	    
	    // Print the status based on whether the prompt is displayed or not
	    if (isDisplayed) {
	        System.out.println("Date of Birth prompt is displayed.");
	    } else {
	        System.out.println("Date of Birth prompt is not displayed.");
	    }
	    driver.findElement(By.xpath("//*[@id='fashion']/div[4]/div[2]/div/div[2]/div/span[18]")).click();
	}

	public boolean isDateOfBirthPromptDisplayed() {
		// Logic to click on date of birth  is displayed

		driver.findElement(By.xpath(
				"//*[@id=\"customer-profile\"]/div/router-view/router-view/div/div[2]/router-view/div[1]/div/form/div[3]/div/div/flatpickr/input"))
				.click();
	    String dobPromptXPath = "//*[@id=\"customer-profile\"]/div/router-view/router-view/div/div[2]/router-view/div[1]/div/form/div[3]/div/div/flatpickr/input";
	    
	    // Find the Date of Birth prompt element
	    WebElement dobPromptElement = driver.findElement(By.xpath(dobPromptXPath));
	    
	    // Check if the Date of Birth prompt element is displayed
	    return dobPromptElement.isDisplayed();

	}


}