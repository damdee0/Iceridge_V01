package com.iceridge.testcases;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.iceridge.basepage.BaseClass;
import com.iceridge.pageobjects.UploadDocObjects;
import com.iceridge.testutilities.TestUtil;

public class UploadDocTest extends BaseClass
{

	private TestUtil testUtilities; 
	private UploadDocObjects UploadDocObj;
	
	UploadDocTest()
	{
		testUtilities = new TestUtil();
	}
	
	
	@DataProvider
	public Iterator<Object[]> getTestData() throws EncryptedDocumentException, IOException
	{
		ArrayList<Object[]> data = testUtilities.getTestData("matterCreation"); 
		return data.iterator();
	}
	
	
	@Test(priority=2,dataProvider="getTestData")
	public void uploadDocuments(String doc) throws InterruptedException
	{
		UploadDocObj = new UploadDocObjects(driver);
		driver.manage().timeouts().implicitlyWait(testUtilities.IMPLICITWAIT_SECONDS, TimeUnit.SECONDS);
		UploadDocObj.clickSummaryBtn();
		UploadDocObj.clickEditBtn();
		UploadDocObj.clickEditUploadBtn();
		testUtilities.clickuploadFile(doc);
		UploadDocObj.clickSaveBtn();
		logger.info("Document loaded successfully");		
    }
}
