package tek.bdd.capstone.config;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Capstone_EdgeBrowser implements Capstone_Browser1 {

	@Override
	public WebDriver openBrowser(String url) {
		
		WebDriverManager.edgedriver().setup();
		WebDriver driver = new EdgeDriver();
		driver.get(url);
		return driver;
	}
	
	

}
