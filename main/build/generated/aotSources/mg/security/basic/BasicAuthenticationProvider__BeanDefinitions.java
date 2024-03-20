package mg.security.basic;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.InstanceSupplier;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link BasicAuthenticationProvider}.
 */
@Generated
public class BasicAuthenticationProvider__BeanDefinitions {
  /**
   * Get the bean definition for 'basicAuthenticationProvider'.
   */
  public static BeanDefinition getBasicAuthenticationProviderBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(BasicAuthenticationProvider.class);
    InstanceSupplier<BasicAuthenticationProvider> instanceSupplier = InstanceSupplier.using(BasicAuthenticationProvider::new);
    instanceSupplier = instanceSupplier.andThen(BasicAuthenticationProvider__Autowiring::apply);
    beanDefinition.setInstanceSupplier(instanceSupplier);
    return beanDefinition;
  }
}
