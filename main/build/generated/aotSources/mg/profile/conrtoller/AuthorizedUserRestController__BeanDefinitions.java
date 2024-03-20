package mg.profile.conrtoller;

import mg.profile.mapper.UserMapper;
import mg.profile.service.UserService;
import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.BeanInstanceSupplier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link AuthorizedUserRestController}.
 */
@Generated
public class AuthorizedUserRestController__BeanDefinitions {
  /**
   * Get the bean instance supplier for 'authorizedUserRestController'.
   */
  private static BeanInstanceSupplier<AuthorizedUserRestController> getAuthorizedUserRestControllerInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<AuthorizedUserRestController>forConstructor(UserService.class, UserMapper.class)
            .withGenerator((registeredBean, args) -> new AuthorizedUserRestController(args.get(0), args.get(1)));
  }

  /**
   * Get the bean definition for 'authorizedUserRestController'.
   */
  public static BeanDefinition getAuthorizedUserRestControllerBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(AuthorizedUserRestController.class);
    beanDefinition.setInstanceSupplier(getAuthorizedUserRestControllerInstanceSupplier());
    return beanDefinition;
  }
}
