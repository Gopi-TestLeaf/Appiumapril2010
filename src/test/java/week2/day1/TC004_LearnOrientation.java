package week2.day1;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;

public class TC004_LearnOrientation {
	
	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		
		DesiredCapabilities dc = new DesiredCapabilities();
		dc.setCapability("appPackage", "com.testleaf.leaforg");
		dc.setCapability("appActivity", "com.testleaf.leaforg.MainActivity");
		dc.setCapability("deviceName", "Gopi Phone");
		dc.setCapability("platformName", "Android");

		URL url = new URL("http://0.0.0.0:4723/wd/hub");
		AndroidDriver<WebElement> driver =  new AndroidDriver<WebElement>(url, dc);
		
		String orient = driver.getOrientation().toString();
		System.out.println(orient);
		
		Thread.sleep(3000);
		driver.rotate(ScreenOrientation.LANDSCAPE);
		
		String orient1 = driver.getOrientation().toString();
		System.out.println(orient1);
		Thread.sleep(3000);
		driver.rotate(ScreenOrientation.PORTRAIT);
	}

}
