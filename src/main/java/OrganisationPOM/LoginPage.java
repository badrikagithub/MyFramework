package OrganisationPOM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage 
{
	//Initialization
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	//Declaration
	@FindBy(name="user_name")
	private WebElement userNameTextField;
	
	@FindBy(name="user_password")
	private WebElement userPasswordTextField;
	
	@FindBy(id="submitButton")
	private WebElement loginButton; 

	//getter methods
	public WebElement getUserNameTextField() { 
		return userNameTextField;
	}

	public WebElement getUserPasswordTextField() {
		return userPasswordTextField;
	}

	public WebElement getLoginButton() {
		return loginButton;
	}
	
	//Business logic
	public void loginToAPP(String userName,String Password)
	{
		userNameTextField.sendKeys(userName);
		userPasswordTextField.sendKeys(Password);
		loginButton.click();
		
	}
	
	
	

}
