package week1.day2;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MultiTouchAction;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

public class LearnTouchAction05 {

	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		DesiredCapabilities dc = new DesiredCapabilities();
		dc.setCapability("appPackage", "com.the511plus.MultiTouchTester");
		dc.setCapability("appActivity", "com.the511plus.MultiTouchTester.MultiTouchTester");
		dc.setCapability("deviceName", "Gopi Phone");
		dc.setCapability("platformName", "Android");

		URL url = new URL("http://0.0.0.0:4723/wd/hub");
		AndroidDriver<WebElement> driver =  new AndroidDriver<WebElement>(url, dc);
		
		Thread.sleep(3000);
		
// Swipe01
		// Get the Screen Size
		Dimension size = driver.manage().window().getSize();
		System.out.println(size);
		int width = size.getWidth();
		int height = size.getHeight();
		
		// find the position that where we need to touch
		int startX = (int)(width*0.2);
		int startY = (int)(height*0.5);
		
		int endX = (int)(width*0.8);
		int endY = (int)(height*0.5);
		
		System.out.println(height + "================" + width);
		System.out.println(startX + "================" + startY);
		System.out.println(endX + "================" + endY);
		
		
		TouchAction<?> action1 = new TouchAction<>(driver)
		.press(PointOption.point(startX, startY))
		.waitAction(WaitOptions.waitOptions(Duration.ofSeconds(3)))
		.moveTo(PointOption.point(endX, endY))
		.release();
		
		TouchAction<?> action2 = new TouchAction<>(driver)
		.press(PointOption.point(startX, startY + 400))
		.waitAction(WaitOptions.waitOptions(Duration.ofSeconds(3)))
		.moveTo(PointOption.point(endX, endY + 400))
		.release();
		
		new MultiTouchAction(driver)
		.add(action1)
	//	.add(action2)
		.perform();

	}

}
