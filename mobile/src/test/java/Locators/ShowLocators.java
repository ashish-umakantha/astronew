package Locators;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.support.PageFactory;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class ShowLocators {
	
	public ShowLocators(AppiumDriver<MobileElement> driver)
	{
		PageFactory.initElements(new AppiumFieldDecorator(driver, 5, TimeUnit.SECONDS), this);
	}
	
	@AndroidFindBy(id="tv_show_details_title")
	public MobileElement show_title;
	
	@AndroidFindBy(id="tv_show_details_availability")
	public MobileElement show_availability;
	
	@AndroidFindBy(id="action_search")
	public MobileElement search_icon;
	
	@AndroidFindBy(id="img_expand_arrow")
	public MobileElement expand_btn;
	
	@AndroidFindBy(id="tv_show_short_desc")
	public MobileElement short_content;
	
	@AndroidFindBy(id="fl_overlay")
	public MobileElement show_img;
	
	@AndroidFindBy(id="fab_more")
	public MobileElement fab_menu;
	
	@AndroidFindBy(id="tv_show_long_desc")
	public MobileElement expanded_content;
	
	@AndroidFindBy(id="img_close_action")
	public MobileElement fab_menu_close;
	
	@AndroidFindBy(id="img_remote_booking_action")
	public MobileElement fab_menu_remote;
	
	@AndroidFindBy(id="img_reminder_action")
	public MobileElement fab_menu_reminder;
	
	@AndroidFindBy(id="img_favourite_action")
	public MobileElement fab_menu_fav;
		
	@AndroidFindBy(id="img_share_action")
	public MobileElement fab_menu_share;
	
	@AndroidFindBy(id="android:id/title")
	public MobileElement dialog_title;
	
	@AndroidFindBy(id="android:id/message")
	public MobileElement dialog_msg;
	
	@AndroidFindBy(id="android:id/button1")
	public MobileElement dialog_ok;
	
}
