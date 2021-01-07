package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddAUser {
	
	public static final String URL = "http://thedemosite.co.uk/addauser.php";
	
	@FindBy(name = "username")
	private WebElement usernameInput;
	
	@FindBy(name = "password")
	private WebElement passwordInput;
	
	public void addAUser(String username, String password) {
		usernameInput.sendKeys(username);
		passwordInput.sendKeys(password);
		passwordInput.submit();
	}
	
	public String getUsernameValue() {
		return usernameInput.getAttribute("value");
	}
	
	public String getPasswordValue() {
		return passwordInput.getAttribute("value");
	}
}
