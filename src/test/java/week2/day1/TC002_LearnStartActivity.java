package week2.day1;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;

public class TC002_LearnStartActivity {

	public static void main(String[] args) throws MalformedURLException, InterruptedException {
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

		// Switch control from one activity to another activity(diff app)
		Activity act = new Activity("com.oneplus.mms", "com.android.mms.ui.ConversationList");
		driver.startActivity(act);
		
	//	driver.findElementById("android:id/button1").click(); // for popup
		
		driver.findElementByAccessibilityId("Search messages").click();
		
		driver.findElementById("com.oneplus.mms:id/search_src_text").sendKeys("Tl Sam");
		
		Thread.sleep(2000);
		
		driver.findElementById("com.oneplus.mms:id/container").click();
		
		driver.findElementById("com.oneplus.mms:id/compose_message_text").sendKeys(text);
		
		driver.findElementByAccessibilityId("Send Message").click();
		
		Thread.sleep(2000); // its working
		
		// its kills current active app
		driver.terminateApp("com.oneplus.mms");
		
		// its switch back to the background running app
		driver.activateApp("com.oneplus.calculator");
		
		
	}

}
