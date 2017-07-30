package CommonResources;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertTrue;
import java.util.ArrayList;
import java.util.Collections;
import org.json.JSONArray;
import org.json.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import Locators.flipkart;
import Locators.shopclues;
import io.restassured.response.Response;

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
	ArrayList<String> paytm_output;
	
	//Method to initialize variables
	public void initializeVariables(WebDriver driver) throws Exception{
			phonename = new ArrayList<WebElement>();
			phoneprice = new ArrayList<WebElement>();
			link = new ArrayList<WebElement>();
			build = new StringBuilder();
			data = new ReadPropertyFile();
			wait = new WebDriverWait(driver,10);
			flipkart_output = new ArrayList<String>();
			shopclues_output = new ArrayList<String>();
	}
	
	//Method to get prices of iPhone 7 from Flipkart.
	public ArrayList<String> getFlipkartPrices(WebDriver driver) throws Exception
	{	
		driver=new ChromeDriver();
		initializeVariables(driver);
		locators = new flipkart(driver);
		String details="";
		
		driver.navigate().to(data.getEcommerceUrl1());
		dismissFlipkartPopUp(driver);

		assertTrue(locators.flipkart_text_box.isDisplayed(), "Flipkart text box is not seen");
		assertTrue(locators.flipkart_search_btn.isDisplayed(), "Flipkart serach btn is not seen");
		locators.flipkart_text_box.sendKeys(data.getSearchText());
		locators.flipkart_search_btn.click();
		wait.until(ExpectedConditions.visibilityOf(locators.phone_names));
		assertTrue(locators.phone_names.isDisplayed(), "Phone names not dispalyed");
		
		phonename.addAll(driver.findElements(By.xpath("//a[@class='_1UoZlX']/div[2]/div[1]/div[1]")));
		phoneprice.addAll(driver.findElements(By.xpath("//div[@class='_1vC4OE _2rQ-NK']")));
		link.addAll(driver.findElements(By.xpath("//a[@class='_1UoZlX']")));
		
		for(int i=0;i<phonename.size();i++)
		{
			WebElement e1 = phonename.get(i);
			String phone_name = e1.getText();
			WebElement e2 = phoneprice.get(i);
			//replacing ₹ with Rs. from price
			String price = e2.getText();
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
			if(phone_name.toLowerCase().contains("iphone 7") && !phone_name.toLowerCase().contains("iphone 7 plus"))
			{
				build.append(actualprice + " ");
				build.append(phone_name + "  ");
				build.append("Website is Flipkart ");
				build.append("Link: " + url);
				details = build.toString();
				flipkart_output.add(details);
			}
			build.setLength(0);
		}
		driver.close();
		System.out.println("Total number of Flipkart phones are: " + flipkart_output.size());
		return flipkart_output;
	}
	
	//Method to get prices of iPhone 7 from Shopclues.
	public ArrayList<String> getShopcluesPrices(WebDriver driver) throws Exception
	{
		
		driver=new ChromeDriver();
		initializeVariables(driver);
		locators1 = new shopclues(driver);
		String details="";
		
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
			WebElement e1 = phonename.get(i);
			String phone_name = e1.getText();
			WebElement e2 = phoneprice.get(i);
			String price = e2.getText();
			String url = link.get(i).getAttribute("href");
			if(phone_name.toLowerCase().contains("iphone 7") && !phone_name.toLowerCase().contains("iphone 7 plus"))
			{	
				build.append(price + " ");
				build.append(phone_name + "  ");
				build.append("Website is Shopclues ");
				build.append("Link: " + url);
				details = build.toString();
				shopclues_output.add(details);
			}
			build.setLength(0);
		}
		driver.close();
		System.out.println("Total number of Shopclues phones are: " + shopclues_output.size());
		return shopclues_output;
	}
	
	//Method to dismiss Flipkart pop up. 
	public void dismissFlipkartPopUp(WebDriver driver){
		try{
			locators = new flipkart(driver);
			for (String handle1 : driver.getWindowHandles()) 
			{
	        	driver.switchTo().window(handle1);
	        	locators.login_pop_up_close.click();
	        }
		}catch(Exception e){}
	}
	
	//Method to combine both outputs into one and display on console
	public void output(WebDriver driver) throws Exception
	{
		ArrayList<String> finallist = new ArrayList<String>();
		finallist.addAll(getFlipkartPrices(driver));
		finallist.addAll(getShopcluesPrices(driver));
		finallist.addAll(getPaytmPrices());
		Collections.sort(finallist);
		for (int i=0; i<=finallist.size()-1;i++)
		{
			System.out.println(finallist.get(i));
		}
	}
	
	//Method to get prices of iPhone 7 from Paytm using rest assured.
	public ArrayList<String> getPaytmPrices() throws Exception
	{
		data = new ReadPropertyFile();
	    String requestUrl = data.getPaytmApi();
		Response  rep = getCall(requestUrl);
	    paytm_output  = new ArrayList<String>();
		JSONObject data = new JSONObject(rep.body().asString());
		JSONArray allPhones = data.getJSONArray("grid_layout");
		
		for(int i=0;i<allPhones.length();i++){
			 String name = allPhones.getJSONObject(i).getString("name");
			 String url;
			 String price;
			 if(name.toLowerCase().contains("iphone 7") && !name.toLowerCase().contains("iphone 7 plus")){
				 url = allPhones.getJSONObject(i).getString("url");
				 //Making get call using url in order to get url and offer_price
				 rep = getCall(url);
				 JSONObject phoneData = new JSONObject(rep.body().asString());
				 url = phoneData.getString("shareurl");
				 price = String.valueOf(phoneData.get("offer_price"));
				 paytm_output.add("Rs."+price+" "+name+"  "+"Website is Paytm "+"Link: "+url);
			 }
			 
		}
		System.out.println("Total number of Paytm phones are: " + paytm_output.size());
		return paytm_output;
	}
	
	//Method to make a get call
	public Response getCall(String request){
		Response rep = given().get(request);
		return rep;
	}
}
