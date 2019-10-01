package com.iceridge.pageobjects;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.iceridge.testutilities.TestUtil;

public class UploadDocObjects 
{

	WebDriver driver;
	private Actions actionsobj;
	
	
    public UploadDocObjects(WebDriver ldriver)
    {
        driver = ldriver;
        PageFactory.initElements(driver,this);

        actionsobj = new Actions(driver);       
    }
    
    
    @FindBy(xpath="//div[@class='primaryClient']/span")
    @CacheLookup
    WebElement btnSummary;

    @FindBy(xpath="(//button[contains(text(),'Edit')])[1]")
    @CacheLookup
    WebElement btnEdit;

    @FindBy(xpath="//span[@class='label']/strong")
    @CacheLookup
    WebElement btnEditUpload;

    @FindBy(xpath="//a[contains(text(),'Choose a file to upload')]")
    @CacheLookup
    WebElement uploadFile;
    
    
    @FindBy(xpath="(//button[contains(text(),'Save')])[1]")
    @CacheLookup
    WebElement btnSave;
   
    
    @FindBy(xpath="//div[@class='FileViewer']/a")
    @CacheLookup
    WebElement addedMatterInfo;
    
    public void clickSummaryBtn()
    {
    	  actionsobj.click(btnSummary).build().perform(); 
    }
    
    public void clickEditBtn()
    {
    	 
    	  	try 
        	{
        		By clickEditBtn = By.xpath("(//button[contains(text(),'Edit')])[1]");
    			boolean isElementPresent = TestUtil.waitForPresenceOfElementLocated(clickEditBtn,100);
    			if(isElementPresent==true)
    			{
    				 
    				actionsobj.click(btnEdit).build().perform(); 
    			}
    			
    		} 
        	catch (InterruptedException e) 
        	{
    			e.printStackTrace();
    		}
    }
    
    public void clickEditUploadBtn()
    {
    	 
    	  try 
      		{
      		By editUploadbtn = By.xpath("//span[@class='label']/strong");
  			boolean isElementPresent = TestUtil.waitForPresenceOfElementLocated(editUploadbtn,100);
  			if(isElementPresent==true)
  			{
  				 actionsobj.click(btnEditUpload).build().perform(); 
  				 
  			}
  			
      		} 
      		catch (InterruptedException e) 
      		{
  			e.printStackTrace();
      		}
    }
    
    
    
    public void clickSaveBtn()
    {
    	
    	try 
    	{
    		By saveBtn = By.xpath("(//button[contains(text(),'Save')])[1]");
			boolean isElementPresent = TestUtil.waitForPresenceOfElementLocated(saveBtn,100);
			if(isElementPresent==true)
			{
				 
				 actionsobj.click(btnSave).build().perform(); 	
				 Thread.sleep(5000);
			}
			
		} 
    	catch (InterruptedException e) 
    	{
			e.printStackTrace();
		}
    	 
    }
    
    public String getaddedMatterInfo()
    {
    	return addedMatterInfo.getAttribute("innerHTML");
    }
    
}
