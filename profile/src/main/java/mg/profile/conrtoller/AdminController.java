package mg.profile.conrtoller;

import lombok.AllArgsConstructor;
import mg.profile.service.UserService;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@CrossOrigin("http://localhost:3000/#/profile")
@AllArgsConstructor
public class AdminController {

    private final UserService userService;
    private final AuthenticationProvider authenticationProvider;

    @RequestMapping(value="/login", method = RequestMethod.OPTIONS)
    public void loginCheck(HttpServletRequest request, HttpServletResponse response) {
        response.setStatus(HttpServletResponse.SC_OK);
    }
}
