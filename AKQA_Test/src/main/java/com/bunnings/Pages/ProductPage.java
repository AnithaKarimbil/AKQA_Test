package com.bunnings.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ProductPage extends InitializeDriver{
	

	public ProductPage(InitializeDriver lclInitDriver) {
		this.driver=lclInitDriver.driver;
		this.wait = lclInitDriver.wait;
	}
	
	/*
	 * Gets the ProductName from the Product detail page
	 */
	public String getProductName() {
		String productName = driver.findElement(By.xpath("//h1[@itemprop='name']")).getText();
		return productName;
	}
	
	/*
	 * Gets the Product ID from Product detail page
	 */
	public String getProductID() {
		String productID = driver.findElement(By.xpath("//span[@class='product-in']")).getText();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@data-action='add-to-wish-list']")));
		return productID;
	}
	
	/*
	 * Clicks Add to Wish List button and waits till 'Added' is displayed 
	 */
	public void clickAddToWishList() {
		driver.findElement(By.xpath("//button[@data-action='add-to-wish-list']")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='btn-add-wishlist added']")));	
	}
	
	/*
	 * Click on WishList link
	 */
	public void openWishList() {
		driver.findElement(By.xpath("//span[@data-copy='Wish List']")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='wishlist-title']")));	
	}
	
}
