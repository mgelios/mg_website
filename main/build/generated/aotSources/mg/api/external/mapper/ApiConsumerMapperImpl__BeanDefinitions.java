package mg.api.external.mapper;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link ApiConsumerMapperImpl}.
 */
@Generated
public class ApiConsumerMapperImpl__BeanDefinitions {
  /**
   * Get the bean definition for 'apiConsumerMapperImpl'.
   */
  public static BeanDefinition getApiConsumerMapperImplBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(ApiConsumerMapperImpl.class);
    beanDefinition.setInstanceSupplier(ApiConsumerMapperImpl::new);
    return beanDefinition;
  }
}
