package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class base {

    public WebDriver driver;


    public void OpenChrom() {
        System.setProperty("webdriver.chrome.driver", "/Users/chathuraj/Documents/Data/Driver/chromedriver");

        driver = new ChromeDriver();
    }

    public void OpenChromeHeadLess() {
        System.setProperty("webdriver.chrome.driver", "/Users/chathuraj/Documents/Data/Driver/chromedriver");

        ChromeOptions opt = new ChromeOptions();
//#chrome_options.add_argument("--disable-extensions")
//#chrome_options.add_argument("--disable-gpu")
//#chrome_options.add_argument("--no-sandbox") #linux only
        opt.addArguments("--headless");
//#chrome_options.headless = True #also works
        driver = new ChromeDriver(opt);

       // driver = webdriver.Chrome(options = chrome_options)
    }
}
