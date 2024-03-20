package mg.api.external.mapper;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link ExternalApiResponseMapperImpl}.
 */
@Generated
public class ExternalApiResponseMapperImpl__BeanDefinitions {
  /**
   * Get the bean definition for 'externalApiResponseMapperImpl'.
   */
  public static BeanDefinition getExternalApiResponseMapperImplBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(ExternalApiResponseMapperImpl.class);
    beanDefinition.setInstanceSupplier(ExternalApiResponseMapperImpl::new);
    return beanDefinition;
  }
}
