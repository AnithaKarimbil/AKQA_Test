package com.bunnings.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

/*Initialize Driver,Teardown and other testcase independent methods*/

public class InitializeDriver {
	public WebDriver driver;
	public WebDriverWait wait;
	
	/*
	 * Sets the browser to run the test
	 * Selects driver based on the browser
	 */
	public void setBrowser(String browser){
		if (browser.equals("Chrome")){
			System.setProperty("webdriver.chrome.driver","drivers\\chromedriver.exe");
			this.driver = new ChromeDriver();
		}
		else if (browser.equals("Firefox")){
			System.setProperty("webdriver.gecko.driver","drivers\\geckodriver.exe");						
			this.driver = new FirefoxDriver();
			}	
		this.wait = new WebDriverWait(this.driver, 10);
	}
	
	/*
	 * Closes browser and terminate driver
	 */
	public void tearDown() {
		driver.quit();
	}
}
