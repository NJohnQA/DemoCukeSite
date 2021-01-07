package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Login {
	
	public static final String URL = "http://thedemosite.co.uk/login.php";
	
	@FindBy(name = "username")
	private WebElement usernameInput;
	
	@FindBy(name = "password")
	private WebElement passwordInput;
	
	@FindBy(css = "blockquote > font > center > b")
	private WebElement loginStatus;
	
	public void login(String username, String password) {
		usernameInput.sendKeys(username);
		passwordInput.sendKeys(password);
		passwordInput.submit();
	}
	
	public String loginStatus() {
		return loginStatus.getText();
	}

}
