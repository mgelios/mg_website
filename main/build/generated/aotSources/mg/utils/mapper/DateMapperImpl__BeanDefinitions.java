package mg.utils.mapper;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link DateMapperImpl}.
 */
@Generated
public class DateMapperImpl__BeanDefinitions {
  /**
   * Get the bean definition for 'dateMapperImpl'.
   */
  public static BeanDefinition getDateMapperImplBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(DateMapperImpl.class);
    beanDefinition.setInstanceSupplier(DateMapperImpl::new);
    return beanDefinition;
  }
}
