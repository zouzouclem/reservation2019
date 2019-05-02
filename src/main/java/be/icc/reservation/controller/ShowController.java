package be.icc.reservation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import be.icc.reservation.service.ShowService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


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
}