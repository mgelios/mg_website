package org.springframework.boot.autoconfigure.liquibase;

import liquibase.integration.spring.SpringLiquibase;
import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.aot.BeanInstanceSupplier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link LiquibaseAutoConfiguration}.
 */
@Generated
public class LiquibaseAutoConfiguration__BeanDefinitions {
  /**
   * Get the bean definition for 'liquibaseAutoConfiguration'.
   */
  public static BeanDefinition getLiquibaseAutoConfigurationBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(LiquibaseAutoConfiguration.class);
    beanDefinition.setInstanceSupplier(LiquibaseAutoConfiguration::new);
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'liquibaseDefaultDdlModeProvider'.
   */
  private static BeanInstanceSupplier<LiquibaseSchemaManagementProvider> getLiquibaseDefaultDdlModeProviderInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<LiquibaseSchemaManagementProvider>forFactoryMethod(LiquibaseAutoConfiguration.class, "liquibaseDefaultDdlModeProvider", ObjectProvider.class)
            .withGenerator((registeredBean, args) -> registeredBean.getBeanFactory().getBean(LiquibaseAutoConfiguration.class).liquibaseDefaultDdlModeProvider(args.get(0)));
  }

  /**
   * Get the bean definition for 'liquibaseDefaultDdlModeProvider'.
   */
  public static BeanDefinition getLiquibaseDefaultDdlModeProviderBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(LiquibaseSchemaManagementProvider.class);
    beanDefinition.setInstanceSupplier(getLiquibaseDefaultDdlModeProviderInstanceSupplier());
    return beanDefinition;
  }

  /**
   * Bean definitions for {@link LiquibaseAutoConfiguration.LiquibaseConfiguration}.
   */
  @Generated
  public static class LiquibaseConfiguration {
    /**
     * Get the bean definition for 'liquibaseConfiguration'.
     */
    public static BeanDefinition getLiquibaseConfigurationBeanDefinition() {
      RootBeanDefinition beanDefinition = new RootBeanDefinition(LiquibaseAutoConfiguration.LiquibaseConfiguration.class);
      beanDefinition.setInstanceSupplier(LiquibaseAutoConfiguration.LiquibaseConfiguration::new);
      return beanDefinition;
    }

    /**
     * Get the bean instance supplier for 'liquibaseConnectionDetails'.
     */
    private static BeanInstanceSupplier<LiquibaseAutoConfiguration.PropertiesLiquibaseConnectionDetails> getLiquibaseConnectionDetailsInstanceSupplier(
        ) {
      return BeanInstanceSupplier.<LiquibaseAutoConfiguration.PropertiesLiquibaseConnectionDetails>forFactoryMethod(LiquibaseAutoConfiguration.LiquibaseConfiguration.class, "liquibaseConnectionDetails", LiquibaseProperties.class, ObjectProvider.class)
              .withGenerator((registeredBean, args) -> registeredBean.getBeanFactory().getBean(LiquibaseAutoConfiguration.LiquibaseConfiguration.class).liquibaseConnectionDetails(args.get(0), args.get(1)));
    }

    /**
     * Get the bean definition for 'liquibaseConnectionDetails'.
     */
    public static BeanDefinition getLiquibaseConnectionDetailsBeanDefinition() {
      RootBeanDefinition beanDefinition = new RootBeanDefinition(LiquibaseAutoConfiguration.PropertiesLiquibaseConnectionDetails.class);
      beanDefinition.setInstanceSupplier(getLiquibaseConnectionDetailsInstanceSupplier());
      return beanDefinition;
    }

    /**
     * Get the bean instance supplier for 'liquibase'.
     */
    private static BeanInstanceSupplier<SpringLiquibase> getLiquibaseInstanceSupplier() {
      return BeanInstanceSupplier.<SpringLiquibase>forFactoryMethod(LiquibaseAutoConfiguration.LiquibaseConfiguration.class, "liquibase", ObjectProvider.class, ObjectProvider.class, LiquibaseProperties.class, LiquibaseConnectionDetails.class)
              .withGenerator((registeredBean, args) -> registeredBean.getBeanFactory().getBean(LiquibaseAutoConfiguration.LiquibaseConfiguration.class).liquibase(args.get(0), args.get(1), args.get(2), args.get(3)));
    }

    /**
     * Get the bean definition for 'liquibase'.
     */
    public static BeanDefinition getLiquibaseBeanDefinition() {
      RootBeanDefinition beanDefinition = new RootBeanDefinition(SpringLiquibase.class);
      beanDefinition.setInstanceSupplier(getLiquibaseInstanceSupplier());
      return beanDefinition;
    }
  }
}
