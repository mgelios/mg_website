package mg.profile.conrtoller;

import mg.profile.mapper.UserMapper;
import mg.profile.service.UserService;
import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.BeanInstanceSupplier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link AdminUserRestController}.
 */
@Generated
public class AdminUserRestController__BeanDefinitions {
  /**
   * Get the bean instance supplier for 'adminUserRestController'.
   */
  private static BeanInstanceSupplier<AdminUserRestController> getAdminUserRestControllerInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<AdminUserRestController>forConstructor(UserService.class, UserMapper.class)
            .withGenerator((registeredBean, args) -> new AdminUserRestController(args.get(0), args.get(1)));
  }

  /**
   * Get the bean definition for 'adminUserRestController'.
   */
  public static BeanDefinition getAdminUserRestControllerBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(AdminUserRestController.class);
    beanDefinition.setInstanceSupplier(getAdminUserRestControllerInstanceSupplier());
    return beanDefinition;
  }
}
