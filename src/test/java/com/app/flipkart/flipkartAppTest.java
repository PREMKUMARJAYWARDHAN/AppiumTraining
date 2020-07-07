package com.app.flipkart;

import static org.testng.Assert.assertTrue;

import java.lang.reflect.Method;

import org.openqa.selenium.By;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.flipkar.page.CartPage;
import com.flipkar.page.FilterPage;
import com.flipkar.page.HomePage;
import com.flipkar.page.LoginPage;
import com.flipkart.util.MethodFactory;
import com.flipkart.util.MobileDriver;
import com.flipkart.util.ReadPropertiesFileData;

public class flipkartAppTest {
 
 LoginPage logingPage;
 HomePage homePage;
 FilterPage filterPage;
 CartPage cartPage;
 

@BeforeTest(description = "Initilize driver and launch flipkart app")
  public void SetUp() {
		MethodFactory.openApp(); //open App
		
	}

@BeforeMethod
public void beforeMethod(Method m) {
	logingPage=new LoginPage();
	homePage=new HomePage(); 
	filterPage=new FilterPage();
	cartPage=new CartPage();
	System.out.println("********Starting Test*********"+m.getName());
}
  
  @Test(description = "Login to flipkart app.")
	public void logintoFlipkart() throws Exception {
		logingPage.selectLang();
		logingPage.enterMobileNo();
		logingPage.enterPass();
		if (!MobileDriver.getDriver().findElements(By.id(ReadPropertiesFileData.readLocater("productSearchBarId")))
				.isEmpty()) {
			System.out.println("Product search bar is available....");
		}
		if (!MobileDriver.getDriver().findElements(By.id(ReadPropertiesFileData.readLocater("flipkartHomeId")))
				.isEmpty()) {
			System.out.println("Login successful....");
			assertTrue(true);
		} else {
			System.out.println("Login failed...");
			assertTrue(false);
		}
	}
  
  
  @Test(description = "Search itesm.", dependsOnMethods = {"logintoFlipkart"})
  public void searchItesm() {
	  //assertEquals(FlipkartActivity.searchItem(), true);
	  try {
	  homePage.searchItemsInHomePage();
	  homePage.accessNetwork();
	  homePage.allowDeviceLocation();
	  assertTrue(true);
	  }
	  catch (Exception e) {
		  assertTrue(false);
		  e.printStackTrace();
	  }
  }


  @Test(description = "Filter by brand.", dependsOnMethods = {"searchItesm"})
  public void filterByBrand() {
	  //assertEquals(FlipkartActivity.filterIteamByBrand(),true);
	  filterPage.filterByBrand();
	 // filterPage.selectMiBrand();
	  filterPage.selectSamsungBrand();
	  filterPage.selectApple();
	  filterPage.applyFilter();
  }
  
 
  @Test(description = "Sort items by price - low to high", dependsOnMethods = {"filterByBrand"})
  public void sortItem() { 
	  //assertEquals(FlipkartActivity.sortItemByPrice(),true);
	  homePage.sortItems();
	}
  
  
  @Test(description = "Select 1st product and add into the cart.", dependsOnMethods = {"sortItem"})
  public void addProductIntoCart() {
	  //assertEquals(FlipkartActivity.addProdIntoCart(),true);
	  try {
	  homePage.selectFirstElement();
	  homePage.addToCart();
	  assertTrue(true);
	  }catch (Exception e) {
		  e.printStackTrace();
		  assertTrue(false);
	}
	  
  }
  
  
  @Test(description = "check cart and payment screen.", dependsOnMethods = {"addProductIntoCart"})
  public void checkCartPage() {
	 // FlipkartActivity.cartPageValidation();
	  try {
		  cartPage.clickOnCartIcon();
		  cartPage.placeOrder();
		  assertTrue(true);
	  }
	  catch (Exception e) {
		  assertTrue(false);
		  e.printStackTrace();
	}
  }
  
	
	  @AfterTest(description = "Close opened flipkart app") 
	public void TearDown() {
		System.out.println("closing the launched app.");
		MethodFactory.closeApp(); // close driver
	}
	 
	 
}
