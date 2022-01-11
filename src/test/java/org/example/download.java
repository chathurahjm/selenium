package org.example;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class download  extends base{

    @Test
    public void rajwap() throws InterruptedException {
       
        Thread.sleep(7500000);

        OpenChrom();
        driver.get("https://rajwap.me/");
        driver.findElement(By.id("login")).click();
        Thread.sleep(2000);

        driver.findElement(By.name("username")).sendKeys("werwsds");
        driver.findElement(By.name("pass")).sendKeys("werwsds");
        driver.findElement(By.xpath("//*[@class=\"inpbutton auth\"]")).click();
        Thread.sleep(6000);

        for (int i =9;i<=15;i++) {
            driver.get("https://rajwap.me/fresh/?p="+i);

            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
            LocalDateTime now = LocalDateTime.now();

            System.out.println(dtf.format(now));
            System.out.println("i="+i);
            String[] cars = new String[90];
            int j=0;

            List<WebElement> elm = driver.findElements(By.xpath("//*[@class=\"kt_imgrc\"]"));
            for (WebElement url:elm) {

                cars[j] = url.getAttribute("href").toString();
                j=j+1;

            }
try {
    for (String lastURL:cars) {
        driver.get(lastURL);
        driver.findElement(By.className("down_video")).click();
        Thread.sleep(3000);
        driver.findElement(By.id("vidlinks")).click();
        Thread.sleep(10000);
        Thread.sleep(10000);


    }


}
catch (Exception e)
{

}



        }


    }
}
