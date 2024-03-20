package mg.utils;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link BasicJSONConsumer}.
 */
@Generated
public class BasicJSONConsumer__BeanDefinitions {
  /**
   * Get the bean definition for 'basicJSONConsumer'.
   */
  public static BeanDefinition getBasicJSONConsumerBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(BasicJSONConsumer.class);
    beanDefinition.setInstanceSupplier(BasicJSONConsumer::new);
    return beanDefinition;
  }
}
