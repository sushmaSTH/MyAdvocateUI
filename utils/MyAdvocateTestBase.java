package myadvocateui.utils;

import myadvocateui.pages.MyAdvocateLandingPage;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.remote.service.DriverService;

public class MyAdvocateTestBase {
	
	protected static WebDriver driver;
	//private static DriverService service;
	
	@BeforeClass
	public static void myAdvocateTestBaseBefore(){
		driver = createWebDriver();
		
	}
	
	@AfterClass
	public static void myAdvocateTestBaseAfter(){
		driver.quit();
		driver=null;
	}
	
	public static WebDriver createWebDriver(){
		WebDriver driver = new FirefoxDriver();
		return driver;

	}
	
	public MyAdvocateLandingPage getHomePage(){
		String URL= "https://test-aws.myadvocatehelps.com/";
		driver.navigate().to(URL);
		return new MyAdvocateLandingPage(driver);
	}

}
