
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class LoginTest {

	
	WebDriver driver;

    @BeforeTest
	public void readCoafing() {
    	
    	//InputStream
    	//BuffeReader
    	//FileReader
    	//Scanner
    	
    	Properties prop = new properties();
    	try {
    		InputStream input = new FileInputStream("./src/main/java/cofing/cofing.properties");
    	prop.load(input);
    	
    	
    	
    	
    	}catch(IOException e) {
    		e.printStackTrace();
    	
    	}
    	
    	
    }
    	
    	
String browser = "firefox";	

	
	if(browser.equalsIgnoreCase("chrome"))  {

		System.setProperty("webdriver.gecko.driver", "./driver/geckodriver.exe");

		driver = new FirefoxDriver();

		
	}else if(browser.equalsIgnoreCase("Firefox")) {
		
	}
		
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
         driver = new ChromeDriver();
		

		driver.get("htt:www.techfios.com/ibilling/?ng=admin/");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
}
	@Test

	public void loginTest() throws InterruptedException {

		By USERNAME_FIELD_LOCATOR = By.id("username");
		By PASSWORD_FIELD_LOCATOR = By.id("password");
		By SIGNIN_FIELD_LOCATOR = By.name("login");

		String loginid = "demo@techfios.com";
		String password = "abc123";

		driver.findElement(USERNAME_FIELD_LOCATOR).sendKeys(loginid);
		driver.findElement(PASSWORD_FIELD_LOCATOR).sendKeys(password);
		driver.findElement(SIGNIN_FIELD_LOCATOR).click();

		Thread.sleep(2000);

	}

    @AfterTest
	public void tearDown() {

		driver.close();
		driver.quit();

	}
}

