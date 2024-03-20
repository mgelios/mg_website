package mg.news.mapper;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.AutowiredFieldValueResolver;
import org.springframework.beans.factory.support.RegisteredBean;

/**
 * Autowiring for {@link RadiotPodcastMapperImpl}.
 */
@Generated
public class RadiotPodcastMapperImpl__Autowiring {
  /**
   * Apply the autowiring.
   */
  public static RadiotPodcastMapperImpl apply(RegisteredBean registeredBean,
      RadiotPodcastMapperImpl instance) {
    AutowiredFieldValueResolver.forRequiredField("radiotPodcastTimeLabelMapper").resolveAndSet(registeredBean, instance);
    return instance;
  }
}
