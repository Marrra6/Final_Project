package tests;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class MealItemTest extends BasicTest{
	
	@Test (priority = 1)
	public void AddMealToCart() throws InterruptedException {
		driver.get(baseURL + "/meal/lobster-shrimp-chicken-quesadilla-combo");
		locationPopUpPage.getCloseBtn();
		
		mealPage.AddMealToCart("6");
		boolean firstMessage = notificationSistemPage.getMessage().contains("The Following Errors Occurred");
		boolean secondMessage = notificationSistemPage.getMessage().contains ("Please Select Location");
		Assert.assertTrue(firstMessage,
		                 "[ERROR] Message is not displayed.");
		Assert.assertTrue(secondMessage,
		                 "[ERROR] Message is not displayed.");
		
		notificationSistemPage.notificationDisappear();
		
		locationPopUpPage.addLocation("City Center - Albany");
		Thread.sleep(3000);
		
		mealPage.AddMealToCart("4");
		boolean messageMealAddedToCart = notificationSistemPage.getMessage().contains("Meal Added To Cart");
		Assert.assertTrue(messageMealAddedToCart,
				         "[ERROR] Message is not displayed.");
	}
	
	@Test (priority = 2)
	public void AddMealToFavorite() throws InterruptedException {
		driver.get(baseURL + "/meal/lobster-shrimp-chicken-quesadilla-combo");
		locationPopUpPage.getCloseBtn();
		
		mealPage.AddMealToFavorite();
		Thread.sleep(3000);
		boolean message = notificationSistemPage.getMessage().contains("Please login first");
		Assert.assertTrue(message,
		                 "[ERROR] Message is not displayed.");
		
		driver.get(baseURL + "/guest-user/login-form");
		loginPage.Login(email, password);
		driver.get(baseURL + "meal/lobster-shrimp-chicken-quesadilla-combo");
		mealPage.AddMealToFavorite();
		Thread.sleep(3000);
		boolean favoriteMeal = notificationSistemPage.getMessage().contains("Product has been added to your favorites.");
		Assert.assertTrue(favoriteMeal,
		                 "[ERROR] Message is not displayed.");
			
	}
	
	@Test (priority = 3)
	public void ClearCart () throws IOException  {
		driver.get(baseURL + "/meals");
		locationPopUpPage.addLocation("City Center - Albany");
		SoftAssert sa = new SoftAssert();

        File file = new File("data/Data.xlsx");
		FileInputStream fis = new FileInputStream(file);
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheet("Meals");
		
		DataFormatter format = new DataFormatter();
		
		for (int i = 1; i < 7 + 1; i++) {
			String url = sheet.getRow(i).getCell(0).getStringCellValue();
			format.formatCellValue(sheet.getRow(i).getCell(1));
			driver.get(url);
			
			mealPage.AddMealToCart("2"); 
			sa.assertTrue(notificationSistemPage.getMessage().contains("Meal added to cart"),
					"[ERROR] Message is not displayed.");
			
			
		}
		
			cartSummaryPage.ClearAll();

			Assert.assertTrue(notificationSistemPage.getMessage().contains("All meals removed from cart successfully"),
					"[ERROR] Message not displayed..");

			workbook.close();
			fis.close();
		}		
	}
		
		
	
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	


