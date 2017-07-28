package TestCases;

import org.testng.annotations.Test;
import CommonResources.ReadPropertyFile;
import CommonResources.ecommerceLogic;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.WebDriver;

public class ecommerce {
	public WebDriver driver;
	public ReadPropertyFile data;
	public ecommerceLogic method;


@BeforeClass
public void beforeClass() throws Exception {
	method = new ecommerceLogic();
	  
}

@Test
  public void ecommerceCase() throws Exception 
  {
	  method.output(driver);	
	  
  }  
}
