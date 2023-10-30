package OrganisationPOM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ValidationAllModulePage
{
	public void validationpage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);		
	}
	//initialization
	@FindBy(id="dtlview_Organization Name")
	private WebElement orgnamevalidate;
	
	@FindBy(xpath="//span[@id='dtlview_Phone']")
	private WebElement phnvalidate;
	
	@FindBy(xpath="//span[@id='dtlview_Email']")
	private WebElement emailValidate;
   
	//getters
	public WebElement getOrgnamevalidate() {
		return orgnamevalidate;
	}

	public WebElement getPhnvalidate() {
		return phnvalidate;
	}

	public WebElement getEmailValidate() {
		return emailValidate; 
	}
	
	//businesslogic
	public String OrgValidate()
	{
		return orgnamevalidate.getText();
		
	}
	public String phnNumValidate()
	{
		return phnvalidate.getText();
	}
	public String emailIdValidate()
	{
		return emailValidate.getText();
	}
	
	

}
