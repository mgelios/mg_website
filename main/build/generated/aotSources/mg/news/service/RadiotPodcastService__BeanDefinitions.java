package mg.news.service;

import mg.news.repository.RadiotPodcastRepository;
import mg.news.repository.RadiotPodcastTimeLabelRepository;
import mg.utils.JSONHelper;
import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.BeanInstanceSupplier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link RadiotPodcastService}.
 */
@Generated
public class RadiotPodcastService__BeanDefinitions {
  /**
   * Get the bean instance supplier for 'radiotPodcastService'.
   */
  private static BeanInstanceSupplier<RadiotPodcastService> getRadiotPodcastServiceInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<RadiotPodcastService>forConstructor(RadiotPodcastRepository.class, RadiotPodcastTimeLabelRepository.class, RadiotExternalApiService.class, JSONHelper.class)
            .withGenerator((registeredBean, args) -> new RadiotPodcastService(args.get(0), args.get(1), args.get(2), args.get(3)));
  }

  /**
   * Get the bean definition for 'radiotPodcastService'.
   */
  public static BeanDefinition getRadiotPodcastServiceBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(RadiotPodcastService.class);
    beanDefinition.setInstanceSupplier(getRadiotPodcastServiceInstanceSupplier());
    return beanDefinition;
  }
}
