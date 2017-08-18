package com.test.util;

import com.sun.org.apache.xpath.internal.operations.Mod;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.util.ArrayList;

@Controller
public class HomeController {

    @RequestMapping("/")
    public ModelAndView weather() {
        try {
            //java object that talks aross the net - library has code and method
            // to create a new object, instead of calling a constructor
            // this httpclient will make requests from the other server

            HttpClient http = HttpClientBuilder.create().build();

            //httphost holds connection info
            //will pass this through the above object ^^^^
            HttpHost host = new HttpHost("forecast.weather.gov", 80, "http");

            //hhtpget will retrieve the info from the specific uri/url
            //good practice to test link below
            HttpGet getPage = new HttpGet("/MapClick.php?lat=42.331427&lon=-83.045754&FcstType=json");

            //actually run it and pull in the response
            //has status code with in it
            //has html and json object inside it
            HttpResponse resp = http.execute(host, getPage);

            //get JSON string (actual content) from inside the response and turn into an object
            String jsonString = EntityUtils.toString(resp.getEntity());

            //turn the string into an actual JSON object (in a Java representation)
            JSONObject json = new JSONObject(jsonString);

            //info. from the http response (resp)
            //get the response code and some info from JSON
            //production center (THIS HAS TO MATCH)
            int status = resp.getStatusLine().getStatusCode();
            String prodCenter = json.get("productionCenter").toString();


            //getting entire JSON Array named startPeriodName and temperature from JSON Object
            JSONArray days = json.getJSONObject("time").getJSONArray("startPeriodName");
            JSONArray temps = json.getJSONObject("data").getJSONArray("temperature");

            //First, create a Java class
            ArrayList<Weather> arr = new ArrayList<Weather>();
          // String ArrayList<String> arrTemp = new ArrayList<String>();

            for (int i = 0; i < days.length(); i++) {
//                result += "<h3>" + days.getString(i) + "</h3>";
                arr.add(new Weather(days.getString(i),temps.getString(i)));
                //arrTemp.add();

            }

            return new ModelAndView("weather", "infoarray", arr);

//            for (int i = 0; i < temps.length(); i++) {
//                result += "<h3>" + temps.getString(i) + "</h3>";
//
//            }
//            System.out.println(days);
           // model.addAttribute("result2",arrTemp);

//
//            //put it into my web page (M+V)
//            ModelAndView mv = new ModelAndView("weather");
//            mv.addObject("status", status);
//            mv.addObject("prodCenter", prodCenter);
//            mv.addObject("Th1",days.getString(0));//how we access info in the above array - startPeriodName
//            mv.addObject("Th2",days.getString(1));//how we access info in the above array  - startPeriodName
//            mv.addObject("ThTemp1",temps.getString(0));//how we access info in the above array - temperature
//            mv.addObject("ThTemp2",temps.getString(1));//how we access info in the above array - temperature
//            return mv;


        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("1st Prob.");
        } catch (JSONException e) {
            e.printStackTrace();
            System.out.println("2nd Prob.");
        }

        return null;

    }

    @RequestMapping("/userform")
    public ModelAndView userform() {

        return new ModelAndView("registerpage", "inst", "Please enter your information below.");

    }

    @RequestMapping("/formhandler")
    public ModelAndView formhandler(
            @RequestParam("firstname") String firstname,
            @RequestParam("lastname") String lastname,
            @RequestParam("num") long phoneNumber,
            @RequestParam("email") String email,
            @RequestParam("favcoffee") String favcoffee
    )
    //server side validation
    {
        ModelAndView mv = new ModelAndView("summarypage");
        mv.addObject("firstname", firstname);
        mv.addObject("lastname", lastname);
        mv.addObject("num", phoneNumber);
        mv.addObject("email", email);
        mv.addObject("favcoffee", favcoffee);
        return mv;
    }

//    @RequestMapping("/weather")
//    public ModelAndView weather(){
//        try {
//            //java object that talks aross the net - library has code and method
//            // to create a new object, instead of calling a constructor
//            // this httpclient will make requests from the other server
//
//            HttpClient http = HttpClientBuilder.create().build();
//
//            //httphost holds connection info
//            //will pass this through the above object ^^^^
//            HttpHost host = new HttpHost("forecast.weather.gov",80,"http");
//
//            //hhtpget will retrieve the info from the specific uri/url
//            //good practice to test link below
//            HttpGet getPage = new HttpGet("/MapClick.php?lat=42.331427&lon=-83.045754&FcstType=json");
//
//            //actually run it and pull in the response
//            //has status code with in it
//            //has html and json object inside it
//            HttpResponse resp =  http.execute(host,getPage);
//
//            //get JSON string (actual content) from inside the response and turn into an object
//            String jsonString = EntityUtils.toString(resp.getEntity());
//
//            //turn the string into an actual JSON object (in a Java representation)
//            JSONObject json = new JSONObject(jsonString);
//
//            //info. from the http response (resp)
//            //get the response code and some info from JSON
//            //production center (THIS HAS TO MATCH)
//            int status = resp.getStatusLine().getStatusCode();
//            String prodCenter = json.get("productionCenter").toString();
//
//
//            //getting entire JSON Array named startPeriodName and temperature from JSON Object
//            JSONArray days = json.getJSONObject("time").getJSONArray("startPeriodName");
//            JSONArray temps = json.getJSONObject("data").getJSONArray("temperature");
//
//
//            //put it into my web page (M+V)
//            ModelAndView mv = new ModelAndView("weather");
//            mv.addObject("status", status);
//            mv.addObject("prodCenter", prodCenter);
//            mv.addObject("day1",days.getString(0));//how we access info in the above array - startPeriodName
//            mv.addObject("day2",days.getString(1));//how we access info in the above array  - startPeriodName
//            mv.addObject("temp1",temps.getString(0));//how we access info in the above array - temperature
//            mv.addObject("temp2",temps.getString(1));//how we access info in the above array - temperature
//            return mv;
//
//        } catch (IOException e) {
//            e.printStackTrace();
//            System.out.println("1st Prob.");
//        } catch (JSONException e){
//            e.printStackTrace();
//            System.out.println("2nd Prob.");
//        }
//
//        return null;
//
//    }
}