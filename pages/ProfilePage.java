package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProfilePage extends BasicPage {


	public ProfilePage(WebDriver driver2, WebDriverWait waiter, JavascriptExecutor js) {
		super(driver2, waiter, js);
		
	}
	
	public WebElement getPersonalInfo() {
		return driver.findElement(By.className("after-arrow user-trigger-js"));
	}
	
	public WebElement getMyAcc() {
		return driver.findElement(By.linkText("My Account"));
	}
	
	public WebElement getProfile() {
		return driver.findElement(By.linkText("Profile"));
	}
	
	public WebElement getFirstName() {
		return  driver.findElement(By.name("user_first_name"));
	}
	
	public WebElement getLastName() {
		return driver.findElement(By.name("user_last_name"));
	}
	
	public WebElement getEmail() {
		return driver.findElement(By.name("user_email"));
	}
	
	public WebElement getAddress() {
		return driver.findElement(By.name("user_address"));
	}
	
	public WebElement getPhoneNumber() {
		return driver.findElement(By.name("user_phone"));
	}
	
	
	public WebElement getZipCode() {
		return driver.findElement(By.name("user_zip"));
	}
	
	public Select getCountry() {
		Select country = new Select(driver.findElement(By.id("user_country_id")));
		return country;
	}
	
	public Select getState() {
		Select state = new Select (driver.findElement(By.id("user_state_id")));
		return state;
	}
	
	public Select getCity() {
		Select city = new Select (driver.findElement(By.id("user_city")));
		return city;
	}
	
	public WebElement getSaveBtn() {
		return driver.findElement(By.name("btn_submit"));
	}
	
	public WebElement getCurrentPassword() {
		return driver.findElement(By.name("current_password"));
	}
	
	public WebElement getNewPassword() {
		return driver.findElement(By.name("new_password"));
	}
	
	public WebElement getConfirmNewPassword() {
		return driver.findElement(By.name("conf_new_password"));
	
	}
	
	public WebElement getRemoveBtn() {
		return driver.findElement(By.className("remove"));
	}
	
	public void getUploadBtn() {
		WebElement Photo =  driver.findElement(By.xpath("//*[@tittle-'Upload']"));
		js.executeScript("arguments[0].click();", Photo);
	}
	
	public void UploadProfilePhoto(String imgPath) {
		this.getUploadBtn();
		driver.findElement(By.xpath("//input[@type='file']")).sendKeys(imgPath);;
	}
	
	public void RemovePhoto() {
		js.executeScript("arguments[0].click();", getRemoveBtn());
	}
	
	
	public void ProfileSetup(String FirstName, String LastName, String Email,
			String Address, String PhoneNumber, String ZipCode, String Country, String State, String City ) {
		this.getFirstName().sendKeys(Keys.CONTROL,"a"+ Keys.DELETE);
		this.getFirstName().sendKeys("Ronald");
		this.getLastName().sendKeys(Keys.CONTROL,"a"+ Keys.DELETE);
		this.getLastName().sendKeys("Williams");
		this.getEmail().sendKeys(Keys.CONTROL,"a"+ Keys.DELETE);
		this.getEmail().sendKeys("customer@dummyid.com");
		this.getAddress().sendKeys(Keys.CONTROL,"a"+ Keys.DELETE);
		this.getAddress().sendKeys("123");
		this.getPhoneNumber().sendKeys(Keys.CONTROL,"a"+ Keys.DELETE);
		this.getPhoneNumber().sendKeys("9856321478");
		this.getZipCode().sendKeys(Keys.CONTROL,"a"+ Keys.DELETE);
		this.getZipCode().sendKeys("75024");
		
		this.getCountry().selectByVisibleText("United States");
		this.getState().selectByVisibleText("California");
		this.getCity().selectByVisibleText("Los Angeles");
		
		this.getSaveBtn();
		
	}


		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

