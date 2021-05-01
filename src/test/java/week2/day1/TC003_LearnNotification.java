package week2.day1;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;

public class TC003_LearnNotification {
	
	public static void main(String[] args) throws MalformedURLException {
		DesiredCapabilities dc = new DesiredCapabilities();
		dc.setCapability("appPackage", "net.oneplus.launcher");
		dc.setCapability("appActivity", "net.oneplus.launcher.Launcher");
		dc.setCapability("deviceName", "Gopi Phone");
		dc.setCapability("platformName", "Android");

		URL url = new URL("http://0.0.0.0:4723/wd/hub");
		AndroidDriver<WebElement> driver =  new AndroidDriver<WebElement>(url, dc);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		driver.openNotifications();
		
		WebElement ele = driver.findElementByXPath("//android.widget.TextView[@text='USB debugging connected']");
		
		String text = ele.getText();
		System.out.println(text);
		
		ele.click();
		
		List<WebElement> allText = driver.findElementsById("android:id/title");
		for (WebElement eachText : allText) {
			System.out.println(eachText.getText());
		}
		
		
		
	}

}
