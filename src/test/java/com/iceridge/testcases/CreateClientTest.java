package com.iceridge.testcases;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.iceridge.basepage.BaseClass;
import com.iceridge.pageobjects.CreateClientObjects;
import com.iceridge.testutilities.TestUtil;

public class CreateClientTest extends BaseClass
{
	private TestUtil testUtilities; 
	private CreateClientObjects createClientObj;
	
	CreateClientTest()
	{
		testUtilities = new TestUtil();
	}
	
	
	@DataProvider
	public Iterator<Object[]> getTestData() throws EncryptedDocumentException, IOException
	{
		ArrayList<Object[]> data = testUtilities.getTestData("clientCreation"); 
		return data.iterator();
	}
	
	
	@Test(priority=2,dataProvider="getTestData")
	public void clientCreation(String title, String firstName, String lastName,String phone,String email,String dob,String stNo,String stName,String stType,String suburb,String postCode,String state,String primaryClient)
	{
		createClientObj = new CreateClientObjects(driver);
		driver.manage().timeouts().implicitlyWait(testUtilities.IMPLICITWAIT_SECONDS, TimeUnit.SECONDS);
		createClientObj.clickClientsLnk();
		createClientObj.clickAddClient();
		createClientObj.selectTitle(title);
		createClientObj.setFirstName(firstName);
		createClientObj.setLastName(lastName);
		createClientObj.setPhone(phone);
		createClientObj.setClienttEmailID(email);
		createClientObj.setDOB(dob);
		createClientObj.clickManualAddressLnk();
		createClientObj.setStreetNo(stNo);
		createClientObj.setStreetName(stName);
		createClientObj.selStreetType(stType);
		createClientObj.setSuburb(suburb);
		createClientObj.setPostcode(postCode);
		createClientObj.selState(state);
		createClientObj.clickCreateBtn();
		String actualText = createClientObj.getaddedClientName();
		testUtilities.verifyDetails("ClientCreation",actualText.trim(),primaryClient,"Client details are not added succesfully","Client details are added successfully");
				
    }
}
