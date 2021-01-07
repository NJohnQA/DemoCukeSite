package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Index {
	
	public static final String URL = "http://thedemosite.co.uk/index.php";
	
	@FindBy(css = "small > a:nth-child(6)")
	private WebElement addAUserAnchor;
	
	@FindBy(css = "small > a:nth-child(7)")
	private WebElement loginAnchor;
	
	public void navAddAUser() {
		addAUserAnchor.click();
	}
	
	public void navLogin() {
		loginAnchor.click();
	}

}
