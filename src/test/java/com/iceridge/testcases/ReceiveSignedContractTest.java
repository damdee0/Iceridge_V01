package com.iceridge.testcases;

import java.util.concurrent.TimeUnit;
import org.testng.annotations.Test;
import com.iceridge.basepage.BaseClass;
import com.iceridge.pageobjects.ReceiveSignedContractObjects;
import com.iceridge.testutilities.TestUtil;

public class ReceiveSignedContractTest extends BaseClass
{
	private TestUtil testUtilities; 
	private ReceiveSignedContractObjects ReceiveSignedContractObj;
	
	ReceiveSignedContractTest()
	{
		testUtilities = new TestUtil();
	}
	
	@Test(priority=2,dataProvider="DataInput",dataProviderClass=TestUtil.class)
	public void clientCreation(String settlementDate,String contractDate) throws InterruptedException
	{
		ReceiveSignedContractObj = new ReceiveSignedContractObjects(driver);
		driver.manage().timeouts().implicitlyWait(testUtilities.IMPLICITWAIT_SECONDS, TimeUnit.SECONDS);
		ReceiveSignedContractObj.clickSummaryBtn();
		ReceiveSignedContractObj.clickReceiveSignedContractBtn();
		ReceiveSignedContractObj.setSettlementDate(settlementDate);
		ReceiveSignedContractObj.setContractDate(contractDate);
		ReceiveSignedContractObj.clickSaveBtn();
		ReceiveSignedContractObj.clickConfirmDate();
		logger.info("Received Signed Contract successfully");		
    }
}
