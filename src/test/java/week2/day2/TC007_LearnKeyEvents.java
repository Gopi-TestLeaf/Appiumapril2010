package week2.day2;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class TC007_LearnKeyEvents {

	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		DesiredCapabilities dc = new DesiredCapabilities();
		dc.setCapability("appPackage", "com.testleaf.leaforg");
		dc.setCapability("appActivity", "com.testleaf.leaforg.MainActivity");
		dc.setCapability("deviceName", "Gopi Phone");
		dc.setCapability("platformName", "Android");

		URL url = new URL("http://0.0.0.0:4723/wd/hub");
		AndroidDriver<WebElement> driver =  new AndroidDriver<WebElement>(url, dc);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		Thread.sleep(4000);
		driver.findElementByXPath("(//android.widget.EditText)[1]").click();
		Thread.sleep(4000);
		System.out.println("finished");
		
		KeyEvent key1 = new KeyEvent(AndroidKey.B);
		driver.pressKey(key1);
		
		driver.pressKey(new KeyEvent(AndroidKey.A));
		driver.pressKey(new KeyEvent(AndroidKey.Z));
		
		driver.hideKeyboard();
		
	}

}
