package mg.news.controller;

import mg.news.mapper.RadiotArticleMapper;
import mg.news.service.RadiotArticleService;
import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.BeanInstanceSupplier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link NewsRestController}.
 */
@Generated
public class NewsRestController__BeanDefinitions {
  /**
   * Get the bean instance supplier for 'newsRestController'.
   */
  private static BeanInstanceSupplier<NewsRestController> getNewsRestControllerInstanceSupplier() {
    return BeanInstanceSupplier.<NewsRestController>forConstructor(RadiotArticleService.class, RadiotArticleMapper.class)
            .withGenerator((registeredBean, args) -> new NewsRestController(args.get(0), args.get(1)));
  }

  /**
   * Get the bean definition for 'newsRestController'.
   */
  public static BeanDefinition getNewsRestControllerBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(NewsRestController.class);
    beanDefinition.setInstanceSupplier(getNewsRestControllerInstanceSupplier());
    return beanDefinition;
  }
}
