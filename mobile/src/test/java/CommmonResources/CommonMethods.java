package CommmonResources;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;
import static org.testng.Assert.assertTrue;
import Locators.OnBoarding;
import Locators.loginPage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.SwipeElementDirection;

public class CommonMethods {
	public ReadConfigFile data;
	public WebDriverWait wait;
	public loginPage LogLocators;
	public OnBoarding OnOboardLocators;
	public SoftAssert sa;
	
	//Method for login.
	public void login(AppiumDriver<MobileElement> driver) throws Exception
	   {
		   LogLocators = new loginPage(driver);
		   data = new ReadConfigFile();
		   wait=new WebDriverWait(driver,10);
		   sa = new SoftAssert();
		   sa.assertTrue(elementDisplayed(driver,LogLocators.astrologo_login_logo, 5), "Login logo not displayed");
		   assertTrue(elementDisplayed(driver,LogLocators.astrologo_login_btn, 5), "Login btn not displayed");
		   sa.assertTrue(elementDisplayed(driver,LogLocators.astrologo_login_text, 5), "Login text not displayed");
		   sa.assertTrue(elementDisplayed(driver,LogLocators.astrologo_sign_up_btn, 5), "Sign up btn not displayed");
		   sa.assertTrue(elementDisplayed(driver,LogLocators.astrologo_skip_btn, 5), "Skip btn not displayed");
		   LogLocators.astrologo_login_btn.click();
		   sa.assertTrue(elementDisplayed(driver,LogLocators.login_field, 5), "Login field not displayed");
		   LogLocators.login_field.sendKeys(data.getLogin());
		   driver.hideKeyboard();
		   LogLocators.password_field.sendKeys(data.getPassword());
		   driver.hideKeyboard();
		   LogLocators.web_view_login_btn.click();
		   sa.assertTrue(elementDisplayed(driver, LogLocators.agree_btn, 5), "Agree btn not dispalyed");  
		   //Condition to check if agreement page is seen or home page is seen.
		   if (LogLocators.agree_btn.isDisplayed() == true)
		   {
			   System.out.println("Agreement page displayed");
			   sa.assertTrue(elementDisplayed(driver, LogLocators.disagree_btn, 5), "Disagree btn not dispalyed");
			   LogLocators.agree_btn.click();
			   assertTrue(elementDisplayed(driver, LogLocators.home_search_icon, 5), "Home search icon not displayed");
		   }
		   
		   else
		   {
			   assertTrue(elementDisplayed(driver, LogLocators.home_search_icon, 5), "Home search icon not displayed");
		   }
		 
	   }
	//Method for skipping Onboarding screen
	public void SkipOnboarding(AppiumDriver<MobileElement> driver) throws InterruptedException
	   {
		   OnOboardLocators = new OnBoarding(driver);
		   sa = new SoftAssert();
		   wait=new WebDriverWait(driver,10);
		   sa.assertTrue(elementDisplayed(driver,OnOboardLocators.astrologo_launch, 5), "Launch logo not displayed");
		   sa.assertTrue(elementDisplayed(driver,OnOboardLocators.loader, 5), "Screen 1 loader not displayed");
		   assertTrue(elementDisplayed(driver,OnOboardLocators.screen_1_header_text, 5), "Screen 1 header text not displayed");
		   sa.assertTrue(elementDisplayed(driver,OnOboardLocators.screen_1_volume, 5), "Volume id not displayed");
		   sa.assertTrue(elementDisplayed(driver,OnOboardLocators.screen_1_loader, 5), "Screen 1 loader not displayed");
		   sa.assertTrue(elementDisplayed(driver,OnOboardLocators.screen_1_content_text, 5), "Screen 1 content text not displayed");
		   sa.assertTrue(elementDisplayed(driver,OnOboardLocators.screen_1_rewind, 5),  "Rewind id not displayed");
		   sa.assertTrue(elementDisplayed(driver,OnOboardLocators.screen_1_play, 5), "Play id not displayed");
		   sa.assertTrue(elementDisplayed(driver,OnOboardLocators.screen_1_pause, 5), "Pause id not displayed");
		   sa.assertTrue(elementDisplayed(driver,OnOboardLocators.screen_1_stop, 5), "Stop id not displayed");
		   sa.assertTrue(elementDisplayed(driver,OnOboardLocators.screen_1_forward, 5), "Forward id not displayed");
		   sa.assertTrue(elementDisplayed(driver,OnOboardLocators.screen_1_loader, 5 ), "Screen 1 loader not displayed");
		   sa.assertTrue(elementDisplayed(driver,OnOboardLocators.screen_indicator_1, 5), "Indicator 1 not displayed");
		   sa.assertTrue(elementDisplayed(driver,OnOboardLocators.screen_indicator_2, 5), "Indicator 2 not displayed");
		   sa.assertTrue(elementDisplayed(driver,OnOboardLocators.screen_indicator_3, 5), "Indicator 3 not displayed");
		   sa.assertTrue(elementDisplayed(driver,OnOboardLocators.screen_indicator_4, 5), "Indicator 4 not displayed");
		   OnOboardLocators.relative_view.swipe(SwipeElementDirection.LEFT,10,20,1000);
		   sa.assertTrue(elementDisplayed(driver,OnOboardLocators.screen_2_header_text, 5), "Screen 2 header text not displayed");
		   OnOboardLocators.relative_view.swipe(SwipeElementDirection.LEFT,10,20,1000);
		   sa.assertTrue(elementDisplayed(driver,OnOboardLocators.screen_3_img, 5), "Screen 3 image not displayed");
		   sa.assertTrue(elementDisplayed(driver,OnOboardLocators.screen_3_header_text, 5), "Screen 3 header text not displayed");
		   OnOboardLocators.relative_view.swipe(SwipeElementDirection.LEFT,10,20,1000);
		   sa.assertTrue(elementDisplayed(driver,OnOboardLocators.screen_4_all_img, 5), "Screen 4 image not displayed");
		   sa.assertTrue(elementDisplayed(driver,OnOboardLocators.screen_4_content_text, 5), "Screen 4 content text not displayed");
		   sa.assertTrue(elementDisplayed(driver,OnOboardLocators.screen_4_header_text, 5), "Screen 4 header text not displayed");
		   sa.assertTrue(elementDisplayed(driver,OnOboardLocators.screen_4_signal_line_1, 5), "Screen 4 signal line 1 not displayed");
		   sa.assertTrue(elementDisplayed(driver,OnOboardLocators.screen_4_signal_line_2, 5), "Screen 4 signal line 2 not displayed");
		   sa.assertTrue(elementDisplayed(driver,OnOboardLocators.screen_4_signal_line_3, 5), "Screen 4 signal line 3 not displayed");
		   sa.assertTrue(elementDisplayed(driver,OnOboardLocators.screen_4_tv_img, 5), "Screen 4 tv image not displayed");
		   OnOboardLocators.relative_view.swipe(SwipeElementDirection.LEFT,10,20,1000);
	   }
	
	//Generic method for checking if the element exists, this will return a boolean value
	public boolean elementDisplayed(AppiumDriver<MobileElement> driver, MobileElement me,int time){
		  boolean elementDisplayed = false;
		  l1:for(int i=0;i<time;i++){
			   try{

				   if(me!=null){
					    if(me.isDisplayed()){
					    	elementDisplayed=true;
					    	break l1;
					    }
					   
				   }
			   }catch(Exception e){
				   System.err.println("Unable to fetch the element");
			   }
			   try{
				   Thread.sleep(500);
			   }catch(Exception e){
				   System.err.println("Error in element sleep");
			   }
			  
		  }
		  return elementDisplayed;
	  }
}
