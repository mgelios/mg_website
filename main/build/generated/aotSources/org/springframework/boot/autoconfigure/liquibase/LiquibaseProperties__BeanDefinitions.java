package org.springframework.boot.autoconfigure.liquibase;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link LiquibaseProperties}.
 */
@Generated
public class LiquibaseProperties__BeanDefinitions {
  /**
   * Get the bean definition for 'liquibaseProperties'.
   */
  public static BeanDefinition getLiquibasePropertiesBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(LiquibaseProperties.class);
    beanDefinition.setInstanceSupplier(LiquibaseProperties::new);
    return beanDefinition;
  }
}
