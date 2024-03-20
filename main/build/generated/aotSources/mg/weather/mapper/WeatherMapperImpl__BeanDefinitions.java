package mg.weather.mapper;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link WeatherMapperImpl}.
 */
@Generated
public class WeatherMapperImpl__BeanDefinitions {
  /**
   * Get the bean definition for 'weatherMapperImpl'.
   */
  public static BeanDefinition getWeatherMapperImplBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(WeatherMapperImpl.class);
    beanDefinition.setInstanceSupplier(WeatherMapperImpl::new);
    return beanDefinition;
  }
}
