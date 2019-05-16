package be.icc.reservation.controller;

import be.icc.reservation.entity.Locations;
import be.icc.reservation.entity.Shows;
import be.icc.reservation.entity.Users;
import be.icc.reservation.form.ShowForm;
import be.icc.reservation.form.SignupForm;
import be.icc.reservation.service.LocationsService;
import be.icc.reservation.entity.Shows;
import be.icc.reservation.service.ShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.math.BigDecimal;

import java.util.List;


@Controller
public class ShowController {

    @Autowired
    private ShowService showService;
    @Autowired
    private LocationsService locationsService;

    @RequestMapping(value = "/show")
    public String home(Model model) {
        List<Shows> showsList = showService.findAllShows();
        model.addAttribute("showList", showsList);
        return "show/showList";
    }

    @RequestMapping(value = "/show/add")
    public String addSpectacle(Model model) {
        model.addAttribute("showForm", new ShowForm());
        model.addAttribute("locationsList", locationsService.findAllLocations());
        return "show/addShow";
    }

    @RequestMapping(value = "/show/add", method = RequestMethod.POST)
    public String addShowDB(@ModelAttribute("showForm") @Valid ShowForm showForm, BindingResult result,
                         RedirectAttributes attr, Model model) {
        if (result.hasErrors()) {
            attr.addFlashAttribute("org.springframework.validation.BindingResult.showForm", result);
            attr.addFlashAttribute("showForm", showForm);
            return "show/addShow";
        }

        Shows s = new Shows();
        s.setSlug(showForm.getSlug());
        Locations loc = locationsService.findLocationsById(showForm.getLocation());
        s.setLocationId(loc);
        s.setBookable(showForm.isBookable());
        s.setPosterUrl(showForm.getPosterURL());
        s.setPrice(showForm.getPrice());
        s.setTitle(showForm.getTitle());
        showService.saveShow(s);
        return "redirect:/show";
    }

    @RequestMapping(value = "/show/update/{id}")
    public String updateSpectacle(Model model, @PathVariable int id)
    {
        Shows sho = showService.findById(id);
        ShowForm showForm = new ShowForm();
        showForm.setId(sho.getId());
        showForm.setSlug(sho.getSlug());
        showForm.setTitle(sho.getTitle());
        showForm.setPosterURL(sho.getPosterUrl());
        showForm.setLocation(sho.getLocationId().getId());
        showForm.setBookable(sho.isBookable());
        showForm.setPrice((BigDecimal)sho.getPrice());
        model.addAttribute("showForm", showForm);
        model.addAttribute("locationsList", locationsService.findAllLocations());
        return "show/updateShow";
    }

    @RequestMapping(value = "/show/update", method = RequestMethod.POST)
    public String updateSpectacleDB(@ModelAttribute("showForm") @Valid ShowForm showForm, BindingResult result,
                                  RedirectAttributes attr)
    {
        if(result.hasErrors())
        {
            attr.addFlashAttribute("org.springframework.validation.BindingResult.showForm", result);
            attr.addFlashAttribute("showForm", showForm);
            return "redirect:/show/updateShow";
        }

        Shows s = showService.findById(showForm.getId());
        s.setSlug(showForm.getSlug());
        Locations l = locationsService.findLocationsById(showForm.getLocation());
        s.setLocationId(l);
        s.setBookable(showForm.isBookable());
        s.setPosterUrl(showForm.getPosterURL());
        s.setPrice(showForm.getPrice());
        s.setTitle(showForm.getTitle());
        showService.updateShow(s);
        return "show/updateShow";
    }
}
