package tests;

import java.io.File;
import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.Test;


public class ProfileTest extends BasicTest {
	
	@Test (priority = 1)
	
	public void editProfile() throws InterruptedException {
		driver.get( baseURL + "/guest-user/login-form"); 
		locationPopUpPage.getCloseBtn();
		
		loginPage.Login(email, password);
		boolean login = notificationSistemPage.getMessage().contains("Login successful.");
		Assert.assertTrue(login,
				"[ERROR] Login not successful.");
		
		
		driver.get(baseURL + "/member/profile");
		profilePage.ProfileSetup("Marija", "Kostic", "kostic.marija89@yahoo.com", "Tome Rosandica 1/13", "069/ 18 44 927", "18000", "United States", "California", "Los Angeles");
		boolean setup = notificationSistemPage.getMessage().contains("Setup successful.");
		Assert.assertTrue(setup, 
				"[ERROR] Setup failed.");
		
		authPage.getLogout();
		boolean logout = notificationSistemPage.getMessage().contains("Logout successful.");
		Assert.assertTrue(logout,
                "[ERROR] Logout failed.");
		
		
	}
	
	@Test (priority = 2)
	
	public void ChangeProfileImgTest() throws InterruptedException, IOException {
		driver.get(baseURL + "/guest-user/login-form");
		locationPopUpPage.getCloseBtn();
		loginPage.Login(email,password);
		boolean login = notificationSistemPage.getMessage().contains("Login successful.");
		Assert.assertTrue(login, 
				"[ERROR] Login not successful.");
		
		driver.get(baseURL + "/member/profile");
		
		String imgPath = new File("images/slika.png").getCanonicalPath();
		profilePage.UploadProfilePhoto(imgPath);
	    Assert.assertEquals(notificationSistemPage.getMessage().contains("Profile image uploaded successfully."), 
	    		"[ERROR] The profile image isn't uploaded.");
	   
	   notificationSistemPage.notificationDisappear();
	    
	    profilePage.RemovePhoto(); 
	    Assert.assertEquals(notificationSistemPage.getMessage().contains ("Profile image deleted successfully."),
	    		"[ERROR] The profile image isn't deleted.");
	    
	    notificationSistemPage.notificationDisappear();
	    
	    authPage.logOut();
	    Assert.assertEquals(notificationSistemPage.getMessage().contains ("Logout Successful."),
	    		"[ERROR] Logout not successful");
	
	
		
	
	
	}
}
