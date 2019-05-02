package be.icc.reservation.controller;

import be.icc.reservation.entity.Locations;
import be.icc.reservation.entity.Shows;
import be.icc.reservation.entity.Users;
import be.icc.reservation.form.ShowForm;
import be.icc.reservation.form.SignupForm;
import be.icc.reservation.service.LocationsService;
import org.springframework.beans.factory.annotation.Autowired;
import be.icc.reservation.service.ShowService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.math.BigDecimal;


@Controller
public class ShowController
{
    @Autowired
    ShowService showService;
    @Autowired
    LocationsService locationsService;

    @RequestMapping(value = "/show")
    public String home()
    {
        return "show/showList";
    }

    @RequestMapping(value = "/show/add")
    public String addSpectacle(Model model)
    {
        model.addAttribute("showForm", new ShowForm());
        model.addAttribute("locationsList", locationsService.findAllLocations());
        return "show/addShow";
    }

    @RequestMapping(value = "show/show/add", method = RequestMethod.POST)
    public String addShowDB(@ModelAttribute("showForm") @Valid ShowForm showForm, BindingResult result,
                         RedirectAttributes attr, Model model) {
        /*if (result.hasErrors()) {
            attr.addFlashAttribute("org.springframework.validation.BindingResult.showForm", result);
            attr.addFlashAttribute("showForm", showForm);
            return "redirect:/show/addShow";
        }*/

        Shows s = new Shows();
        s.setSlug(showForm.getSlug());
        Locations loc = locationsService.findLocationsById(showForm.getLocation());
        s.setLocationId(loc);
        s.setBookable(showForm.isBookable()? Byte.parseByte("1") : 0 );
        s.setPosterUrl(showForm.getPosterURL());
        s.setPrice(BigDecimal.valueOf(showForm.getPrice()));
        s.setTitle(showForm.getTitle());
        showService.saveShow(s);
        return "redirect:/show";
    }

    @RequestMapping(value = "/show/update")
    public String updateSpectacle()
    {
        return "show/updateShow";
    }
}