package GoldenFalcon.gfa;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import abstractcponents.Abstractclass;

public class Crm_lead_listingpage extends Abstractclass{
	
	WebDriver driver;
	
	public Crm_lead_listingpage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//button[@accesskey='c']")
	WebElement create;
	
	@FindBy(xpath="(//li[@class='breadcrumb-item active'])[1]")
	WebElement check_new;
	
	

	public void click_create()
	{
		create.click();
			
	}
	
	public String verify_new() throws InterruptedException
	{
		Thread.sleep(5000);
		waitforElementvisibility(check_new);
		return check_new.getText();
	}
	
	
}


