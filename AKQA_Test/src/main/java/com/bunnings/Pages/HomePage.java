package com.bunnings.Pages;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends InitializeDriver {

	public HomePage(InitializeDriver lclInitDriver) {
		this.driver=lclInitDriver.driver;
		this.wait = lclInitDriver.wait;
	}

	/*
	 * Enter Search parameter into search box and click Search icon
	 */
	public void search(String searchWord) {
		driver.findElement(By.xpath("//input[@data-page='/search']")).sendKeys(searchWord);
		driver.findElement(By.xpath("//button[contains(@class,'btn-submit')]")).click();		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[@class='search-result__tabs__item active']")));
	}
	
	/*
	 * Clicks a random product from the search page
	 */
	public void clickRandomProduct(){
		List<WebElement> allProducts = driver.findElements(By.xpath("//*[@id=\"content-layout_inside-anchor\"]/div[3]/div/div/section/div[3]//img"));
        Random rand = new Random();										
        int randomProduct = rand.nextInt(allProducts.size());
        allProducts.get(randomProduct).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='product-header  ']")));
	}
	
	/*
	 * Opens the URL in selected browser
	 */
	public	void openUrl(String url) {
			driver.manage().window().maximize();
			driver.get("https://" + url);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@data-page='/search']")));
		}
}
