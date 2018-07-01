package AKQA_Test.AKQA_Test;

import static org.testng.Assert.assertEquals;

import java.io.File;

import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.bunnings.Pages.HomePage;
import com.bunnings.Pages.InitializeDriver;
import com.bunnings.Pages.ProductPage;
import com.bunnings.Pages.WishList;

import jxl.Workbook;

/*
 * Opens Bunnings website url passed through excel
 * Searches product specified in excel
 * Adds random product to wishlist
 * Verifies the product in wishlist
 */

public class BunningsWishListTest  {
	String browser;
	String url;
	String searchItem;
	InitializeDriver init;		
	HomePage homepage;
	ProductPage productpage;
	WishList wishlist;
	
	/*
	 * Runs before every @test
	 */
	@BeforeTest
	public void beforeTest() throws Exception{
		//Gets data from excelsheet in the given location
		File file = new File("Excel\\seleniumdata.xls");
		Workbook wb = Workbook.getWorkbook(file);
		browser = wb.getSheet(0).getCell(1, 1).getContents();
		url = wb.getSheet(0).getCell(1, 2).getContents();
		searchItem = wb.getSheet(0).getCell(1, 3).getContents();
		
		//Instantiates the required pages
		init = new InitializeDriver();
		init.setBrowser(browser);
		wishlist  = new WishList(init);
		homepage = new HomePage(init);
		productpage = new ProductPage(init);
	}
	
	/*
	 * Runs after every @test
	 */
	@AfterTest
	public void tearDown() throws Exception{
		init.tearDown();
	}
	
	/*
	 * TestCase
	 */
	 @Test
	 public void verifyWishList() throws Exception{
		//Opens the url 
		homepage.openUrl(url);
		//Searches the SearchItem
		homepage.search(searchItem);
		//Selects a random product
		homepage.clickRandomProduct();
		//Gets the selected product's id
		String productID = productpage.getProductID();
		//Clicks on Add to WishList
		productpage.clickAddToWishList();
		//Opens the WishList
		productpage.openWishList();
		//Verifies the Product ID in the WishList
		boolean product = wishlist.verifyWishListProductList(productID);
		//Asserts if the value is present(Fails if not)
		assertEquals(product, true);
	  }
  
}
