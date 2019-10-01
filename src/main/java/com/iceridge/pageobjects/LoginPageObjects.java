package com.iceridge.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



public class LoginPageObjects 
{
	WebDriver driver;
	private Actions actionsobj;
	
    public LoginPageObjects(WebDriver ldriver)
    {
        driver = ldriver;
        PageFactory.initElements(driver,this);

        actionsobj = new Actions(driver);
    }
    
    
    @FindBy(xpath="//button[text()='Sign in']")
    @CacheLookup
    WebElement lnkSignIn;

    @FindBy(xpath="//input[@name='email' and @placeholder='me@example.com']")
    @CacheLookup
    WebElement txtEmail;

    @FindBy(xpath="//input[@name='password' and @placeholder='6-18 characters']")
    @CacheLookup
    WebElement txtPassword;

    @FindBy(xpath="//button[@type='submit']")
    @CacheLookup
    WebElement btnSignIn;
    
    
    //@FindBy(xpath="//div[@class='NullState']/h1")
    @FindBy(xpath="//header[@class='TaskHeader']/h2")
    @CacheLookup
    WebElement loggedInText;
    
    public void clickSignInLnk()
    {
    	actionsobj.click(lnkSignIn).build().perform(); 
    }
    
    public void setTxtEmail(String emailID)
    {
    	actionsobj.moveToElement(txtEmail).doubleClick().sendKeys(emailID).build().perform();    	    
    }

    public void setTxtPassword(String password)
    {
    	actionsobj.moveToElement(txtPassword).doubleClick().sendKeys(password).build().perform();     	
    }

    public void clickSignInBtn()
    {
    	actionsobj.click(btnSignIn).build().perform(); 
    }
    
    public String getHomePageText()
    {
    	//System.out.println(loggedInText.getAttribute("innerHTML"));
    	return loggedInText.getAttribute("innerHTML");
    }
}

