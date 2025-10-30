package abstractcponents;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Abstractclass {
	
	WebDriver driver;
	
	public Abstractclass(WebDriver driver)
	{
		this.driver =driver;
		
	}
	
	public void waitforElementvisibility(WebElement element)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	public void triggerOnChange(WebElement element) {
	    JavascriptExecutor js = (JavascriptExecutor) driver;
	    js.executeScript("arguments[0].dispatchEvent(new Event('change', { bubbles: true }));", element);
	    js.executeScript("arguments[0].dispatchEvent(new Event('blur', { bubbles: true }));", element);
	}

}
