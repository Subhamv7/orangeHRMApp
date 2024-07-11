package candidateInformation;

import java.io.IOException;
import java.util.Random;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.comcast.hrm.baseUtility.BaseClassTest;
import com.comcast.hrm.fileUtility.ExcelUtility;

public class AddCandidateTest extends BaseClassTest {

	ExcelUtility elib = new ExcelUtility();

	Random ran = new Random();
	int randomNum = ran.nextInt(5000);

	@Test

	public void sampleTest() throws EncryptedDocumentException, IOException, InterruptedException {

		Thread.sleep(3000);

		String randomEmail = elib.getDataFromExcel("candidate", 1, 2) + randomNum + "@gmail.com";

		String fn = elib.getDataFromExcel("candidate", 1, 0) + randomNum;
		String ln = elib.getDataFromExcel("candidate", 1, 1) + randomNum;

		driver.findElement(By.xpath(
				"//span[@class='oxd-text oxd-text--span oxd-main-menu-item--name'][normalize-space()='Recruitment']"))
				.click();
		driver.findElement(By.xpath("//button[normalize-space()='Add']")).click();

		driver.findElement(By.name("firstName")).sendKeys(fn);

		driver.findElement(By.name("lastName")).sendKeys(ln);
		driver.findElement(By.xpath("(//input[@class=\"oxd-input oxd-input--active\"])[2]")).sendKeys(randomEmail);
		driver.findElement(By.xpath("//button[text()=\" Save \"]")).click();

		WebElement actualName = driver.findElement(By.xpath(
				"(//h6[@class=\"oxd-text oxd-text--h6 orangehrm-main-title\"])[1]/..//p[text()='"+fn+" "+ln+"']"));
		String expectedName = actualName.getText();

		Assert.assertEquals(expectedName, actualName);

	}

}
