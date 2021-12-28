package org.example;

import static org.junit.Assert.assertTrue;

import org.json.simple.JSONArray;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.json.simple.JSONObject;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Unit test for simple App.
 * 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
 */
public class AppTest extends base
{
    /**
     * Rigorous Test :-)
     */

    String avg,count,collection,document,max,min,updateTime;
    ArrayList<String> list = new ArrayList<String>();
    @Test
    public void shouldAnswerWithTrue() throws InterruptedException {


        String[] yearList = {"2014","2015","2016","2017","2018","2019","2020","2021"};

        for (String year:yearList){
            OpenChrom();


        for (int i = 1 ; i<8;i++) {

            driver.get("https://ikman.lk/en/ads/sri-lanka/cars/honda/vezel?sort=date&order=desc&buy_now=0&urgent=0&page="+i+"&numeric.model_year.minimum="+year+"&numeric.model_year.maximum="+year+"&tree.brand=honda_honda-vezel");
            String noresults = "";
            try {
                noresults = driver.findElement(By.className("no-result-text--16bWr")).getText();
            }
            catch (Exception e)
            {
                
            }
                
                if(noresults.contains("No results found"))
                {
                    break;

                }
                


            else {
                try {
                    List<WebElement> elm = driver.findElements(By.xpath("//*[contains(@class,\"normal--2QYVk gtm-normal-ad\")]//*/span[1]"));
                    for (WebElement price : elm) {
                        String _price = price.getText();
                        _price = _price.replace("Rs", "");
                        _price = _price.replace(",", "");
                        _price = _price.replace(" ", "");
                        list.add(_price);
                    }
                } catch (Exception e) {

                }
            }
            

           
        }

        driver.quit();


        ArrayList<Integer> Intlist = new ArrayList<Integer>();
        for (String price:list) {

            int intPrice = Integer.parseInt(price);
            Intlist.add(intPrice);
        }


        try {
            count = Integer.toString(list.size());
            collection="Vezel";
            document = year;
            min = Integer.toString(Intlist.stream().collect(Collectors.minBy(Comparator.naturalOrder())).get());
            max = Integer.toString(Intlist.stream().collect(Collectors.maxBy(Comparator.naturalOrder())).get());
            avg = getAvg(Intlist);
            updateTime= LocalDate.now().toString();
        }
        catch (Exception e)
        {

        }


        list.clear();
        Intlist.clear();



            updateDB(collection,document,avg,min,max,count,updateTime);


            }
        }



    public String getAvg(ArrayList<Integer> list)
    {
        int count = list.size();
        int sum=0;
        for (Integer price:list) {

            sum = price + sum;
        }

        int intavg = sum/count;
        avg = Integer.toString(intavg);
        return avg;

    }


    public void updateDB(String collection,String document,String Avg,String Min,String Max,String Total,String Update ) throws InterruptedException {
        OpenChrom();
        driver.get("https://vehicleprice-9bdc5.web.app/");
        Thread.sleep(6000);
        driver.findElement(By.id("collection")).clear();
        driver.findElement(By.id("collection")).sendKeys(collection);

        driver.findElement(By.id("document")).clear();
        driver.findElement(By.id("document")).sendKeys(document);

        driver.findElement(By.id("Avg")).clear();
        driver.findElement(By.id("Avg")).sendKeys(Avg);

        driver.findElement(By.id("Min")).clear();
        driver.findElement(By.id("Min")).sendKeys(Min);

        driver.findElement(By.id("Max")).clear();
        driver.findElement(By.id("Max")).sendKeys(Max);

        driver.findElement(By.id("Total")).clear();
        driver.findElement(By.id("Total")).sendKeys(Total);

        driver.findElement(By.id("Update")).clear();
        driver.findElement(By.id("Update")).sendKeys(Update);
        Thread.sleep(3000);
        driver.findElement(By.id("addData")).click();
        Thread.sleep(6000);

        count="";
        min="";
        max="";
        avg="";

        driver.quit();
    }



}
