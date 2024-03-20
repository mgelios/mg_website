package mg.weather.service;

import mg.weather.WeatherConfiguration;
import mg.weather.mapper.GeocodingInfoMapper;
import mg.weather.mapper.OneCallMapper;
import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.BeanInstanceSupplier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link CurrentWeatherService}.
 */
@Generated
public class CurrentWeatherService__BeanDefinitions {
  /**
   * Get the bean instance supplier for 'currentWeatherService'.
   */
  private static BeanInstanceSupplier<CurrentWeatherService> getCurrentWeatherServiceInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<CurrentWeatherService>forConstructor(WeatherConfiguration.class, OneCallMapper.class, GeocodingInfoMapper.class, OpenWeatherApiService.class)
            .withGenerator((registeredBean, args) -> new CurrentWeatherService(args.get(0), args.get(1), args.get(2), args.get(3)));
  }

  /**
   * Get the bean definition for 'currentWeatherService'.
   */
  public static BeanDefinition getCurrentWeatherServiceBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(CurrentWeatherService.class);
    beanDefinition.setInstanceSupplier(getCurrentWeatherServiceInstanceSupplier());
    return beanDefinition;
  }
}
