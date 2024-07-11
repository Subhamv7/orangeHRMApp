package com.comcast.hrm.baseUtility;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import com.comcast.hrm.fileUtility.FileUtility;

public class BaseClassTest {

	public  FileUtility flib = new FileUtility();
 public WebDriver driver = null;

	@BeforeClass
	public void configBC() throws IOException {

		System.out.println("===Launch Browser===");

		String BROWSER = System.getProperty("browser", flib.getDataFromFile("browser"));

		if (BROWSER.equals("chrome")) {
			driver = new ChromeDriver();

		} else if (BROWSER.equals("firefox")) {
			driver = new FirefoxDriver();

		} else if (BROWSER.equals("edge")) {
			driver = new EdgeDriver();

		} else {
			driver = new ChromeDriver();
		}

	}

	@BeforeMethod
	public void configBM() throws IOException {

		String URL = System.getProperty("url", flib.getDataFromFile("url"));
		String USERNAME = System.getProperty("username", flib.getDataFromFile("username"));
		String PASSWORD = System.getProperty("password", flib.getDataFromFile("password"));

		driver.manage().window().maximize();
		driver.get(URL);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys(USERNAME);
		driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys(PASSWORD);
		driver.findElement(By.xpath("//button[@type='submit']")).click();

	}

	@AfterClass
	public void configAC() {

		System.out.println("==Close Browser==");
		driver.quit();

	}

	@AfterMethod
	public void configAM() {

		System.out.println("===sign out===");
		driver.findElement(By.xpath("//p[@class='oxd-userdropdown-name']")).click();
		driver.findElement(By.xpath("//a[normalize-space()='Logout']")).click();
	}

}
