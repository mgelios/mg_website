package mg.weather.utils;

public interface WeatherUrlBuilder {

    String buildCurrentDefaultWeatherUrl();
    String buildCurrentWeatherUrl(String city);
    String buildForecastDefaultUrl();
    String buildForecastUrl(String city);
}
