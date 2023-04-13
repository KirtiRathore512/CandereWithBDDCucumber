package CandereAutomation.PageObjectModel;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SocialMediaHandlePage {
	
	private static final Logger logger = LogManager.getLogger(SocialMediaHandlePage.class);

	//private static final CharSequence Product_Name = null;
		 
		 //Section1:  Declare a driver object
		 
		 WebDriver driver;
		 WebDriverWait webDriverWait;
		 
		// Section 2: Paratmerize the constuctor
		 
		 public SocialMediaHandlePage(WebDriver driver, WebDriverWait webDriverWait )
		 {
			 this.driver =driver;
			 this.webDriverWait=webDriverWait;
		 }

		 public void validateFbText()
		 {
			    String expectedHeading = "Candere by Kalyan Jewellers";
	        	
	        	String Actualheading = driver.findElement(By.xpath("//h1[text()='Candere by Kalyan Jewellers']")).getText();
	        	if(expectedHeading.equalsIgnoreCase(Actualheading))
	        	{
	              	System.out.println("The expected heading is same as actual heading --- "+Actualheading);
	        	}
	        	else
	        	{
	              	System.out.println("The expected heading doesn't match the actual heading --- "+Actualheading);
	        	}
	        	
			 //String FBtext= driver.findElement(By.xpath("//h1[text()='Candere by Kalyan Jewellers']")).getText();
			 //WebElement FBText = driver.findElement(By.xpath("//h1[text()='Candere by Kalyan Jewellers']"));
			// String ExpTextfb ="Candere by Kalyan Jewellers";
			
			// Assert.assertEquals(ExpTextfb,FBText.getText());
		 }
		 public void validateInstaText()
		 {
			 String Instatext= driver.findElement(By.xpath("//h2[@class='x1lliihq x1plvlek xryxfnj x1n2onr6 x193iq5w xeuugli x1fj9vlw x13faqbe x1vvkbs x1s928wv xhkezso x1gmr53x x1cpjm7i x1fgarty x1943h6x x1i0vuye x1ms8i2q xo1l8bm x5n08af x10wh9bi x1wdrske x8viiok x18hxmgj']")).getText();
			 String ExpTextInsta = "canderejewellery";
			
			 Assert.assertEquals(ExpTextInsta,Instatext);
		 }
		 public void validateTwitText()
		 {
			 String Twittext= driver.findElement(By.xpath("//div[@class='css-901oao r-1awozwy r-18jsvk2 r-6koalj r-37j5jr r-adyw6z r-1vr29t4 r-135wba7 r-bcqeeo r-1udh08x r-qvutc0']//span[text()='Candere By Kalyan Jewellers']")).getText();
			 String ExpTextTwit = "Candere By Kalyan Jewellers";
			 if(ExpTextTwit.equalsIgnoreCase(Twittext))
	        	{
	              	System.out.println("The expected heading is same as actual heading --- "+Twittext);
	        	}
	        	else
	        	{
	              	System.out.println("The expected heading doesn't match the actual heading --- "+Twittext);
	        	}
			 //Assert.assertEquals(ExpTextTwit,Twittext);
		 }	 
}