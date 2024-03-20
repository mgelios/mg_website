package mg.security;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ConfigurationClassUtils;

/**
 * Bean definitions for {@link MgMvcConfigurerAdapter}.
 */
@Generated
public class MgMvcConfigurerAdapter__BeanDefinitions {
  /**
   * Get the bean definition for 'mgMvcConfigurerAdapter'.
   */
  public static BeanDefinition getMgMvcConfigurerAdapterBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(MgMvcConfigurerAdapter.class);
    beanDefinition.setTargetType(MgMvcConfigurerAdapter.class);
    ConfigurationClassUtils.initializeConfigurationClass(MgMvcConfigurerAdapter.class);
    beanDefinition.setInstanceSupplier(MgMvcConfigurerAdapter$$SpringCGLIB$$0::new);
    return beanDefinition;
  }
}
