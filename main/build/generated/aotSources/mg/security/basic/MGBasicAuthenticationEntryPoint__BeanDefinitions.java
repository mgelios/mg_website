package mg.security.basic;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link MGBasicAuthenticationEntryPoint}.
 */
@Generated
public class MGBasicAuthenticationEntryPoint__BeanDefinitions {
  /**
   * Get the bean definition for 'mGBasicAuthenticationEntryPoint'.
   */
  public static BeanDefinition getMGBasicAuthenticationEntryPointBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(MGBasicAuthenticationEntryPoint.class);
    beanDefinition.setInstanceSupplier(MGBasicAuthenticationEntryPoint::new);
    return beanDefinition;
  }
}
