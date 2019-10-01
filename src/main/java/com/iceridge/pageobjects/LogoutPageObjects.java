package com.iceridge.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.iceridge.testutilities.TestUtil;

public class LogoutPageObjects 
{
			
			WebDriver driver;
			private Actions actionsobj;
			
		    public LogoutPageObjects(WebDriver ldriver)
		    {
		        driver = ldriver;
		        PageFactory.initElements(driver,this);

		        actionsobj = new Actions(driver);
		    }
		    		    
		    @FindBy(xpath="(//div[@class='trigger'])[1]")
		    @CacheLookup
		    WebElement lnkUsername;

		    @FindBy(xpath="//li[contains(text(),'Log out')]")
		    @CacheLookup
		    WebElement lnkLogOut;
		    
		    
		    @FindBy(xpath="//div[@class='inset']/h1")
		    @CacheLookup
		    WebElement labelSignIn;
		    
		    public void clickUsernameLnk()
		    {
		    	
		    	try 
		    	{
		    		By userName = By.xpath("(//div[@class='trigger'])[1]");
					boolean isElementPresent = TestUtil.waitForPresenceOfElementLocated(userName, 100);
					if(isElementPresent==true)
					{
						actionsobj.click(lnkUsername).build().perform();  
					}
				} 
		    	catch (InterruptedException e) 
		    	{
					e.printStackTrace();
				}
		    	
		    }
		    
		    public void clickLogoutLnk()
		    {
		    	try 
		    	{
		    		By logoutLnk = By.xpath("//li[contains(text(),'Log out')]");
					boolean isElementPresent = TestUtil.waitForPresenceOfElementLocated(logoutLnk, 100);
					if(isElementPresent==true)
					{
						actionsobj.click(lnkLogOut).build().perform(); 
					}
				} 
		    	catch (InterruptedException e) 
		    	{
					e.printStackTrace();
				}
		    	    	    
		    }
		    
		    public String getLoginPageText()
		    {
		    	//System.out.println(loggedInText.getAttribute("innerHTML"));
		    	return labelSignIn.getAttribute("innerHTML");
		    }
}
