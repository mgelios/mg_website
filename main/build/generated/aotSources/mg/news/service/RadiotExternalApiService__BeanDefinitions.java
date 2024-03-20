package mg.news.service;

import mg.news.util.RadiotUrlBuilder;
import mg.utils.JSONConsumer;
import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.BeanInstanceSupplier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link RadiotExternalApiService}.
 */
@Generated
public class RadiotExternalApiService__BeanDefinitions {
  /**
   * Get the bean instance supplier for 'radiotExternalApiService'.
   */
  private static BeanInstanceSupplier<RadiotExternalApiService> getRadiotExternalApiServiceInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<RadiotExternalApiService>forConstructor(JSONConsumer.class, RadiotUrlBuilder.class)
            .withGenerator((registeredBean, args) -> new RadiotExternalApiService(args.get(0), args.get(1)));
  }

  /**
   * Get the bean definition for 'radiotExternalApiService'.
   */
  public static BeanDefinition getRadiotExternalApiServiceBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(RadiotExternalApiService.class);
    beanDefinition.setInstanceSupplier(getRadiotExternalApiServiceInstanceSupplier());
    return beanDefinition;
  }
}
