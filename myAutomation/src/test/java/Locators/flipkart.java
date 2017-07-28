package Locators;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class flipkart {
	public flipkart(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath=".//input[@class='LM6RPg']")
	public WebElement flipkart_text_box;
	
	@FindBy(xpath=".//button[@class='vh79eN']")
	public WebElement flipkart_search_btn;
	
	@FindBy(xpath="//a[@class='_1UoZlX']/div[2]/div[1]/div[1]")
	public WebElement phone_names;
	
	@FindBy(xpath=".//input[@class='_2zrpKA F_Atl2']")
	public WebElement login_pop_up;
	
	@FindBy(xpath=".//button[@class='_2AkmmA _29YdH8']")
	public WebElement login_pop_up_close;

}
