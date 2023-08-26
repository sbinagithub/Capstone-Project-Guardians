package tek.bdd.capstone.config;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Capstone_FireFoxBrowser implements Capstone_Browser1 {

	@Override
	public WebDriver openBrowser(String url) {
		
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver = new FirefoxDriver();
		driver.get(url);
		return driver;
	}

}
