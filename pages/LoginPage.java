package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BasicPage {

	public LoginPage(WebDriver driver2, WebDriverWait waiter, JavascriptExecutor js) {
		super(driver2, waiter, js);
		
	}
	
	public WebElement getLogin() {
		return driver.findElement(By.linkText("Login"));
	}
	
	public WebElement getUsername() {
		return driver.findElement(By.name("username"));
	}
	
	public WebElement getPassword() {
		return driver.findElement(By.name("password"));
	}
	
	public WebElement getLoginBtn() {
		return driver.findElement(By.name("btn_submit"));
	}
	
	public void Login(String email, String password) {
		this.getLogin().click();
		this.getUsername().sendKeys(Keys.CONTROL + "a" + Keys.DELETE);
		this.getUsername().sendKeys(email);
		this.getPassword().sendKeys(Keys.CONTROL + "a" + Keys.DELETE);
		this.getPassword().sendKeys(password);
		this.getLoginBtn().click();
	}
	
	

}
