package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LocationPopupPage extends BasicPage{
 
	
	public LocationPopupPage(WebDriver driver, WebDriverWait waiter, JavascriptExecutor js) {
		super(driver, waiter, js);
	}	
	
	public WebElement getSelectLocation() {
		return driver.findElement(By.className("location-selector"));
	}
	
	public WebElement getCloseBtn() {
		return driver.findElement(By.linkText("Close"));       
	}
	
	public WebElement getKeyword() {
		return driver.findElement(By.id("locality_keyword"));
	}
	
	public WebElement  getLocation(String locationName) {
		return driver.findElement(By.xpath("//li/a[contains(text(), '" + locationName + "')]/.."));
	}
	
	public WebElement getLocationInput() {
		return driver.findElement(By.id("location_id"));
	}
	
	public WebElement getSubmit() {
		return driver.findElement(By.name("btn_submit"));
	}
	
	public void OpenPopup() {
		this.getSelectLocation().click();
	}
	
	
	public void addLocation (String locationName) {
		this.getSelectLocation().click();
		this.getKeyword().click();
		String location = this.getLocation(locationName).getAttribute("data-value");
		js.executeScript("arguments[0].value=arguments[1]", this.getLocationInput(), location);
		js.executeScript("arguments[0].click();", this.getSubmit());
		
	}
	
	public void closeLocationPage() {
		this.getCloseBtn().click();
	}

	
	}
	
	
	





	
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	