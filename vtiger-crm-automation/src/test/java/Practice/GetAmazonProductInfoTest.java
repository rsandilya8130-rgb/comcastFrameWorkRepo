package Practice;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.comcast.crm.generic.fileutility.ExcelUtility;

public class GetAmazonProductInfoTest {

	@Test(dataProvider = "getData")
	public void getProductInfoTest(String BrandName, String ProductName) {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.manage().window().maximize();

		driver.get("http://amazon.in");

		// Search Product
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys(BrandName, Keys.ENTER);

		// capture product price
		String x = "//span[text()='"+ProductName+"']/../../../../../div[3]/div/div/div/div/div/a/span/span/span[2]";
		String price = driver.findElement(By.xpath(x)).getText();
		System.out.println(price);

		driver.quit();
	}

	@DataProvider
	public Object[][] getData() throws IOException {
		ExcelUtility eu = new ExcelUtility();
		int rowcount= eu.getRowCount("Product");
		
		Object[][] ObjArr = new Object[rowcount][2];
		for(int i=0; i<rowcount;i++) {
		ObjArr[i][0] =eu.getDataFromExcelFile("Product", i+1, 0);
		ObjArr[i][1] = eu.getDataFromExcelFile("Product", i+1, 1);
		}
		return ObjArr;
	}

}
