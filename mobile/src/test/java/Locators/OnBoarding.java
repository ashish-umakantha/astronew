package Locators;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class OnBoarding {
	public OnBoarding(AppiumDriver<MobileElement> driver)
	{
		PageFactory.initElements(new AppiumFieldDecorator(driver, 5, TimeUnit.SECONDS), this);
	}
	
	@AndroidFindBy(id="img_launcher_image_3")
	public MobileElement astrologo_launch;
	
	@AndroidFindBy(id="tvCopyright")
	public MobileElement copy_right;
	
	@AndroidFindBy(id="pbCurrentProgress")
	public MobileElement screen_1_loader;
		
	@AndroidFindBy(xpath = "//*[@text='The smart remote control at your fingertips']")
	public MobileElement screen_1_header_text;
	
	@AndroidFindBy(xpath = "//*[@text='Introducing the smart remote control that conveniently changes and controls your decoder right from the app.']")
	public MobileElement screen_1_content_text;
		
	@AndroidFindBy(id="ibVolume")
	public MobileElement screen_1_volume;
	
	@AndroidFindBy(id="ibRewind")
	public MobileElement screen_1_rewind;
	
	@AndroidFindBy(id="ibPlay")
	public MobileElement screen_1_play;
	
	@AndroidFindBy(id="ibPause")
	public MobileElement screen_1_pause;
	
	@AndroidFindBy(id="ibStop")
	public MobileElement screen_1_stop;
	
	@AndroidFindBy(id="ibFastForward")
	public MobileElement screen_1_forward;
	
	@AndroidFindBy(id="ll_indicators")
	public MobileElement screen_indicators;
	
	@AndroidFindBy(id="img_indicator_1")
	public MobileElement screen_indicator_1;
	
	@AndroidFindBy(id="img_indicator_2")
	public MobileElement screen_indicator_2;
	
	@AndroidFindBy(id="img_indicator_3")
	public MobileElement screen_indicator_3;
	
	@AndroidFindBy(id="img_indicator_4")
	public MobileElement screen_indicator_4;
	
	@AndroidFindBy(className="android.widget.ImageView")
	public MobileElement screen_mobile_img;
	
	@AndroidFindBy(xpath = "//*[@text='Plan your TV schedule']")
	public MobileElement screen_2_header_text;
	
	@AndroidFindBy(xpath="//*[@text='With the 7-day TV guide at the palm of your hand, you won't miss the TV programmes you want to watch.']")
	public MobileElement screen_2_content_text;
	
	@AndroidFindBy(id="img_discover_5")
	public MobileElement screen_3_img;
	
	@AndroidFindBy(xpath="//*[@text= 'Discover New & Engaging Content']")
	public MobileElement screen_3_header_text;
	
	@FindBy(name="Discover what's on anytime, anywhere. "
			+ "Have fun exploring Astro. There's always something for everyone.")
	public MobileElement screen_3_content_text;
	
	@AndroidFindBy(id="img_remote_tv_border")
	public MobileElement screen_4_tv_img;
	
	@AndroidFindBy(id="signal_line_3")
	public MobileElement screen_4_signal_line_3;
	
	@AndroidFindBy(id="signal_line_2")
	public MobileElement screen_4_signal_line_2;
	
	@AndroidFindBy(id="signal_line_1")
	public MobileElement screen_4_signal_line_1;
	
	@AndroidFindBy(id="img_remote_mobile")
	public MobileElement screen_4_mob_img;
	
	@AndroidFindBy(id="ll_image")
	public MobileElement screen_4_all_img;
	
	@AndroidFindBy(xpath="//*[@text= 'Never miss your favourite show again']")
	public MobileElement screen_4_header_text;
	
	@AndroidFindBy(xpath="//*[@text= 'You can easily record a show at your fingertip while you are away from your remote control.']")
	public MobileElement screen_4_content_text;
	
	@AndroidFindBy(className="android.widget.RelativeLayout")
	public MobileElement relative_view;
	
	@AndroidFindBy(className="android.widget.ProgressBar")
	public MobileElement loader;
		
}
