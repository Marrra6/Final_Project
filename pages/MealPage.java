package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MealPage extends BasicPage{

	public MealPage(WebDriver driver, WebDriverWait waiter, JavascriptExecutor js) {
		super(driver, waiter, js);
	}
	
	public WebElement getMeals() {
		return driver.findElement(By.linkText("Meals"));
	}
	
	public WebElement getMealsSearch() {
		return driver.findElement(By.className("js-search-keywords"));
	}
	
	public WebElement getSearchBtn() {
		return driver.findElement(By.name("btn_submit"));
	}
	
	public WebElement getQuantity() {
		return driver.findElement(By.name("product_qty"));
	}
	
	public WebElement getFavorite() {
		return driver.findElement(By.className("favourite  itemfav link"));
	}  
				
	public WebElement getAddToCart() {
		return driver.findElement(By.linkText("Add To Cart"));
	
	}
	
	public void AddMealToCart(String quantity) {
		String amount = String.valueOf(quantity);
	    this.getQuantity().sendKeys(Keys.CONTROL, "a");
		this.getQuantity().sendKeys(amount);
		js.executeScript("arguments[0].click();", this.getAddToCart());	
	}
	
	public void AddMealToFavorite() {
		waiter.until(ExpectedConditions.elementToBeClickable(this.getFavorite()));
		this.getFavorite().click();
	
		
	}

	}
	
	


