package stepdef;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.PageFactory;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.AddAUser;
import pages.Index;
import pages.Login;

public class DemoWebsite {
	
	private static WebDriver driver;
	private static String URL = "http://thedemosite.co.uk";
	
	@Before
	public void init() {
		System.setProperty("webdriver.chrome.driver", 
				"src/test/resources/chromedriver.exe");
		ChromeOptions cOptions = new ChromeOptions();
		cOptions.setHeadless(false);
		driver = new ChromeDriver(cOptions);
		driver.manage().window().maximize();
	}
	
	@After
	public void cleanup() {
		driver.quit();
	}
	
	@Given("^The correct web address$")
	public void the_correct_web_address() {
		driver.get(Index.URL);
		assertEquals(Index.URL, driver.getCurrentUrl());
	}

	@When("^I navigate to the 'Add a User' page$")
	public void i_navigate_to_the_Add_a_User_page() {
		Index index = PageFactory.initElements(driver, Index.class);
		index.navAddAUser();
		assertEquals(AddAUser.URL, driver.getCurrentUrl());
	}

	@Then("^I can add a new user$")
	public void i_can_add_a_new_user() {
		AddAUser addAUser = PageFactory.initElements(driver, AddAUser.class);
		String username = "username";
		String password = "password";
		addAUser.addAUser(username, password);
		assertEquals("", addAUser.getUsernameValue());
		assertEquals("", addAUser.getPasswordValue());
	}

	@When("^I navigate to the 'Login' page$")
	public void i_navigate_to_the_Login_page() {
		Index index = PageFactory.initElements(driver, Index.class);
		index.navLogin();
		assertEquals(Login.URL, driver.getCurrentUrl());
	}

	@Then("^I can login as a new user$")
	public void i_can_login_as_a_new_user() {
		Login login = PageFactory.initElements(driver, Login.class);
		String username = "username";
		String password = "password";
		login.login(username, password);
		assertEquals("**Successful Login**", login.loginStatus());
	}

}
