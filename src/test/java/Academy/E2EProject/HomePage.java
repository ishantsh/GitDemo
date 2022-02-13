package Academy.E2EProject;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObject.LandingPage;
import pageObject.LoginPage;
import resource.base;

public class HomePage extends base {
	public WebDriver driver;
	public static Logger log = LogManager.getLogger(base.class.getName());
	@BeforeTest
	public void initilizer() throws IOException {
		
		driver =  intializeDriver();
		//river.get(prop.getProperty("url"));
	}

	@Test(dataProvider = "getData")
	public void basePageNavigation(String username, String password, String text) throws IOException {

		
		driver.get(prop.getProperty("url"));
		LandingPage lpage = new LandingPage(driver);
		lpage.getLogin().click();

		LoginPage lp = new LoginPage(driver);
		lp.getEmail().sendKeys(username);
		lp.getPassword().sendKeys(password);
		lp.getlogin().click();
		//System.out.println(text);
		
		log.info(text);
	}

	@DataProvider
	public Object[][] getData() {
		// row stands for how many different data types test should run
		// column stands for how many values per each test case
		Object[][] data = new Object[2][3];
		data[0][0] = "rahlshetty@gmail.com";
		data[0][1] = "123456789";
		data[0][2] = "restricted user";

		
		  data[1][0] = "ishant@gmail.com"; 
		  data[1][1]= "456"; 
		  data[1][2] ="non restricted user";
		 
		return data;
	}
	
	@AfterTest
	public void teardown() {
		driver.close();
	}

}
