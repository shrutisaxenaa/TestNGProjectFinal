package pages;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class Page1 {
	
	WebDriver driver;
	
	public Page1(WebDriver driver) {
		this.driver=driver;
		
	}
	public int generateRandomNumber() {
		Random randomNumber= new Random();
		int RandomNumber=randomNumber.nextInt(100);
		return RandomNumber;
		
	}
	
	
	@FindBy(how=How.NAME,using="categorydata")WebElement catagoryDataField;
	@FindBy(how=How.XPATH,using="//input[@name='submit' and @value='Add category']")WebElement addCatagoryButton;
	@FindBy(how=How.XPATH,using="//a[text()='Nevermind']")WebElement NevermindWebElementField;
	@FindBy(how=How.XPATH,using="//select[@name='due_month']")WebElement dueMonth;
	
	public void insertCatagoryData(String catagorydata) {
		int RandomNumber=generateRandomNumber();
				catagoryDataField.sendKeys(catagorydata+RandomNumber);
				
		
	}
	public void clickAddCatagoryButton() {
		addCatagoryButton.click();
	}
	
	public void validationofDuplicateCategoryData() {
		
	//Assert.assertEquals(NevermindWebElementField.getText(), "Nevermind", "There is no Duplicate");
	String bodyText=driver.findElement(By.tagName("body")).getText();
	String actualText="The category you want to add already exists";
	if(bodyText.contains(actualText)) {
		System.out.println(actualText);
	}
	
	} 
	public boolean validatingMonthDropDownButton() {
		
			Select select = new Select(dueMonth);
			List<WebElement> options = select.getOptions();
			ArrayList<String> months = new  ArrayList<>();
			for(WebElement we : options) {
				if(we.getText().equals(months))
					return true;
				
			    months.add(we.getText());
		
			}
			
			System.out.println("Current list of months: " +months);
			return false;
		}
		
	}
	
	
	

