package com.flipkar.page;

import java.util.List;

import com.flipkart.activity.FlipkartActivity;
import com.flipkart.util.MobileDriver;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class HomePage extends FlipkartActivity {
	@AndroidFindBy(id = "com.flipkart.android:id/search_widget_textbox")
	private MobileElement productSearchBarId;
	@AndroidFindBy(id = "com.flipkart.android:id/root_titles")
	private List<MobileElement> searchElementListId;
	@AndroidFindBy(id = "com.flipkart.android:id/allow_button")
	private MobileElement allowAccessNetworkId;
	@AndroidFindBy(id = "com.android.packageinstaller:id/permission_allow_button")
	private MobileElement flipkartDevicelocationPopupId;
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Sort']")
	private MobileElement sortXpath;
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Price -- High to Low']")
	private MobileElement highToLowPrice;
	@AndroidFindBy(xpath = "//android.widget.ScrollView//android.widget.ImageView[1]")
	private List<MobileElement> firstItemXpath;
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='ADD TO CART']")
	private MobileElement addToCart;
	@AndroidFindBy(accessibility = "Back Button")
	private MobileElement closeBtnAccId;

	public HomePage searchItemsInHomePage() {
		waitforVisiblity(productSearchBarId);
		if (productSearchBarId.isDisplayed()) {
			clickOn(productSearchBarId);
			MobileDriver.getDriver().getKeyboard().sendKeys("Mobiles" + "\n");
			System.out.println("Product name enterd in search bar...");
			if (!searchElementListId.isEmpty()) {
				clickOn(searchElementListId.get(0));
				System.out.println("clicked on populated itesm...");
			}
		}
		return this;
	}

	public HomePage accessNetwork() {
		waitforVisiblity(allowAccessNetworkId);
		if (allowAccessNetworkId.isDisplayed()) {
			clickOn(allowAccessNetworkId);
			System.out.println("Allowed Network access....");
		}
		return this;
	}

	public HomePage allowDeviceLocation() {
		waitforVisiblity(flipkartDevicelocationPopupId);
		if (flipkartDevicelocationPopupId.isDisplayed()) {
			clickOn(flipkartDevicelocationPopupId);
			System.out.println("Allowd flipkart device location id....");
		}
		return this;
	}

	public HomePage sortItems() {
		if (sortXpath.isDisplayed()) {
			clickOn(sortXpath);
			waitforVisiblity(highToLowPrice);
			if (highToLowPrice.isDisplayed()) {
				clickOn(highToLowPrice);
			}
		}
		return this;
	}

	public HomePage selectFirstElement() {
		if (!firstItemXpath.isEmpty()) {
			clickOn(firstItemXpath.get(0));
			System.out.println("First item selected....");
		}
		return this;
	}

	public HomePage addToCart() {
		waitforVisiblity(addToCart);
		if (addToCart.isDisplayed()) {
			clickOn(addToCart);
			if (closeBtnAccId.isDisplayed()) {
				clickOn(closeBtnAccId);
			}
		}
		return this;
	}

}
