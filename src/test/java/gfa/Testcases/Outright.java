package gfa.Testcases;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import GoldenFalcon.gfa.CRM_PN_details;
import GoldenFalcon.gfa.Crm_lead_listingpage;
import GoldenFalcon.gfa.HeaderMenus;
import GoldenFalcon.gfa.crm_lead;
import GoldenFalcon.gfaTestComponents.Base;
import dataset.DataReader;

public class Outright extends Base{
	
	
	public crm_lead createlead;
	
	
	@Test (priority ='1')
	public void goTo_CRM()
	{
		HeaderMenus menu = new HeaderMenus(driver);
		menu.click_menulist();
		menu.click_CRM();
		Assert.assertEquals("Pipeline", menu.crm_text());
		
	}
	@Test(priority='2')
	public void create_lead() throws InterruptedException
	{
		Crm_lead_listingpage leadcreation = new Crm_lead_listingpage(driver);
		leadcreation.click_create();
	
		Assert.assertEquals( leadcreation.verify_new(),"New");
	}
	
	@Test(priority='3', dataProvider="dataSet")
	public void createOutrightlead(HashMap<String, String>input) throws InterruptedException
	{
		crm_lead createlead = new crm_lead(driver);
		createlead.selectCustomer(input.get("customername"));
		createlead.selectSalesperson(input.get("salespersonname"));
		createlead.rfQRef(input.get("rfqref"));
		createlead.selectPrioity(input.get("priority"));
		createlead.clickAddPn();
		
	}
	@Test(priority='4')
	public void addPN() throws InterruptedException
	{
		CRM_PN_details pn = new CRM_PN_details (driver);
		pn.addPndetails("	101-555309-0001");
	}
	@Test(priority='5')
	public void savecrmlead()
	{
		crm_lead createlead = new crm_lead(driver);
		createlead.saveLead();
		createlead.getleadNumber();
	}
	
	@Test(priority='6')
	public void addvendor() throws InterruptedException
	{
		crm_lead createlead = new crm_lead(driver);
		createlead.addVendor("The Boeing Company");
	}
	@Test(priority='7')
	public void verifystage()
	{
		
		crm_lead createlead = new crm_lead(driver);
		String currentStage = createlead.verifyCorrentState();
		Assert.assertEquals(currentStage, "RFQ");
	}
	@DataProvider
	public Object[][] dataSet() throws IOException
	{
		DataReader data = new DataReader();
		List<HashMap<String, String>> datas =data.getJsonData(System.getProperty("user.dir") + "\\src\\test\\java\\dataset\\leaddata.json");
		return new Object [][] {{datas.get(0)}};
		}

}
