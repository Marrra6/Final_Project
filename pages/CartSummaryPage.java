package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CartSummaryPage extends BasicPage {

	public CartSummaryPage(WebDriver driver2, WebDriverWait waiter, JavascriptExecutor js) {
		super(driver2, waiter, js);
	}
	
	public WebElement getClearAllButton() {
		return driver.findElement(By.linkText("Clear All"));
	}
	
	public void ClearAll() {
		this.getClearAllButton().click();
	}

}
