package com.iceridge.testcases;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.iceridge.basepage.BaseClass;
import com.iceridge.pageobjects.CreateMatterObjects;
import com.iceridge.pageobjects.ReceiveSignedContractObjects;
import com.iceridge.pageobjects.UploadDocObjects;
import com.iceridge.testutilities.TestUtil;

public class CreateMatterTest extends BaseClass 
{

	private TestUtil testUtilities; 
	private CreateMatterObjects createMatterObj;
	private UploadDocObjects UploadDocObj;
	private ReceiveSignedContractObjects ReceiveSignedContractObj;
	
	CreateMatterTest()
	{
		testUtilities = new TestUtil();
	}
	
	@DataProvider
	public Iterator<Object[]> getTestData() throws EncryptedDocumentException, IOException
	{
		ArrayList<Object[]> data = testUtilities.getTestData("matterCreation"); 
		return data.iterator();
	}
	
	
	@Test(priority=4,dataProvider="getTestData")
	public void matterCreation(String matterType,String matterState,String matterReference,String titleReference,String stNo,String stName,String stType,String suburb,String postCode,String state,String council,String primaryClient,String doc) throws InterruptedException
	{
		createMatterObj = new CreateMatterObjects(driver);
		driver.manage().timeouts().implicitlyWait(testUtilities.IMPLICITWAIT_SECONDS, TimeUnit.SECONDS);
		createMatterObj.clickMattersLnk();
		createMatterObj.clickCreateMatterBtn();
		createMatterObj.selectMatterType(matterType);
		createMatterObj.selectMatterState(matterState);
		createMatterObj.clickNextBtn();
		createMatterObj.setMatterReference(matterReference);
		createMatterObj.setTitleRef(titleReference);
		createMatterObj.clickManualAddressLnk();
		createMatterObj.setStreetNo(stNo);
		createMatterObj.setStreetName(stName);
		createMatterObj.selStreetType(stType);
		createMatterObj.setSuburb(suburb);
		createMatterObj.setPostcode(postCode);
		createMatterObj.selState(state);
		createMatterObj.selCouncil(council);
		createMatterObj.clickMatterNextBtn();
		createMatterObj.selPrimaryClient(primaryClient);
		createMatterObj.clkCreateMatterBtn();
		
		String actualText = createMatterObj.getaddedMatterDetails();
		testUtilities.verifyDetails("MatterCreation",actualText.trim(),primaryClient,"Matter details are not added succesfully","Matter details are added successfully");
	
		
		UploadDocObj = new UploadDocObjects(driver);
		UploadDocObj.clickEditBtn();
		UploadDocObj.clickEditUploadBtn();
		testUtilities.clickuploadFile(doc);
		UploadDocObj.clickSaveBtn();
		
		String actualDoc = UploadDocObj.getaddedMatterInfo();
		testUtilities.verifyDetails("MatterInformation",actualDoc.trim(),doc+".pdf","Document is not uploaded succesfully","Document is uploaded succesfully");
		
		
		ReceiveSignedContractObj = new ReceiveSignedContractObjects(driver);
		ReceiveSignedContractObj.clickReceiveSignedContractBtn();
		ReceiveSignedContractObj.clickEditBtn();
		ReceiveSignedContractObj.clickEditUploadBtn();
		testUtilities.clickuploadFile(doc);
		ReceiveSignedContractObj.setSettlementDate(testUtilities.setDate());
		ReceiveSignedContractObj.setContractDate(testUtilities.setDate());
		ReceiveSignedContractObj.clickSaveBtn();
		ReceiveSignedContractObj.clickConfirmDate();
		
		String actualDocument = ReceiveSignedContractObj.getReceiveSignedContractInfo();
		testUtilities.verifyDetails("ReceiveSignedContract",actualDocument.trim(),doc+".pdf","Received Signed Contract details not added successfully","Received Signed Contract details added successfully");
		//logger.info("Received Signed Contract details added successfully");
		}
		
		
    }


