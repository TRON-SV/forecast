package com.weatherapi.forecast;

import com.google.gson.annotations.SerializedName;

//Class to hold the response data from the WeatherAPI.com API
public class WeatherResponse {
    @SerializedName("forecast")
    private Forecast forecast;

    public Forecast getForecast() {
        return forecast;
    }

    public void setForecast(Forecast forecast) {
        this.forecast = forecast;
    }

    public static class Forecast {
        @SerializedName("forecastday")
        private ForecastDay[] forecastDays;

        public ForecastDay[] getForecastDays() {
            return forecastDays;
        }

        public void setForecastDays(ForecastDay[] forecastDays) {
            this.forecastDays = forecastDays;
        }

        public static class ForecastDay {
            @SerializedName("date")
            private String date;

            @SerializedName("day")
            private Day day;

            public String getDate() {
                return date;
            }

            public void setDate(String date) {
                this.date = date;
            }

            public Day getDay() {
                return day;
            }

            public void setDay(Day day) {
                this.day = day;
            }

            public static class Day {
                @SerializedName("condition")
                private Condition condition;

                public Condition getCondition() {
                    return condition;
                }

                public void setCondition(Condition condition) {
                    this.condition = condition;
                }

                public static class Condition {
                    @SerializedName("text")
                    private String text;

                    public String getText() {
                        return text;
                    }

                    public void setText(String text) {
                        this.text = text;
                    }
                }
            }
        }
    }
}
