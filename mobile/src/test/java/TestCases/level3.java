package TestCases;
import java.net.URL;
import java.util.concurrent.TimeoutException;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import CommmonResources.AddingFavMethods;
import CommmonResources.CommonMethods;
import CommmonResources.ReadConfigFile;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class level3 {
	
public AppiumDriver<MobileElement> driver;
public ReadConfigFile data;
public CommonMethods common;
public AddingFavMethods fav;

@BeforeClass
public void setUp() throws Exception
{
	//Set up desired capabilities and pass the Android app path to Appium
	data = new ReadConfigFile();
	DesiredCapabilities capabilities = new DesiredCapabilities();
	capabilities.setCapability("platformVersion", data.getPlatformVersion()); 
	capabilities.setCapability("deviceName", data.getDeviceName());
	capabilities.setCapability("platformName","Android");
	capabilities.setCapability("app", data.getApkPath() );
	//Create AndroidDriver instance and connect to the Appium server
	driver = new AndroidDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"), capabilities);
	//It will launch the Astro App in Android Device using the configurations specified in Desired Capabilities
	}
	
 @Test
  public void level3_case() throws Exception,TimeoutException
  {
	  common = new CommonMethods();
	  fav = new AddingFavMethods();
	  //Below are the methods which performs the tests using Key word driven approach
	  common.SkipOnboarding(driver);
	  common.login(driver);	  
	  fav.ShowTestCase(driver);
  }
    
  @AfterClass
  public void teardown(){
  	//close the app
	  if (driver != null)
	  {
		  driver.quit();
	  }
  	
  }
}
