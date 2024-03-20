package mg.weather.service;

import mg.api.external.service.ApiConsumerService;
import mg.weather.WeatherConfiguration;
import mg.weather.util.OpenWeatherUrlBuilder;
import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.BeanInstanceSupplier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link OpenWeatherApiService}.
 */
@Generated
public class OpenWeatherApiService__BeanDefinitions {
  /**
   * Get the bean instance supplier for 'openWeatherApiService'.
   */
  private static BeanInstanceSupplier<OpenWeatherApiService> getOpenWeatherApiServiceInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<OpenWeatherApiService>forConstructor(WeatherConfiguration.class, OpenWeatherUrlBuilder.class, ApiConsumerService.class)
            .withGenerator((registeredBean, args) -> new OpenWeatherApiService(args.get(0), args.get(1), args.get(2)));
  }

  /**
   * Get the bean definition for 'openWeatherApiService'.
   */
  public static BeanDefinition getOpenWeatherApiServiceBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(OpenWeatherApiService.class);
    beanDefinition.setInstanceSupplier(getOpenWeatherApiServiceInstanceSupplier());
    return beanDefinition;
  }
}
