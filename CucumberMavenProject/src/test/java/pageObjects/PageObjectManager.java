package pageObjects;

import org.openqa.selenium.WebDriver;

public class PageObjectManager {
	public LandingPage landingpage;
	public OffersPage offerpage;
	public WebDriver driver;
	
	public PageObjectManager(WebDriver driver)
	{
		this.driver = driver;
	}
	

	public LandingPage getLandingPage()
	{
		landingpage = new LandingPage(driver);
		return landingpage;
	}
	
	public OffersPage offersPage()
	{
		offerpage = new OffersPage(driver);
		return offerpage;
	}
}
