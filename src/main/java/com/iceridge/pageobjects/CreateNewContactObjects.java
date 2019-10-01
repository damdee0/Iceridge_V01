package com.iceridge.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.iceridge.testutilities.TestUtil;

public class CreateNewContactObjects 
{

	WebDriver driver;
	private Actions actionsobj;
	
	
    public CreateNewContactObjects(WebDriver ldriver)
    {
        driver = ldriver;
        PageFactory.initElements(driver,this);

        actionsobj = new Actions(driver);        
    }
    
    
    @FindBy(xpath="(//a[contains(text(),'Contacts')])[1]")
    @CacheLookup
    WebElement linkContacts;

    @FindBy(xpath="//button[@class='Button size-normal variant-primary-round ']")
    @CacheLookup
    WebElement clkAddContact;
    
    @FindBy(xpath="(//div[@class='multiselect__tags']/span)[1]")
    @CacheLookup
    WebElement selContactType;

    @FindBy(xpath="//span[contains(text(),'Title')]")
    @CacheLookup
    WebElement selTitle;

    @FindBy(xpath="//input[@placeholder='First Name' and @name='givenName']")
    @CacheLookup
    WebElement txtFirstName;
    
    
    @FindBy(xpath="//input[@placeholder='Last Name' and @name='familyName']")
    @CacheLookup
    WebElement txtLastName;
    
    
    @FindBy(xpath="//input[@placeholder='Phone' and @name='phone']")
    @CacheLookup
    WebElement txtPhone;
    
    @FindBy(xpath="//input[@placeholder='Email' and @name='email']")
    @CacheLookup
    WebElement txClienttEmailID;
    
    
    @FindBy(xpath="//a[@class='action-manual-address']")
    @CacheLookup
    WebElement lnkManualAddress;
    
    
    @FindBy(name="address.streetNumber")
    @CacheLookup
    WebElement txtStreetNo;
    
    
    @FindBy(name="address.streetName")
    @CacheLookup
    WebElement txtStreetName;
       
    @FindBy(xpath="//span[contains(text(),'- None -')]")
    @CacheLookup
    WebElement selStreetType;
    
    @FindBy(name="address.suburb")
    @CacheLookup
    WebElement txtSuburb;
    
    @FindBy(name="address.postcode")
    @CacheLookup
    WebElement txtPostcode;
    
    @FindBy(xpath="(//div[@class='multiselect__tags']/span)[4]")
    @CacheLookup
    WebElement selState;
    
    @FindBy(xpath="//button[contains(text(),'Create')]")
    @CacheLookup
    WebElement btnCreate;
   
    @FindBy(xpath="//div[@class='input']/span")
    @CacheLookup
    WebElement addedContact;
    
    public void clickContactsLnk()
    {
    	
    	try 
    	{
    		By clickLinkContacts = By.xpath("(//a[contains(text(),'Contacts')])[1]");
			boolean isElementPresent = TestUtil.waitForPresenceOfElementLocated(clickLinkContacts, 100);
			if(isElementPresent==true)
			{
				actionsobj.click(linkContacts).build().perform();  	
			}
		} 
    	catch (InterruptedException e) 
    	{
			e.printStackTrace();
		}
    	  
    }
    
    public void clickAddContact()
    {
    	try 
    	{
    		By AddContact = By.xpath("//button[@class='Button size-normal variant-primary-round ']");
			boolean isElementPresent = TestUtil.waitForPresenceOfElementLocated(AddContact, 100);
			if(isElementPresent==true)
			{
				actionsobj.click(clkAddContact).build().perform(); 	
			}
		} 
    	catch (InterruptedException e) 
    	{
			e.printStackTrace();
		}
    	     
    }
    
    
    public void selectContactType(String contactType)
    {
    	try 
    	{
    		By ContactType = By.xpath("(//div[@class='multiselect__tags']/span)[1]");
			boolean isElementPresent = TestUtil.waitForPresenceOfElementLocated(ContactType,100);
			if(isElementPresent==true)
			{
				actionsobj.moveToElement(driver.findElement(By.xpath("(//div[@class='multiselect__tags']/span)[1]"))).click().build().perform(); 
		    	WebElement selectContactType = driver.findElement(By.xpath("//span[contains(text(),"+"'"+contactType+"'"+")]"));
		    	actionsobj.moveToElement(selectContactType).click().build().perform();
			}
		} 
    	catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
    	catch (StaleElementReferenceException e) 
    	{
    		By ContactType = By.xpath("(//div[@class='multiselect__tags']/span)[1]");
			boolean isElementPresent;
			try 
			{
				isElementPresent = TestUtil.waitForPresenceOfElementLocated(ContactType,100);
				if(isElementPresent==true)
				{
					actionsobj.moveToElement(selContactType).click().build().perform(); 
			    	WebElement selectContactType = driver.findElement(By.xpath("//span[contains(text(),"+"'"+contactType+"'"+")]"));
			    	actionsobj.moveToElement(selectContactType).click().build().perform();
				}
			} 
			catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		}    	
    	        
    }
    

    public void selectTitle(String title)
    {
    	try 
    	{
    		By titleSelect = By.xpath("//span[contains(text(),'Title')]");
			boolean isElementPresent = TestUtil.waitForPresenceOfElementLocated(titleSelect,100);
			if(isElementPresent==true)
			{
				actionsobj.moveToElement(selTitle).click().build().perform(); 
		    	WebElement selectTitle = driver.findElement(By.xpath("//span[contains(text(),"+"'"+title+"'"+")]"));
		    	actionsobj.moveToElement(selectTitle).click().build().perform();
			}
		} 
    	catch (InterruptedException e) 
    	{
			e.printStackTrace();
		}   	        
    }

    public void setFirstName(String firstName)
    {
    	actionsobj.moveToElement(txtFirstName).doubleClick().sendKeys(firstName).build().perform();
    }
    
    public void setLastName(String lastName)
    {
    	actionsobj.moveToElement(txtLastName).doubleClick().sendKeys(lastName).build().perform();
    }
    
    
    public void setPhone(String phone)
    {
    	actionsobj.moveToElement(txtPhone).doubleClick().sendKeys(phone).build().perform();
    }
    
    public void setClienttEmailID(String email)
    {
    	actionsobj.moveToElement(txClienttEmailID).doubleClick().sendKeys(email).build().perform();
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
    	actionsobj.moveToElement(selState).click().build().perform();
    	WebElement selectState = driver.findElement(By.xpath("(//span[contains(text(),"+"'"+state+"'"+")])[1]"));
    	actionsobj.moveToElement(selectState).click().build().perform();
    }
    
    
    public void clickCreateBtn()
    {
    	actionsobj.click(btnCreate).build().perform();      
    }
    
    public String getaddedContactDetails()
    {
    	return addedContact.getAttribute("innerHTML");
    }
	
}
