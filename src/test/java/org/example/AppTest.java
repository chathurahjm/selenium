package org.example;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.json.simple.JSONObject;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Unit test for simple App.
 */
public class AppTest extends base
{
    /**
     * Rigorous Test :-)
     */

    String avg,count,itemID,max,min,updateTime;
    ArrayList<String> list = new ArrayList<String>();
    @Test
    public void shouldAnswerWithTrue()
    {
        OpenChrom();
        for (int i = 1 ; i<8;i++) {
            driver.get("https://ikman.lk/en/ads/sri-lanka/cars/honda/vezel?sort=date&order=desc&buy_now=0&urgent=0&page="+i+"&numeric.model_year.minimum=2014&numeric.model_year.maximum=2014&tree.brand=honda_honda-vezel");
            try {
                List<WebElement> elm = driver.findElements(By.xpath("//*[contains(@class,\"normal--2QYVk gtm-normal-ad\")]//*/span[1]"));
                for (WebElement price : elm) {
                    String _price= price.getText();
                    _price = _price.replace("Rs","");
                    _price = _price.replace(",","");
                    _price = _price.replace(" ","");
                    list.add(_price);
                }
            }
            catch (Exception e){

            }
        }


        ArrayList<Integer> Intlist = new ArrayList<Integer>();
        for (String price:list) {

            int intPrice = Integer.parseInt(price);
            Intlist.add(intPrice);
        }

        count = Integer.toString(list.size());
        itemID="Vezel";
        min = Integer.toString(Intlist.stream().collect(Collectors.minBy(Comparator.naturalOrder())).get());
        max = Integer.toString(Intlist.stream().collect(Collectors.maxBy(Comparator.naturalOrder())).get());
        getAvg(Intlist);
        updateTime= LocalDate.now().toString();




    }



    public void getAvg(ArrayList<Integer> list)
    {
        int count = list.size();
        int sum=0;
        for (Integer price:list) {

            sum = price + sum;
        }

        int intavg = sum/count;
        avg = Integer.toString(intavg);

    }

    public void createJson()
    {
        JSONObject jsonObject = new JSONObject();
        //Inserting key-value pairs into the json object
        jsonObject.put("ID", "1");
        jsonObject.put("First_Name", "Shikhar");
        jsonObject.put("Last_Name", "Dhawan");
        jsonObject.put("Date_Of_Birth", "1981-12-05");
        jsonObject.put("Place_Of_Birth", "Delhi");
        jsonObject.put("Country", "India");
        try {
            FileWriter file = new FileWriter("E:/output.json");
            file.write(jsonObject.toJSONString());
            file.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }


}
