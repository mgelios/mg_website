package mg.api.external.service;

import mg.api.external.repository.ExternalApiResponseRepository;
import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.BeanInstanceSupplier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link ExternalApiCacheService}.
 */
@Generated
public class ExternalApiCacheService__BeanDefinitions {
  /**
   * Get the bean instance supplier for 'externalApiCacheService'.
   */
  private static BeanInstanceSupplier<ExternalApiCacheService> getExternalApiCacheServiceInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<ExternalApiCacheService>forConstructor(ExternalApiResponseRepository.class)
            .withGenerator((registeredBean, args) -> new ExternalApiCacheService(args.get(0)));
  }

  /**
   * Get the bean definition for 'externalApiCacheService'.
   */
  public static BeanDefinition getExternalApiCacheServiceBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(ExternalApiCacheService.class);
    beanDefinition.setInstanceSupplier(getExternalApiCacheServiceInstanceSupplier());
    return beanDefinition;
  }
}
