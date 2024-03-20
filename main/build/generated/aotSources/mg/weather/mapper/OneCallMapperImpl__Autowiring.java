package mg.weather.mapper;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.AutowiredFieldValueResolver;
import org.springframework.beans.factory.support.RegisteredBean;

/**
 * Autowiring for {@link OneCallMapperImpl}.
 */
@Generated
public class OneCallMapperImpl__Autowiring {
  /**
   * Apply the autowiring.
   */
  public static OneCallMapperImpl apply(RegisteredBean registeredBean, OneCallMapperImpl instance) {
    AutowiredFieldValueResolver.forRequiredField("dailyWeatherForecastMapper").resolveAndSet(registeredBean, instance);
    AutowiredFieldValueResolver.forRequiredField("currentWeatherMapper").resolveAndSet(registeredBean, instance);
    return instance;
  }
}
