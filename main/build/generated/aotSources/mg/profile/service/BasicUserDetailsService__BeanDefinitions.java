package mg.profile.service;

import mg.profile.mapper.UserMapper;
import mg.profile.repository.UserRepository;
import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.BeanInstanceSupplier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link BasicUserDetailsService}.
 */
@Generated
public class BasicUserDetailsService__BeanDefinitions {
  /**
   * Get the bean instance supplier for 'basicUserDetailsService'.
   */
  private static BeanInstanceSupplier<BasicUserDetailsService> getBasicUserDetailsServiceInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<BasicUserDetailsService>forConstructor(UserRepository.class, UserMapper.class)
            .withGenerator((registeredBean, args) -> new BasicUserDetailsService(args.get(0), args.get(1)));
  }

  /**
   * Get the bean definition for 'basicUserDetailsService'.
   */
  public static BeanDefinition getBasicUserDetailsServiceBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(BasicUserDetailsService.class);
    beanDefinition.setInstanceSupplier(getBasicUserDetailsServiceInstanceSupplier());
    return beanDefinition;
  }
}
