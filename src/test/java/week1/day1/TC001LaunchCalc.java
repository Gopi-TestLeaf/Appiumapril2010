package week1.day1;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class TC001LaunchCalc {

	public static void main(String[] args) throws MalformedURLException {
		
		DesiredCapabilities dc = new DesiredCapabilities();
		dc.setCapability("appPackage", "com.oneplus.calculator");
		dc.setCapability("appActivity", "com.oneplus.calculator.Calculator");
		dc.setCapability("deviceName", "Gopi Phone");
		dc.setCapability("platformName", "Android");
		
		URL url = new URL("http://0.0.0.0:4723/wd/hub");
		AndroidDriver<WebElement> driver =  new AndroidDriver<WebElement>(url, dc);
		
		driver.findElementById("com.oneplus.calculator:id/digit_7").click();
		driver.findElementById("com.oneplus.calculator:id/digit_5").click();
		driver.findElementById("com.oneplus.calculator:id/op_mul").click();
		driver.findElementById("com.oneplus.calculator:id/digit_5").click();
		driver.findElementByAccessibilityId("equals").click();
		String text = driver.findElementById("com.oneplus.calculator:id/result").getText();
		System.out.println(text);
	}

}















