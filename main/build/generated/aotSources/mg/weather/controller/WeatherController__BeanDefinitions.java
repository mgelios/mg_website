package mg.weather.controller;

import mg.weather.service.CurrentWeatherService;
import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.BeanInstanceSupplier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link WeatherController}.
 */
@Generated
public class WeatherController__BeanDefinitions {
  /**
   * Get the bean instance supplier for 'weatherController'.
   */
  private static BeanInstanceSupplier<WeatherController> getWeatherControllerInstanceSupplier() {
    return BeanInstanceSupplier.<WeatherController>forConstructor(CurrentWeatherService.class)
            .withGenerator((registeredBean, args) -> new WeatherController(args.get(0)));
  }

  /**
   * Get the bean definition for 'weatherController'.
   */
  public static BeanDefinition getWeatherControllerBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(WeatherController.class);
    beanDefinition.setInstanceSupplier(getWeatherControllerInstanceSupplier());
    return beanDefinition;
  }
}
