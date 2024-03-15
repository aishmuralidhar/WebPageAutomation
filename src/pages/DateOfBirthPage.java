package pages;

import static org.testng.Assert.assertEquals;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class DateOfBirthPage {
	private WebDriver driver;

	public DateOfBirthPage(WebDriver driver) {

		this.driver = driver;

	}

	@Test(priority = 1)
	public void getMoreClub() throws InterruptedException {

		
		// Click on the HamburgerMenu
		driver.findElement(By.xpath("/html/body/div[1]/div[1]/hamburger-menu")).click();
		// Click on the Get More Club item from the Menu
		WebElement getMoreClub = driver.findElement(
				By.xpath("//*[@id=\"fashion\"]/div[1]/div[1]/hamburger-menu/div[2]/div[2]/div[2]/menu-item[5]"));
		getMoreClub.click();
		
		// Click on Login Button
		WebElement Anmeldung = driver
				.findElement(By.xpath("//*[@id=\"app\"]/div/div/div/div[1]/div[2]/div[2]/button[1]"));
		Anmeldung.click();

	}
		@Test(priority = 2)
		
		public void enterIncorrectCredentials(String email, String password) throws InterruptedException {

		// Enter the email

		WebElement emailInput = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div/div/div[2]/div/input"));
		emailInput.sendKeys(email);

		// Find and send password
		WebElement passwordInput = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div/div/div[3]/div/input"));
		passwordInput.sendKeys(password);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0, 200);");

		// Click on login button
		WebElement login = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div/div/div[5]/div[2]/button"));
		login.click();
		
		WebElement errorMessage=driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div/div/div[1]/div[2]/div[2]/div"));
		String expectedErrorMessage="Ich konnte dich nicht anmelden. Bitte �berpr�fe nochmal Email Adresse und Passwort!";
		String actualErrorMessage=errorMessage.getText();
		 assertEquals(actualErrorMessage, expectedErrorMessage, "Error message not displayed correctly");
		 emailInput.clear();
		 passwordInput.clear();
		driver.navigate().refresh();
		}
		
		
		@Test(priority = 3)
		public void enterCredentials(String email1, String password1) throws InterruptedException {
		// Enter the email

		WebElement emailInput1 = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div/div/div[2]/div/input"));
		emailInput1.sendKeys(email1);
		System.out.println(email1);

		// Find and send password
		WebElement passwordInput1 = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div/div/div[3]/div/input"));
		passwordInput1.sendKeys(password1);
		System.out.println(password1);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0, 100);");

		// Click on login button
		 driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div/div/div[5]/div[2]/button")).click();

		
		}



	@Test(priority = 4)
	public void enterDateOfBirth() throws InterruptedException {
		// To find the DOB click on the customer widget on the top right
		driver.findElement(By.xpath("//*[@id=\"fashion\"]/div[1]/div[2]/customer-widget")).click();
		// to click on MeinKonto under the customer widget
		// Execute JavaScript to access the shadow root
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		WebElement meinKonto = (WebElement) jse
				.executeScript("return document.querySelector('customer-widget').shadowRoot.querySelector('a')");
		meinKonto.click();
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0, 200);");
		Thread.sleep(2000);
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
		// Logic to click on date of birth is displayed

		WebElement dob=driver.findElement(By.xpath("/html/body/main/div/div/router-view/router-view/div/div[2]/router-view/div[1]/div/form/div[2]/div/div/flatpickr/input"));
				dob.click();
		String dobPromptXPath = "/html/body/div[4]/div[1]/span[2]/span";

		// Find the Date of Birth prompt element
		WebElement dobPromptElement = driver.findElement(By.xpath(dobPromptXPath));

		// Check if the Date of Birth prompt element is displayed
		return dobPromptElement.isDisplayed();

	}

}