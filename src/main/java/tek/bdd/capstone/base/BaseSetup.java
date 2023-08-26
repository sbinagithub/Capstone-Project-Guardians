package tek.bdd.capstone.base;

import java.io.FileNotFoundException;
import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;

import tek.bdd.capstone.config.Capstone_Browser1;
import tek.bdd.capstone.config.Capstone_ChromeBrowser;
import tek.bdd.capstone.config.Capstone_ChromeHeadless;
import tek.bdd.capstone.config.Capstone_EdgeBrowser;
import tek.bdd.capstone.config.Capstone_FireFoxBrowser;
import tek.bdd.capstone.utilities.Capstone_ReadYamlFiles;


public class  BaseSetup{
	
	private static WebDriver webDriver;
	private final Capstone_ReadYamlFiles environmentVariables;
	public static Logger logger;
	
	public BaseSetup() {
		// we need the path to env_capstone_config.yml file and store it in a String variable
		String filePath = System.getProperty("user.dir") + "/src/main/resources/env_capstone_config.yml";
		// if i don't use this System.getProperty we can just use a . before the path and than after . paste the path
		// like this 
		// String filePath = ".\\src\\main\\resources\\env_capstone_config.yml"; // and this is the path
		// but the proper ways to use System.getProperty so we are in project level than concatanate + with the file path
		
		// we need the path to the log4j_capstone.properties file and store it in a String variable
		String log4JPath = System.getProperty("user.dir") +"/src/main/resources/log4j_capstone.properties";
		
		// here we get instance of our project configuration file (env_capstone_config.yaml)
		// go to ReadYamlFiles we create a method getInstance and that will return instance of ReadYamlFiles
		// here it will throw an error we can try with try catch block
		try {
			environmentVariables = Capstone_ReadYamlFiles.getInstance(filePath);
			// this environmentVariables we can copy and paste it from line 23
			
		} catch(FileNotFoundException e) {
			System.out.println("Failed for Load environment context. check possible file path errors");
			throw new RuntimeException("Failed for Load environment context with message " + e.getMessage());
			
		}
		// initialize our logger
		// than configure our log4j using the PropertyConfigurator class
		// we copy logger from the top line 24 just logger and then initialize to logger.getLogger logger and it will take 
		// String as a parameters you can pass logger file but it doesn't need to be logger file it can be any String text
		logger = Logger.getLogger("logger_File");
		// now we pass propertyConfigurator class and there is a method call .cofigure click on the first one and we pass
		// the log4JPath line 35 copy log4JPath and paste it in the configure( ) 
		PropertyConfigurator.configure(log4JPath);
		
	}
	// now next method is we create for instance of WebDriver
	// and the return is webDriver we can copy from line 22 and paste it that we create in class level and the w is in 
	// lowercase. So here we just return webDriver to call the WebDriver method
	public WebDriver getDriver() {
		return webDriver;
	}
	// Now we create one method to setup our browser
	// But before doing that, what we have to do is we have to get the project configuration from our YAML file.
	// so again we will go to ReadYamlFiles class we have a method f we go back to our read YAML file, 
	// we have this one method can get YAML property and remember we said if we use a key it will return the value for us.
	public void setupBrowser() {
   //What we can do is we can store this in a hashmap  and we can also use a reference HashMap instruction.
		HashMap uiProperties = environmentVariables.getYamlProperty("ui");
// Now we need the URL to lanuch the browser
//So what we do is we type URL  and then toString, make sure that the URL we get and our base setup page that URL is string
//That URL is a string OK because and driver dot get method we need to pass the URL as a string right?
		String ur1 = uiProperties.get("url").toString().toLowerCase();
		
// Now we have one Interface Browser which i named here Capstone_Browser1 through that 
// we can access each one of the browser classes, so we can create instance of that here
// and we can import this browser from tek.bdd.capstone.config package
		Capstone_Browser1 browser;
		// Now we can create our Switch statment
		// here what we do we get the browser name
		switch (uiProperties.get("browser").toString().toLowerCase()) {
		case "chrome":
			if((boolean) uiProperties.get("headless")){
				browser = new Capstone_ChromeHeadless();
				
			}else {
				browser = new Capstone_ChromeBrowser();
			}
			webDriver = browser.openBrowser(ur1);
			break;
		case "firefox":
			browser = new Capstone_FireFoxBrowser();
			webDriver = browser.openBrowser(ur1);
			break;
		case "edge":
			browser = new Capstone_EdgeBrowser() ;
		break;
		default:
			throw new RuntimeException("Unknown Browser check environment properties");
	
		}
		webDriver.manage().window().maximize();
		webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		webDriver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
	}
	public void quitBrowser() {
		if(webDriver !=null)
			webDriver.quit();
	}
			
				
		
	

}
