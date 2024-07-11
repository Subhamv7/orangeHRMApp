package candidateInformation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class OpenBrowserTest {
	WebDriver driver;
	
	@Test
	@Parameters("browser")
	public void sampleTest(String BROWSER) {
		
		
		if (BROWSER.equals("chrome")) {
			driver = new ChromeDriver();
			
		} else if (BROWSER.equals("firefox")) {
			driver = new FirefoxDriver();
			
		}else {
			driver = new ChromeDriver();
		} {

		}
		
		
	}

}
