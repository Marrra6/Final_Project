package tests;


import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import pages.AuthPage;
import pages.CartSummaryPage;
import pages.LocationPopupPage;
import pages.LoginPage;
import pages.MealPage;
import pages.NotificationSistemPage;
import pages.ProfilePage;

public abstract class BasicTest {
	
	protected WebDriver driver;
	protected WebDriverWait waiter;
	protected JavascriptExecutor js;
	
	protected String baseURL = "http://demo.yo-meals.com/";
	protected String email = "customer@dummyid.com";
	protected String password = "12345678a";
	
	protected LocationPopupPage locationPopUpPage;
	protected LoginPage loginPage;
	protected ProfilePage profilePage;
	protected NotificationSistemPage notificationSistemPage;
	protected AuthPage authPage;
	protected MealPage mealPage;
	protected CartSummaryPage cartSummaryPage;
	
	
	@BeforeClass
	
	public void setUp () {
		
		System.setProperty("webdriver.chrome.driver", "driver-lib\\chromedriver.exe");
		driver = new ChromeDriver();
		waiter = new WebDriverWait(driver, 30);
		js = (JavascriptExecutor) driver;
		
		locationPopUpPage = new LocationPopupPage (driver, waiter, js);
		loginPage = new LoginPage(driver, waiter, js);
		profilePage = new ProfilePage (driver, waiter, js);
		notificationSistemPage = new NotificationSistemPage(driver, waiter,js);
		authPage = new AuthPage(driver, waiter, js);
		mealPage = new MealPage(driver, waiter, js);
		cartSummaryPage = new CartSummaryPage (driver, waiter, js);
		
		baseURL = "http://demo.yo-meals.com/";
		email = "customer@dummyid.com";
		password = "12345678a";

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);

	}
	
	@AfterMethod
	public void Screenshot(ITestResult result) throws IOException {
			SimpleDateFormat dateFormat = new SimpleDateFormat ("dd-mm-yyyy-h-m-s");
			Date date = new Date();
			
			if(result.getStatus() == ITestResult.FAILURE) {
			TakesScreenshot scrShot =((TakesScreenshot)driver);
			File photo = scrShot.getScreenshotAs(OutputType.FILE);
			File location =  new File("screenshots/" + dateFormat.format(date) + ".png");
			FileHandler.copy(photo, location);
		}
	
	
		driver.manage().deleteAllCookies();
		
	}	
	@AfterClass
	public void clean() {
		this.driver.quit();
	}	
			
	}




























