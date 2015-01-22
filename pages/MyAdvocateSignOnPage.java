//package myadvocateui.pages;
//
//import myadvocateui.utils.SeleniumUtils;
//
//
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//
//public class MyAdvocateSignOnPage extends MyAdvocateMasterPage {
//	protected WebDriver	driver;
//	
//		
//	
//			
//			final By email = By.xpath("email");
//			final By password = By.xpath("password");
//			final By login = By.xpath("id('login-modal')/div[2]/form/div[5]/div");
//			
//			
//			public MyAdvocateSignOnPage(WebDriver driver) {
//				super(driver);
//				this.driver = driver;
//				SeleniumUtils.Click(driver, login);
//	
//			}
//			
//			public MyAdvocateSignOnPage getMyAdvocateSignOnPage( String hostUrl) {
//				driver.navigate().to(hostUrl);
//				return new MyAdvocateSignOnPage(driver);
//			}
//			public boolean verifySafePageLoaded() {
//				return driver.findElement(login).isDisplayed();
//				
//			}
//			
//			public LoginPage signOn(String safeEmail, String safePassword) {
//				driver.findElement(email).sendKeys(safeEmail);
//				driver.findElement(password).sendKeys(safePassword);
//				driver.findElement(login).click();
//				return new LoginPage(driver);
//			
//			}
//
//	}
//	
//	
//
//
