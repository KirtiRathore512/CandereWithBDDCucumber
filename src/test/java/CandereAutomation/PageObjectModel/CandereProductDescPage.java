package CandereAutomation.PageObjectModel;

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

public class CandereProductDescPage {
	
	private static final Logger logger = LogManager.getLogger(CandereProductDescPage.class);

		 //Section1:  Declare a driver object
		 
		 WebDriver driver;
		 WebDriverWait webDriverWait;
		 
		// Section 2: Paratmerize the constuctor
		 
		 public CandereProductDescPage(WebDriver driver, WebDriverWait webDriverWait )
		 {
			 this.driver =driver;
			 this.webDriverWait=webDriverWait;
		 }

		 public void validateSearchProdTitle()
			{
				WebElement validateProductTitle= driver.findElement(By.xpath("//h1[@class='page-title']//span[text()='Majestic Solitaire Diamond Ring']"));
				
			    Assert.assertEquals("Product Title",true,validateProductTitle.isDisplayed());
			    logger.info("The product Title is displayed : > "+validateProductTitle);

			}
		    public void selectRingSize()
		    {
			    WebElement SelectRingSizeEle= driver.findElement(By.xpath("//div[@class='custome_select']/select[@id='mt_size']"));
			
			    Select ringSizeSelect = new Select(SelectRingSizeEle);
			    webDriverWait.until(ExpectedConditions.elementToBeClickable(SelectRingSizeEle));
			    ringSizeSelect.selectByVisibleText("17");
			    logger.info("User select the size of the Ring");
		    }
		    public void textNotification()
		    {
		    	//String notificationText = driver.findElement(By.xpath("//div[text()='Price updated']")).getText();
		    	WebElement notificationText = driver.findElement(By.xpath("//div[text()='Price updated']"));
			    webDriverWait.until(ExpectedConditions.visibilityOf(notificationText));

		    	System.out.println("The Notification Title is : " +notificationText.getText());
		    	
		    	logger.info("After select the size of ring Notification text generate: > "+notificationText);
		    	
		    }		       
}
