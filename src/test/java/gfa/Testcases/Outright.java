package gfa.Testcases;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import GoldenFalcon.gfa.Crm_lead_listingpage;
import GoldenFalcon.gfa.HeaderMenus;
import GoldenFalcon.gfa.crm_lead;
import GoldenFalcon.gfaTestComponents.Base;
import dataset.DataReader;

public class Outright extends Base{
	
	
	
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
		createlead.selectPrioity(input.get("priorty"));
		
	}
	@DataProvider
	public Object[][] dataSet() throws IOException
	{
		DataReader data = new DataReader();
		List<HashMap<String, String>> datas =data.getJsonData(System.getProperty("user.dir") + "\\src\\test\\java\\dataset\\leaddata.json");
		return new Object [][] {{datas.get(0)}};
		}

}
