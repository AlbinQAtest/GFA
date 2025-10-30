package GoldenFalcon.gfa;

import java.time.Duration;

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
	
	@FindBy(xpath="//div[@name='rfq_reference']")
	WebElement rfq_Ref;
	
	@FindBy(xpath="//select[@name='lead_priority'")
	WebElement priority;
	
	
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
		waitforElementvisibility(rfq_Ref);
		rfq_Ref.sendKeys(rfqRef);
		rfq_Ref.sendKeys(Keys.ENTER);
	}
	
	public void selectPrioity(String lead_priority)
	{
		
	Select dropdown= new Select (priority);
	dropdown.selectByVisibleText(lead_priority);
	}
	
	
}


