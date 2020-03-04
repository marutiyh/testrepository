package mavenframework.zestmoney;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import mavenframework.pageobjects.AmazonPage;
import mavenframework.pageobjects.FlipCartPage;

public class TestClass {
	
	WebDriver driver;
	
	@BeforeMethod
	public void preCondition() {
		System.setProperty("webdriver.chrome.driver",".\\drivers\\chromedriver.exe" );
		driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();

	}

	@Test
	public void test() {

		driver.get("https://www.amazon.in");
		AmazonPage amz=new AmazonPage(driver);
		amz.amzPhoneSearch("iPhone XR (64GB) - Yellow");
		String amzPhoneName=amz.getAmazonPhoneName();
		int amzPhonePrice=amz.getAmazonPhonePrice();

		driver.get("https://www.flipkart.com/");
		FlipCartPage flip=new FlipCartPage(driver);
		flip.flipPhoneSearch("iPhone XR (64GB) - Yellow");
		String flipPhoneName=flip.getFlipPhoneName();
		int flipPhonePrice=flip.getFlipPhonePrice();

		if(amzPhonePrice<flipPhonePrice) {
			System.out.println("Amazon mobile price : "+amzPhonePrice);
			System.out.println("Flipcart mobile price : "+flipPhonePrice);
			System.out.println("The Amazon phone : "+amzPhoneName + " price is less than flipcart phone : "+ flipPhoneName+" i.e. : "+(flipPhonePrice-amzPhonePrice) +" amount");
		}else {
			System.out.println("Amazon mobile price : "+amzPhonePrice);
			System.out.println("Flipcart mobile price : "+flipPhonePrice);
			System.out.println("The FlipCart phone : "+flipPhoneName + " price is less than Amazon phone : "+ amzPhoneName +" i.e. : "+(amzPhonePrice-flipPhonePrice) +" amount");

		}
	}

	@AfterMethod
	public void closeBrowser() {
		driver.close();
	}
}
