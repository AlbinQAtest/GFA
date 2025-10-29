package GoldenFalcon.gfa;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage {
WebDriver driver;

public LandingPage(WebDriver driver)
{
	this.driver=driver;
	PageFactory.initElements(driver, this);;
	
}

@FindBy(id="login")
WebElement user_name;

@FindBy(xpath="//input[@placeholder='Password']")
WebElement passWord;

@FindBy(css ="button.btn-signin")
WebElement signin_button;



public void goTo(String URL)
{
	driver.get(URL);
}

public void loginAction(String email, String password)
{
	user_name.sendKeys(email);
	passWord.sendKeys(password);
	signin_button.click();
}
}
