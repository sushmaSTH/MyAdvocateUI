package myadvocateui.testcases;

import myadvocateui.pages.MyAdvocateLandingPage;
import myadvocateui.pages.MyAdvocateLandingPage.LoginWidget;
import myadvocateui.utils.MyAdvocateTestBase;
import org.junit.Test;
import org.openqa.selenium.By;


public class LoginTest extends MyAdvocateTestBase{
	
	final static By login = By.xpath("id('login-modal')/div[2]/form/div[5]/div");
	
	@Test
	public void loginTest() {
		MyAdvocateLandingPage test  = new MyAdvocateLandingPage(driver);
		test = getHomePage();
		LoginWidget loginWidget = test.clickLogin();
		//loginWidget.Login("sushma.shrestha@altegrahealth.com", "Summer!14");
		
	}

		
			
		}


