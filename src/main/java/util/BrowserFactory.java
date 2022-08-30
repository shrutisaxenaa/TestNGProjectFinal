package util;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class BrowserFactory {
	
	static WebDriver driver;
	

	public static WebDriver init() {
		
		System.setProperty("webdriver.chrome.driver", "driver\\chromedriver.exe");
		driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("http://techfios.com/test/101/");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		return driver;
		
	}
	 public static void tearDown() throws InterruptedException  {
		 
		 Thread.sleep(5000);
		 driver.close();
		 driver.quit();
		 
		 
		 
	 }
}
