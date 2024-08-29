package base;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SetupDriver extends Commons
{
    public WebDriver driver;
    public String browserTypeKey;
    //TODO: Will help to trigger browser depending upon user selection
    public void setupDriver()
    {
        if(browserTypeKey.equalsIgnoreCase("chrome"))
        {	
        	System.setProperty("webdriver.chrome.driver","D:\\WebDriver\\ChromeDriver\\chromedriver.exe"); 
        	//WebDriverManager.chromedriver().setup();
        	ChromeOptions options = new ChromeOptions();
        	options.addArguments("--remote-allow-origins=*");
        	driver = new ChromeDriver(options);
            
        } else if (browserTypeKey.equalsIgnoreCase("firefox"))
        {
        	WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        } else if (browserTypeKey.equalsIgnoreCase("edge"))
        {
            driver = new EdgeDriver();
        } else
        {
        	WebDriverManager.edgedriver().setup();
            System.out.println("Driver not supported!!!");
        }

        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
    }

    public void quitDriver()
    {
        driver.quit();
    }
}
