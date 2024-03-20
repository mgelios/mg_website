package mg.api.external.service;

import mg.api.external.mapper.ApiConsumerMapper;
import mg.api.external.repository.ApiConsumerRepository;
import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.BeanInstanceSupplier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link ApiConsumerService}.
 */
@Generated
public class ApiConsumerService__BeanDefinitions {
  /**
   * Get the bean instance supplier for 'apiConsumerService'.
   */
  private static BeanInstanceSupplier<ApiConsumerService> getApiConsumerServiceInstanceSupplier() {
    return BeanInstanceSupplier.<ApiConsumerService>forConstructor(ApiConsumerRepository.class, ApiConsumerMapper.class)
            .withGenerator((registeredBean, args) -> new ApiConsumerService(args.get(0), args.get(1)));
  }

  /**
   * Get the bean definition for 'apiConsumerService'.
   */
  public static BeanDefinition getApiConsumerServiceBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(ApiConsumerService.class);
    beanDefinition.setInstanceSupplier(getApiConsumerServiceInstanceSupplier());
    return beanDefinition;
  }
}
