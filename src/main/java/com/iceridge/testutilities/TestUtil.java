package com.iceridge.testutilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.iceridge.basepage.BaseClass;

public class TestUtil extends BaseClass
{
	public long IMPLICITWAIT_SECONDS = 2000;
	static XSSFWorkbook workbook;
	static XSSFSheet sheet;
	public static String TESTSHEET_PATH = System.getProperty("user.dir")+"\\src\\main\\java\\com\\iceridge\\testdata\\IceridgeTestData.xlsx";
	static FileInputStream fis;
	public static WebDriverWait wait;
	public static DateFormat dateFormat; 
	
	public ArrayList<Object[]> getTestData(String testCase) throws EncryptedDocumentException, IOException 
	{
        ArrayList<Object[]> myData = new ArrayList<Object[]>();
        
		try 
		{
			fis = new FileInputStream(TESTSHEET_PATH);
		} 
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		}
        try 
        {
			workbook = new XSSFWorkbook(fis);
		} 
        catch (IOException e) 
        {
			e.printStackTrace();
		}
		sheet = workbook.getSheet("Sheet1");
        int numOfRows = sheet.getLastRowNum();
       // int numOfCol = sheet.getRow(0).getLastCellNum();
       // System.out.println("Number of columns = "+numOfCol);
        String title,firstName,lastName,phone,email,dob,streetNo,streetName,streetType,suburb,postCode,state,contactType,matterType,matterState,matterReference,primaryTitleRef,council,primaryClient,doc;
        
        for(int i=1; i<=numOfRows; i++)
        {
            title = sheet.getRow(i).getCell(1).getStringCellValue();
            firstName = sheet.getRow(i).getCell(2).getStringCellValue();
            lastName = sheet.getRow(i).getCell(3).getStringCellValue();
            phone = sheet.getRow(i).getCell(4).getStringCellValue();
            email = sheet.getRow(i).getCell(5).getStringCellValue();
            dob = sheet.getRow(i).getCell(6).getStringCellValue();
            //streetNo =  NumberToTextConverter.toText(sheet.getRow(i).getCell(7).getNumericCellValue());
            streetNo = sheet.getRow(i).getCell(7).getStringCellValue();
            streetName = sheet.getRow(i).getCell(8).getStringCellValue();
            streetType = sheet.getRow(i).getCell(9).getStringCellValue();
            suburb = sheet.getRow(i).getCell(10).getStringCellValue();
            postCode =  NumberToTextConverter.toText(sheet.getRow(i).getCell(11).getNumericCellValue());
            state = sheet.getRow(i).getCell(12).getStringCellValue();
            contactType = sheet.getRow(i).getCell(13).getStringCellValue();
            matterType = sheet.getRow(i).getCell(14).getStringCellValue();
            matterState = sheet.getRow(i).getCell(15).getStringCellValue();
            matterReference =  NumberToTextConverter.toText(sheet.getRow(i).getCell(16).getNumericCellValue());
            primaryTitleRef =  sheet.getRow(i).getCell(17).getStringCellValue();
            council = sheet.getRow(i).getCell(18).getStringCellValue();
            primaryClient = sheet.getRow(i).getCell(19).getStringCellValue();
            doc = sheet.getRow(i).getCell(20).getStringCellValue();
           // settlementDate = sheet.getRow(i).getCell(21).getStringCellValue();
           // contractDate = sheet.getRow(i).getCell(22).getStringCellValue();
            
            
            if(testCase.equalsIgnoreCase("clientCreation")) 
            {
            	 myData.add(new Object[]{title,firstName,lastName,phone,email,dob,streetNo,streetName,streetType,suburb,postCode,state,primaryClient});
            }
            
            else if(testCase.equalsIgnoreCase("contactCreation"))
            {
            	 myData.add(new Object[]{contactType,title,firstName,lastName,phone,email,streetNo,streetName,streetType,suburb,postCode,state});
            }
            
            else if(testCase.equalsIgnoreCase("matterCreation"))
            {
            	 myData.add(new Object[]{matterType,matterState,matterReference,primaryTitleRef,streetNo,streetName,streetType,suburb,postCode,state,council,primaryClient,doc});
            }
            //myData.add(new Object[]{title, firstName, lastName,phone,email,streetNo,streetName,streetType,suburb,postCode,state});
            
            
            
        }
        
        return myData;
       
    }
    
    
    
    public void takeScreenshot()
	{
		try
		{
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String currentDir = System.getProperty("user.dir");
		FileUtils.copyFile(src,new File(currentDir+"/screenshots/"+System.currentTimeMillis()+".png"));
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
    
    
    public static boolean waitForElementVisibility(WebElement element, int time) throws InterruptedException
	{
    	
		boolean isElementPresent = true;
		try 
		{
		wait = new WebDriverWait(driver, time);
		wait.until(ExpectedConditions.visibilityOf(element));
		Thread.sleep(1000);
		}
		catch(Exception e) 
		{
			isElementPresent = false;
		}
		return isElementPresent;
	}

    
    public static boolean waitForElementToBeClickable(WebElement element, int time) throws InterruptedException
	{
    	
		boolean isElementPresent = true;
		try 
		{
		wait = new WebDriverWait(driver, time);
		wait.until(ExpectedConditions.elementToBeClickable(element));
		Thread.sleep(1000);
		}
		catch(Exception e) 
		{
			isElementPresent = false;
		}
		return isElementPresent;
	}
    
    public static boolean waitForPresenceOfElementLocated(By locator, int time) throws InterruptedException
	{
    	
		boolean isElementPresent = true;
		try 
		{
		wait = new WebDriverWait(driver, time);
		wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		Thread.sleep(1000);
		}
		catch(TimeoutException e) 
		{
			isElementPresent = false;
		}
		return isElementPresent;
	}
    
    
    public void verifyDetails(String testCase,String actualResult,String expectedResult,String message,String successMessage)
    {
    	if(testCase.equalsIgnoreCase("LoginPage"))
    	{
    	Assert.assertEquals(actualResult, expectedResult, message);
    	logger.info(successMessage);  	
    	}
    	
    	else if(testCase.equalsIgnoreCase("ClientCreation"))
    	{
    		Assert.assertEquals(actualResult, expectedResult, message);
    	    logger.info(actualResult + " - " +successMessage); 
    	}
    	
    	
    	else if(testCase.equalsIgnoreCase("ContactCreation"))
    	{
    		Assert.assertEquals(actualResult, expectedResult, message);
    	    logger.info(actualResult + " - " + successMessage); 
    		
    	}
    	
    	else if(testCase.equalsIgnoreCase("MatterCreation"))
    	{
    	    Assert.assertEquals(actualResult, expectedResult, message);
    	    logger.info(actualResult + " - " + successMessage); 
    	}
    	
    	else if(testCase.equalsIgnoreCase("MatterInformation"))
    	{
    	    	Assert.assertEquals(actualResult, expectedResult, message);
    	    	logger.info(actualResult + " - " + successMessage); 
    	}
    	
    	else if(testCase.equalsIgnoreCase("ReceiveSignedContract"))
    	{
    	    	Assert.assertEquals(actualResult, expectedResult, message);
    	    	logger.info(actualResult + " - " + successMessage); 
    	}
    	
    	else if(testCase.equalsIgnoreCase("Logout"))
    	{
    	Assert.assertEquals(actualResult, expectedResult, message);
    	logger.info(successMessage);  	
    	}
    	
    	else
    	{
    		System.out.println("No details given to verify...");
    	}
    	}
    	
    
    
    
    public void clickuploadFile(String document) throws InterruptedException
    {
     	  try 
    	  {
    		  
    		if(document.equalsIgnoreCase("Contract of Sale"))
    		{
    		Thread.sleep(5000);	
			Runtime.getRuntime().exec(System.getProperty("user.dir")+"\\src\\main\\java\\com\\iceridge\\testdata\\COSFile.exe");
    		}
    		
    		else if(document.equalsIgnoreCase("Client Authority Form"))
    		{
    			Thread.sleep(5000);
    			Runtime.getRuntime().exec(System.getProperty("user.dir")+"\\src\\main\\java\\com\\iceridge\\testdata\\CAFFile.exe");
    		}
    	  } 
    	  catch (IOException e) 
    	  {
			e.printStackTrace();
    	  }
    	}
    
    public String setDate()
    {
    	dateFormat = new SimpleDateFormat("MM/dd/yyyy");
    	Date date = new Date();
    	return dateFormat.format(date);
    	   	 
    }
    }

