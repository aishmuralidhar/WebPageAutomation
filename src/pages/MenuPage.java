package pages;

import java.time.Duration;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MenuPage {
	private WebDriver driver;

	public MenuPage(WebDriver driver) {
		this.driver = driver;
	}

	public void selectCategory(Map<String, String> categoryXPaths) throws InterruptedException {
		// Iterate over each category entry
		for (Map.Entry<String, String> entry : categoryXPaths.entrySet()) {
			long time = 5000;
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(time));
	
			//String categoryName = entry.getKey();
			String categoryXPath = entry.getValue();
			// Click on the MenuButtom
			WebElement menuButton = driver.findElement(By.xpath("/html/body/div[1]/div[1]/hamburger-menu"));
			menuButton.click();
			
			// Click on the category element from the Menu
			WebElement categoryElement = driver.findElement(By.xpath(categoryXPath));
			categoryElement.click();
			Thread.sleep(3000);

			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0, 500);");

		}

	}

}