package com.flipkar.page;

import java.util.List;

import com.flipkart.activity.FlipkartActivity;
import com.flipkart.util.MethodFactory;
import com.flipkart.util.MobileDriver;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class LoginPage extends FlipkartActivity {

	@AndroidFindBy(id = "com.flipkart.android:id/locale_icon_layout")
	private List<MobileElement> langList;
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='English']")
	private MobileElement engLanguageXpath;
	@AndroidFindBy(id = "com.flipkart.android:id/select_btn")
	private MobileElement continutToLanaguage;
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Use Password']")
	private MobileElement usePwdLink;
	@AndroidFindBy(xpath = "//android.widget.EditText[@content-desc='Password']")
	private MobileElement passxpath;
	@AndroidFindBy(id = "com.flipkart.android:id/sub_title")
	private MobileElement passSubtitle;
	@AndroidFindBy(id = "com.flipkart.android:id/tv_text")
	private List<MobileElement> Lang;

	public LoginPage selectLang() {
		MethodFactory.sleep();
		for (int i = 0; i < langList.size(); i++) {
			for (int j = i; j < Lang.size(); j++) {
				if (!langList.get(i).isSelected()) {
					if (Lang.get(j).getText().equals("English")) {
						clickOn(langList.get(i));
						break;
					}
				}
			}
		}
		waitforVisiblity(continutToLanaguage);
		clickOn(continutToLanaguage);
		return this;
	}

	public LoginPage enterMobileNo() {
		MethodFactory.sleep();
		MobileDriver.getDriver().getKeyboard().sendKeys("9819422714" + "\n");
		
		return this;
	}

	
	public HomePage enterPass() {
		MethodFactory.sleep();
		if (passSubtitle.isDisplayed()) {
			MethodFactory.sleep();
			String elText = passSubtitle.getText();
			System.out.println("Element text is::" + elText);
			if (elText.contains("OTP limit reached. Please enter password")) {
				waitforVisiblity(passxpath);
				if (passxpath.isDisplayed()) {
					MobileDriver.getDriver().getKeyboard().sendKeys("@jaywardhan1989" + "\n");
				}
			}
			else {
				waitforVisiblity(usePwdLink);
				if (usePwdLink.isDisplayed()) {
					clickOn(usePwdLink);
					waitforVisiblity(passxpath);
					if (passxpath.isDisplayed()) {
						MobileDriver.getDriver().getKeyboard().sendKeys("@jaywardhan1989" + "\n");
					}
				}
			}
		}

		return new HomePage();
	}

}
