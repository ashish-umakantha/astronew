package CommmonResources;

import java.io.InputStream;
import java.util.Properties;

public class ReadConfigFile {

	Properties property_obj = null;
	InputStream input = ReadConfigFile.class.getResourceAsStream("/config.properties");

	public ReadConfigFile() throws Exception  
	{
		property_obj = new Properties();
		property_obj.load(input);
	}
	
	public String getLogin()
	{
		return property_obj.getProperty("login");
	}
	
	public String getPassword()
	{
		return property_obj.getProperty("password");
	}
	
	public String getPlatformVersion()
	{
		return property_obj.getProperty("platformVersion");
	}
	
	public String getDeviceName()
	{
		return property_obj.getProperty("deviceName");
	}
	
	public String getPlatformName()
	{
		return property_obj.getProperty("platformName");
	}
	
	public String getApkPath()
	{
		return property_obj.getProperty("apkPath");
	}
}
