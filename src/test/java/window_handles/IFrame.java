package window_handles;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class IFrame {
	WebDriver driver;

	By USERNAME_FIELD = By.xpath("//*[@id=\"user_name\"]");
	By PASSWORD_FIELD = By.xpath("//*[@id=\"password\"]");
	By LOGINSUBMIT_FIELDT = By.xpath("//*[@id=\"login_submit\"]");
	By DASHBOARD_HEADER_FIELDT = By.xpath("/html/body/div[1]/header/nav/div[2]/ul[1]/li[2]/a");
	By ADVERTISEMENT_FIELDT = By.xpath("/html/body/div[1]/section/div/div[2]/div/div/div/iframe[1]");
	By YOUR_PET_FISH_FIELDT = By.xpath("//div[@id='ad_one']");
	By TICKET_FIOS_FIELDT = By.xpath("//div[@id='ad_two']");
	//By Techfios_PORTAL_FIELDT = By.xpath("//legend[text()='TECHFIOS PORTAL']");
	By AUTOTECHNOTES_FIELDT = By.xpath("//div[@id='portal_one']");
	By OBJECTSPY_SPACE_FIELDT = By.xpath("//div[@id=\"portal_two\"]");
	
;
	@Before
	public void init() {
		System.setProperty("webdriver.chrome.driver", "Driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.get("https://codefios.com/ebilling/login");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Test
	public void LoginTest() {
		driver.findElement(USERNAME_FIELD).sendKeys("demo@codefios.com");
		driver.findElement(PASSWORD_FIELD).sendKeys("abc123");
		driver.findElement(LOGINSUBMIT_FIELDT).click();
		Assert.assertTrue("Daschborard page not found!!", driver.findElement(DASHBOARD_HEADER_FIELDT).isDisplayed());
		
		driver.switchTo().frame("advertisement");
		driver.findElement(YOUR_PET_FISH_FIELDT).click();
		driver.findElement(TICKET_FIOS_FIELDT).click();
		
	
		driver.switchTo().frame("portals");
		driver.findElement(AUTOTECHNOTES_FIELDT).click();
		driver.findElement(OBJECTSPY_SPACE_FIELDT).click();
		
		
		
	}

}
