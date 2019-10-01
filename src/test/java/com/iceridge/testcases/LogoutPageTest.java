package com.iceridge.testcases;

import java.util.concurrent.TimeUnit;


import org.testng.annotations.Test;

import com.iceridge.basepage.BaseClass;
import com.iceridge.pageobjects.LogoutPageObjects;
import com.iceridge.testutilities.TestUtil;

public class LogoutPageTest extends BaseClass
{
	private TestUtil testUtilities; 
	private LogoutPageObjects logoutPageObj;
	
	LogoutPageTest()
	{
		testUtilities = new TestUtil();
		
	}
	
	@Test(priority=5,description="Logout page...")
    public void logoutPage()
    {	
		logoutPageObj = new LogoutPageObjects(driver);
		driver.manage().timeouts().implicitlyWait(testUtilities.IMPLICITWAIT_SECONDS, TimeUnit.SECONDS);
		logoutPageObj.clickUsernameLnk();
		//logger.info("Clicked on username");
		logoutPageObj.clickLogoutLnk();
		
		
		String actualText = logoutPageObj.getLoginPageText();
		testUtilities.verifyDetails("Logout",actualText.trim(),"Sign In","Not logged out successfully","Logged out successfully");
		
    }	
}
