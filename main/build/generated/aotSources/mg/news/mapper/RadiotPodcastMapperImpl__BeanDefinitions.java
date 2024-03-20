package mg.news.mapper;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.InstanceSupplier;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link RadiotPodcastMapperImpl}.
 */
@Generated
public class RadiotPodcastMapperImpl__BeanDefinitions {
  /**
   * Get the bean definition for 'radiotPodcastMapperImpl'.
   */
  public static BeanDefinition getRadiotPodcastMapperImplBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(RadiotPodcastMapperImpl.class);
    InstanceSupplier<RadiotPodcastMapperImpl> instanceSupplier = InstanceSupplier.using(RadiotPodcastMapperImpl::new);
    instanceSupplier = instanceSupplier.andThen(RadiotPodcastMapperImpl__Autowiring::apply);
    beanDefinition.setInstanceSupplier(instanceSupplier);
    return beanDefinition;
  }
}
