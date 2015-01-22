package myadvocateui.pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MyAdvocateMasterPage {
	
	final By myAdvocateLogo = By.xpath("id('myadvocate-header')/div[1]/div/a/img");
	final By homeTab = By.xpath("=id('myadvocate-header')/div[2]/ul/li[1]/a");
	final By chatTab = By.xpath("id('myadvocate-header')/div[2]/ul/li[2]/a");
	final By settingsTab = By.xpath("id('myadvocate-header')/div[2]/ul/li[3]/a");
	final By logout = By.xpath("id('myadvocate-header')/div[2]/ul/li[4]/a");
	final By espanol = By.xpath("id('myadvocate-header')/div[2]/ul/li[5]/a");
	final By login = By.xpath("id('myadvocate-header')/div[2]/ul/li[2]/a/span");
	final By register = By.xpath("id('myadvocate-header')/x:div[2]/x:ul/x:li[3]/x:a/x:span");
	
	protected WebDriver driver;
	
	public MyAdvocateMasterPage(final WebDriver driver){
		this.driver = driver;
	}
	
	public void clickMyAdvocateLogo(){
		driver.findElement(myAdvocateLogo).click();
	}

	public void clickHomeTab(){
		driver.findElement(homeTab).click();
	}
	public void clickChatTab(){
		driver.findElement(chatTab).click();
	}
	public void clickSettingsTab(){
		driver.findElement(settingsTab).click();
	}
	public void clickEspanol(){
		driver.findElement(espanol).click();
	}
	public void clickLogoutTab(){
		driver.findElement(logout).click();
		}
	public void clickLog(){
		driver.findElement(login).click();
	}
}
