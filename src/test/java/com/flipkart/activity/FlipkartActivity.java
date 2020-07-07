package com.flipkart.activity;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.flipkart.util.MethodFactory;
import com.flipkart.util.MobileDriver;
import com.flipkart.util.ReadPropertiesFileData;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

public class FlipkartActivity {
	
	
	
	
	public FlipkartActivity() {
		PageFactory.initElements(new AppiumFieldDecorator(MobileDriver.getDriver()), this);
	}
	
	/*
	
	//login Flipkart
	public static boolean loginFlipkart() {
		try {
			System.out.println("inside login...");
			//MethodFactory.sleep();
			MethodFactory.sleep();
			List<MobileElement> langList = MobileDriver.getDriver()
					.findElements(By.id("com.flipkart.android:id/locale_icon_layout"));
			langList.get(0).click();
			MethodFactory.sleep();
			MobileDriver.getDriver().findElement(By.id(ReadPropertiesFileData.readLocater("continueToEngId"))).click();
			MethodFactory.sleep();
			MobileDriver.getDriver().getKeyboard().sendKeys("9819422714" + "\n");
			MethodFactory.sleep();
			MethodFactory.sleep();
			
			if(!MobileDriver.getDriver().findElements(By.xpath(ReadPropertiesFileData.readLocater("usePwdlinkxpath"))).isEmpty()) {
				System.out.println("using passwoord link....");
			List<MobileElement> pwdLink = MobileDriver.getDriver().findElements(By.xpath(ReadPropertiesFileData.readLocater("usePwdlinkxpath")));
				pwdLink.get(0).click();
				MethodFactory.sleep();
				if(MobileDriver.getDriver().findElementByXPath(ReadPropertiesFileData.readLocater("passwordXpath")).isDisplayed()) {
					MobileDriver.getDriver().getKeyboard().sendKeys("@jaywardhan1989" + "\n");
				}
			}
			if(!MobileDriver.getDriver().findElements(By.id(ReadPropertiesFileData.readLocater("passwordSubtitle"))).isEmpty()) {
				MobileElement element = (MobileElement) MobileDriver.getDriver().findElementById(ReadPropertiesFileData.readLocater("passwordSubtitle"));
				String elText = element.getText();
				System.out.println("Element text is::"+elText);
				if(elText.contains("OTP limit reached. Please enter password")) {
					if(MobileDriver.getDriver().findElementByXPath(ReadPropertiesFileData.readLocater("passwordXpath")).isDisplayed()) {
						MobileDriver.getDriver().getKeyboard().sendKeys("@jaywardhan1989" + "\n");
					}
				}
				
			}
			
			MethodFactory.sleep();
			if(!MobileDriver.getDriver().findElements(By.id(ReadPropertiesFileData.readLocater("productSearchBarId"))).isEmpty()) {
				System.out.println("Product search bar is available....");
			}
			
			if (!MobileDriver.getDriver().findElements(By.id(ReadPropertiesFileData.readLocater("flipkartHomeId")))
					.isEmpty()) {
				System.out.println("Login successful....");
				return true;
			} else {
				System.out.println("Login failed...");
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}
	
	public static boolean searchItem() {
		System.out.println("Inside search item....");
		if (!MobileDriver.getDriver().findElements(By.id(ReadPropertiesFileData.readLocater("productSearchBarId")))
				.isEmpty()) {
			MobileDriver.getDriver().findElement(By.id(ReadPropertiesFileData.readLocater("productSearchBarId")))
					.click();
			MobileDriver.getDriver().getKeyboard().sendKeys("Mobiles" + "\n");
			System.out.println("Product name enterd in search bar...");
			if(!MobileDriver.getDriver().findElements(By.id(ReadPropertiesFileData.readLocater("searchElementListId"))).isEmpty()) {
				List<MobileElement> searchedEle=MobileDriver.getDriver().findElements(By.id(ReadPropertiesFileData.readLocater("searchElementListId")));
				searchedEle.get(0).click();
				System.out.println("clicked on populated itesm...");
				
			}
			MethodFactory.sleep();
			//Allow network access
			if(!MobileDriver.getDriver().findElements(By.id(ReadPropertiesFileData.readLocater("allowAccessNetworkId"))).isEmpty()) {
				List<MobileElement> searchedEle=MobileDriver.getDriver().findElements(By.id(ReadPropertiesFileData.readLocater("allowAccessNetworkId")));
				searchedEle.get(0).click();
				System.out.println("Allowed Network access....");
				
			}
			MethodFactory.sleep();
			//Allow flipkart device location 
			if(!MobileDriver.getDriver().findElements(By.id(ReadPropertiesFileData.readLocater("flipkartDevicelocationPopupId"))).isEmpty()) {
				List<MobileElement> searchedEle=MobileDriver.getDriver().findElements(By.id(ReadPropertiesFileData.readLocater("flipkartDevicelocationPopupId")));
				searchedEle.get(0).click();
				System.out.println("Allowd flipkart device location id....");
				
			}
			MethodFactory.sleep();
			return true;

		} else {
			return false;
		}
	}
	
	
	public static boolean filterIteamByBrand() {
		boolean filterByBrand=false;
		System.out.println("Inside filter items by brand name...");
		if (!MobileDriver.getDriver().findElements(By.xpath(ReadPropertiesFileData.readLocater("filterXpath")))
				.isEmpty()) {
			MobileDriver.getDriver().findElement(By.xpath(ReadPropertiesFileData.readLocater("filterXpath"))).click();
			System.out.println("Clicked in filter....");
			MethodFactory.sleep();
			if (!MobileDriver.getDriver().findElements(By.xpath(ReadPropertiesFileData.readLocater("brandXpath")))
					.isEmpty()) {
				MobileDriver.getDriver().findElement(By.xpath(ReadPropertiesFileData.readLocater("brandXpath")))
						.click();
				System.out.println("Clicked on brand...");
				MethodFactory.sleep();
				
				if(!MobileDriver.getDriver().findElements(By.xpath(ReadPropertiesFileData.readLocater("miBrandXpath"))).isEmpty()) {
					MobileDriver.getDriver().findElement(By.xpath(ReadPropertiesFileData.readLocater("miBrandXpath"))).click();
					System.out.println("Clicked on Mi brand....");
				}
				if(!MobileDriver.getDriver().findElements(By.xpath(ReadPropertiesFileData.readLocater("samsungBrandXpath"))).isEmpty()) {
					MobileDriver.getDriver().findElement(By.xpath(ReadPropertiesFileData.readLocater("samsungBrandXpath"))).click();
					System.out.println("Clicked on Samsung brand....");
				}
				FlipkartActivity.scrolldownAndGetElement(MobileDriver.getDriver(), ReadPropertiesFileData.readLocater("appleBrandXpath"));
				if(!MobileDriver.getDriver().findElements(By.xpath(ReadPropertiesFileData.readLocater("appleBrandXpath"))).isEmpty()) {
					MobileDriver.getDriver().findElement(By.xpath(ReadPropertiesFileData.readLocater("appleBrandXpath"))).click();
					System.out.println("Clicked on Samsung brand....");
				}
				
				MethodFactory.sleep();
				System.out.println("Scrolled and clicked on specified brand");
				if (!MobileDriver.getDriver()
						.findElements(By.xpath(ReadPropertiesFileData.readLocater("applyFilterXpath"))).isEmpty()) {
					MobileDriver.getDriver()
							.findElement(By.xpath(ReadPropertiesFileData.readLocater("applyFilterXpath"))).click();
					MethodFactory.sleep();
					filterByBrand= true;
				}
			}
			return filterByBrand;
		}
		else
		{
			return filterByBrand;
		}
	}

	
public static boolean sortItemByPrice() {
	System.out.println("inside sotr item by price....");
	if (!MobileDriver.getDriver().findElements(By.xpath(ReadPropertiesFileData.readLocater("sortXpath")))
			.isEmpty()) {
		MobileDriver.getDriver().findElement(By.xpath(ReadPropertiesFileData.readLocater("sortXpath"))).click();
		System.out.println("clicked on sort icon...");
		MethodFactory.sleep();
		if (!MobileDriver.getDriver().findElements(By.xpath(ReadPropertiesFileData.readLocater("highToLowPrice")))
				.isEmpty()) {
			MobileDriver.getDriver().findElement(By.xpath(ReadPropertiesFileData.readLocater("highToLowPrice")))
					.click();
			MethodFactory.sleep();
			System.out.println("Clicked on price high to low...");
			
		}
		
	return true;
	}
	else {
		return false;
	}
}
	

public static boolean addProdIntoCart() {
	boolean addProdIntoCart=false;
	System.out.println("Inside add product into cart.");
	List<MobileElement> totalProductDisplayed=MobileDriver.getDriver().findElements(By.xpath(ReadPropertiesFileData.readLocater("firstItemXpath")));
	if (!totalProductDisplayed.isEmpty()) {
		totalProductDisplayed.get(0).click();
		System.out.println("clicked on product");
		MethodFactory.sleep();
		if(!MobileDriver.getDriver().findElements(By.xpath(ReadPropertiesFileData.readLocater("addToCart"))).isEmpty()) {
			MobileDriver.getDriver().findElement(By.xpath(ReadPropertiesFileData.readLocater("addToCart"))).click();
			MethodFactory.sleep();
			if(MobileDriver.getDriver().findElementByAccessibilityId(ReadPropertiesFileData.readLocater("closeBtnAccId")).isDisplayed()) {
				MobileDriver.getDriver().findElementByAccessibilityId(ReadPropertiesFileData.readLocater("closeBtnAccId")).click();
			}
			addProdIntoCart = true;
		}
		
		return addProdIntoCart;
	}
	else
		return addProdIntoCart;
}

public static boolean cartPageValidation() {
	System.out.println("Inside cart paeg validation....");
	FlipkartActivity.scrollUpAndGetElement(MobileDriver.getDriver(), ReadPropertiesFileData.readLocater("cartIconId"));
	MethodFactory.sleep();
	if(MobileDriver.getDriver().findElement(By.id(ReadPropertiesFileData.readLocater("cartIconId"))).isDisplayed()) {
		MobileDriver.getDriver().findElement(By.id(ReadPropertiesFileData.readLocater("cartIconId"))).click();
		MethodFactory.sleep();
		
	}
	if(MobileDriver.getDriver().findElement(By.xpath(ReadPropertiesFileData.readLocater("placeOrderXpath"))).isDisplayed()) {
		MobileDriver.getDriver().findElement(By.xpath(ReadPropertiesFileData.readLocater("placeOrderXpath"))).click();
		MethodFactory.sleep();
	}
	if(MobileDriver.getDriver().findElement(By.xpath(ReadPropertiesFileData.readLocater("continueBtnXpath"))).isDisplayed()) {
		MobileDriver.getDriver().findElement(By.xpath(ReadPropertiesFileData.readLocater("continueBtnXpath"))).click();
		MethodFactory.sleep();
	}
	
	return true;
}

*/

public static void scrolldownAndGetElement(AndroidDriver driver, String xpath) {
	System.out.println("Inside scrolling...");
	while (driver.findElements(By.xpath(xpath)).size()==0){
		TouchAction  action =new TouchAction(driver);	
		Dimension size	=driver.manage().window().getSize();
		int width=size.width;
		int height=size.height;				
		int middleOfX=width/2;
		int startYCoordinate= (int)(height*.7);
		int endYCoordinate= (int)(height*.2);
		action.press(PointOption.point(middleOfX, startYCoordinate))
		.waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2)))
		.moveTo(PointOption.point(middleOfX, endYCoordinate)).release().perform();
		}
}



public static void scrollUpAndGetElement(AndroidDriver driver, String id) {
	System.out.println("Inside up scrolling...");
	while (driver.findElements(By.id(id)).size()==0){
		TouchAction  action =new TouchAction(driver);	
		Dimension size	=driver.manage().window().getSize();
		int width=size.width;
		int height=size.height;				
		int middleOfX=width/2;
		int startYCoordinate= (int)(height*.7);
		int endYCoordinate= (int)(height*.2);
		action.press(PointOption.point(middleOfX, endYCoordinate))
		.waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2)))
		.moveTo(PointOption.point(middleOfX, startYCoordinate)).release().perform();
		}
}

	
public void waitforVisiblity(MobileElement element) {
	WebDriverWait wait=new WebDriverWait(MobileDriver.getDriver(), Integer.parseInt(ReadPropertiesFileData.readDeviceDetails("wait")));
	wait.until(ExpectedConditions.visibilityOf(element));
	
}

public void clickOn(MobileElement element) {
	waitforVisiblity(element);
	element.click();
}




}
