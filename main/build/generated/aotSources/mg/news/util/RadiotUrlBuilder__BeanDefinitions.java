package mg.news.util;

import mg.news.NewsConfiguration;
import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.BeanInstanceSupplier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link RadiotUrlBuilder}.
 */
@Generated
public class RadiotUrlBuilder__BeanDefinitions {
  /**
   * Get the bean instance supplier for 'radiotUrlBuilder'.
   */
  private static BeanInstanceSupplier<RadiotUrlBuilder> getRadiotUrlBuilderInstanceSupplier() {
    return BeanInstanceSupplier.<RadiotUrlBuilder>forConstructor(NewsConfiguration.class)
            .withGenerator((registeredBean, args) -> new RadiotUrlBuilder(args.get(0)));
  }

  /**
   * Get the bean definition for 'radiotUrlBuilder'.
   */
  public static BeanDefinition getRadiotUrlBuilderBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(RadiotUrlBuilder.class);
    beanDefinition.setInstanceSupplier(getRadiotUrlBuilderInstanceSupplier());
    return beanDefinition;
  }
}
