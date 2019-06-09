package be.icc.reservation.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;


@Controller
@RequestMapping("/admin")
public class AdminController {

    @ModelAttribute("styleColor")
    public String getStyleColor(HttpServletRequest request) {
        return (String) request.getSession().getAttribute("styleColor");
    }

    @RequestMapping(value = "/")
    public String home() {
        return "admin/admin";
    }

    @RequestMapping(value = "/changeColor/{color}")
    public String changeColor(HttpServletRequest request, @PathVariable("color") String color) {
        request.getSession().setAttribute("styleColor", color);
        return "redirect:/admin/";
    }


}
