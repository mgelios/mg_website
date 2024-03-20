package mg;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.lang.Override;
import java.lang.String;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import mg.utils.properties.YamlPropertyLoaderFactory;
import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.annotation.ContextAnnotationAutowireCandidateResolver;
import org.springframework.context.annotation.ImportAwareAotBeanPostProcessor;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.core.annotation.AnnotationAwareOrderComparator;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.io.support.PropertySourceDescriptor;
import org.springframework.core.io.support.PropertySourceProcessor;

/**
 * {@link ApplicationContextInitializer} to restore an application context based on previous AOT processing.
 */
@Generated
public class Application__ApplicationContextInitializer implements ApplicationContextInitializer<GenericApplicationContext> {
  @Override
  public void initialize(GenericApplicationContext applicationContext) {
    DefaultListableBeanFactory beanFactory = applicationContext.getDefaultListableBeanFactory();
    beanFactory.setAutowireCandidateResolver(new ContextAnnotationAutowireCandidateResolver());
    beanFactory.setDependencyComparator(AnnotationAwareOrderComparator.INSTANCE);
    processPropertySources(applicationContext.getEnvironment(), applicationContext);
    addImportAwareBeanPostProcessors(beanFactory);
    new Application__BeanFactoryRegistrations().registerBeanDefinitions(beanFactory);
    new Application__BeanFactoryRegistrations().registerAliases(beanFactory);
  }

  /**
   * Apply known @PropertySources to the environment.
   */
  private void processPropertySources(ConfigurableEnvironment environment,
      ResourceLoader resourceLoader) {
    PropertySourceProcessor processor = new PropertySourceProcessor(environment, resourceLoader);
    try {
      processor.processPropertySource(new PropertySourceDescriptor(List.of("classpath:/weather.yml"), false, null, YamlPropertyLoaderFactory.class, null));
      processor.processPropertySource(new PropertySourceDescriptor(List.of("classpath:/external-api-cache.yml"), false, null, YamlPropertyLoaderFactory.class, null));
      processor.processPropertySource(new PropertySourceDescriptor(List.of("classpath:/news.yml"), false, null, YamlPropertyLoaderFactory.class, null));
    } catch (IOException ex) {
      throw new UncheckedIOException(ex);
    }
  }

  /**
   * Add ImportAwareBeanPostProcessor to support ImportAware beans.
   */
  private void addImportAwareBeanPostProcessors(DefaultListableBeanFactory beanFactory) {
    Map<String, String> mappings = new HashMap<>();
    mappings.put("org.springframework.scheduling.annotation.ProxyAsyncConfiguration", "mg.AppConfig");
    mappings.put("org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration", "mg.AppConfig");
    mappings.put("org.springframework.transaction.annotation.ProxyTransactionManagementConfiguration", "mg.JpaConfig");
    RootBeanDefinition beanDefinition = new RootBeanDefinition(ImportAwareAotBeanPostProcessor.class);
    beanDefinition.setRole(BeanDefinition.ROLE_INFRASTRUCTURE);
    beanDefinition.setInstanceSupplier(() -> new ImportAwareAotBeanPostProcessor(mappings));
    beanFactory.registerBeanDefinition("org.springframework.context.annotation.internalImportAwareAotProcessor", beanDefinition);
  }
}
