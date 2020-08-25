package com.example.weatherapp;

import android.app.Application;

import com.example.weatherapp.data.WeatherService;

public class App extends Application {
    public static WeatherService weatherService = new WeatherService();
}
