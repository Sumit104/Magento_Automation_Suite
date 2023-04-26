package mp.magentoProj.base;

import java.io.File;
import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class Base {
	
	WebDriver driver;
	public Properties prop;
			
	public Base() {
		
		prop = new Properties();
		File propFile = new File(System.getProperty("user.dir")+"\\src\\test\\java\\mp\\magentoProj\\config\\config.properties");
		
			
		try {
			FileInputStream fis = new FileInputStream(propFile);
			prop.load(fis);
		}catch(Throwable e) {
			e.printStackTrace();
		}
		
	}
	
	public WebDriver initializeBrowserAndOpenApplicationURL(String browserName) {
			
		if(browserName.equalsIgnoreCase("chrome")) {
			
			driver = new ChromeDriver();
			
		}else if(browserName.equalsIgnoreCase("firefox")) {
			
			driver = new FirefoxDriver();
		}
		driver.manage().window().maximize();
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		//driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));
		driver.get(prop.getProperty("URL"));
		System.out.println();
		return driver;
		
	}
	
	
	
	
	
}



