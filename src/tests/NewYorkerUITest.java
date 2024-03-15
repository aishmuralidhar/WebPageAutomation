package tests;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import pages.DateOfBirthPage;
import pages.HomePage;
import pages.MenuPage;
import utils.BrowserFactory;
import utils.getReportObject;

public class NewYorkerUITest {
	private WebDriver driver;
	private HomePage homePage;
	private MenuPage menuPage;
	private DateOfBirthPage dateOfBirthPage;
	public static ExtentReports extent;

	@BeforeClass
	public void setUp() {
		
		
	String path=System.getProperty("user.dir")+"\\reports\\index.html";
	System.out.println("Current working directory in Java : " + path);
	ExtentSparkReporter reporter = new ExtentSparkReporter(path);
	reporter.config().setReportName("WebAutomationResults");
	reporter.config().setDocumentTitle("TestResults");
     extent = new ExtentReports();
	extent.attachReporter(reporter);
	
	
	
		driver = BrowserFactory.setup("firefox");
		homePage = new HomePage(driver);
		menuPage = new MenuPage(driver);
		dateOfBirthPage = new DateOfBirthPage(driver);
		// Female =
		// driver.findElement(By.cssSelector("a.cg-select[onclick*=\"setCustomerGroup('FEMALE')\"]"));
	}

	@Test(priority = 1)
	public void navigateAndTestNewYorkerWebsite() throws InterruptedException {
		extent.createTest("navigateToHomePage");
		
		homePage.navigateToHomePage("https://www.newyorker.de/");
		extent.flush();
		
	}

	@Test(priority = 2)
	public void selectMenu() throws InterruptedException {
		extent.createTest("selectdifferentCategories");
	
		long time = 5000;
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(time));
		Map<String, String> categoryXPaths = new HashMap<>();
		categoryXPaths.put("Produkte",
				"//*[@id=\"fashion\"]/div[1]/div[1]/hamburger-menu/div[2]/div[2]/div[2]/menu-item[1]");
		categoryXPaths.put("InstaFasion",
				"//*[@id=\"fashion\"]/div[1]/div[1]/hamburger-menu/div[2]/div[2]/div[2]/menu-item[3]");
		categoryXPaths.put("Lifestyle",
				"//*[@id=\"fashion\"]/div[1]/div[1]/hamburger-menu/div[2]/div[2]/div[2]/menu-item[7]");

		// Select categories
		menuPage.selectCategory(categoryXPaths);
		
		extent.flush();
		
		
	}

	@Test(priority = 3)
	public void DoB() throws InterruptedException {
		extent.createTest("FindandSelectDOB");
		long time = 5000;
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(time));
		dateOfBirthPage.getMoreClub();
		dateOfBirthPage.enterIncorrectCredentials("prism@gmail.com", "Abc");
		dateOfBirthPage.enterCredentials("prismabclogin@gmail.com", "prismabc");
		dateOfBirthPage.enterDateOfBirth();
		dateOfBirthPage.printDateOfBirthPromptStatus();
		extent.flush();
	}

	@AfterClass
	public void tearDown() {
		if (driver != null) {
			driver.quit();
		}
	}
}