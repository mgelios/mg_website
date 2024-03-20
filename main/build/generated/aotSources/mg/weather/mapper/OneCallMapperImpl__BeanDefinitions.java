package mg.weather.mapper;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.InstanceSupplier;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link OneCallMapperImpl}.
 */
@Generated
public class OneCallMapperImpl__BeanDefinitions {
  /**
   * Get the bean definition for 'oneCallMapperImpl'.
   */
  public static BeanDefinition getOneCallMapperImplBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(OneCallMapperImpl.class);
    InstanceSupplier<OneCallMapperImpl> instanceSupplier = InstanceSupplier.using(OneCallMapperImpl::new);
    instanceSupplier = instanceSupplier.andThen(OneCallMapperImpl__Autowiring::apply);
    beanDefinition.setInstanceSupplier(instanceSupplier);
    return beanDefinition;
  }
}
