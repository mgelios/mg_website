package mg.weather.mapper;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.InstanceSupplier;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link CurrentWeatherMapperImpl}.
 */
@Generated
public class CurrentWeatherMapperImpl__BeanDefinitions {
  /**
   * Get the bean definition for 'currentWeatherMapperImpl'.
   */
  public static BeanDefinition getCurrentWeatherMapperImplBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(CurrentWeatherMapperImpl.class);
    InstanceSupplier<CurrentWeatherMapperImpl> instanceSupplier = InstanceSupplier.using(CurrentWeatherMapperImpl::new);
    instanceSupplier = instanceSupplier.andThen(CurrentWeatherMapperImpl__Autowiring::apply);
    beanDefinition.setInstanceSupplier(instanceSupplier);
    return beanDefinition;
  }
}
