package utils;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class GenericUtils {
	WebDriver driver;
	
	public GenericUtils(WebDriver driver)
	{
		this.driver = driver;
	}

	public void SwitchWindowToChild() {
		
		Set<String> s1= driver.getWindowHandles();
		Iterator<String> i1 = s1.iterator();
	    String parentWindow = i1.next();
	    String childWindow  = i1.next();
	    driver.switchTo().window(childWindow);
	//    testContextSetup.driver.switchTo().window(childWindow);
	}
}
