package CommmonResources;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import static org.testng.Assert.fail;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;
import Locators.HomePage;
import Locators.ShowLocators;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.SwipeElementDirection;

public class AddingFavMethods {
	public HomePage HomeLocators;
	public ShowLocators ShowLocators;
	public WebDriverWait wait;
	public SoftAssert sa;
	public CommonMethods methods;
	
	public void ShowTestCase(AppiumDriver<MobileElement> driver) throws Exception
	   {
		   HomeLocators = new HomePage(driver);
		   ShowLocators = new ShowLocators(driver);
		   wait=new WebDriverWait(driver,30);
		   sa = new SoftAssert();
		   methods = new CommonMethods();
		   //Below are validating all ui - it covers ui cases as well.
		   sa.assertTrue(methods.elementDisplayed(driver,HomeLocators.home_search_icon, 5), "Search icon not displayed");
		   sa.assertTrue(methods.elementDisplayed(driver,HomeLocators.astro_toolbar_title, 5), "Home title not displayed");
		   sa.assertTrue(methods.elementDisplayed(driver,HomeLocators.hero_banner_img, 5), "Hero banner image not displayed");
		   sa.assertTrue(methods.elementDisplayed(driver,HomeLocators.hero_banner_title, 5), "Hero banner title not displayed");
		   sa.assertTrue(methods.elementDisplayed(driver,HomeLocators.hero_banner_date, 5), "Hero banner date not displayed");
		   //I am using wait.until for achieving explicit wait (15 sec) with as reminder and booking btn is not seen for all hero title. 
		   wait.until(ExpectedConditions.visibilityOf(HomeLocators.hero_reminder_btn));
		   wait.until(ExpectedConditions.visibilityOf(HomeLocators.remote_booking_btn));
		   sa.assertTrue(methods.elementDisplayed(driver,HomeLocators.banner_content, 5), "Hero banner content not displayed");
		   sa.assertTrue(methods.elementDisplayed(driver,HomeLocators.quick_link_discover_tab, 5), "Discovery tab not displayed");
		   sa.assertTrue(methods.elementDisplayed(driver,HomeLocators.quick_link_channels_tab, 5), "Channels tab not displayed");
		   sa.assertTrue(methods.elementDisplayed(driver,HomeLocators.quick_link_tv_guide_tab, 5), "Tv guide tab not displayed");
		   sa.assertTrue(methods.elementDisplayed(driver,HomeLocators.quick_link_on_demand_tab, 5), "On demand tab not displayed");
		   sa.assertTrue(methods.elementDisplayed(driver,HomeLocators.quick_link_remote_control_tab, 5), "Remote tab not displayed");
		   assertTrue(methods.elementDisplayed(driver, HomeLocators.channel_show_img, 10), "Must see shows not loaded");
//		   wait.until(ExpectedConditions.visibilityOf(HomeLocators.channel_show_img));
		   HomeLocators.banner_view.swipe(SwipeElementDirection.UP, 10, 10, 1000);
		   sa.assertTrue(methods.elementDisplayed(driver,HomeLocators.frame_layout_view, 5), "Framelayout view not displayed");
		   sa.assertTrue(methods.elementDisplayed(driver,HomeLocators.channel_show_img, 5), "Channels img not displayed");
		   HomeLocators.second_show.click();
		   wait.until(ExpectedConditions.visibilityOf(ShowLocators.show_img));
		   sa.assertTrue(methods.elementDisplayed(driver,ShowLocators.show_title, 5), "Show title not displayed");
		   sa.assertTrue(methods.elementDisplayed(driver,ShowLocators.show_availability, 5), "Show availability details not displayed");
		   sa.assertTrue(methods.elementDisplayed(driver,ShowLocators.fab_menu, 5), "Show fab menu btn not displayed");
		   sa.assertTrue(methods.elementDisplayed(driver, ShowLocators.expand_btn , 5), "Expand btn not dispalyed");
		   sa.assertTrue(methods.elementDisplayed(driver,ShowLocators.short_content, 5), "Synopsis short content not displayed");		   
		   verifySynopsis(driver);
		   AddReminder(driver);
		   sa.assertTrue(methods.elementDisplayed(driver, HomeLocators.second_show, 5), "Second show not displayed");
		   HomeLocators.second_show.click();
		   wait.until(ExpectedConditions.visibilityOf(ShowLocators.show_img));
		   AddFav(driver);
	   }
	
	// Method for Verifying Synopsis length is more than 50 characters.
	public void verifySynopsis(AppiumDriver<MobileElement> driver)
	{
		ShowLocators = new ShowLocators(driver);
		methods = new CommonMethods();
		if (methods.elementDisplayed(driver, ShowLocators.expand_btn , 5) == true)
		{
			ShowLocators.expand_btn.click();
			assertTrue(methods.elementDisplayed(driver,ShowLocators.expanded_content, 5), "Synopsis expaned content not displayed");
			String expanded = ShowLocators.expanded_content.getAttribute("text");
			int length = expanded.length();
			if (length <= 50)
			{
				fail("Synopsis length is less than 50 charcters");
			}
		}
		else if (methods.elementDisplayed(driver, ShowLocators.expanded_content , 5) == true)
		{
			String expanded = ShowLocators.expanded_content.getAttribute("text");
			int length = expanded.length();
			if (length <= 50)
			{
				fail("Synopsis length is less than 50 charcters");
			}
		}
			
	}
	
	//Method for adding reminder
	public void AddReminder(AppiumDriver<MobileElement> driver) throws InterruptedException
	{	
		wait=new WebDriverWait(driver,15);
		ShowLocators = new ShowLocators(driver);
		methods = new CommonMethods();
		sa = new SoftAssert();
		assertTrue(methods.elementDisplayed(driver,ShowLocators.fab_menu, 5), "Show fab menu btn not displayed");
		ShowLocators.fab_menu.click();
		assertTrue(methods.elementDisplayed(driver,ShowLocators.fab_menu_reminder, 5), "Reminder btn not displayed");
		sa.assertTrue(methods.elementDisplayed(driver,ShowLocators.fab_menu_close, 5), "Show fab menu close btn not displayed");
		ShowLocators.fab_menu_reminder.click();
		assertTrue(methods.elementDisplayed(driver,ShowLocators.dialog_title, 10), "Dialog title not displayed");
		assertTrue(methods.elementDisplayed(driver,ShowLocators.dialog_msg, 5), "Dialog msg not displayed");
		assertTrue(methods.elementDisplayed(driver,ShowLocators.dialog_ok, 5), "Dialog ok btn not displayed");
		ShowLocators.dialog_ok.click();
		driver.navigate().back();
	}
	
	//Method for adding favorite
	public void AddFav(AppiumDriver<MobileElement> driver) throws Exception
	{
		wait=new WebDriverWait(driver,15);
		ShowLocators = new ShowLocators(driver);
		HomeLocators = new HomePage(driver);
		methods = new CommonMethods();
		assertTrue(methods.elementDisplayed(driver,ShowLocators.fab_menu, 5), "Show fab menu btn not displayed");
		ShowLocators.fab_menu.click();
		String before_title = ShowLocators.show_title.getAttribute("text");
		assertTrue(methods.elementDisplayed(driver,ShowLocators.fab_menu_fav, 5), "Favorite btn not displayed");
		ShowLocators.fab_menu_fav.click();
		driver.navigate().back();
		wait.until(ExpectedConditions.visibilityOf(HomeLocators.favorite_tab));
		HomeLocators.favorite_tab.click();
		String after_title = HomeLocators.show_title.getAttribute("text");
		assertEquals(after_title, before_title, "Title does not match");
		HomeLocators.show_title.click();
		assertTrue(methods.elementDisplayed(driver,ShowLocators.fab_menu, 5), "Show fab menu btn not displayed");
		ShowLocators.fab_menu.click();
		assertTrue(methods.elementDisplayed(driver,ShowLocators.fab_menu_fav, 5), "Favorite btn not displayed");
		ShowLocators.fab_menu_fav.click();
		driver.navigate().back();
		if (HomeLocators.favorite_empty.isDisplayed())
		{
			System.out.println("Favorite list is empty");
		}
		
	}
	
}
