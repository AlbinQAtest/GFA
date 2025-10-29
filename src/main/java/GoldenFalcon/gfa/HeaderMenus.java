package GoldenFalcon.gfa;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import abstractcponents.Abstractclass;

public class HeaderMenus extends Abstractclass {
	WebDriver driver;
	
	public HeaderMenus(WebDriver driver)
	{
		super(driver);
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//i[@class='fa fa-th-large']")
	WebElement main_menu;
	
	@FindBy(xpath="//div[@class='dropdown-menu show']")
	WebElement menu_dropDown;
	
	@FindBy(xpath="//a[normalize-space()='CRM']")
	WebElement crm;
	
	@FindBy(xpath="//li[@class='breadcrumb-item active']")
	WebElement crm_page;
	
	
	
	public void click_menulist()
	{
		waitforElementvisibility(main_menu);
		main_menu.click();
	}
	
	public void click_CRM()
	{
		waitforElementvisibility(menu_dropDown);
		crm.click();
	}
	
	public String crm_text()
	{
		waitforElementvisibility(crm_page);
		return crm_page.getText();
	}
	
	

}
