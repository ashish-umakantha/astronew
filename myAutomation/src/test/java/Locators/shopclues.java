package Locators;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class shopclues {
	
	public shopclues(WebDriver driver){
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath=".//span[@class='p_price']")
	public WebElement shopclues_price;
	
	@FindBy(xpath=".//div[@class='column col3']")
	public WebElement shopclues_href;
	
	@FindBy(xpath=".//*[@id='product_list']/div/div/a/h3")
	public WebElement shopclues_phone;
	
	@FindBy(xpath=".//*[@id='autocomplete']")
	public WebElement shopclues_text_box;
	
	@FindBy(xpath=".//*[@id='search']/input[2]")
	public WebElement shopclues_search_btn;


}
