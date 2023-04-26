package mp.magentoProj.testcases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import mp.magentoProj.base.Base;
import mp.magentoProj.pageobjects.HomePage;

public class HomePageTest extends Base {
HomePage homePage;
	
	public HomePageTest() {
		super();
	}
	
	public WebDriver driver;
	
	@BeforeMethod
	public void setup() {
		
		driver = initializeBrowserAndOpenApplicationURL(prop.getProperty("Browser"));
		homePage = new HomePage(driver);
		
		
	}

@AfterMethod
public void tearDown() {
	
	driver.quit();
	
}

@Test
public void verifyLogo() {
	
	boolean logo=homePage.display();
	Assert.assertTrue(logo, "Logo is not available");
	
}
@Test
public void verifyDefaultMessage() throws InterruptedException {
	String actualMessage=homePage.visiblemessage();
	String expectedMessage="Default welcome msg!";
	Assert.assertEquals(actualMessage, expectedMessage);
	}

@Test
public void verifyTitle() {
	Assert.assertEquals(driver.getTitle(), "Home Page", "Title is not correct");
}
}