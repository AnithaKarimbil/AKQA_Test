package com.bunnings.Pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class WishList extends InitializeDriver {
	
	public WishList(InitializeDriver lclInitDriver) {
		this.driver=lclInitDriver.driver;
		this.wait = lclInitDriver.wait;
	}
	
	/*
	 * Verifies if the given productname is present in the wishlist and return true or false
	 */
	public boolean verifyWishListProductList(String productName) {
		List<WebElement> wishListProducts = driver.findElements(By.xpath("//tr[@class='hproduct ']/td/small[@class='fineline']"));
		List<String> product = new ArrayList<String>();
		 for(int i=1;i<= wishListProducts.size();i++) {
			 product.add(driver.findElement(By.xpath("//tr["+i+"][@class='hproduct ']/td/small[@class='fineline']")).getText());			
		 }		 
		boolean check= product.contains(productName);
		return check;		 	 
	}
}
