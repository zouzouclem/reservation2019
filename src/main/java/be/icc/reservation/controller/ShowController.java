package be.icc.reservation.controller;

import be.icc.reservation.entity.Shows;
import org.springframework.beans.factory.annotation.Autowired;
import be.icc.reservation.service.ShowService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class ShowController
{
    @Autowired
    ShowService showService;

    @RequestMapping(value = "/show")
    public String home()
    {
        return "show/showList";
    }

    @RequestMapping(value = "/show/add")
    public String addSpectacle()
    {
        return "show/addShow";
    }

    @RequestMapping(value = "/show/update")
    public String updateSpectacle()
    {
        return "show/updateShow";
    }

    @RequestMapping(value = "/show/showDetail")
    public String detail(Model model, @RequestParam(required = true)int id){

        Shows show = showService.findById(id);
        model.addAttribute("show", show);

        return "show/showDetail";
    }

}