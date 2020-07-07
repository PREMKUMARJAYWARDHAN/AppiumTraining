package com.flipkar.page;

import com.flipkart.activity.FlipkartActivity;
import com.flipkart.util.MobileDriver;
import com.flipkart.util.ReadPropertiesFileData;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class CartPage extends FlipkartActivity {

	@AndroidFindBy(id = "com.flipkart.android:id/cart_bg_icon")
	private MobileElement cartIconId;
	@AndroidFindBy(xpath = "//android.view.ViewGroup[2]/android.widget.TextView[1][contains(@text,'Place Order')]")
	private MobileElement placeOrderXpath;
	@AndroidFindBy(xpath = "//android.view.View[@text='CONTINUE']")
	private MobileElement continueBtnXpath;
	@AndroidFindBy(accessibility = "Back Button")
	private MobileElement closeBtnAccId;

	public CartPage clickOnCartIcon() {
		FlipkartActivity.scrollUpAndGetElement(MobileDriver.getDriver(),
				ReadPropertiesFileData.readLocater("cartIconId"));
		waitforVisiblity(cartIconId);
		if (cartIconId.isDisplayed()) {
			clickOn(cartIconId);
			System.out.println("clicked on cart...");
		}
		return this;
	}

	public CartPage placeOrder() {
		waitforVisiblity(placeOrderXpath);
		if (placeOrderXpath.isDisplayed()) {
			clickOn(placeOrderXpath);
			System.out.println("order placed...");
		}
		return this;
	}

	public CartPage clickOnContinue() {
		waitforVisiblity(continueBtnXpath);
		if (continueBtnXpath.isDisplayed()) {
			clickOn(continueBtnXpath);
		}
		return this;
	}

}
