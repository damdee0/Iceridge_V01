package com.iceridge.testcases;

import java.util.concurrent.TimeUnit;
import org.testng.annotations.Test;
import com.iceridge.basepage.BaseClass;
import com.iceridge.pageobjects.LoginPageObjects;
import com.iceridge.testutilities.TestUtil;

public class LoginPageTest extends BaseClass
{
	
	private TestUtil testUtilities; 
	private LoginPageObjects loginPageObj;
	
	LoginPageTest()
	{
		testUtilities = new TestUtil();
	}
	
	@Test(priority=1,description="Login page...")
    public void loginPage()
    {	
		loginPageObj = new LoginPageObjects(driver);
		loginPageObj.clickSignInLnk();
		driver.manage().timeouts().implicitlyWait(testUtilities.IMPLICITWAIT_SECONDS, TimeUnit.SECONDS);
		loginPageObj.setTxtEmail(prop.getProperty("emailID"));
		logger.info("Entered Email ID");
	    loginPageObj.setTxtPassword(prop.getProperty("password"));
	    logger.info("Entered password");
	    loginPageObj.clickSignInBtn();
	   // driver.manage().timeouts().implicitlyWait(testUtilities.IMPLICITWAIT_SECONDS, TimeUnit.SECONDS);
	    String actualText = loginPageObj.getHomePageText();
	   // testUtilities.verifyDetails("LoginPage",actualText.trim(),"Awesome, you're all caught up","Not logged in succesfully","Logged in successfully"); 	
	    testUtilities.verifyDetails("LoginPage",actualText.trim(),"Matters","Not logged in successfully","Logged in successfully"); 		
    }	
}
