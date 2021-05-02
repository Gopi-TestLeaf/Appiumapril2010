package week2.day2;

import org.testng.annotations.Test;

import wrappers.GenericWrappers;

public class TC011_LearOrgAppHybridPractice extends GenericWrappers{
	
	@Test
	public void executeTest() {
		launchAndroidApp("Gopi Phone", "com.testleaf.leaforg", "com.testleaf.leaforg.MainActivity", "", "");
		printContext();
		switchWebview();
		enterValue(getWebElement("xpath", "//input[@placeholder='Email']"), "rajkumar@testleaf.com");
		enterValue(getWebElement("xpath", "//input[@placeholder='Password']"), "rajkumar@testleaf.com");
	}

}
