package blog.controllers;

import blog.forms.RegistrationForm;
import blog.services.INotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
public class RegistrationController {

    @Autowired
    private INotificationService notifyService;

    @RequestMapping(value = "/users/registration")
    public String registration(RegistrationForm registrationForm){
        return "users/registration";
    }

    @RequestMapping(value = "/users/registration", method = RequestMethod.POST)
    public String registrationPage(@Valid RegistrationForm registrationForm, BindingResult bindingResult){


        if(bindingResult.hasErrors()){
            notifyService.addErrorMessage("You are not out of the woods yet");
            return "users/registration";
        }

        if(!registrationForm.getPassword().equals(registrationForm.getConfirmPassword())){
            notifyService.addErrorMessage("Password confirmation didn't match");
            return "/users/registration";
        }
        if(registrationForm.getPassword().isEmpty()){
            notifyService.addErrorMessage("Enter the password");
            return "/users/registration";
        }
        //TODO add a user to a non existent database
        notifyService.addAllGoodMessage("Registration successful");
        return "redirect:/";
    }
}
