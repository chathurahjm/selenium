package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class base {

    public WebDriver driver;


    public void OpenChrom()
    {
        System.setProperty("webdriver.chrome.driver","/Users/chathuraj/Documents/Data/Driver/chromedriver");
        driver = new ChromeDriver();
    }
}
