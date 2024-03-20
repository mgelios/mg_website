package mg.news.mapper;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link RadiotArticleMapperImpl}.
 */
@Generated
public class RadiotArticleMapperImpl__BeanDefinitions {
  /**
   * Get the bean definition for 'radiotArticleMapperImpl'.
   */
  public static BeanDefinition getRadiotArticleMapperImplBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(RadiotArticleMapperImpl.class);
    beanDefinition.setInstanceSupplier(RadiotArticleMapperImpl::new);
    return beanDefinition;
  }
}
