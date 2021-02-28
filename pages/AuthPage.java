package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AuthPage extends BasicPage {

	public AuthPage(WebDriver driver2, WebDriverWait waiter, JavascriptExecutor js) {
		super(driver2, waiter, js);
	
	}
	
	public WebElement getUser() {
		return driver.findElement(By.className("after-arrow"));
	}
	
	public WebElement getMyAccount() {
		return driver.findElement(By.linkText("My Account"));
	}
	
	public WebElement getLogout() {
		return driver.findElement(By.linkText("Logout"));
	}
	
	public void logOut() {
		this.getUser().click();
		this.getLogout().click();
		
	}
}
