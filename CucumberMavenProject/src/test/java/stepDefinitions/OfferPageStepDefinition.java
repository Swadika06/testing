package stepDefinitions;

import java.util.Iterator;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.LandingPage;
import pageObjects.OffersPage;
import pageObjects.PageObjectManager;
import utils.TestContextSetup;

public class OfferPageStepDefinition {
	
	public String offerPageProductName;
	TestContextSetup testContextSetup;
	PageObjectManager pageObjectManager;

	public OfferPageStepDefinition(TestContextSetup testContextSetup)
	{
		this.testContextSetup = testContextSetup;
	}
	
	@Then("user searched for {string} shortname in offers page")
	public void user_searched_for_shortname_in_offers_page(String shortName) throws InterruptedException {
		switchToOffersPage();
	//	OffersPage offerspage = new OffersPage(testContextSetup.driver);
		OffersPage offerspage = testContextSetup.pageObjectManager.offersPage();
		offerspage.searchItem(shortName);
	    Thread.sleep(2000);
	    testContextSetup.offerPageProductName = offerspage.getProductName();
	    System.out.println(testContextSetup.offerPageProductName);
	}

	public void switchToOffersPage()
	{
	//	pageObjectManager = new PageObjectManager(testContextSetup.driver);
		LandingPage landingpage = testContextSetup.pageObjectManager.getLandingPage();
				
//		LandingPage landingpage = new LandingPage(testContextSetup.driver);
		landingpage.selectTopDeals();
		testContextSetup.genericUtils.SwitchWindowToChild();
		
	//	testContextSetup.driver.findElement(By.linkText("Top Deals")).click();
	}
	
	@Then("validate product name in offers page matches with Landing Page")
	public void validate_product_name_in_offers_page_matches_with_landing_page() {
		Assert.assertEquals(testContextSetup.offerPageProductName, testContextSetup.landingPageProductName);
		System.out.println("Product is matched successfully");
		
	    
	}
}
