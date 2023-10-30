package OrganisationPOM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateOrganisationPage 
{
	public CreateOrganisationPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//img[@alt='Create Organization...']")
	private WebElement clickPlusImg;
	
	@FindBy(xpath="//input[@name='accountname']")
	private WebElement Orgname;
	
	@FindBy(id="phone")
	private WebElement OrgPhnone; 
	
	@FindBy(id="email1")
	private WebElement OrgEmail;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement saveButton;
	
	
	
	//getter

	

	public WebElement getClickPlusImg() {
		return clickPlusImg;
	}

	public WebElement getOrgname() {
		return Orgname;
	}

	public WebElement getOrgPhnone() {
		return OrgPhnone;
	}
	public WebElement getOrgEmail() {
		return OrgEmail;
	}
	
	public WebElement getSaveButton() {
		return saveButton;
	}
	
	//busineslogic
	public void clickonPlusimg()
	{
		clickPlusImg.click();
	}
	public void orgData(String orgname,String phnNum,String mailid)
	{
		Orgname.sendKeys(orgname);
		OrgPhnone.sendKeys(phnNum);
		OrgEmail.sendKeys(mailid);
		
	}
	
	public void clickonSaveButton()
	{
		saveButton.click();
	}
	
	
	
	
	
	
	
	

	
	
	

}
