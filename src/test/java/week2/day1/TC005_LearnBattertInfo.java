package week2.day1;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidBatteryInfo;
import io.appium.java_client.android.AndroidDriver;

public class TC005_LearnBattertInfo {

	public static void main(String[] args) throws MalformedURLException {
		DesiredCapabilities dc = new DesiredCapabilities();
		dc.setCapability("appPackage", "net.oneplus.launcher");
		dc.setCapability("appActivity", "net.oneplus.launcher.Launcher");
		dc.setCapability("deviceName", "Gopi Phone");
		dc.setCapability("platformName", "Android");

		URL url = new URL("http://0.0.0.0:4723/wd/hub");
		AndroidDriver<WebElement> driver =  new AndroidDriver<WebElement>(url, dc);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		// Way 1:
		AndroidBatteryInfo batterInfo = driver.getBatteryInfo();
		System.out.println(batterInfo.getLevel());
		System.out.println(batterInfo.getState());
		
		// Way 2:
		Map<String, Object> mp = new HashMap<String, Object>();
		mp.put("command", "dumpsys");
		mp.put("args", "battery");
		
		Object executeScript = driver.executeScript("mobile:shell", mp);
		System.out.println(executeScript.toString());
		

	}

}
