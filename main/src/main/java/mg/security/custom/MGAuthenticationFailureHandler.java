package mg.security.custom;

import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.stereotype.Component;

@Component
public class MGAuthenticationFailureHandler extends SimpleUrlAuthenticationFailureHandler {
}
