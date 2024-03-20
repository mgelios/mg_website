package mg.weather.mapper;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link TemperatureFeelsLikeMapperImpl}.
 */
@Generated
public class TemperatureFeelsLikeMapperImpl__BeanDefinitions {
  /**
   * Get the bean definition for 'temperatureFeelsLikeMapperImpl'.
   */
  public static BeanDefinition getTemperatureFeelsLikeMapperImplBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(TemperatureFeelsLikeMapperImpl.class);
    beanDefinition.setInstanceSupplier(TemperatureFeelsLikeMapperImpl::new);
    return beanDefinition;
  }
}
