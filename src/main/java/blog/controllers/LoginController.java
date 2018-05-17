package blog.controllers;

import blog.forms.LoginForm;
import blog.services.INotificationService;
import blog.services.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
public class LoginController {

    @Autowired
    private IUserService userService;

    @Autowired
    private INotificationService notifyService;

    @RequestMapping(value = "/users/login")
    public String login(LoginForm loginForm){
        return "users/login";
    }

    @RequestMapping(value = "/users/login", method = RequestMethod.POST)
    public String loginPage(@Valid LoginForm loginForm, BindingResult bindingResult){

        if(bindingResult.hasErrors()){
            notifyService.addErrorMessage("You have 30 seconds to fill this form correctly...\n on second thought, take your time");
            return "users/login";
        }

        if(!userService.authenticate(loginForm.getUsername(),loginForm.getPassword())){
            notifyService.addErrorMessage("This login is not in the system!");
            return  "users/login";
        }

        notifyService.addAllGoodMessage("Great job, Login successful");
        return "redirect:/";

    }

}
