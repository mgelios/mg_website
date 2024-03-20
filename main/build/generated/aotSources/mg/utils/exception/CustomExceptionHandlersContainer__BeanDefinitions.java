package mg.utils.exception;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link CustomExceptionHandlersContainer}.
 */
@Generated
public class CustomExceptionHandlersContainer__BeanDefinitions {
  /**
   * Get the bean definition for 'customExceptionHandlersContainer'.
   */
  public static BeanDefinition getCustomExceptionHandlersContainerBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(CustomExceptionHandlersContainer.class);
    beanDefinition.setInstanceSupplier(CustomExceptionHandlersContainer::new);
    return beanDefinition;
  }
}
