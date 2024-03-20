package mg.weather.mapper;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.AutowiredFieldValueResolver;
import org.springframework.beans.factory.support.RegisteredBean;

/**
 * Autowiring for {@link CurrentWeatherMapperImpl}.
 */
@Generated
public class CurrentWeatherMapperImpl__Autowiring {
  /**
   * Apply the autowiring.
   */
  public static CurrentWeatherMapperImpl apply(RegisteredBean registeredBean,
      CurrentWeatherMapperImpl instance) {
    AutowiredFieldValueResolver.forRequiredField("dateMapper").resolveAndSet(registeredBean, instance);
    AutowiredFieldValueResolver.forRequiredField("weatherMapper").resolveAndSet(registeredBean, instance);
    return instance;
  }
}
