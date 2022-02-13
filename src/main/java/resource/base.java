package resource;

import java.io.File;
import java.io.FileInputStream;

import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class base {
	
	/*
	 * public void base(WebDriver driver) { this.driver=driver;
	 * 
	 * }
	 */
	
	public WebDriver driver;
	public Properties prop ;
	public WebDriver intializeDriver() throws IOException {
		prop= new Properties();
		FileInputStream fis=new FileInputStream("C:\\Users\\LENOVO\\eclipse-workspace\\E2EProject\\src\\main\\java\\resource\\data.properties");
		
		
		prop.load(fis);
		
		//---below line will take browser parameter from mvn cmd--- mvn test -Dbrowser=chrome
		
		String browserName= System.getProperty("browser");
		//String browserName = prop.getProperty("browser");
		
		if(browserName.contains("chrome")) {
			System.setProperty("webdriver.chrome.driver", "D:\\Driver\\chromedriver.exe");
			
			//below code is written to make the chrome browser headless so test execution take place at backend.
			ChromeOptions options= new ChromeOptions();
			if(browserName.contains("headless")) {
				options.addArguments("headless");
			}
			
			 driver = new ChromeDriver(options);
			driver.manage().window().maximize();
		}
		else if(browserName=="firfox") {
			//
		}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		return driver;	
	}
	public void getScreenShots(String Testcasename,WebDriver driver) throws IOException {
		TakesScreenshot ts=(TakesScreenshot)driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String destination = System.getProperty("user.dir")+"\\reports\\"+Testcasename+".png";
		FileUtils.copyFile(source,new File(destination));
	}
	
	

}
