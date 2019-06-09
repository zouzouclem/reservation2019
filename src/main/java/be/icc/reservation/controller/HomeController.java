package be.icc.reservation.controller;


import be.icc.reservation.service.RolesService;
import be.icc.reservation.service.ShowService;
import be.icc.reservation.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;


@Controller
public class HomeController {

    @Autowired
    RolesService rolesService;
    @Autowired
    UserService userService;
    @Autowired
    ShowService showService;

    @ModelAttribute("styleColor")
    public String getStyleColor(HttpServletRequest request) {
        return (String) request.getSession().getAttribute("styleColor");
    }

    @RequestMapping(value = "/")
    public String home(HttpServletRequest request) {
        if ((String) request.getSession().getAttribute("styleColor") == null) {
            request.getSession().setAttribute("styleColor", "defaut");
        }
        return "index";
    }

    @RequestMapping(value = "/accessDenied")
    public String accessDenied() {
        return "accessDenied";
    }

}
