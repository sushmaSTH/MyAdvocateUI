package myadvocateui.utils;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.base.Predicate;

public final class SeleniumUtils
{
	
	public final static TimeUnit		DEFAULT_TIME_UNIT		= TimeUnit.MILLISECONDS;
	public final static long			DEFAULT_TIMEOUT			= 90000;
	
	// suppress default constructor for non-instantiability
	private SeleniumUtils()
	{
		throw new AssertionError();
	}


	/**
	 * Waits up to 10 seconds for an element to appear on a page.
	 * 
	 * @param driver
	 *            a Selenium driver
	 * @param by
	 *            an element identifier for which to wait
	 * @return a web element
	 */
	public static WebElement waitForElement(final WebDriver driver, final By by)
	{
		if(SeleniumUtils.IsElementPresent(driver, by))
			return driver.findElement(by);
		
		return waitForElement(driver, by, 40);
	}


	public static Object executeScript(final WebDriver driver, String script){		

		return ((JavascriptExecutor)driver).executeScript(script);
	}

	public static void scrollToTop(final WebDriver driver)
	{
	
	}

	protected void scrollWindow(final WebDriver driver, int xAmount, int yAmount) {
		((RemoteWebDriver)driver).executeScript("window.scrollBy(" + xAmount + "," + yAmount + ")");
		Utils.sleep(100);

	}

	/**
	 * Checks the desired checkbox if it is currently unchecked 
	 * @param checkbox the checkbox to check
	 */
	protected void checkCheckbox(final WebDriver driver, By checkbox){
		WebElement element = driver.findElement(checkbox);
		if(!element.isSelected())
			element.click();
	}

	/**
	 * Un-checks the desired checkbox if it is currently checked
	 * @param checkbox
	 */
	protected void uncheckCheckbox(final WebDriver driver, By checkbox){
		WebElement element = driver.findElement(checkbox);
		if(element.isSelected())
			element.click();
		Utils.sleep(500);

	}



	/**
	 * Waits for an element to appear on a page. A default wait of 10 seconds is used if {@code maxWaitInSeconds} is provided as {@code null}.
	 * 
	 * @param driver
	 *            a Selenium driver
	 * @param by
	 *            an element identifier for which to wait
	 * @param waitInSeconds
	 *            the number seconds for which to wait on {@code by} to appear on a page
	 * @return a web element
	 */
	public static WebElement waitForElement(final WebDriver driver, final By by, final int waitInSeconds)
	{
		return (new WebDriverWait(driver, waitInSeconds)).until(ExpectedConditions.presenceOfElementLocated(by));
	}
	
	
	public static void waitForElementDisappear(final WebDriver driver, By by) {
		waitForElementDisappear(driver, by, 200);
	}
	
	public static void waitForElementDisappear(final WebDriver driver, By by, int timeout) {
		Predicate<By> disappeared = new Predicate<By>() {
			@Override
			public boolean apply(By by) {
				try {
					return !(driver.findElement(by)).isDisplayed();
				} catch (WebDriverException e) {
					return true;
				}
			}
		};
		
		new FluentWait<By>(by)
			.withTimeout(timeout, TimeUnit.SECONDS)
			.pollingEvery(250, TimeUnit.MILLISECONDS)
			.until(disappeared);
	}
		
	
		

	/**
	 * Makes a new Selenium {@code Action} to perform hovering of the provided element identifier
	 * 
	 * @param driver
	 *            a Selenium driver
	 * @param by
	 *            an element identifier upon which to hover
	 */
	public static void hover(final WebDriver driver, final By by)
	{
		hover(driver, by, 0, 0);
	}

	public static void hover(WebDriver driver, By by, int xOffset, int yOffset)
	{
		WebElement elementToHover = driver.findElement(by);
		new Actions(driver).moveToElement(elementToHover).moveByOffset(xOffset, yOffset).build().perform();
	}

	public static void moveToThenClick(WebDriver driver, By toClick)
	{
		WebElement elementToClick = driver.findElement(toClick);
		new Actions(driver).moveToElement(elementToClick).click().build().perform();
	}

	public static boolean IsElementPresent(final WebDriver driver, final By by)
	{
		try
		{
			driver.findElement(by);
			return true;
		}
		catch (Exception e)
		{
			return false;
		}
	}

	public static boolean IsElementPresent(WebDriver driver, String element) {
		By by;
		try{
			by = By.id(element);
			if(IsElementPresent(driver, by)) return true;
		}
		catch(Exception e)
		{
		}

		try{
			by = By.xpath(element);
			if(IsElementPresent(driver, by)) return true;
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}

		try{
			by = By.className(element);
			if(IsElementPresent(driver, by)) return true;
		}
		catch(Exception e)
		{

		}

		try{
			by = By.cssSelector(element);
			if(IsElementPresent(driver, by)) return true;
		}
		catch(Exception e)
		{

		}

		try{
			by = By.linkText(element);
			if(IsElementPresent(driver, by)) return true;
		}
		catch(Exception e)
		{

		}

		try{
			by = By.name(element);
			if(IsElementPresent(driver, by)) return true;
		}
		catch(Exception e)
		{

		}

		try{
			by = By.partialLinkText(element);
			if(IsElementPresent(driver, by)) return true;
		}
		catch(Exception e)
		{

		}

		try{
			by = By.tagName(element);
			if(IsElementPresent(driver, by)) return true;
		}
		catch(Exception e)
		{

		}



		return false;
	}

	public static String getText(WebDriver driver, By by) {
		String text = "";
		try{
			if(SeleniumUtils.IsElementPresent(driver, by))
			{
				for(int i = 0; i < 50; i ++)
				{
					WebElement el = driver.findElement(by);
					text = el.getText();
					if(text == "" || text.isEmpty())
						text = driver.findElement(by).getAttribute("value");
					if(!(text == null))
						if(!(text == "" || text.isEmpty()))
							return text;
				}
			}
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			text = "";
		}

		return text;


	}

	public static String getTextWithoutChildText(WebDriver driver, By by) {
		try{
			WebElement target = driver.findElement(by);
			String text = target.getText();

			for(WebElement child : target.findElements(By.xpath("./*"))){
				text = text.replace(child.getText(), "");
			}

			return text.trim();
		} 
		catch(Exception e)
		{
			return "";
		}
	}

	public static void setTextInTextbox(WebDriver driver, By textbox, String text) {
		driver.findElement(textbox).click();
		driver.findElement(textbox).sendKeys(Keys.chord(Keys.CONTROL, "a"));
		driver.findElement(textbox).sendKeys(text);
	}

	public static void WaitForPageToLoad(final WebDriver driver)
	{
		WaitForPageToLoad(driver, DEFAULT_TIMEOUT);
	}
	
	public static void WaitForPageToLoad(final WebDriver driver, final long implicitWait)
	{
		try
		{
			final long implicitWaitInSeconds = DEFAULT_TIME_UNIT.toSeconds(implicitWait);
			(new WebDriverWait(driver, implicitWaitInSeconds)).until(new ExpectedCondition <Boolean>()
			{
				public Boolean apply(final WebDriver driver)
				{
					return ((JavascriptExecutor)driver).executeScript("return document.readyState;").equals("complete");
				}
			});
		}
		catch(final Exception e)
		{
			
		}
	}

	/**
	 * Waits up to the default wait time for all forms of Javascript to finish executing
	 * 
	 * @param driver
	 *            The current Selenium Webdriver
	 */
	public static void waitForJavascript(final WebDriver driver)
	{
		waitForJavascript(driver, DEFAULT_TIMEOUT);
	}

	/**
	 * Waits up to the specified implicit wait for all forms of Javascript to finish executing
	 * 
	 * @param driver
	 *            The current Selenium Webdriver
	 * @param implicitWait
	 *            The maximum number of seconds that Selenium should wait
	 */
	public static void waitForJavascript(final WebDriver driver, final long implicitWait)
	{
		try
		{
			final JavascriptExecutor javascriptExecutor = (JavascriptExecutor)driver;
			final long implicitWaitInSeconds = DEFAULT_TIME_UNIT.toSeconds(implicitWait);
			(new WebDriverWait(driver, implicitWaitInSeconds)).until(new ExpectedCondition <Boolean>()
			{
				@Override

				public Boolean apply(final WebDriver driver)
				{
					final String javascript = "if(typeof jQuery == 'undefined') { return true; } else { return (jQuery.active == 0 && $(':animated').size() < 1); }";
					return((Boolean)javascriptExecutor.executeScript(javascript));
				}
			});
		}
		catch(final Exception e)
		{
			// e.printStackTrace();
		}
	}
	
	public static void scrollToElement(WebDriver driver, By scrollTo, boolean alignToTop)
	{
		if(!SeleniumUtils.IsElementPresent(driver,  scrollTo))
			((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(arguments[1])", driver.findElement(scrollTo), alignToTop);
	}

	public static void javaScriptClick(WebDriver driver, By toClick)
	{
		((JavascriptExecutor)driver).executeScript("arguments[0].click()", driver.findElement(toClick));
	}

	public static void doubleClick(WebDriver driver, By toClick)
	{
		WebElement elementToClick = driver.findElement(toClick);
		elementToClick.click();
		try{
			elementToClick.click();
		} catch (Exception e) {}
	}

	
	public static void ultimateClick(WebDriver driver, By by)
	{
		SeleniumUtils.waitForElement(driver, by).click();
		try
		{
			driver.findElement(by).click();
			driver.findElement(by).sendKeys(Keys.ENTER);
		}
		catch (Exception e)
		{
		}
	}

	public static void waitForElementToBeClickable(WebDriver driver, By by, int timeOut) throws Exception
	{
		while (timeOut >= 0)
		{
			try
			{
				driver.findElement(by).click();
				break;
			}
			catch (Exception e)
			{

			}
			Thread.sleep(1000);
			timeOut--;
		}
	}


	public static void Click(WebDriver driver, By by) {
		SeleniumUtils.waitForElement(driver, by).click();
		try
		{
			driver.findElement(by).click();
		}
		catch (Exception e)
		{
		}

	}
}
