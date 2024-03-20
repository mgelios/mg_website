package mg.weather.mapper;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.AutowiredFieldValueResolver;
import org.springframework.beans.factory.support.RegisteredBean;

/**
 * Autowiring for {@link DailyWeatherForecastMapperImpl}.
 */
@Generated
public class DailyWeatherForecastMapperImpl__Autowiring {
  /**
   * Apply the autowiring.
   */
  public static DailyWeatherForecastMapperImpl apply(RegisteredBean registeredBean,
      DailyWeatherForecastMapperImpl instance) {
    AutowiredFieldValueResolver.forRequiredField("dateMapper").resolveAndSet(registeredBean, instance);
    AutowiredFieldValueResolver.forRequiredField("temperatureInfoMapper").resolveAndSet(registeredBean, instance);
    AutowiredFieldValueResolver.forRequiredField("temperatureFeelsLikeMapper").resolveAndSet(registeredBean, instance);
    AutowiredFieldValueResolver.forRequiredField("weatherMapper").resolveAndSet(registeredBean, instance);
    return instance;
  }
}
