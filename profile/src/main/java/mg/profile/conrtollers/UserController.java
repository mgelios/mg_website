package mg.profile.conrtollers;

import mg.profile.models.LocalUser;
import mg.profile.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping(value={"/login"}, method = RequestMethod.GET)
    public ModelAndView login(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("login");
        return modelAndView;
    }

    @RequestMapping(value={"/registration"}, method = RequestMethod.GET)
    public ModelAndView registration(){
        ModelAndView modelAndView = new ModelAndView();
        LocalUser user = new LocalUser();
        modelAndView.addObject("localUser", user);
        modelAndView.setViewName("registration");
        return modelAndView;
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public ModelAndView createNewUser(@Validated(LocalUser.FullValidation.class) LocalUser localUser, BindingResult bindingResult) {
        ModelAndView modelAndView = new ModelAndView();
        LocalUser userExists = userService.findUserByEmail(localUser.getEmail());
        if (userExists != null) {
            bindingResult
                    .rejectValue("email", "error.user",
                            "There is already a user registered with the email provided");
        }
        if (bindingResult.hasErrors()) {
            modelAndView.setViewName("user/registration");
        } else {
            userService.saveUser(localUser);
            modelAndView.addObject("successMessage", "User has been registered successfully");
            modelAndView.addObject("localUser", new LocalUser());
            modelAndView.setViewName("user/registration");

        }
        return modelAndView;
    }

    @RequestMapping(value="/list", method = RequestMethod.GET)
    public ModelAndView usersList(){
        ModelAndView modelAndView = new ModelAndView();
        List<LocalUser> users = userService.getUsersList();
        modelAndView.addObject("users", users);
        modelAndView.setViewName("user/list");
        return modelAndView;
    }

    @RequestMapping(value="/details", method = RequestMethod.GET)
    public ModelAndView userDetails(){
        ModelAndView modelAndView = new ModelAndView();
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        LocalUser localUser = userService.findUserByEmail(auth.getName());
        modelAndView.addObject("localUser", localUser);
        modelAndView.setViewName("user/details");
        return modelAndView;
    }

    //TODO: finish user update process
    @RequestMapping(value="/details", method = RequestMethod.POST)
    public ModelAndView userDetailsUpdate(@Validated(LocalUser.PartialValidation.class) LocalUser localUser,
                                          BindingResult bindingResult){
        ModelAndView modelAndView = new ModelAndView();
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        LocalUser userDublicate = userService.findUserByEmail(localUser.getEmail());
        LocalUser currentUser = userService.findUserByEmail(auth.getName());
        if (userDublicate.getId() != currentUser.getId()) {
            bindingResult
                    .rejectValue("email", "error.user",
                            "There is a user registered with the email provided");
        }
        if (bindingResult.hasErrors()) {
            modelAndView.setViewName("user/details");
        } else {
            currentUser = userService.mergeUpdatedUser(localUser, currentUser);
            modelAndView.addObject("successMessage", "User has been updated successfully");
            modelAndView.addObject("localUser", currentUser);
            modelAndView.setViewName("user/details");
        }
        return modelAndView;
    }


}
