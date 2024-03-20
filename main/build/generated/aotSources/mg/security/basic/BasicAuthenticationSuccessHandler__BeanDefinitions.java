package mg.security.basic;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link BasicAuthenticationSuccessHandler}.
 */
@Generated
public class BasicAuthenticationSuccessHandler__BeanDefinitions {
  /**
   * Get the bean definition for 'basicAuthenticationSuccessHandler'.
   */
  public static BeanDefinition getBasicAuthenticationSuccessHandlerBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(BasicAuthenticationSuccessHandler.class);
    beanDefinition.setInstanceSupplier(BasicAuthenticationSuccessHandler::new);
    return beanDefinition;
  }
}
