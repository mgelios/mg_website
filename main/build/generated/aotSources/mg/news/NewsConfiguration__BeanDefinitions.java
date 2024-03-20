package mg.news;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ConfigurationClassUtils;

/**
 * Bean definitions for {@link NewsConfiguration}.
 */
@Generated
public class NewsConfiguration__BeanDefinitions {
  /**
   * Get the bean definition for 'newsConfiguration'.
   */
  public static BeanDefinition getNewsConfigurationBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(NewsConfiguration.class);
    beanDefinition.setTargetType(NewsConfiguration.class);
    ConfigurationClassUtils.initializeConfigurationClass(NewsConfiguration.class);
    beanDefinition.setInstanceSupplier(NewsConfiguration$$SpringCGLIB$$0::new);
    return beanDefinition;
  }

  /**
   * Get the bean definition for 'newsConfiguration'.
   */
  public static BeanDefinition getNewsConfigurationBeanDefinition1() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(NewsConfiguration.class);
    beanDefinition.setTargetType(NewsConfiguration.class);
    ConfigurationClassUtils.initializeConfigurationClass(NewsConfiguration.class);
    beanDefinition.setInstanceSupplier(NewsConfiguration$$SpringCGLIB$$0::new);
    return beanDefinition;
  }
}
