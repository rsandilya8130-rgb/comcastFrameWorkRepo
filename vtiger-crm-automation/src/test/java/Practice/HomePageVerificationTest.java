package Practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;


public class HomePageVerificationTest {

	@Test
	public void homePageTest() {
		System.out.println("=== Test Start ===");
		String expectedPage = "Home page";

		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().window().maximize();

		driver.get("http://localhost:8888");

		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("manager");
		driver.findElement(By.id("submitButton")).click();

		String actTitle = driver.findElement(By.xpath("//a[contains(text(),'Home')]")).getText();

	//	if (actTitle.trim().equals(expectedPage)) {
	//		System.out.println(expectedPage + " Page is verified===");
	//	} else {
	//		System.out.println(expectedPage + " page is not verified====");
	//	}
		
		//Hard Assert.....
		Assert.assertEquals(actTitle,expectedPage);
		
		System.out.println("===Testend===");
		driver.quit();

	}

}
