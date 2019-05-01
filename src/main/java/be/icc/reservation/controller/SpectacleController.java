package be.icc.reservation.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class SpectacleController {

    @RequestMapping(value = "/spectacle")
    public String home() {
        return "spectacle/spectacleList";
    }

    @RequestMapping(value = "/spectacle/add")
    public String addSpectacle() {
        return "spectacle/ajoutSpectacle";
    }

    @RequestMapping(value = "/spectacle/update")
    public String updateSpectacle() {
        return "spectacle/modifSpectacle";
    }

}
