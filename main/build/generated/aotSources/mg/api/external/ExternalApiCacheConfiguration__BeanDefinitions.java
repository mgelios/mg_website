package mg.api.external;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ConfigurationClassUtils;

/**
 * Bean definitions for {@link ExternalApiCacheConfiguration}.
 */
@Generated
public class ExternalApiCacheConfiguration__BeanDefinitions {
  /**
   * Get the bean definition for 'externalApiCacheConfiguration'.
   */
  public static BeanDefinition getExternalApiCacheConfigurationBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(ExternalApiCacheConfiguration.class);
    beanDefinition.setTargetType(ExternalApiCacheConfiguration.class);
    ConfigurationClassUtils.initializeConfigurationClass(ExternalApiCacheConfiguration.class);
    beanDefinition.setInstanceSupplier(ExternalApiCacheConfiguration$$SpringCGLIB$$0::new);
    return beanDefinition;
  }
}
