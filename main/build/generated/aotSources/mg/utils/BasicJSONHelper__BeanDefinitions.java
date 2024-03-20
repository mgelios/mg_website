package mg.utils;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link BasicJSONHelper}.
 */
@Generated
public class BasicJSONHelper__BeanDefinitions {
  /**
   * Get the bean definition for 'basicJSONHelper'.
   */
  public static BeanDefinition getBasicJSONHelperBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(BasicJSONHelper.class);
    beanDefinition.setInstanceSupplier(BasicJSONHelper::new);
    return beanDefinition;
  }
}
