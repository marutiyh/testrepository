package mavenframework.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AmazonPage {

    WebDriver driver;
	
	@FindBy(xpath="//input[@id='twotabsearchtextbox']")
	private WebElement serachbutton;
	
	@FindBy(xpath="//div[@class='nav-search-submit nav-sprite']//input[@class='nav-input']")
	private WebElement gobutton;

	@FindBy(xpath="//span[contains(text(),'Apple iPhone XR (64GB) - Yellow')]")
	private WebElement amzphonename;
		
	@FindBy(xpath="//span[@class='celwidget slot=SEARCH_RESULTS template=SEARCH_RESULTS widgetId=search-results index=0']//span[@class='a-price']")
	private WebElement amzphoneprice;
	
	public AmazonPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void searchPhone(String search) {
		serachbutton.sendKeys(search);
	}
	public void clickGoButton() {
		gobutton.click();
	}
	public String getAmazonPhoneName() {
		return amzphonename.getText();
	}
	public int getAmazonPhonePrice() {
		String price=amzphoneprice.getText();
		String afterCurrRemoval=price.substring(1);
		afterCurrRemoval = afterCurrRemoval.replaceAll(",","");
		int actualPrice = Integer.valueOf(afterCurrRemoval);
		return actualPrice;
	}
	
	public void amzPhoneSearch(String search) {
		searchPhone(search);
		clickGoButton();
	}
}
