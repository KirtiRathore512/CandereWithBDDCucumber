package CandereAutomation.PageObjectModel;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CandereLandingPage {
	
 private static final Logger logger = LogManager.getLogger(CandereLandingPage.class);

//private static final CharSequence Product_Name = null;
	 
	 //Section1:  Declare a driver object
	 
	 WebDriver driver;
	 WebDriverWait webDriverWait;
	 
	// Section 2: Paratmerize the constuctor
	 
	 public CandereLandingPage(WebDriver driver, WebDriverWait webDriverWait )
	 {
		 this.driver =driver;
		 this.webDriverWait=webDriverWait;
	 }
	 
	 private By searchBoxEle= By.xpath("//input[@id='search']");
	 
     public void NavigateOnLandingPage()
     {
    	 driver.get("https://www.candere.com/");
    	 logger.info("Browser got invoke the base URL" );

     }
     
     public void SearchProduct()
     {
    	 WebElement searchBoxElement= driver.findElement(searchBoxEle);
    	 webDriverWait.until(ExpectedConditions.elementToBeClickable(searchBoxElement));
    	 
    	 logger.info("Waiting for Element:> SearchBoxElement to be clickable");
    	 
    	 searchBoxElement.sendKeys("majestic solitaire diamond ring");
    	 
    	 logger.info("Sending Key into WebElement:> searchBoxEle");	  
     } 
     public void validateUserIsOnLandingPage(String base_url)
     {
    	 String Expected= "Online Jewellery Shopping India | Candere By Kalyan Jewellers | Most Trusted Online Jewellery Store";
    	 
    	 String Actual= driver.getTitle();
   
    	 Assert.assertEquals("Title is Validate",Expected,Actual);
    	 
    	 logger.info("Assertion of page Validation title was passed with expectes as:> " +Expected+ "As Actual was:> " +Actual);
     }
     public void displaySearchResult()
     {
    		WebElement highLightEle= driver.findElement(By.xpath("//div[@id='productsList']//ul//li//div[text()='Majestic Solitaire Diamond Ring']"));

     }
     public void clickAction()
     {
    		WebElement highLightEle= driver.findElement(By.xpath("//div[@id='productsList']//ul//li//div[text()='Majestic Solitaire Diamond Ring']"));
    	   
    		highLightEle.click();
     }
     
     public void scrollDown()
	    {
	    	WebElement AboutUsElement = driver.findElement(By.xpath("//p[text()='ABOUT US']"));

	    	JavascriptExecutor js = ((JavascriptExecutor) driver);
	    	js.executeScript("arguments[0].scrollIntoView(true);", AboutUsElement);
	    }
     public void aboutUsSection(List<String> ExpectedAboutUsOptions)
     {
    	 List<WebElement> ActualAboutUsEleOpt= driver.findElements(By.xpath("//p[text()='ABOUT US']//parent::nav//a[text()]"));
    	   
    	   for (int i = 0; i < ExpectedAboutUsOptions.size(); i++) {
    			if (ExpectedAboutUsOptions.get(i).equals(ActualAboutUsEleOpt.get(i).getText())) {
    				Assert.assertTrue(true);
    			}
    			else
    			{
    				Assert.fail();
    			}

    		}
     }
     public void followUsSection()
     {
    	 WebElement FollowUsSecEle= driver.findElement(By.xpath("//p[text()='FOLLOW US']//parent::nav//div[@class='row_group flex_group_item']//a"));
    	    
    	 Assert.assertEquals("Social media Icons",true,FollowUsSecEle.isDisplayed());

     }
     public void FBIcon()
     {
    	WebElement FBsocialMediaIcon= driver.findElement(By.xpath("//a[@class='social_icons__ fb']"));
    	webDriverWait.until(ExpectedConditions.elementToBeClickable(FBsocialMediaIcon));
    	FBsocialMediaIcon.click();
     }
     public void InstaIcon()
     {
    	 WebElement InstasocialMediaIcon= driver.findElement(By.xpath("//img[@alt='instagram_color_1']"));
    	 //webDriverWait.until(ExpectedConditions.elementToBeClickable(InstasocialMediaIcon));
    	 InstasocialMediaIcon.click();
     }
     public void TwitIcon()
     {
    	 WebElement TwitsocialMediaIcon= driver.findElement(By.xpath("//a[@href='https://twitter.com/canderebyKalyan']"));
    	 //webDriverWait.until(ExpectedConditions.elementToBeClickable(TwitsocialMediaIcon));
    	 TwitsocialMediaIcon.click();
     }  
}
