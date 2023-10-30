package OrganisationPOM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Generic_Utility.Wendriver_Utility;

public class CreateProductPage 
{
	//Initialization
		public CreateProductPage(WebDriver driver)
		{
			PageFactory.initElements(driver, this);
		}
		@FindBy(xpath="//img[@alt='Create Product...']")
		private WebElement plusimgSign;
		
		@FindBy(name="productname")
		private WebElement productName;
		
		//@FindBy(xpath="//input[@title='Save [Alt+S]']")
		//private WebElement saveButton;
		
		@FindBy(xpath="//input[@title='Save [Alt+S]'])[2]")
		private WebElement saveButton;

		 
		
		
		

		//getter methods
		public WebElement getPlusimgSign() {
			return plusimgSign;
		}

		public WebElement getProductName() {
			return productName;
		}

		public WebElement getSaveButton() {
			return saveButton;
		}
		
		
		//business logic
		public void clickOnPlusSign()
		{
			plusimgSign.click();
			
		}
		public void productName(String ProductNAme)
		{
			productName.sendKeys(ProductNAme);
			
		}
		public void clickonSaveButtn(WebDriver driver)
		{
			Wendriver_Utility wlib=new Wendriver_Utility();
		    WebElement saveButton = driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[2]"));
			wlib.javaScriptExecutor(driver, saveButton);
			//saveButton.click();
			saveButton.click();
		}
		

}
