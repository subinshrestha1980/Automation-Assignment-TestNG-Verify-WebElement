package Page;

import static org.testng.Assert.assertEquals;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class MainPage extends BasePage {

	WebDriver driver;

	public MainPage(WebDriver driver) {
		this.driver = driver;
	}

	@FindBy(how = How.NAME, using = "categorydata")
	WebElement AddCategory;

	@FindBy(how = How.CSS, using = "input[value='Add category']")
	WebElement AddCategory_Button;

	@FindBy(how = How.XPATH, using = "/html/body/div[3]/a[37]/span")
	WebElement Validation;

	@FindBy(how = How.XPATH, using = "/html/body/span[2]")
	WebElement Duplicate_Validation;

	@FindBy(how = How.XPATH, using = "/html/body/div[4]/span/select[3]")
	WebElement Month_DropDownValidation;

	
	public void AddCategory_Cell(String Category) {
		AddCategory.sendKeys(Category);
	}

	public void AddCategory_CellButton() {
		AddCategory_Button.click();
		
	}

	
	// div[3]/a[47]/span

	public void verifyEnteredName(String enterName) {
	

		List<WebElement> mainpageText = driver.findElements(By.xpath("//div/a/span"));

		for (WebElement lookingforKathmandu : mainpageText) {

			String abc = lookingforKathmandu.getText();

			// System.out.println(abc);

			if (lookingforKathmandu.getText().equalsIgnoreCase("kathmandu")) {

				System.out.println("Element Present: " + abc);

			} else {
				// System.out.println("Element Not Present");
				// }
			}
		}
	}

	public void duplicate_validationPage() throws InterruptedException {

		MainPage loginvalidation = PageFactory.initElements(driver, MainPage.class);

		loginvalidation.AddCategory_Cell("Kathmandu");
		loginvalidation.AddCategory_CellButton();
		Assert.assertEquals(Duplicate_Validation.getText(), "Kathmandu", "Kathmandu Not Found");
		System.out.println("The category you want to add already exists: " + Duplicate_Validation.getText());
		driver.navigate().back();
}

	public void WebElement_Month() {
		List<WebElement> wholemonth = driver.findElements(By.name("due_month"));
		for (WebElement months : wholemonth) {
			String everymonth = months.getText();
			System.out.println(everymonth);
			
		}
		
	}
}