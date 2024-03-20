package mg.profile.conrtoller;

import mg.profile.mapper.UserMapper;
import mg.profile.service.UserService;
import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.BeanInstanceSupplier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link GuestUserRestController}.
 */
@Generated
public class GuestUserRestController__BeanDefinitions {
  /**
   * Get the bean instance supplier for 'guestUserRestController'.
   */
  private static BeanInstanceSupplier<GuestUserRestController> getGuestUserRestControllerInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<GuestUserRestController>forConstructor(UserService.class, UserMapper.class)
            .withGenerator((registeredBean, args) -> new GuestUserRestController(args.get(0), args.get(1)));
  }

  /**
   * Get the bean definition for 'guestUserRestController'.
   */
  public static BeanDefinition getGuestUserRestControllerBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(GuestUserRestController.class);
    beanDefinition.setInstanceSupplier(getGuestUserRestControllerInstanceSupplier());
    return beanDefinition;
  }
}
