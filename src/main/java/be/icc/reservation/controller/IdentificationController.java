package be.icc.reservation.controller;


import be.icc.reservation.entity.Users;
import be.icc.reservation.form.SignupForm;
import be.icc.reservation.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

import static org.apache.logging.log4j.util.Strings.isNotBlank;


/**
 * Created by Scohier Dorian on 19-04-19.
 */
@Controller
@RequestMapping("/connect")
public class IdentificationController {

    @Autowired
    UserService userService;

    @RequestMapping("")
    public String connect(Model model, @RequestParam(required = false) String error, @RequestParam(required = false) String success) {
        if (isNotBlank(success)) {
            model.addAttribute("success", "success.userCreated");
        }

        if (!model.containsAttribute("signupForm")) {
            model.addAttribute("signupForm", new SignupForm());
        }
        if (isNotBlank(error)) {
            model.addAttribute("error", "error.login.error");
        }
        return "connect";
    }

    @RequestMapping(value = "/signup", method = RequestMethod.POST)
    public String signup(@ModelAttribute("signupForm") @Valid SignupForm signupForm, BindingResult result,
                         RedirectAttributes attr, Model model) {
        if (result.hasErrors()) {
            attr.addFlashAttribute("org.springframework.validation.BindingResult.signupForm", result);
            attr.addFlashAttribute("signupForm", signupForm);
            return "redirect:/connect";
        }

        Users user = new Users();
        user.setLogin(signupForm.getLogin());
        user.setLastname(signupForm.getLastName());
        user.setLangue(signupForm.getLangue());
        user.setFirstname(signupForm.getFirstName());
        user.setEmail(signupForm.getEmail());
        user.setPassword(signupForm.getPassword());
        user.setRoleId();
        userService.signUp(user);
        return "redirect:/connect?success=userCreated";
    }
}