package com.inetbanking.testbase;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.inetbanking.utility.ConfigDataProvider;
//import com.inetbanking.utility.ExcelDataProvider;

public class TestBase {

	public WebDriver driver;

	public static ConfigDataProvider configDataProvider;
	//public static ExcelDataProvider excelDataProvider;

	@BeforeSuite
	public void init() {
		configDataProvider = new ConfigDataProvider("config"); // config.properties
		//excelDataProvider = new ExcelDataProvider("inetBankingTestData"); // inetBankingTestData.xlsx
	}

	@BeforeMethod
	@Parameters("brname")
	public void setUp(@Optional("Chrome") String browser) {

		if (browser.equals("Chrome")) {
			System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
			driver = new ChromeDriver();
			System.out.println(" browser setup done and launch the  chrome browser");
		} else if (browser.equals("Firefox")) {
			System.setProperty("webdriver.gecko.driver", "./Drivers/geckodriver.exe");
			driver = new FirefoxDriver();
			System.out.println(" browser setup done and launch the Firefox browser");
		}

		driver.manage().window().maximize();
		// driver.get("https://demo.guru99.com/v1/index.php");
		driver.get(configDataProvider.getAppURL());

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

	}

	@AfterMethod
	public void tearDown() {

		try {
			Thread.sleep(3000);
			driver.quit();
		} catch (InterruptedException e) {

			e.printStackTrace();
		}

	}

}
