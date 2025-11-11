package GoldenFalcon.gfa;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import abstractcponents.Abstractclass;

public class crm_lead extends Abstractclass{

	WebDriver driver;
	public WebDriverWait wait;
	
	public crm_lead(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//div[@name='partner_id']/div/input")
	WebElement customer_name;
	
	@FindBy(xpath="//div[@name='user_id']/div/input")
	WebElement salesPerson;
	
	@FindBy(xpath="//input[@name='rfq_reference']")
	WebElement rfq_Ref;
	
	@FindBy(xpath="//select[@name='lead_priority']")
	WebElement priority;
	
	@FindBy(linkText="Add a line")
	WebElement addPN;
	
	@FindBy(xpath="//button[contains(text(),'Save')]")
	WebElement saveLead;
	
	@FindBy(xpath="//span[@name='name']")
	WebElement leadNumber;
	
	@FindBy(xpath="//button[@name='2651']")
	WebElement addVendor;
	
	@FindBy(xpath="//div[@name='partner_ids']/div/input")
	WebElement chooseVendor;
	
	By vendorDrop = By.xpath("//ul[contains(@class,'ui-autocomplete')");
	
	@FindBy(xpath="//ul[contains(@class,'ui-autocomplete')")
	WebElement vendorDropdown;
	
	@FindBy(xpath="//a[@class='ui-menu-item-wrapper']")
	List<WebElement> vendorNames;
	
	@FindBy(xpath="//a[normalize-space(text())='THE BOEING COMPANY']")
	WebElement vendorNamelist;
	
	@FindBy(xpath="//button[@name='action_create_purchase_quotation']")
	WebElement saveVendor;
	
	@FindBy(xpath="//div[@class='o_form_statusbar']//button[@title='Current state'][normalize-space()='RFQ']")
	WebElement currentState;
	
	
	
	
	
	
	
	public void selectCustomer(String customername) {
	    wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    
	    waitforElementvisibility(customer_name);
	    
	    customer_name.click();
	    customer_name.clear();
	    customer_name.sendKeys(customername);

	    // wait for suggestion to appear
	    WebElement suggestion = wait.until(ExpectedConditions.visibilityOfElementLocated(
	        By.xpath("//ul[contains(@class,'ui-autocomplete')]//a[normalize-space(text())='" + customername + "']")
	    ));

	    suggestion.click();
	    triggerOnChange(customer_name);
	}
		
	
	public void selectSalesperson(String salespersonname) throws InterruptedException
	{
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		waitforElementvisibility(salesPerson);
		salesPerson.click();
		salesPerson.clear();
		salesPerson.sendKeys(salespersonname);
		
			    
		      Thread.sleep(1000); // small wait for RPC autocomplete to load

		    // Press ArrowDown + Enter to select
		   
		   // Thread.sleep(500);
		    salesPerson.sendKeys(Keys.ENTER);
		    
		    triggerOnChange(salesPerson);
			    
			
	}
	
	public void rfQRef(String rfqRef)
	{
		Actions actions = new Actions(driver);
		
		actions.moveToElement(rfq_Ref).perform();
		rfq_Ref.sendKeys(rfqRef);
		rfq_Ref.sendKeys(Keys.ENTER);
	}
	
	public void selectPrioity(String lead_priority)
	{
		Actions actions = new Actions(driver);
		actions.moveToElement(priority).perform();
	Select dropdown= new Select (priority);
	dropdown.selectByVisibleText(lead_priority);
	}
	
	public void clickAddPn()
	{

		Actions actions = new Actions(driver);
		actions.moveToElement(addPN).perform();
		addPN.click();
	}
	
	
	public void saveLead()
	{
		waitforElementvisibility(saveLead);
		saveLead.click();
	}
	
	public void  getleadNumber()
	{
		scrollviewUp();
		waitforElementvisibility(leadNumber);
		String leadnumber = leadNumber.getText();
		System.out.println(leadnumber);
	}
	
	public void addVendor(String vendorname) throws InterruptedException
	{
		Actions actions = new Actions(driver);
		actions.moveToElement(addVendor).perform();
		addVendor.click();
		waitforElementvisibility(chooseVendor);
		chooseVendor.clear();
		chooseVendor.sendKeys(vendorname);
		Thread.sleep(1000);
		vendorNamelist.click();
		Thread.sleep(1000);
		saveVendor.click();
		
	}
	
	public String verifyCorrentState ()
	{
		waitforElementvisibility(currentState);
		String stage =currentState.getText();
		System.out.println(stage);
		return stage;
	}
		
	
	
}


