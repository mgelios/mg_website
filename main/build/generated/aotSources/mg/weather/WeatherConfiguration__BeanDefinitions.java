package mg.weather;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ConfigurationClassUtils;

/**
 * Bean definitions for {@link WeatherConfiguration}.
 */
@Generated
public class WeatherConfiguration__BeanDefinitions {
  /**
   * Get the bean definition for 'weatherConfiguration'.
   */
  public static BeanDefinition getWeatherConfigurationBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(WeatherConfiguration.class);
    beanDefinition.setTargetType(WeatherConfiguration.class);
    ConfigurationClassUtils.initializeConfigurationClass(WeatherConfiguration.class);
    beanDefinition.setInstanceSupplier(WeatherConfiguration$$SpringCGLIB$$0::new);
    return beanDefinition;
  }

  /**
   * Get the bean definition for 'weatherConfiguration'.
   */
  public static BeanDefinition getWeatherConfigurationBeanDefinition1() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(WeatherConfiguration.class);
    beanDefinition.setTargetType(WeatherConfiguration.class);
    ConfigurationClassUtils.initializeConfigurationClass(WeatherConfiguration.class);
    beanDefinition.setInstanceSupplier(WeatherConfiguration$$SpringCGLIB$$0::new);
    return beanDefinition;
  }
}
