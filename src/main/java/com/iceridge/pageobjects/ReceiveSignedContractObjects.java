package com.iceridge.pageobjects;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.iceridge.testutilities.TestUtil;

public class ReceiveSignedContractObjects 
{
	WebDriver driver;
	private Actions actionsobj;
	private JavascriptExecutor jse;
	
    public ReceiveSignedContractObjects(WebDriver ldriver)
    {
        driver = ldriver;
        PageFactory.initElements(driver,this);

        actionsobj = new Actions(driver);       
    }
    
    
    @FindBy(xpath="//div[@class='primaryClient']/span")
    @CacheLookup
    WebElement btnSummary;

    @FindBy(xpath="//h3[text()='Receive signed contract']")
    @CacheLookup
    WebElement btnReceiveSignedContract;
    
    @FindBy(xpath="(//button[contains(text(),'Edit')])[1]")
    @CacheLookup
    WebElement btnEdit;
    
    @FindBy(xpath="//span[@class='label']/strong")
    @CacheLookup
    WebElement btnEditUpload;

    @FindBy(xpath="//div[@name='settlementDate']")
    @CacheLookup
    WebElement txtSettlementDate;

    @FindBy(xpath="//div[@name='contractDate']")
    @CacheLookup
    WebElement txtContractDate;
    
    
    @FindBy(xpath="(//button[contains(text(),'Save')])[1]")
    @CacheLookup
    WebElement btnSave;
    
    
    @FindBy(xpath="//button[contains(text(),'Confirm Date')]")
    @CacheLookup
    WebElement btnConfirmDate;
   
    @FindBy(xpath="//div[@class='FileViewer']/a")
    @CacheLookup
    WebElement addedReceiveSignedContractInfo;
    
    public void clickSummaryBtn()
    {
    	  actionsobj.click(btnSummary).build().perform(); 
    }
    
    public void clickReceiveSignedContractBtn()
    {
    	   
    	  try 
      		{
      		By saveBtn = By.xpath("//h3[text()='Receive signed contract']");
  			boolean isElementPresent = TestUtil.waitForPresenceOfElementLocated(saveBtn,100);
  			if(isElementPresent==true)
  			{
  				 
  				actionsobj.click(btnReceiveSignedContract).build().perform();
  				// Thread.sleep(5000);
  			}
  			
      		} 
      		catch (InterruptedException e) 
      		{
  			e.printStackTrace();
      		}
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
    
    public void setSettlementDate(String settlementDate)
    {
    	 jse = (JavascriptExecutor) driver;
    	 jse.executeScript("arguments[0].scrollIntoView(true);", txtSettlementDate);
    	 try 
     	{
     		By editSettlementDate = By.xpath("//div[@name='settlementDate']");
 			boolean isElementPresent = TestUtil.waitForPresenceOfElementLocated(editSettlementDate,100);
 			if(isElementPresent==true)
 			{
 				actionsobj.moveToElement(txtSettlementDate).doubleClick().sendKeys(settlementDate).build().perform();    				 
 			}
 			
 		} 
     	catch (InterruptedException e) 
     	{
 			e.printStackTrace();
 		}
    	 
    }
    
    public void setContractDate(String contractDate)
    {
    	  actionsobj.moveToElement(txtContractDate).doubleClick().sendKeys(contractDate).build().perform();
    }
   
    
    public void clickSaveBtn() throws InterruptedException
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
    
    public void clickConfirmDate()
    {
    	  actionsobj.click(btnConfirmDate).build().perform(); 
    }
    
    public String getReceiveSignedContractInfo()
    {
    	return addedReceiveSignedContractInfo.getAttribute("innerHTML");
    }
    
}

