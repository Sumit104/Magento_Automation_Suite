package mp.magentoProj.pageobjects;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
	
	WebDriver driver;
	
	@FindBy(xpath="//img[contains(@src, 'logo.svg')]")
	private WebElement image;
	
	@FindBy(xpath="//span[contains(text(), 'welcome')]")
	private WebElement message;
	
public HomePage(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver,this);
		
	}

public boolean display () {
	return image.isDisplayed();
}
	
public String visiblemessage() {
	WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(20));
	wait.until(ExpectedConditions.visibilityOf(message));
	return message.getText();
}

}
