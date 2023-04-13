package CandereAutomation.Core;

import java.util.concurrent.TimeUnit;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebDriverFactory {

	private static final Logger logger = LogManager.getLogger(WebDriverFactory.class);

	private static WebDriver driver=null;
		
		public static WebDriver getWebDriverForbrowser(String browser) throws Exception
		{
			switch(browser.toLowerCase())
			{
			 case "chrome":
	            	WebDriverManager.chromedriver().setup();
	            	driver = new ChromeDriver();
	                logger.info("Chrome Browser invoked");
	                break;

	            case "edge":
	            	WebDriverManager.edgedriver().setup();
	                driver = new EdgeDriver();
	                logger.info("edge Browser invoked");
	                break;
	            case "firefox":
	            	WebDriverManager.firefoxdriver().setup();
	                driver = new FirefoxDriver();
	                logger.info("Firefox Browser invoked");
	                break;
	            case "opera":
	            	WebDriverManager.operadriver().setup();
	                driver = new OperaDriver();
	                logger.info("Firefox Browser invoked");
	                break;
	          
	            case "headless":
	                ChromeOptions options = new ChromeOptions();
	                options.addArguments("headless");
	                options.addArguments("window-size=1200x600");
	                driver = new ChromeDriver(options);
	                logger.info("Headless Chrome Browser invoked");
	                break;
	            default:
	                logger.fatal("No such browser is implemented.Browser name sent: " + browser);
	                throw new Exception("No such browser is implemented.Browser name sent: " + browser);
	        }

			
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
			logger.info("Browser gor maximize and implicit wait dor 20 seconds");
			return driver;	
		}
		
		public static void navigateToURL(String base_url)
		{
			driver.get(base_url);
			logger.info("Broswer got Navigate to The URL:> " +base_url);
		}
		
		public static void quitDriver()
		{
			driver.quit();
			logger.info("Browser got Closed");
		}
		
		
		public static String getBrowserName()
		{
			String defaultBrowser = "chrome"; // set by default Chrome Driver
			String browserSendFromCMD = System.getProperty("browser");
			
			if(browserSendFromCMD==null)
			{
				return defaultBrowser;
			}
			else
			{
				return browserSendFromCMD;
			}
		}
	}

