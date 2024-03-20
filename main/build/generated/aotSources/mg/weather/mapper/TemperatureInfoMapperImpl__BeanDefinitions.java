package mg.weather.mapper;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link TemperatureInfoMapperImpl}.
 */
@Generated
public class TemperatureInfoMapperImpl__BeanDefinitions {
  /**
   * Get the bean definition for 'temperatureInfoMapperImpl'.
   */
  public static BeanDefinition getTemperatureInfoMapperImplBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(TemperatureInfoMapperImpl.class);
    beanDefinition.setInstanceSupplier(TemperatureInfoMapperImpl::new);
    return beanDefinition;
  }
}
