package week1.day2;

import java.lang.reflect.Array;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Arrays;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MultiTouchAction;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

public class LearnTouchAction04 {

	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		DesiredCapabilities dc = new DesiredCapabilities();
		dc.setCapability("appPackage", "com.the511plus.MultiTouchTester");
		dc.setCapability("appActivity", "com.the511plus.MultiTouchTester.MultiTouchTester");
		dc.setCapability("deviceName", "Gopi Phone");
		dc.setCapability("platformName", "Android");

		URL url = new URL("http://0.0.0.0:4723/wd/hub");
		AndroidDriver<WebElement> driver =  new AndroidDriver<WebElement>(url, dc);

		Thread.sleep(3000);

		// Zoom Out
		Dimension size = driver.manage().window().getSize();
		int width = size.getWidth();
		int height = size.getHeight();

		int sX1 = (int)(width*0.5);
		int sY1 = (int)(height*0.5);
		int eX1 = (int)(width*0.8);
		int eY1 = (int)(height*0.2);

		int sX2 = (int)(width*0.5);
		int sY2 = (int)(height*0.5);
		int eX2 = (int)(width*0.2);
		int eY2 = (int)(height*0.8);

		// Action1
		PointerInput finger1 = new PointerInput(PointerInput.Kind.TOUCH, "finger1");
		Sequence dragNdrop1 = new Sequence(finger1, 1);

		dragNdrop1.addAction(finger1.createPointerMove(Duration.ofMillis(0),
				PointerInput.Origin.viewport(), sX1, sY1));

		dragNdrop1.addAction(finger1.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));	

		dragNdrop1.addAction(finger1.createPointerMove(Duration.ofMillis(3000),
				PointerInput.Origin.viewport(), eX1, eY1));

		dragNdrop1.addAction(finger1.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));


		// Action2
		PointerInput finger2 = new PointerInput(PointerInput.Kind.TOUCH, "finger2");
		Sequence dragNdrop2 = new Sequence(finger2, 2);

		dragNdrop2.addAction(finger2.createPointerMove(Duration.ofMillis(0),
				PointerInput.Origin.viewport(), sX2, sY2));

		dragNdrop2.addAction(finger2.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));	

		dragNdrop2.addAction(finger2.createPointerMove(Duration.ofMillis(3000),
				PointerInput.Origin.viewport(), eX2, eY2));

		dragNdrop2.addAction(finger2.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

		
		
		
		
		driver.perform(Arrays.asList(dragNdrop1, dragNdrop2));






















	}

}
