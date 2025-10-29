package gfa.Testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import GoldenFalcon.gfa.Crm_page;
import GoldenFalcon.gfa.HeaderMenus;
import GoldenFalcon.gfaTestComponents.Base;

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
		Crm_page leadcreation = new Crm_page(driver);
		leadcreation.click_create();
	
		Assert.assertEquals( leadcreation.verify_new(),"New");
				}
	

}
