package Locators;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.support.PageFactory;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class loginPage {
	
	public loginPage(AppiumDriver<MobileElement> driver)
	{
		PageFactory.initElements(new AppiumFieldDecorator(driver, 5, TimeUnit.SECONDS), this);
	}
	
	@AndroidFindBy(id="img_astro_view_logo")
	public MobileElement astrologo_login_logo;
	
	@AndroidFindBy(id="tv_desc")
	public MobileElement astrologo_login_text;
	
	@AndroidFindBy(id="btn_ftu_login")
	public MobileElement astrologo_login_btn;
	
	@AndroidFindBy(id="btn_ftu_signup")
	public MobileElement astrologo_sign_up_btn;
	
	@AndroidFindBy(id="tv_skip_ftu_login")
	public MobileElement astrologo_skip_btn;
	
	@AndroidFindBy(id="body_txtAstroID")
	public MobileElement login_field;
	
	@AndroidFindBy(id="body_txtPassword")
	public MobileElement password_field;
	
	@AndroidFindBy(id="body_btnLogin")
	public MobileElement web_view_login_btn;
	
	@AndroidFindBy(id="com.astro.astroview:id/btn_agree")
	public MobileElement agree_btn;
	
	@AndroidFindBy(id="com.astro.astroview:id/btn_cancel")
	public MobileElement disagree_btn;
	
	@AndroidFindBy(id="com.astro.astroview:id/action_search")
	public MobileElement home_search_icon;
	
}
