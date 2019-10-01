package com.iceridge.testcases;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.iceridge.basepage.BaseClass;
import com.iceridge.pageobjects.CreateNewContactObjects;
import com.iceridge.testutilities.TestUtil;

public class CreateNewContactTest extends BaseClass
{

	private TestUtil testUtilities; 
	private CreateNewContactObjects createNewContactObj;
	
	CreateNewContactTest()
	{
		testUtilities = new TestUtil();
	}
	
	@DataProvider
	public Iterator<Object[]> getTestData() throws EncryptedDocumentException, IOException
	{
		ArrayList<Object[]> data = testUtilities.getTestData("contactCreation"); 
		return data.iterator();
	}
	
	
	@Test(priority=3,dataProvider="getTestData")
	public void contactCreation(String contactType,String title, String firstName, String lastName,String phone,String email,String stNo,String stName,String stType,String suburb,String postCode,String state)
	{
		createNewContactObj = new CreateNewContactObjects(driver);
		driver.manage().timeouts().implicitlyWait(testUtilities.IMPLICITWAIT_SECONDS, TimeUnit.SECONDS);
		createNewContactObj.clickContactsLnk();
		createNewContactObj.clickAddContact();
		createNewContactObj.selectContactType(contactType);
		createNewContactObj.selectTitle(title);
		createNewContactObj.setFirstName(firstName);
		createNewContactObj.setLastName(lastName);
		createNewContactObj.setPhone(phone);
		createNewContactObj.setClienttEmailID(email);
		createNewContactObj.clickManualAddressLnk();
		createNewContactObj.setStreetNo(stNo);
		createNewContactObj.setStreetName(stName);
		createNewContactObj.selStreetType(stType);
		createNewContactObj.setSuburb(suburb);
		createNewContactObj.setPostcode(postCode);
		createNewContactObj.selState(state);
		createNewContactObj.clickCreateBtn();
		String actualText = createNewContactObj.getaddedContactDetails();
		testUtilities.verifyDetails("ContactCreation",actualText.trim(),contactType,"Contact details are not added succesfully","Contact details are added successfully");		
    }
}

