package com.hyundai;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Map;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.offset.PointOption;

public class SampleMobile 
{


	public static AndroidDriver driver;


	@Test
	public void configuration() throws MalformedURLException, InterruptedException
	{
		DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
		desiredCapabilities.setCapability("platformName", "android");
		desiredCapabilities.setCapability("appium:platformVersion", "14.0.5");
		desiredCapabilities.setCapability("appium:deviceName", "Sibi");
		desiredCapabilities.setCapability("appium:udid", "lfzhn7rwk7irbqbe");
		desiredCapabilities.setCapability("appium:appPackage", "com.miui.home");
		desiredCapabilities.setCapability("appium:appActivity", "com.miui.home.launcher.Launcher");
		desiredCapabilities.setCapability("appium:noReset", "true");
		desiredCapabilities.setCapability("appium:ensureWebviewsHavePages", true);
		desiredCapabilities.setCapability("appium:nativeWebScreenshot", true);
		desiredCapabilities.setCapability("appium:newCommandTimeout", 3600);
		desiredCapabilities.setCapability("appium:connectHardwareKeyboard", true);

		URL remoteUrl = new URL("http://127.0.0.1:4723/wd/hub");

		driver = new AndroidDriver(remoteUrl, desiredCapabilities);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));



		driver.findElement(By.xpath("//android.widget.ImageView[@resource-id=\"com.miui.home:id/icon_icon\"]")).click();

		driver.findElement(By.id("com.application.zomato:id/fw_mobile_edit_text")).sendKeys("9003690138");

		driver.findElement(By.id("com.application.zomato:id/send_otp_button")).click();

		driver.findElement(By.id("com.application.zomato:id/vsearch_parent")).click();
		
		driver.findElement(By.id("com.application.zomato:id/edittext")).sendKeys("CakeZone");
		
		(new TouchAction(driver))
		  .press(PointOption.point(457, 569))
		  .moveTo(PointOption.point(239, 493))
		  .release()
		  .perform();
		  
		(new TouchAction(driver))
		  .press(PointOption.point(460, 569))
		  .moveTo(PointOption.point(460, 574))
		  .release()
		  .perform();
		
		driver.findElement(AppiumBy.accessibilityId("Chocolate Truffle Cake")).click();

		driver.findElement(By.id("com.application.zomato:id/button")).click();
		
		driver.findElement(By.id("com.application.zomato:id/text_view_title")).click();

		driver.findElement(By.xpath("//android.widget.FrameLayout[@content-desc=\"Chocolate Truffle Cake is an egg dish of ₹509\"]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.TextView")).click();
		
		(new TouchAction(driver))
		  .press(PointOption.point(296, 1010))
		  .moveTo(PointOption.point(197, 1049))
		  .release()
		  .perform();
		
	}



}
