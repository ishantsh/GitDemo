package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {
	
	public WebDriver driver;
	
	private By sigin = By.cssSelector("a[href*='sign_in']");
	private By title = By.cssSelector(".text-center  h2");
	private By navbar = By.cssSelector(".nav.navbar-nav.navbar-right");
	private By header = By.cssSelector("div[class*='video-banner'] h3");
	
	
	public LandingPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
	}

	public WebElement  getLogin() {
		return driver.findElement(sigin);	
	}
	
	public WebElement  getTitle() {
		return driver.findElement(title);	
	}
	
	public WebElement  getNavBar() {
		return driver.findElement(navbar);	
	}
	
	public WebElement getheader() {
		return driver.findElement(header);	
	}



}
