package OrganisationPOM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateCampaignPage
{
	public CreateCampaignPage(WebDriver diver)
	{
		PageFactory.initElements(diver, this);
	}
	@FindBy(xpath="//img[@alt='Create Campaign...']")
	private WebElement clickplusimg;
	
	@FindBy(name="campaignname")
	private WebElement campName;
	
	@FindBy(xpath="//input[@value='  Save  ']")
	private WebElement saveButton;
	
	@FindBy(xpath="//img[@alt='Select']")
	private WebElement selectbutton;
	
	@FindBy(xpath="//input[@name='search_text']")
	private WebElement productnameSwitching;
	
	@FindBy(name="search")
	private WebElement productSearchSwitching;
	
	
	
	

	//getters
	public WebElement getClickplusimg() {
		return clickplusimg;
	}

	public WebElement getCampName() {
		return campName;
	}

	public WebElement getSaveButton() {
		return saveButton;
	}
	
	public WebElement getSelectbutton() {
		return selectbutton;
	}

	public WebElement getProductnameSwitching() {
		return productnameSwitching;
	}

	public WebElement getProductSearchSwitching() {
		return productSearchSwitching;
	}

	public WebElement getSavebutton() {
		return saveButton;
	}
	//businesslogic
	public void clickonPlusImgSign()
	{
		clickplusimg.click();
		
	}
	public void campname(String Campname)
	{
		campName.sendKeys(Campname);
	}
	public void saveCamp()
	{
		saveButton.click();
	}
	public void selectButton() 
	{
		selectbutton.click();
		
	}
	public void productNameSwitching(String ProductName)
	{
		productnameSwitching.sendKeys(ProductName);
		
	}
	public void searchProduct() 
	{
		productSearchSwitching.click();
		
	}
	public void saveButon() 
	{
		saveButton.click();
		
	}
	

    
	

}
