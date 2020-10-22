package org.example;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        WebDriver driver;
        System.setProperty("webdriver.chrome.driver","C:\\ChromeDriver1\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.google.com");
    }
}
