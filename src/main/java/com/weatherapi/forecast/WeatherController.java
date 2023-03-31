package com.weatherapi.forecast;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

//Class to handle incoming HTTP requests and call the WeatherService to get the weather forecast
@RestController
public class WeatherController {
    @Autowired
    private WeatherService weatherService;

    @GetMapping("/forecast/{location}")
    public String getForecast(@PathVariable String location) {
        return weatherService.getForecast(location);
    }
}
