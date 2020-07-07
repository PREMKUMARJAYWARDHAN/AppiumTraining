package com.flipkart.util;

import java.net.URL;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import org.openqa.selenium.remote.DesiredCapabilities;

import com.flipkart.config.CapablityType;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class MethodFactory {
	//private static AppiumDriver<MobileElement> driver;
	private static AndroidDriver<MobileElement> driver;
	private static String currentDateRequired = null;
	private static Format formatterMonth;
	private static String dateUtil = null;

	// Launch App
	public static void openApp() {

		try {
			DesiredCapabilities cap = new DesiredCapabilities();
			cap.setCapability(CapablityType.DEVICE_NAME, ReadPropertiesFileData.readDeviceDetails("device.name"));
			cap.setCapability(CapablityType.UDID, ReadPropertiesFileData.readDeviceDetails("device.udid"));
			cap.setCapability(CapablityType.PLATFORM_NAME,
					ReadPropertiesFileData.readDeviceDetails("device.platformName"));
			cap.setCapability(CapablityType.PLATFORM_VERSION,
					ReadPropertiesFileData.readDeviceDetails("device.platformversion"));
			cap.setCapability(CapablityType.APP_PACKAGE, ReadPropertiesFileData.readDeviceDetails("device.appPackage"));
			cap.setCapability(CapablityType.APP_ACTIVITY,
					ReadPropertiesFileData.readDeviceDetails("device.appActivity"));
			cap.setCapability("noReset", false);
			URL url = new URL(ReadPropertiesFileData.readDeviceDetails("appium.server.url"));
			//driver = new AppiumDriver<MobileElement>(url, cap);
			driver = new AndroidDriver<MobileElement>(url, cap);
			MobileDriver.setDriver(driver);
			System.out.println("Appplication started...");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void sleep() {
		try {
			Thread.sleep(Long.parseLong(ReadPropertiesFileData.readDeviceDetails("default-sleep")));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	//close App
	public static void closeApp() {
		MobileDriver.getDriver().quit();
	}


}
