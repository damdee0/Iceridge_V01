package com.iceridge.pageobjects;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.iceridge.testutilities.TestUtil;

public class CreateMatterObjects 
{

	WebDriver driver;
	private Actions actionsobj;
	
	
    public CreateMatterObjects(WebDriver ldriver)
    {
        driver = ldriver;
        PageFactory.initElements(driver,this);

        actionsobj = new Actions(driver);        
    }
    
    
    @FindBy(xpath="//a[contains(text(),'Matters')]")
    @CacheLookup
    WebElement linkMatters;
    
    @FindBy(xpath="//button[contains(text(),'Create Matter')]")
    @CacheLookup
    WebElement btnCreateMatter;

    @FindBy(xpath="//div[@name='type']//span[contains(text(),'Choose One')]")
    @CacheLookup
    WebElement selMatterType;
    
    @FindBy(xpath="(//div[@class='multiselect__tags']/span)[4]")
    @CacheLookup
    WebElement selState;

    @FindBy(xpath="//button[contains(text(),'Next')]")
    @CacheLookup
    WebElement btnNext;

    @FindBy(name="matterReference")
    @CacheLookup
    WebElement txtMatterRef;
    
    
    @FindBy(name="titleReferences.0")
    @CacheLookup
    WebElement txtTitleRef;
    
    
    @FindBy(xpath="//a[@class='action-manual-address']")
    @CacheLookup
    WebElement lnkManualAddress;
    
    @FindBy(name="address.streetNumber")
    @CacheLookup
    WebElement txtStreetNo;
    
    @FindBy(name="address.streetName")
    @CacheLookup
    WebElement txtStreetName;
    
    
    @FindBy(xpath="//div[@name='address.streetType']/div[2]/span")
    @CacheLookup
    WebElement selStreetType;
    
    
    @FindBy(name="address.suburb")
    @CacheLookup
    WebElement txtSuburb;
    
    @FindBy(name="address.postcode")
    @CacheLookup
    WebElement txtPostcode;
    
    @FindBy(xpath="//div[@name='address.state']/div[2]/span")
    @CacheLookup
    WebElement sel_State;
    
    @FindBy(xpath="//span[contains(text(),'Council')]")
    @CacheLookup
    WebElement selCouncil;
    
    @FindBy(xpath="//button[contains(text(),'Next')]")
    @CacheLookup
    WebElement btnMatterNext;
    
    @FindBy(xpath="(//div[@class='multiselect__tags']/span)[1]")
    @CacheLookup
    WebElement selPrimaryClient;
    
    @FindBy(xpath="//button[contains(text(),'Create Matter')]")
    @CacheLookup
    WebElement btn_CreateMatter;
   
    
    @FindBy(xpath="//div[@class='client']/span")
    @CacheLookup
    WebElement addedMatter;
    
    public void clickMattersLnk()
    {	 
    	try 
    	{
    		By clickLinkMatters = By.xpath("//a[contains(text(),'Matters')]");
			boolean isElementPresent = TestUtil.waitForPresenceOfElementLocated(clickLinkMatters,100);
			if(isElementPresent==true)
			{
				 
				actionsobj.click(linkMatters).build().perform();	
			}
			
		} 
    	catch (InterruptedException e) 
    	{
			e.printStackTrace();
		}
    	
				 
    }		
    
    public void clickCreateMatterBtn()
    {
    	  actionsobj.click(btnCreateMatter).build().perform(); 
    }
    
    public void selectMatterType(String matterType)
    {
    	try 
    	{
    		By MatterType = By.xpath("//div[@name='type']//span[contains(text(),'Choose One')]");
			boolean isElementPresent = TestUtil.waitForPresenceOfElementLocated(MatterType,100);
			if(isElementPresent==true)
			{
				Thread.sleep(1000);
				actionsobj.moveToElement(selMatterType).click().build().perform(); 
		    	WebElement selectMatterType = driver.findElement(By.xpath("(//span[contains(text(),"+"'"+matterType+"'"+")])[1]"));
		    	actionsobj.moveToElement(selectMatterType).click().build().perform();
			}
		} 
    	catch (InterruptedException e) 
    	{
			e.printStackTrace();
		}
    	     
    }
    
        public void selectMatterState(String state)
        {
    	
			actionsobj.moveToElement(selState).click().build().perform(); 
		    WebElement selectState = driver.findElement(By.xpath("//li[@class='multiselect__element']//span[contains(text(),"+"'"+state+"'"+")]"));
		    //driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		    actionsobj.moveToElement(selectState).click().build().perform();
		} 
    	    	
    	        
    

    public void clickNextBtn()
    {			 
		actionsobj.click(btnNext).build().perform();
	}
		

    public void setMatterReference(String matterReference)
    {
    	actionsobj.moveToElement(txtMatterRef).doubleClick().sendKeys(matterReference).build().perform();
    }
    
    public void setTitleRef(String titleReference)
    {
    	actionsobj.moveToElement(txtTitleRef).doubleClick().sendKeys(titleReference).build().perform();
    }
    
   
    
    public void clickManualAddressLnk()
    {
    	try 
    	{
    		By linkManualAddress = By.xpath("//a[@class='action-manual-address']");
			boolean isElementPresent = TestUtil.waitForPresenceOfElementLocated(linkManualAddress, 100);
			if(isElementPresent==true)
			{
				actionsobj.moveToElement(lnkManualAddress).click().build().perform(); 
			}
		} 
    	catch (InterruptedException e) 
    	{
			e.printStackTrace();
		}
    	
    }
    
    public void setStreetNo(String StreetNo)
    {
    	actionsobj.moveToElement(txtStreetNo).doubleClick().sendKeys(StreetNo).build().perform();
    }
    
    public void setStreetName(String streetName)
    {
    	actionsobj.moveToElement(txtStreetName).doubleClick().sendKeys(streetName).build().perform();
    }
    
    
    public void selStreetType(String stType)
    {
    	actionsobj.moveToElement(selStreetType).click().build().perform();
    	WebElement streetType = driver.findElement(By.xpath("(//span[contains(text(),"+"'"+stType+"'"+")])[1]"));
    	actionsobj.moveToElement(streetType).click().build().perform();
    }
    
    public void setSuburb(String suburb)
    {
    	actionsobj.moveToElement(txtSuburb).doubleClick().sendKeys(suburb).build().perform();
    }
    
    public void setPostcode(String postcode)
    {
    	actionsobj.moveToElement(txtPostcode).doubleClick().sendKeys(postcode).build().perform();
    }
    
    
    public void selState(String state)
    {
    	actionsobj.moveToElement(sel_State).click().build().perform();
    	WebElement selectState = driver.findElement(By.xpath("(//span[contains(text(),"+"'"+state+"'"+")])[1]"));
    	actionsobj.moveToElement(selectState).click().build().perform();
    }
    
    
    public void selCouncil(String council)
    {
    	actionsobj.moveToElement(selCouncil).click().build().perform();
    	WebElement selectCouncil = driver.findElement(By.xpath("(//span[contains(text(),"+"'"+council+"'"+")])[1]"));
    	actionsobj.moveToElement(selectCouncil).click().build().perform();
    }
    
    
    public void clickMatterNextBtn()
    {
    	
    	try 
    	{
    		By clickNextBtn = By.xpath("//button[contains(text(),'Next')]");
			boolean isElementPresent = TestUtil.waitForPresenceOfElementLocated(clickNextBtn,100);
			if(isElementPresent==true)
			{
				
				actionsobj.click(btnMatterNext).build().perform(); 
			}
		} 
    	catch (InterruptedException e) 
    	{
			e.printStackTrace();
		} 
    	
    }
    
    
    public void selPrimaryClient(String primaryClient)
    {
    	actionsobj.moveToElement(selPrimaryClient).click().build().perform();
    	WebElement inputText = driver.findElement(By.xpath("//input[@type='text' and @placeholder='Primary Client']"));
    	actionsobj.moveToElement(inputText).doubleClick().sendKeys(primaryClient).sendKeys(Keys.ENTER).build().perform();
    	//WebElement selectPrimaryClient = driver.findElement(By.xpath("//span[contains(text(),"+"'"+selPrimaryClient+"'"+")]"));
    	//actionsobj.moveToElement(selectPrimaryClient).click().build().perform();
    	/*try 
    	{
    		By primary_Client = By.xpath("(//div[@class='multiselect__tags']/span)[1]");
			boolean isElementPresent = TestUtil.waitForPresenceOfElementLocated(primary_Client,100);
			if(isElementPresent==true)
			{
				
				actionsobj.moveToElement(selPrimaryClient).click().build().perform();
		    	WebElement selectPrimaryClient = driver.findElement(By.xpath("//li[@class='multiselect__element']//span[contains(text(),"+"'"+primaryClient+"'"+")]"));
		    	actionsobj.moveToElement(selectPrimaryClient).click().build().perform();
		    	Thread.sleep(100);
			}
		} 
    	catch (InterruptedException e) 
    	{
			e.printStackTrace();
		}   */	 
    	
    }
    
    public void clkCreateMatterBtn()
    {
    	actionsobj.click(btn_CreateMatter).build().perform();      
    }
    
    public String getaddedMatterDetails()
    {
    	//System.out.println(addedMatter.getAttribute("innerHTML"));
    	return addedMatter.getAttribute("innerHTML");
    }
    	
}
	

