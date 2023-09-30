package com.apinfo.automation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.File;

@Configuration
public class SeleniumConfig {

    static String chromedriverPath= System.getProperty("user.dir") + File.separator+"webdriver"+File.separator+"chrome-win64"+File.separator+"chrome";
    static String geckodriverPath= System.getProperty("user.dir") +File.separator+"webdriver"+File.separator+"firefox-win64"+File.separator+"geckodriver.exe";
    static FirefoxOptions firefoxOptions = new FirefoxOptions();

    @Bean
    public WebDriver webDriver() {
        // Set the path to the GeckoDriver executable
        System.out.println("in the SeleniumConfig::webDriver");
        System.setProperty("webdriver.gecko.driver", geckodriverPath);
        firefoxOptions.addArguments("--headless"); // Run Firefox in headless mode
        firefoxOptions.addArguments("--disable-extensions"); // disabling extensions
        firefoxOptions.addArguments("--disable-dev-shm-usage"); // overcome limited resource problems
        firefoxOptions.addArguments("--no-sandbox"); // Bypass OS security model

//				firefoxOptions.addPreference("browser.startup.page", 1); // Set the startup page to the homepage

        // Create and return FirefoxDriver instance
        return new FirefoxDriver(firefoxOptions);
    }
}