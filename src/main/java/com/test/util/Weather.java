package com.test.util;

/**
 * Created by Grand Circus Student on 8/17/2017.
 */
public class Weather {
    String temp;
    String day;

    public Weather(String day, String temp) {
        this.temp = temp;
        this.day = day;
    }

    public String getTemp() {
        return temp;
    }

    public void setTemp(String temp) {
        this.temp = temp;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }
}
