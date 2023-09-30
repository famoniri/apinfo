package com.apinfo.common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.context.annotation.Configuration;
import org.testng.annotations.BeforeClass;

import java.io.File;


@Configuration
public class WebDriverLib {

    private WebDriver driver;

    @BeforeClass
    public void setup() {
        // Set Chrome WebDriver system property
        String s = System.getProperty("user.dir") +File.separator+ "common"+File.separator+"webdriver"+File.separator+"chrome-win64";
        System.out.println(s);


        // Create ChromeDriver instance
        driver = new ChromeDriver();
    }

//    public WebDriverriver getWebDriver(){
//        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
//        return null;
//    }
}
