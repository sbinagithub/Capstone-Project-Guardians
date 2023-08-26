package tek.bdd.capstone.config;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Capstone_ChromeHeadless implements Capstone_Browser1 {

	@Override
	public WebDriver openBrowser(String url) {
	
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--headless");
		WebDriver driver = new ChromeDriver(options);
		driver.get(url);
		return driver;
	}

	
}
