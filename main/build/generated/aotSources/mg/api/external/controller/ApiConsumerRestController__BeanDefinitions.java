package mg.api.external.controller;

import mg.api.external.mapper.ApiConsumerMapper;
import mg.api.external.service.ApiConsumerService;
import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.BeanInstanceSupplier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link ApiConsumerRestController}.
 */
@Generated
public class ApiConsumerRestController__BeanDefinitions {
  /**
   * Get the bean instance supplier for 'apiConsumerRestController'.
   */
  private static BeanInstanceSupplier<ApiConsumerRestController> getApiConsumerRestControllerInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<ApiConsumerRestController>forConstructor(ApiConsumerService.class, ApiConsumerMapper.class)
            .withGenerator((registeredBean, args) -> new ApiConsumerRestController(args.get(0), args.get(1)));
  }

  /**
   * Get the bean definition for 'apiConsumerRestController'.
   */
  public static BeanDefinition getApiConsumerRestControllerBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(ApiConsumerRestController.class);
    beanDefinition.setInstanceSupplier(getApiConsumerRestControllerInstanceSupplier());
    return beanDefinition;
  }
}
