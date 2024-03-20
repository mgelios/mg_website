package mg.security.token;

import mg.profile.mapper.UserMapper;
import mg.profile.service.UserService;
import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.BeanInstanceSupplier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * Bean definitions for {@link JWTService}.
 */
@Generated
public class JWTService__BeanDefinitions {
  /**
   * Get the bean instance supplier for 'JWTService'.
   */
  private static BeanInstanceSupplier<JWTService> getJWTServiceInstanceSupplier() {
    return BeanInstanceSupplier.<JWTService>forConstructor(UserService.class, BCryptPasswordEncoder.class, UserMapper.class)
            .withGenerator((registeredBean, args) -> new JWTService(args.get(0), args.get(1), args.get(2)));
  }

  /**
   * Get the bean definition for 'jWTService'.
   */
  public static BeanDefinition getJWTServiceBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(JWTService.class);
    beanDefinition.setInstanceSupplier(getJWTServiceInstanceSupplier());
    return beanDefinition;
  }
}
