package mg.security.error;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link AuthenticationFailureHandler}.
 */
@Generated
public class AuthenticationFailureHandler__BeanDefinitions {
  /**
   * Get the bean definition for 'authenticationFailureHandler'.
   */
  public static BeanDefinition getAuthenticationFailureHandlerBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(AuthenticationFailureHandler.class);
    beanDefinition.setInstanceSupplier(AuthenticationFailureHandler::new);
    return beanDefinition;
  }
}
