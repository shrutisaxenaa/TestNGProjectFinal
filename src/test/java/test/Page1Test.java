package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import pages.Page1;
import util.BrowserFactory;

public class Page1Test {

	WebDriver driver;
	
	@Test
	public void userValidateCatagoryField() throws InterruptedException {
		
		driver=BrowserFactory.init();
		
		Page1 pg= PageFactory.initElements(driver, Page1.class);
		pg.insertCatagoryData("King");
		pg.clickAddCatagoryButton();
		pg.validationofDuplicateCategoryData();
		
		//pg.validatingMonthDropDownButton();
		
		BrowserFactory.tearDown();
		
		
	}
	
	
}
