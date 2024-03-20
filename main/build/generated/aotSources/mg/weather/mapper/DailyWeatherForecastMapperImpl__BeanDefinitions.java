package mg.weather.mapper;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.InstanceSupplier;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link DailyWeatherForecastMapperImpl}.
 */
@Generated
public class DailyWeatherForecastMapperImpl__BeanDefinitions {
  /**
   * Get the bean definition for 'dailyWeatherForecastMapperImpl'.
   */
  public static BeanDefinition getDailyWeatherForecastMapperImplBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(DailyWeatherForecastMapperImpl.class);
    InstanceSupplier<DailyWeatherForecastMapperImpl> instanceSupplier = InstanceSupplier.using(DailyWeatherForecastMapperImpl::new);
    instanceSupplier = instanceSupplier.andThen(DailyWeatherForecastMapperImpl__Autowiring::apply);
    beanDefinition.setInstanceSupplier(instanceSupplier);
    return beanDefinition;
  }
}
