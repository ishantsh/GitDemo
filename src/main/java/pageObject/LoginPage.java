package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
	
	public WebDriver driver;
	
	By email = By.cssSelector("[id='user_email']");
	By password = By.cssSelector("[id='user_password']");
	By login = By.cssSelector("[type='submit']");
	
	public LoginPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
	}

	public WebElement  getEmail() {
		return driver.findElement(email);	
	}
	
	public WebElement getPassword() {
		return driver.findElement(password);
	}

	public WebElement getlogin() {
		return driver.findElement(login);
	}


}
