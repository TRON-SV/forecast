package com.weatherapi.forecast;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

//Class to send the API request to WeatherAPI.com and parse the response using Gson
@Service
public class WeatherService {
    private final String API_KEY = "ea6ac94922bf41b8ad4211249232303";
    private final String API_URL = "http://api.weatherapi.com/v1/forecast.json";

    public String getForecast(String location) {
        //Setting up the date for tomorrow, so it can be passed as parameter on the url
        LocalDate tomorrow = LocalDate.now().plusDays(1);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        String url = API_URL + "?key=" + API_KEY + "&q=" + location + "&days=1"+"&dt="+tomorrow.format(formatter);
        RestTemplate restTemplate = new RestTemplate();
        String response = restTemplate.getForObject(url, String.class);
        Gson gson = new Gson();
        WeatherResponse weatherResponse = gson.fromJson(response, WeatherResponse.class);

        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("date", tomorrow.format(formatter));
        jsonObject.addProperty("forecast", weatherResponse.getForecast().getForecastDays()[0].getDay().getCondition().getText());

        return gson.toJson(jsonObject);
    }
}
