package myadvocateui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
public class MyAdvocateLandingPage extends MyAdvocateMasterPage {

	final By feedFilter = By.xpath("id('feed-filter')//a");
	final By search = By.xpath("id('feed-filter')//input");
	
	public MyAdvocateLandingPage(WebDriver driver) {
		super(driver);
	}
	
	public LoginWidget clickLogin(){
		clickLog();
		return new LoginWidget(driver);

	}
	
	
	public class LoginWidget extends MyAdvocateMasterPage{

		final By emailInput = By.id("input");
		final By passwordInput = By.id("password");
		final By cancelButton = By.id("id('login-modal')/div[2]/form/div[5]/div/button[2]");
		final By loginButton = By.id("id('login-modal')/div[2]/form/div[5]/div/button[1]");
		final By lightbox = By.id("login-modal");
		
		public LoginWidget(WebDriver driver) {
			super(driver);
		}
		
		public void enterEmail(String Email){
			driver.findElement(emailInput).sendKeys(Email);
		}
		
		public void enterPassword(String Password){
			driver.findElement(passwordInput).sendKeys(Password);
		}
		
		public void Login(String Email, String Password){
			driver.switchTo().frame(driver.findElement(lightbox));
			driver.findElement(emailInput).sendKeys(Email);
			driver.findElement(passwordInput).sendKeys(Password);
			driver.findElement(loginButton).click();
			driver.switchTo().parentFrame();
			
		}
		
		
	}
}