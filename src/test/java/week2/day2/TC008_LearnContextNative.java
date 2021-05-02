package week2.day2;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;

public class TC008_LearnContextNative {
	
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
		
		// its returns current active view name
		String context = driver.getContext();
		System.out.println("Current active view: "+context);
		
		Set<String> allCon = driver.getContextHandles();
		System.out.println("count of views: "+allCon.size());
		
		for (String eachCon : allCon) {
			System.out.println(eachCon);
		}
		
		driver.findElementByXPath("(//android.widget.EditText)[1]").sendKeys("rajkumar@testleaf.com");
		driver.findElementByXPath("(//android.widget.EditText)[2]").sendKeys("rajkumar@testleaf.com");
		
		
	}

}
