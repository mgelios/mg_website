package mg.security.token;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.BeanInstanceSupplier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link JWTLoginController}.
 */
@Generated
public class JWTLoginController__BeanDefinitions {
  /**
   * Get the bean instance supplier for 'JWTLoginController'.
   */
  private static BeanInstanceSupplier<JWTLoginController> getJWTLoginControllerInstanceSupplier() {
    return BeanInstanceSupplier.<JWTLoginController>forConstructor(JWTService.class)
            .withGenerator((registeredBean, args) -> new JWTLoginController(args.get(0)));
  }

  /**
   * Get the bean definition for 'jWTLoginController'.
   */
  public static BeanDefinition getJWTLoginControllerBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(JWTLoginController.class);
    beanDefinition.setInstanceSupplier(getJWTLoginControllerInstanceSupplier());
    return beanDefinition;
  }
}
