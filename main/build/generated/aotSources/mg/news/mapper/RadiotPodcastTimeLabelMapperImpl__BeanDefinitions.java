package mg.news.mapper;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link RadiotPodcastTimeLabelMapperImpl}.
 */
@Generated
public class RadiotPodcastTimeLabelMapperImpl__BeanDefinitions {
  /**
   * Get the bean definition for 'radiotPodcastTimeLabelMapperImpl'.
   */
  public static BeanDefinition getRadiotPodcastTimeLabelMapperImplBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(RadiotPodcastTimeLabelMapperImpl.class);
    beanDefinition.setInstanceSupplier(RadiotPodcastTimeLabelMapperImpl::new);
    return beanDefinition;
  }
}
