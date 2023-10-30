package OrganisationPOM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DeleteProductPage 
{
	//Initialization
			public DeleteProductPage(WebDriver driver)
			{
				PageFactory.initElements(driver, this);
			}
			
			@FindBy(xpath="//a[text()='Products']")
			private WebElement navigateProductTable;
			
			@FindBy(xpath="//input[@value='Delete']")
			private WebElement DeleteProduct;
           //getter
			public WebElement getNavigateProductTable()
			{
				return navigateProductTable;
			}

			public WebElement getDeleteProduct()
			{
				return DeleteProduct;
			}
			//business logic
			
			public void productTable()
			{
				navigateProductTable.click();
			}
			public void deleteProductdata() 
			{
				DeleteProduct.click();
			}

}
