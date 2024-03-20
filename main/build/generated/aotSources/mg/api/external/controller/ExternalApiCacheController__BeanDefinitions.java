package mg.api.external.controller;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link ExternalApiCacheController}.
 */
@Generated
public class ExternalApiCacheController__BeanDefinitions {
  /**
   * Get the bean definition for 'externalApiCacheController'.
   */
  public static BeanDefinition getExternalApiCacheControllerBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(ExternalApiCacheController.class);
    beanDefinition.setInstanceSupplier(ExternalApiCacheController::new);
    return beanDefinition;
  }
}
