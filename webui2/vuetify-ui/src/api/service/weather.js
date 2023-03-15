import { ApiService } from "../apiService";
import { CurrentWeatherModel } from "../../models/weather/currentWeatherModel";
import { WeatherForecastItemModel } from "../../models/weather/weatherForecastItemModel";

export const currentWeather = new ApiService(
    '/api/v1/weather/current',
    response => new CurrentWeatherModel(response),
    request => request
);

export const weatherForecast = new ApiService(
    '/api/v1/weather/forecast',
    response => new WeatherForecastItemModel(response),
    request => request
);