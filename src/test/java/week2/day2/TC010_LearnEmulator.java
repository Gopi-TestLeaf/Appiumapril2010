package week2.day2;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;

public class TC010_LearnEmulator {
	
	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		

		DesiredCapabilities dc = new DesiredCapabilities();
		dc.setCapability("deviceName", "Android Emulator");
		dc.setCapability("platformName", "Android");
		dc.setCapability("platformVersion", "11.0");
		dc.setCapability("udid", "emulator-5554");
		dc.setCapability("automationName", "UiAutomator2");
		dc.setCapability("app", "C:\\Users\\gopir\\eclipse-workspace\\AppiumAprilBatch\\apps\\leaforg.apk");
		
		URL url = new URL("http://0.0.0.0:4723/wd/hub");
		AndroidDriver<WebElement> driver =  new AndroidDriver<WebElement>(url, dc);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Thread.sleep(5000);
		
		driver.findElementByXPath("(//android.widget.EditText)[1]").sendKeys("rajkumar@testleaf.com");
		driver.findElementByXPath("(//android.widget.EditText)[2]").sendKeys("Leaf@123");
		driver.findElementByXPath("//android.widget.Button[@text='LOGIN']").click();
		
	}

}
