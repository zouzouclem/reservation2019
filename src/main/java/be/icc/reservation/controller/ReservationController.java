package be.icc.reservation.controller;

import be.icc.reservation.entity.Representations;
import be.icc.reservation.entity.Users;
import be.icc.reservation.service.RepresentationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;


@Controller
public class ReservationController {

    @Autowired
    RepresentationService representationService;

    @ModelAttribute("styleColor")
    public String getStyleColor(HttpServletRequest request) {
        return (String) request.getSession().getAttribute("styleColor");
    }

    @RequestMapping(value = "/reservation")
    public String home(Model model) {

        if ("anonymousUser".equals(SecurityContextHolder.getContext().getAuthentication().getPrincipal())) {
            return "redirect:/connect";
        }
        Users user = (Users) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        ArrayList<Representations> reservationUser = representationService.userReservations(user.getId());
        model.addAttribute("Reservations", reservationUser);
        return "reservationList";
    }
}
