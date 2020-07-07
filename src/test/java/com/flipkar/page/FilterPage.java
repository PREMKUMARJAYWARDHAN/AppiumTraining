package com.flipkar.page;

import com.flipkart.activity.FlipkartActivity;
import com.flipkart.util.MobileDriver;
import com.flipkart.util.ReadPropertiesFileData;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class FilterPage extends FlipkartActivity {

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Filter']")
	private MobileElement filterXpath;
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Brand']")
	private MobileElement brandXpath;
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Apple']")
	private MobileElement appleBrandXpath;
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Mi']")
	private MobileElement miBrandXpath;
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Samsung']")
	private MobileElement samsungBrandXpath;
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Apply']")
	private MobileElement applyFilterXpath;

	public FilterPage filterByBrand() {
		if (filterXpath.isDisplayed()) {
			clickOn(filterXpath);
			System.out.println("Clicked in filter....");
			waitforVisiblity(brandXpath);
			if (brandXpath.isDisplayed()) {
				clickOn(brandXpath);
			}
		}
		return this;
	}

	public FilterPage selectMiBrand() {
		waitforVisiblity(miBrandXpath);
		if (miBrandXpath.isDisplayed()) {
			clickOn(miBrandXpath);
			System.out.println("Clicked on Mi brand....");
		}
		return this;
	}

	public FilterPage selectSamsungBrand() {
		waitforVisiblity(samsungBrandXpath);
		if (samsungBrandXpath.isDisplayed()) {
			clickOn(samsungBrandXpath);
			System.out.println("Clicked on Samsung brand....");
		}
		return this;
	}

	public FilterPage selectApple() {
		FlipkartActivity.scrolldownAndGetElement(MobileDriver.getDriver(), ReadPropertiesFileData.readLocater("appleBrandXpath"));
		if (appleBrandXpath.isDisplayed()) {
			clickOn(appleBrandXpath);
			System.out.println("Clicked on Apple brand....");
		}
		return this;
	}

	public HomePage applyFilter() {
		if (applyFilterXpath.isDisplayed()) {
			clickOn(applyFilterXpath);
			System.out.println("Filter applied...");
		}
		return new HomePage();
	}

}
