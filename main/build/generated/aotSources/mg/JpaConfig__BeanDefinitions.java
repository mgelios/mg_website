package mg;

import javax.sql.DataSource;
import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.BeanInstanceSupplier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.ConfigurationClassUtils;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.support.OpenEntityManagerInViewFilter;

/**
 * Bean definitions for {@link JpaConfig}.
 */
@Generated
public class JpaConfig__BeanDefinitions {
  /**
   * Get the bean definition for 'jpaConfig'.
   */
  public static BeanDefinition getJpaConfigBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(JpaConfig.class);
    beanDefinition.setTargetType(JpaConfig.class);
    ConfigurationClassUtils.initializeConfigurationClass(JpaConfig.class);
    beanDefinition.setInstanceSupplier(JpaConfig$$SpringCGLIB$$0::new);
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'entityManagerFactory'.
   */
  private static BeanInstanceSupplier<LocalContainerEntityManagerFactoryBean> getEntityManagerFactoryInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<LocalContainerEntityManagerFactoryBean>forFactoryMethod(JpaConfig.class, "entityManagerFactory", EntityManagerFactoryBuilder.class, DataSource.class)
            .withGenerator((registeredBean, args) -> registeredBean.getBeanFactory().getBean(JpaConfig.class).entityManagerFactory(args.get(0), args.get(1)));
  }

  /**
   * Get the bean definition for 'entityManagerFactory'.
   */
  public static BeanDefinition getEntityManagerFactoryBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(LocalContainerEntityManagerFactoryBean.class);
    beanDefinition.setPrimary(true);
    beanDefinition.setDependsOn("liquibase","dataSourceScriptDatabaseInitializer");
    beanDefinition.setInstanceSupplier(getEntityManagerFactoryInstanceSupplier());
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'openEntityManagerInViewFilter'.
   */
  private static BeanInstanceSupplier<OpenEntityManagerInViewFilter> getOpenEntityManagerInViewFilterInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<OpenEntityManagerInViewFilter>forFactoryMethod(JpaConfig.class, "openEntityManagerInViewFilter")
            .withGenerator((registeredBean) -> registeredBean.getBeanFactory().getBean(JpaConfig.class).openEntityManagerInViewFilter());
  }

  /**
   * Get the bean definition for 'openEntityManagerInViewFilter'.
   */
  public static BeanDefinition getOpenEntityManagerInViewFilterBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(OpenEntityManagerInViewFilter.class);
    beanDefinition.setInstanceSupplier(getOpenEntityManagerInViewFilterInstanceSupplier());
    return beanDefinition;
  }
}
