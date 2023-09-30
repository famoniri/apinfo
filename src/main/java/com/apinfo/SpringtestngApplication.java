package com.apinfo;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringtestngApplication {

//	@Autowired
//	private SeleniumComponent seleniumComponent;

//	public static String BROWSER = "firefox";
//	public static boolean HEADLESS = false;
//	//DesiredCapabilities capabilities = null;
//	static String chromedriverPath= System.getProperty("user.dir") +File.separator+"webdriver"+File.separator+"chrome-win64"+File.separator+"chrome";
//	static String geckodriverPath= System.getProperty("user.dir") +File.separator+"webdriver"+File.separator+"firefox-win64"+File.separator+"geckodriver.exe";
//
//	static ChromeOptions chromeOptions = new ChromeOptions();
//	static FirefoxOptions firefoxOptions = new FirefoxOptions();

//	private static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		SpringApplication.run(SpringtestngApplication.class, args);
/*
		System.out.println("chrome driver path :"+chromedriverPath);
		System.out.println("gecko  driver path :"+geckodriverPath);


		//ChromeOptions options = new ChromeOptions();


		if(System.getProperty("os.name").toLowerCase().contains("win")){
			System.out.println("O.S is windows");
			if(BROWSER.equals("chrome")) {
				chromedriverPath += ".exe";
				chromeOptions.addArguments("--disable-gpu"); // applicable to windows os only
				System.setProperty("webdriver.chrome.driver", chromedriverPath);

				chromeOptions.addArguments("start-maximized"); // open Browser in maximized mode
				if(HEADLESS){
					chromeOptions.addArguments("--headless");
//			chromeOptions.addArguments("disable-infobars"); // disabling infobars
					chromeOptions.addArguments("--disable-extensions"); // disabling extensions
					chromeOptions.addArguments("--disable-dev-shm-usage"); // overcome limited resource problems
					chromeOptions.addArguments("--no-sandbox"); // Bypass OS security model
					//chromeOptions.setCapability("browserless.token", "YOUR-API-TOKEN");
				}

				Map<String, Object> prefs = new HashMap<String, Object>();
				prefs.put("credentials_enable_service", false);
				prefs.put("profile.password_manager_enabled", false);
				prefs.put("excludeSwitches", "enable-automation");
				chromeOptions.setExperimentalOption("prefs", prefs);

				try{
					System.out.println("beforer driver is: ");
//			driver = new ChromeDriver(chromeOptions);
					driver = new ChromeDriver();
					System.out.println("after driver is: "+driver.getCurrentUrl());
				}catch(Exception ex){
					System.out.println("\nException : "+ex.getClass()+" : "+ex.getMessage());
					ex.getStackTrace();
				}

			}
			if(BROWSER.equals("firefox")) {
				System.setProperty("webdriver.gecko.driver", geckodriverPath);
				//firefoxOptions.addArguments("--headless"); // Run Firefox in headless mode
				firefoxOptions.addArguments("--disable-extensions"); // disabling extensions
				firefoxOptions.addArguments("--disable-dev-shm-usage"); // overcome limited resource problems
				firefoxOptions.addArguments("--no-sandbox"); // Bypass OS security model

//				firefoxOptions.addPreference("browser.startup.page", 1); // Set the startup page to the homepage

				driver = new FirefoxDriver(firefoxOptions);
			}
		}
		else{
			chromeOptions.setBinary(chromedriverPath);
		}



 */

//		seleniumComponent.performSeleniumOperations();

		//seleniumComponent.onlyLog();
/*
		driver.get("https://www.google.com");

		// Get the page title
		String pageTitle = driver.getTitle();

		WebElement searchInput = driver.findElement(By.name("q"));

		// Type the keywords to search for
		searchInput.sendKeys("Selenium WebDriver");

		// Press Enter to perform the search
		searchInput.sendKeys(Keys.ENTER);

		// Wait for the search results to load
		// You may need to add an explicit wait here to ensure the results are loaded

		// Extract the search results
		WebElement searchResults = driver.findElement(By.name("btnK"));

		// Print the search results to the console
		System.out.println(searchResults.getText());

		// Close the browser
		driver.quit();
*/
	}


}

