package mg.weather.util;

public interface WeatherUrlBuilder {

    String buildCurrentDefaultWeatherUrl();
    String buildCurrentWeatherUrl(String city);
    String buildForecastDefaultUrl();
    String buildForecastUrl(String city);
    String buildDefaultUviUrl();
}
