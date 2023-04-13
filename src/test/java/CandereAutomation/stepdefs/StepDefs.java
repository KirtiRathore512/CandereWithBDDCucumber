package CandereAutomation.stepdefs;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import CandereAutomation.Core.WebDriverFactory;
import CandereAutomation.PageObjectModel.CandereLandingPage;
import CandereAutomation.PageObjectModel.CandereProductDescPage;
import CandereAutomation.PageObjectModel.SocialMediaHandlePage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefs {

	 Scenario scn;
	 WebDriver driver;
	 String base_url = "https://www.candere.com/";
	 String Product_Name="majestic solitaire diamond ring";
	 int implicit_wait_timeout_in_sec = 20;
	 WebDriverWait webDriverWait;
	 
	 CandereLandingPage candereLandingPage;
	 CandereProductDescPage candereProductDescPage;
	 SocialMediaHandlePage socialMediaHandlePage;
	 
	 private static final Logger logger = LogManager.getLogger(StepDefs.class);
	 	 
@Before

public void setUp(Scenario scn) throws Exception
{
	this.scn=scn;
	
	String browserName = WebDriverFactory.getBrowserName();
	
	driver = WebDriverFactory.getWebDriverForbrowser(browserName);
	webDriverWait = new WebDriverWait(driver,20);
	
	logger.info("Browser got Set");
	
	candereLandingPage = new CandereLandingPage( driver, webDriverWait);
	candereProductDescPage = new CandereProductDescPage( driver, webDriverWait);
	socialMediaHandlePage = new SocialMediaHandlePage( driver, webDriverWait);
 
}
	
@After(order=1)

public void TearDown()
{
	WebDriverFactory.quitDriver();
	
	scn.log("Browser got Closed");
}

@After(order=2)

public void ScreenShotForFailure(Scenario scn)
{
	if(scn.isFailed())
	{
		TakesScreenshot screenShot = ((TakesScreenshot)driver);
		
		byte[] data = screenShot.getScreenshotAs(OutputType.BYTES);
		
		scn.attach(data,"image/png","Failed Step Name:> " +scn.getName());	
	}
	else
	{
		scn.log("Test Case is passed , No screenshot Capture");
	}
 }

@Given("User Navigate to the Landing page of an Application")
public void user_navigate_to_the_landing_page_of_an_application() 
{    
	candereLandingPage.NavigateOnLandingPage();
    scn.log("User Navigate to the Landing page of Application");

}

@Then("User validate the title of Landing page")
public void user_validate_the_title_of_landing_page() 
{
	candereLandingPage.validateUserIsOnLandingPage(base_url);
	scn.log("Validation is Passed");
}

@When("User search for the product in searchBox that is {string}")
public void user_search_for_the_product_in_search_box_that_is(String Product_Name) 
{
	candereLandingPage.SearchProduct();
    scn.log("User search For a Product");

}

@Then("search result is Displyaed")
public void search_result_is_displyaed() 
{
	candereLandingPage.displaySearchResult();
	 scn.log("Search product is displayed");

}

@Then("User click on the product")
public void user_click_on_the_product()
{
	candereLandingPage.clickAction();
	scn.log("User want to click on the product");
}

@Then("User validate the search product Title")
public void user_validate_the_search_product_title()
{
	candereProductDescPage.validateSearchProdTitle();
	scn.log("User validate the Title of Search product");
}
@Then("User select the size of ring throgh drop down icon")
public void user_select_the_size_of_ring_throgh_drop_down_icon()
{
	candereProductDescPage.selectRingSize();
	scn.log("User Select the size of ring");
}
@Then("notificaton is Displayed with some Text")
public void notificaton_is_displayed_with_some_text()
{
	candereProductDescPage.textNotification();
	scn.log("After selecting the size of ring Text Message is Dispayed");
}

@Given("user scroldown to the botton of the landing page of the application")
public void user_scroldown_to_the_botton_of_the_landing_page_of_the_application() 
{
	candereLandingPage.scrollDown();
	scn.log("User scroll to the bottom of landing page");

}

@Then("under these Footer user validate the About Us section following options are available")
public void under_these_footer_user_validate_the_about_us_section_following_options_are_available(List<String> ExpectedAboutUsOptions)
{
	candereLandingPage.aboutUsSection(ExpectedAboutUsOptions);
	scn.log("User validate All the list are available in About Us Section");

}
@Then("Validate the Follow Us section with social media handles for Facebook, Instagram and Twitter.")
public void validate_the_follow_us_section_with_social_media_handles_for_facebook_instagram_and_twitter() 
{
	candereLandingPage.followUsSection();
}
@When("First click on Social Media Handle Icon\"Facebook\",URL Contain and validate Media Text")
public void first_click_on_social_media_handle_icon_facebook_url_contain_and_validate_media_text() 
{
	candereLandingPage.FBIcon();
	scn.log("User click on Facebook Icon");
	
	socialMediaHandlePage.validateFbText();
	scn.log("User validate the Heading available on Facebook Page");
}

@When("First click on Social Media Handle Icon\"Instagram\",URL Contain and validate Media Text")
public void first_click_on_social_media_handle_icon_instagram_url_contain_and_validate_media_text() 
{
	candereLandingPage.InstaIcon();
	scn.log("User click on Instagram Icon");
	
	socialMediaHandlePage.validateInstaText();
	scn.log("User validate the Heading available on Instagram Page");
}

@When("First click on Social Media Handle Icon\"Twitter\",URL Contain and validate Media Text")
public void first_click_on_social_media_handle_icon_twitter_url_contain_and_validate_media_text() 
{
	candereLandingPage.TwitIcon();
	scn.log("User click on Twitter Icon");
    
	socialMediaHandlePage.validateTwitText();
	scn.log("User validate the Heading available on Twitter Page");	
}

}
