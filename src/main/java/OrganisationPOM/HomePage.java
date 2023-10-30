package OrganisationPOM;

import java.awt.Desktop.Action;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Generic_Utility.Wendriver_Utility;

public class HomePage
{
	//Initialization
		public HomePage(WebDriver driver)
		{
			PageFactory.initElements(driver, this);
		}
		
		//DECLARATION
		@FindBy(xpath="//a[text()='Organizations']") 
		private WebElement OrganizationLink;
		
		@FindBy(xpath="//a[text()='Products']")
		private WebElement productlink;
		
		@FindBy(xpath="//img[@alt='Create Organization...']")
		private WebElement CreateOrganisation;
		
		@FindBy(xpath="//a[text()='More']")
		private WebElement morelink;
		
		@FindBy(xpath="//a[@name='Campaigns']")
		private WebElement campaignlink;
			
		

		//signout
		@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
		private WebElement Administrator;//
		
		@FindBy(xpath="//a[text()='Sign Out']")
		private WebElement signout;
		
		//getters

		public WebElement getOrganizationLink() 
		{
			return OrganizationLink;
		}
		
		public WebElement getProductLink()
		{
			return productlink;
		}

		public WebElement getCreateOrganisation() 
		{
			return CreateOrganisation;
		}
		
		public WebElement getMorelink() {
			return morelink;
		}

		public WebElement getCampaignlink() {
			return campaignlink;
		}

		public WebElement getAdministrator() {
			return Administrator;
		}

		public WebElement getSignout() {
			return signout;
		}
		
		//Business logic
		
		public void organizationLink()
		{
			OrganizationLink.click();
		}
		
		public void logout(WebDriver driver)
		{
//			Wendriver_Utility wlib=new Wendriver_Utility();	
//			 wlib.ActionsMoveToElement(driver, Administrator);
			 
			 Actions act=new Actions(driver);
			 act.moveToElement(Administrator).perform();
			 signout.click();
//			 Administrator.click();
//			 signout.click();
			 
		}
		public void clickMoreLink()
		{
			morelink.click();
		}
		public void clickCampaign()
		{
			campaignlink.click();
		}
		public void productLink()
		{
			productlink.click();
		}
		public void clickplusIMG()
		{
			CreateOrganisation.click();
		}

		
	}

		
		
		


