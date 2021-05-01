package week2.day1;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;

public class TC001_InstallApp {
	
	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		
		DesiredCapabilities dc = new DesiredCapabilities();
		dc.setCapability("deviceName", "OnePlus");
		dc.setCapability("platformName", "Android");
		dc.setCapability("app", "C:\\Users\\gopir\\eclipse-workspace\\AppiumAprilBatch\\apps\\leaforg.apk");
		
		URL url = new URL("http://0.0.0.0:4723/wd/hub");
		AndroidDriver<WebElement> driver =  new AndroidDriver<WebElement>(url, dc);
		
		Thread.sleep(2000);
		
		driver.findElementByXPath("(//android.widget.EditText)[1]").sendKeys("rajkumar@testleaf.com");
		driver.findElementByXPath("(//android.widget.EditText)[2]").sendKeys("Leaf@123");
		driver.findElementByXPath("//android.widget.Button[@text='LOGIN']").click();
	}

}
