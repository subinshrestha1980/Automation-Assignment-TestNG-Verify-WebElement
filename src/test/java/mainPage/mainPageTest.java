package mainPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Page.MainPage;

import util.BrowserFactory;

public class mainPageTest {

	WebDriver driver;
	String enterName;
	MainPage login;

	@BeforeClass
	public void mainPageTest() throws InterruptedException {
		driver = BrowserFactory.init();
	}

	@Test(priority = 1)

	public void mainPageTest1() throws InterruptedException {
		login = PageFactory.initElements(driver, MainPage.class); // this will pass driver to LoginPage
		login.AddCategory_Cell("Kathmandu");
		login.AddCategory_CellButton();
		// login.verifyEnteredName(enterName);
		login.verifyEnteredName(enterName);
	}

	@Test(priority = 2)
	public void mainPageTest2() throws InterruptedException {
		login.duplicate_validationPage();
	}

	@Test(priority = 3)
	public void mainPageTest3() throws InterruptedException {
		login.WebElement_Month();

	}

	@AfterClass

	public void tearDown() {
		BrowserFactory.TearDown();
	}
}
