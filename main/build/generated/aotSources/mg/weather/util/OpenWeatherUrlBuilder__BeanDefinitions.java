package mg.weather.util;

import mg.weather.WeatherConfiguration;
import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.BeanInstanceSupplier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link OpenWeatherUrlBuilder}.
 */
@Generated
public class OpenWeatherUrlBuilder__BeanDefinitions {
  /**
   * Get the bean instance supplier for 'openWeatherUrlBuilder'.
   */
  private static BeanInstanceSupplier<OpenWeatherUrlBuilder> getOpenWeatherUrlBuilderInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<OpenWeatherUrlBuilder>forConstructor(WeatherConfiguration.class)
            .withGenerator((registeredBean, args) -> new OpenWeatherUrlBuilder(args.get(0)));
  }

  /**
   * Get the bean definition for 'openWeatherUrlBuilder'.
   */
  public static BeanDefinition getOpenWeatherUrlBuilderBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(OpenWeatherUrlBuilder.class);
    beanDefinition.setInstanceSupplier(getOpenWeatherUrlBuilderInstanceSupplier());
    return beanDefinition;
  }
}
