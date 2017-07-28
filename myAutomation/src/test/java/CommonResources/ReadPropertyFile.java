package CommonResources;

import java.io.InputStream;
import java.util.Properties;

public class ReadPropertyFile {
	
	Properties property_obj = null;
	InputStream input = ReadPropertyFile.class.getResourceAsStream("/config.properties");

	public ReadPropertyFile() throws Exception  {
		property_obj = new Properties();
		property_obj.load(input);
	}
	
	
	public String getUrl()
	{
		return property_obj.getProperty("url");
	}
	
	public String getFirstname()
	{
		return property_obj.getProperty("firstname");
	}
	
	public String getLastname()
	{
		return property_obj.getProperty("lastname");
	}
	
	public String getEmail()
	{
		return property_obj.getProperty("email");
	}
	
	public String getPassword()
	{
		return property_obj.getProperty("password");
	}
	
	public String getEcommerceUrl1()
	{
		return property_obj.getProperty("ecommerce1");
	}
	
	public String getEcommerceUrl2()
	{
		return property_obj.getProperty("ecommerce2");
	}
	
	public String getSearchText()
	{
		return property_obj.getProperty("text");
	}
}
