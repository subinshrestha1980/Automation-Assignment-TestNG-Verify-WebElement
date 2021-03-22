package mainPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import Page.MainPage;

import util.BrowserFactory;

@Test
public class mainPageTest {

	WebDriver driver;
	String enterName;

	public void mainPageTest1() throws InterruptedException {
		driver = BrowserFactory.init();

		MainPage login = PageFactory.initElements(driver, MainPage.class); // this will pass driver to LoginPage
		login.AddCategory_Cell("Kathmandu");
		login.AddCategory_CellButton();
		// login.verifyEnteredName(enterName);
		login.verifyEnteredName(enterName);
		login.duplicate_validationPage();
		login.WebElement_Month();
		BrowserFactory.TearDown();
		
	}
}
