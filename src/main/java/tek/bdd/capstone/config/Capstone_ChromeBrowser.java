package tek.bdd.capstone.config;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Capstone_ChromeBrowser implements Capstone_Browser1 {

	@Override
	public WebDriver openBrowser(String url) {
	
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get(url);
		return driver;
				
	}
	
}
