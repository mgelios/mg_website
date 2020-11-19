package mg.profile.conrtoller;

import mg.profile.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

//TODO: istead of using static pages move controller to rest endpoints
@RestController
@RequestMapping("/user")
@CrossOrigin("http://localhost:3000")
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping(value={"/login"}, method = RequestMethod.GET)
    public ModelAndView login(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("login");
        return modelAndView;
    }
//
//    @RequestMapping(value={"/registration"}, method = RequestMethod.GET)
//    public ModelAndView registration(){
//        ModelAndView modelAndView = new ModelAndView();
//        LocalUserDto user = new LocalUserDto();
//        modelAndView.addObject("localUser", user);
//        modelAndView.setViewName("registration");
//        return modelAndView;
//    }
//
//    @RequestMapping(value = "/registration", method = RequestMethod.POST)
//    public ModelAndView createNewUser(@Validated(LocalUserDto.FullValidation.class) LocalUserDto localUser, BindingResult bindingResult) {
//        ModelAndView modelAndView = new ModelAndView();
//        LocalUserDto userExists = userService.findUserByEmail(localUser.getEmail());
//        if (userExists != null) {
//            bindingResult
//                    .rejectValue("email", "error.user",
//                            "There is already a user registered with the email provided");
//        }
//        if (bindingResult.hasErrors()) {
//            modelAndView.setViewName("user/registration");
//        } else {
//            userService.saveUser(localUser);
//            modelAndView.addObject("successMessage", "User has been registered successfully");
//            modelAndView.addObject("localUser", new LocalUserDto());
//            modelAndView.setViewName("user/registration");
//
//        }
//        return modelAndView;
//    }
//
//    @RequestMapping(value="/list", method = RequestMethod.GET)
//    public ModelAndView usersList(){
//        ModelAndView modelAndView = new ModelAndView();
//        List<LocalUserDto> users = userService.getUsersList();
//        modelAndView.addObject("users", users);
//        modelAndView.setViewName("user/list");
//        return modelAndView;
//    }
//
//    @RequestMapping(value="/details", method = RequestMethod.GET)
//    public ModelAndView userDetails(){
//        ModelAndView modelAndView = new ModelAndView();
//        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//        LocalUserDto localUser = userService.findUserByEmail(auth.getName());
//        modelAndView.addObject("localUser", localUser);
//        modelAndView.setViewName("user/details");
//        return modelAndView;
//    }
//
//    @RequestMapping(value="/details", method = RequestMethod.POST)
//    public ModelAndView userDetailsUpdate(@Validated(LocalUserDto.PartialValidation.class) LocalUserDto localUser,
//                                          BindingResult bindingResult){
//        ModelAndView modelAndView = new ModelAndView();
//        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//        LocalUserDto userDublicate = userService.findUserByEmail(localUser.getEmail());
//        LocalUserDto currentUser = userService.findUserByEmail(auth.getName());
//        if (userDublicate.getId() != currentUser.getId()) {
//            bindingResult
//                    .rejectValue("email", "error.user",
//                            "There is a user registered with the email provided");
//        }
//        if (bindingResult.hasErrors()) {
//            modelAndView.setViewName("user/details");
//        } else {
//            currentUser = userService.mergeUpdatedUser(localUser, currentUser);
//            modelAndView.addObject("successMessage", "User has been updated successfully");
//            modelAndView.addObject("localUser", currentUser);
//            modelAndView.setViewName("user/details");
//        }
//        return modelAndView;
//    }
}
