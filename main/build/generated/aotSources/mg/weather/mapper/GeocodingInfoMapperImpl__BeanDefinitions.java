package mg.weather.mapper;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link GeocodingInfoMapperImpl}.
 */
@Generated
public class GeocodingInfoMapperImpl__BeanDefinitions {
  /**
   * Get the bean definition for 'geocodingInfoMapperImpl'.
   */
  public static BeanDefinition getGeocodingInfoMapperImplBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(GeocodingInfoMapperImpl.class);
    beanDefinition.setInstanceSupplier(GeocodingInfoMapperImpl::new);
    return beanDefinition;
  }
}
