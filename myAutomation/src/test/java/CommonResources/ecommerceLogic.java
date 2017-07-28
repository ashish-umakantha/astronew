package CommonResources;

import static org.testng.Assert.assertTrue;
import java.util.ArrayList;
import java.util.Collections;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import Locators.flipkart;
import Locators.shopclues;

public class ecommerceLogic 
{
	public ReadPropertyFile data;
	public flipkart locators;
	public shopclues locators1;
	ArrayList<WebElement> phonename;
	ArrayList<WebElement> phoneprice;
	ArrayList<WebElement> link;
	StringBuilder build;
	WebDriverWait wait;
	public ArrayList<String> flipkart_output;
	public ArrayList<String> shopclues_output;
	
	//Method to get Prices of iPhone 7 from Flipkart site
	public ArrayList<String> getFlipkartPrices(WebDriver driver) throws Exception
	{	
		driver=new ChromeDriver();
		initialiseElements(driver);
		locators = new flipkart(driver);
		
		driver.navigate().to(data.getEcommerceUrl1());
		dismissPopUp(driver);
		
		assertTrue(locators.flipkart_text_box.isDisplayed(), "Flipkart text box is not seen");
		assertTrue(locators.flipkart_search_btn.isDisplayed(), "Flipkart serach btn is not seen");
		locators.flipkart_text_box.sendKeys(data.getSearchText());
		locators.flipkart_search_btn.click();
		wait.until(ExpectedConditions.visibilityOf(locators.phone_names));
		assertTrue(locators.phone_names.isDisplayed(), "Phone names not dispalyed");
		
		phonename.addAll(driver.findElements(By.xpath("//a[@class='_1UoZlX']/div[2]/div[1]/div[1]")));
		phoneprice.addAll(driver.findElements(By.xpath("//div[@class='_1vC4OE _2rQ-NK']")));
		link.addAll(driver.findElements(By.xpath("//a[@class='_1UoZlX']")));
		
		String details="";
		for(int i=0;i<phonename.size();i++)
		{
			WebElement e3 = phonename.get(i);
			String text = e3.getText();
			WebElement e4 = phoneprice.get(i);
			//replacing ₹ with Rs. from price
			String price = e4.getText();
			for(int l=0;l<=price.length()-1;l++)
			{
				if(price.charAt(l) == '₹')
				{
					continue;
				}
				
				if(price.charAt(l)==',')
				{
					continue;
				}
				else
				{
					build.append(price.charAt(l));
				}
			}
			String actualprice = "Rs." + build.toString();			
			build.setLength(0);			
			String url = link.get(i).getAttribute("href");
			if(!text.contains("Plus") && text.contains("Apple iPhone 7"))
			{
				build.append(actualprice + " ");
				build.append(text + " ");
				build.append("flipkart ");
				build.append("Link: " + url);
				details = build.toString();
				flipkart_output.add(details);
				
			}
			build.setLength(0);
		}
		driver.close();
		return flipkart_output;
	}
	
	public void initialiseElements(WebDriver driver) throws Exception{
		phonename = new ArrayList<WebElement>();
		phoneprice = new ArrayList<WebElement>();
		link = new ArrayList<WebElement>();
		build = new StringBuilder();
		data = new ReadPropertyFile();
		wait = new WebDriverWait(driver,10);
		flipkart_output = new ArrayList<String>();
		shopclues_output = new ArrayList<String>();
	}
	
	//Method to get Prices of iPhone 7 from Shopclues site
	public ArrayList<String> getShopcluesPrices(WebDriver driver) throws Exception
	{
		
		driver=new ChromeDriver();
		initialiseElements(driver);
		locators1 = new shopclues(driver);
		
		driver.navigate().to(data.getEcommerceUrl2());
		
		assertTrue(locators1.shopclues_text_box.isDisplayed(), "Shopclues text box is not seen");
		assertTrue(locators1.shopclues_search_btn.isDisplayed(), "Shopclues serach btn is not seen");
		locators1.shopclues_text_box.sendKeys(data.getSearchText());
		locators1.shopclues_search_btn.click();
		wait.until(ExpectedConditions.visibilityOf(locators1.shopclues_phone));
		assertTrue(locators1.shopclues_phone.isDisplayed(), "Phone names not dispalyed");
		
		phonename.addAll(driver.findElements(By.xpath(".//*[@id='product_list']/div/div/a/h3")));
		phoneprice.addAll(driver.findElements(By.xpath(".//span[@class='p_price']")));
		link.addAll(driver.findElements(By.xpath(".//*[@id='product_list']/div/div/a")));
		for(int i=0;i<phonename.size();i++)
		{
			WebElement e3 = phonename.get(i);
			String text = e3.getText();
			WebElement e4 = phoneprice.get(i);
			String price = e4.getText();
			String url = link.get(i).getAttribute("href");
			if(!text.contains("PLUS")&&text.contains("Apple iPhone 7"))
			{
				build.append(price + " ");
				build.append(text + " ");
				build.append("Shopclues ");
				build.append("Link: " + url);
				String details = build.toString();
				shopclues_output.add(details);
			}
			build.setLength(0);
		}

		driver.close();
		return shopclues_output;
	
	}
	
	public void dismissPopUp(WebDriver driver){
		try{
			if(driver.switchTo().alert() != null)
			{
				Actions action = new Actions(driver);
				action.sendKeys(Keys.ESCAPE).build().perform();
			}
			}catch(Exception e){}
	}
	
	public void output(WebDriver driver) throws Exception
	{
		ArrayList<String> finallist = new ArrayList<String>();
		finallist.addAll(getFlipkartPrices(driver));
		finallist.addAll(getShopcluesPrices(driver));
		Collections.sort(finallist);
		for (int i=0; i<=finallist.size()-1;i++)
		{
			System.out.println(finallist.get(i));
		}
	}
}
