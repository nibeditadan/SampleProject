package sampleProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


public class SampleProjectExecution {

	@Parameters({ "browser" })
	@Test
	public void launchGmail(String browser){
		try {
			if (browser.equalsIgnoreCase("Chrome")) {
				System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"//drivers//chromedriver.exe");
				WebDriver driver=new ChromeDriver();
				driver.get("http://gmail.com");
				driver.findElement(By.id("identifierId")).sendKeys("nibeditadan");
				driver.findElement(By.xpath("//div[@id='identifierNext']/content")).click();
				//driver.findElement(By.id("Email")).sendKeys("nibeditadan");
				//driver.findElement(By.id("next")).click();
				
			}
			else if(browser.equalsIgnoreCase("IE")){
				System.setProperty("webdriver.ie.driver",System.getProperty("user.dir")+"//drivers//IEDriverServer.exe");
				DesiredCapabilities capability = DesiredCapabilities.internetExplorer();
				capability.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
				capability.setCapability(InternetExplorerDriver.IGNORE_ZOOM_SETTING, true);				
				WebDriver driver = new InternetExplorerDriver(capability);					
				driver.get("http://gmail.com");
				driver.findElement(By.xpath("//div[@class='gmail-nav__nav-links-wrap']/a[2]")).click();
				driver.findElement(By.id("Email")).sendKeys("nibeditadan");
				driver.findElement(By.id("next")).click();
			}
		}
			catch(Exception e){
				System.out.println(e);
			}
		
		
		
	}
	
	
}
