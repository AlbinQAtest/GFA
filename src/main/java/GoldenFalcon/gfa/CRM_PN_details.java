package GoldenFalcon.gfa;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import abstractcponents.Abstractclass;

public class CRM_PN_details extends Abstractclass {
	
	
	WebDriver driver;
	public WebDriverWait wait;
	
	public CRM_PN_details(WebDriver driver)
	{
		
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath ="//div[@class='modal-content']//div[@name='product_id']/div/input")
	WebElement pnField;
	
	
	@FindBy(xpath="//ul[@id='ui-id-118']")
	WebElement pndropDown;
	
	@FindBy(xpath="//ul[@id='ui-id-118']//li[@class='ui-menu-item']")
	WebElement Pnlist;
	
	@FindBy(css ="ul.ui-autocomplete li.ui-menu-item a")
	List<WebElement> PnList;
	
	@FindBy(xpath="//span[normalize-space()='Save & Close']")
	WebElement savePN;
	
	
	
	
	public void addPndetails(String partnumber) throws InterruptedException
	{
		waitforElementvisibility(pnField);
		pnField.click();
		pnField.clear();
		pnField.sendKeys(partnumber);
		
		Thread.sleep(1000); // small wait for RPC autocomplete to load

	    // Press ArrowDown + Enter to sele
	   // Thread.sleep(500);
		pnField.sendKeys(Keys.ENTER);
		savePN.click();
	}
}
