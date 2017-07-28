package Locators;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.support.PageFactory;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class HomePage {
	// This constructor will initialize all my objects which takes driver type as parameter
	public HomePage(AppiumDriver<MobileElement> driver)
	{
		PageFactory.initElements(new AppiumFieldDecorator(driver, 5, TimeUnit.SECONDS), this);
		
	}
	
	// Using annotations for defining locators
	@AndroidFindBy(id="action_search")
	public MobileElement home_search_icon;
	
	@AndroidFindBy(id="img_banner_image")
	public MobileElement hero_banner_img;
	
	@AndroidFindBy(id="toolbar_image")
	public MobileElement astro_toolbar_title;
	
	@AndroidFindBy(id="banner_info_title")
	public MobileElement hero_banner_title;
	
	@AndroidFindBy(id="banner_info_date")
	public MobileElement hero_banner_date;
	
	@AndroidFindBy(id="banner_remote_booking_btn")
	public MobileElement remote_booking_btn;
	
	@AndroidFindBy(id="banner_reminder_btn")
	public MobileElement hero_reminder_btn;
	
	@AndroidFindBy(id="banner_content_bottom")
	public MobileElement banner_content;
	
	@AndroidFindBy(id="tv_landing_quicklink_discover")
	public MobileElement quick_link_discover_tab;
	
	@AndroidFindBy(id="tv_landing_quicklink_channels")
	public MobileElement quick_link_channels_tab;
	
	@AndroidFindBy(id="tv_landing_quicklink_tvguide")
	public MobileElement quick_link_tv_guide_tab;
	
	@AndroidFindBy(id="tv_landing_quicklink_ondemand")
	public MobileElement quick_link_on_demand_tab;
	
	@AndroidFindBy(id="tv_landing_quicklink_remote_control")
	public MobileElement quick_link_remote_control_tab;
	
	@AndroidFindBy(className="android.widget.LinearLayout")
	public MobileElement linear_view;
	
	@AndroidFindBy(className="android.widget.FrameLayout")
	public MobileElement frame_layout_view;
	
	@AndroidFindBy(id="img_channel_show")
	public MobileElement channel_show_img;
	
	@AndroidFindBy(className="android.widget.RelativeLayout")
	public MobileElement relative_layout_view;
	
	@AndroidFindBy(id="rl_banner_content")
	public MobileElement banner_view;
	
	@AndroidFindBy(xpath = "//*[@resource-id='com.astro.astroview:id/rv_listing']/android.widget.FrameLayout[@index='1']")
	public MobileElement second_show;
	
	@AndroidFindBy(xpath = "//*[@resource-id='com.astro.astroview:id/tv_tab_title'][@index='2']")
	public MobileElement favorite_tab;
	
	@AndroidFindBy(id="tv_show_title")
	public MobileElement show_title;
	
	@AndroidFindBy(id="tv_favourite_empty_title")
	public MobileElement favorite_empty;
	
}

