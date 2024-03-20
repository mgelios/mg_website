package mg.news.controller;

import mg.news.mapper.RadiotPodcastMapper;
import mg.news.service.RadiotPodcastService;
import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.BeanInstanceSupplier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link PodcastRestController}.
 */
@Generated
public class PodcastRestController__BeanDefinitions {
  /**
   * Get the bean instance supplier for 'podcastRestController'.
   */
  private static BeanInstanceSupplier<PodcastRestController> getPodcastRestControllerInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<PodcastRestController>forConstructor(RadiotPodcastService.class, RadiotPodcastMapper.class)
            .withGenerator((registeredBean, args) -> new PodcastRestController(args.get(0), args.get(1)));
  }

  /**
   * Get the bean definition for 'podcastRestController'.
   */
  public static BeanDefinition getPodcastRestControllerBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(PodcastRestController.class);
    beanDefinition.setInstanceSupplier(getPodcastRestControllerInstanceSupplier());
    return beanDefinition;
  }
}
