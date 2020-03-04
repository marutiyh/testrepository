package mavenframework.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FlipCartPage {

	WebDriver driver;
	
	@FindBy(xpath="//input[@placeholder='Search for products, brands and more']")
	private WebElement serachbutton;
	
	@FindBy(xpath="//body/div[@id='container']/div/div[@class='_3ybBIU']/div[@class='_1tz-RS']/div[@class='_3pNZKl']/div[@class='Y5-ZPI']/form[@class='_1WMLwI header-form-search']/div[@class='col-12-12 _2tVp4j']/button[@class='vh79eN']/*[1]")
	private WebElement gobutton;

	@FindBy(xpath="//div[@class='_3wU53n']")
	private WebElement flipphonename;
		
	@FindBy(xpath="//div[@class='_1vC4OE _2rQ-NK']")
	private WebElement flipphoneprice;
	
	@FindBy(xpath="//button[@class='_2AkmmA _29YdH8']")
	private WebElement loginboxclose;
	
	public FlipCartPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void searchPhone(String search) {
		serachbutton.sendKeys(search);
	}
	public void clickGoButton() {
		if(loginboxclose.isDisplayed()) {
			loginboxclose.click();
		}
		gobutton.click();
	}
	public String getFlipPhoneName() {
		return flipphonename.getText();
	}
	public int getFlipPhonePrice() {
		String price=flipphoneprice.getText();
		String afterCurrRemoval=price.substring(1);
		afterCurrRemoval = afterCurrRemoval.replaceAll(",","");
		int actualPrice = Integer.valueOf(afterCurrRemoval);
		return actualPrice;
	}
	
	public void flipPhoneSearch(String search) {
		searchPhone(search);
		clickGoButton();
	}
}
