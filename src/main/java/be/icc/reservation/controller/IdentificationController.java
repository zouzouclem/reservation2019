package be.icc.reservation.controller;


import be.icc.reservation.entity.Users;
import be.icc.reservation.form.LoginForm;
import be.icc.reservation.form.SignupForm;
import be.icc.reservation.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import java.security.Principal;

import static org.apache.logging.log4j.util.Strings.isNotBlank;


/**
 * Created by Scohier Dorian on 19-04-19.
 */
@Controller
@RequestMapping("connect")
public class IdentificationController {

    @Autowired
    UserService userService;

    @RequestMapping("")
    public String connect(Model model, @RequestParam(required = false) String error, @RequestParam(required = false) String success) {
        if (isNotBlank(success)) {
            model.addAttribute("success", "success.userCreated");
        }
        if (!model.containsAttribute("loginForm")) {
            model.addAttribute("loginForm", new LoginForm());
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

        boolean isUsernameUnique = userService.findByLogin(signupForm.getLogin()) == null;
        if (!isUsernameUnique) {
            attr.addFlashAttribute("org.springframework.validation.BindingResult.signupForm", result);
            attr.addFlashAttribute("signupForm", signupForm);
            attr.addFlashAttribute("error", "Le login doit-être unique");
            return "redirect:/connect";
        }

        boolean isMailUnique = userService.findByEmail(signupForm.getEmail()) == null;
        if (!isMailUnique) {
            attr.addFlashAttribute("org.springframework.validation.BindingResult.signupForm", result);
            attr.addFlashAttribute("signupForm", signupForm);
            attr.addFlashAttribute("error", "Cette adresse mail est déja liée à un compte");
            return "redirect:/connect";
        }

        Users user = new Users();
        user.setLogin(signupForm.getLogin());
        user.setLastname(signupForm.getLastName());
        user.setLangue(signupForm.getLangue());
        user.setFirstname(signupForm.getFirstName());
        user.setEmail(signupForm.getEmail());
        user.setPassword(signupForm.getPassword());
        userService.signUp(user);
        return "redirect:/connect?success=userCreated";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(@ModelAttribute("loginForm") @Valid LoginForm loginForm, BindingResult result,
                        RedirectAttributes attr) {
        if (result.hasErrors()) {
            attr.addFlashAttribute("org.springframework.validation.BindingResult.loginForm", result);
            attr.addFlashAttribute("loginForm", loginForm);
            return "connect";
        }

        Users user = userService.findByLoginAndPassword(loginForm.getUserName(), loginForm.getPassword());

        if (user == null) {
            return "redirect:/connect?error=wrong";
        } else {
            UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());
            SecurityContextHolder.getContext().setAuthentication(token);
        }
        return "redirect:/";
    }

    @RequestMapping("/modifyProfil")
    public String modifyProfil(@ModelAttribute("signupForm") SignupForm updateSignupForm, Model model, @RequestParam(required = false) String error) {
        if ("anonymousUser".equals(SecurityContextHolder.getContext().getAuthentication().getPrincipal())) {
            return "redirect:/connect";
        }
        Users user = (Users)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (!model.containsAttribute("signupForm") || updateSignupForm != null) {
            SignupForm signupForm = new SignupForm();
            signupForm.setId(user.getId());
            signupForm.setEmail(user.getEmail());
            signupForm.setFirstName(user.getFirstname());
            signupForm.setLangue(user.getLangue());
            signupForm.setLastName(user.getLastname());
            signupForm.setLogin(user.getLogin());
            model.addAttribute("signupForm", signupForm);
        }
        return "connect";
    }

    @RequestMapping("/update")
    public String update(@ModelAttribute("signupForm") @Valid SignupForm signupForm, BindingResult result,
                         RedirectAttributes attr) {
        if (result.hasErrors()) {
            attr.addFlashAttribute("org.springframework.validation.BindingResult.loginForm", result);
            attr.addFlashAttribute("signupForm", signupForm);
            return "connect";
        }
        Users user = userService.findById(signupForm.getId());
        user.setEmail(signupForm.getEmail());
        user.setFirstname(signupForm.getFirstName());
        user.setLastname(signupForm.getLastName());
        user.setLangue(signupForm.getLangue());
        BCryptPasswordEncoder encoder= new BCryptPasswordEncoder();
        String hashedPassword= encoder.encode(signupForm.getPassword());
        user.setPassword(hashedPassword);
        userService.update(user);
        return "redirect:/";
    }
}