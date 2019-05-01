package be.icc.reservation.controller;


import be.icc.reservation.entity.Shows;
import be.icc.reservation.service.ShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.Collection;
import java.util.List;
import java.util.Map;


@Controller
public class ShowController {

    @Autowired
    ShowService showService;

    @RequestMapping(value = "/show")
    public String home(Model model) {
        List<Shows> showsList = showService.findAllShows();
        model.addAttribute("showList", showsList);
        return "show/showList";
    }

    @RequestMapping(value = "/show/add")
    public String addSpectacle() {
        return "show/addShow";
    }

    @RequestMapping(value = "/show/update")
    public String updateSpectacle() {
        return "show/updateShow";
    }



}
