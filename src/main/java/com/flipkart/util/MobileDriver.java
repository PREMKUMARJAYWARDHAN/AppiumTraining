package com.flipkart.util;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class MobileDriver {

	//private static AppiumDriver Driver;
	private static AndroidDriver<MobileElement> driver;

	public static void setDriver(AndroidDriver<MobileElement> driver) {
		MobileDriver.driver = driver;
	}

	public static AndroidDriver<MobileElement> getDriver() {
		return driver;
	}


	
	
}
