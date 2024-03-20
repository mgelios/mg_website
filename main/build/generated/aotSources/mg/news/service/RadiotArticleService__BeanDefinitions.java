package mg.news.service;

import mg.news.repository.RadiotArticleRepository;
import mg.utils.JSONHelper;
import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.BeanInstanceSupplier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link RadiotArticleService}.
 */
@Generated
public class RadiotArticleService__BeanDefinitions {
  /**
   * Get the bean instance supplier for 'radiotArticleService'.
   */
  private static BeanInstanceSupplier<RadiotArticleService> getRadiotArticleServiceInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<RadiotArticleService>forConstructor(RadiotArticleRepository.class, RadiotExternalApiService.class, JSONHelper.class)
            .withGenerator((registeredBean, args) -> new RadiotArticleService(args.get(0), args.get(1), args.get(2)));
  }

  /**
   * Get the bean definition for 'radiotArticleService'.
   */
  public static BeanDefinition getRadiotArticleServiceBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(RadiotArticleService.class);
    beanDefinition.setInstanceSupplier(getRadiotArticleServiceInstanceSupplier());
    return beanDefinition;
  }
}
