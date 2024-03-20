package mg.security.basic;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.AutowiredFieldValueResolver;
import org.springframework.beans.factory.support.RegisteredBean;

/**
 * Autowiring for {@link BasicAuthenticationProvider}.
 */
@Generated
public class BasicAuthenticationProvider__Autowiring {
  /**
   * Apply the autowiring.
   */
  public static BasicAuthenticationProvider apply(RegisteredBean registeredBean,
      BasicAuthenticationProvider instance) {
    AutowiredFieldValueResolver.forRequiredField("userDetailsService").resolveAndSet(registeredBean, instance);
    AutowiredFieldValueResolver.forRequiredField("bCryptPasswordEncoder").resolveAndSet(registeredBean, instance);
    return instance;
  }
}
