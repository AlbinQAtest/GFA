package GoldenFalcon.gfaTestComponents;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import GoldenFalcon.gfa.LandingPage;

public class Base {
	public WebDriver driver;
	public LandingPage login;
	public Properties prop;

	public WebDriver initializeDriver() throws IOException {
		prop = new Properties();
		FileInputStream fis = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\main\\java\\Data\\Globaldata.properties");
		prop.load(fis);
		String browserName = prop.getProperty("browser"); 
		if (browserName.equalsIgnoreCase("chrome")) {

			driver = new ChromeDriver();
			driver.manage().window().maximize();
		} else {

		}
		return driver;
	}

	@BeforeSuite
	public LandingPage lauchapplication() throws IOException {
		driver = initializeDriver();
		login = new LandingPage(driver);
		String URL = prop.getProperty("url");
		if (URL == null || URL.isEmpty()) {
			throw new RuntimeException("URL not found in Globaldata.properties!");
		}
		login.goTo(URL);
		return login;

	}

	@BeforeClass
	public void login() {
		String UserName = prop.getProperty("username");
		String Password = prop.getProperty("password");
		login.loginAction(UserName, Password);
	}
}
