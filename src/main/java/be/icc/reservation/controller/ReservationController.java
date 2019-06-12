package be.icc.reservation.controller;

import be.icc.reservation.entity.Locations;
import be.icc.reservation.entity.Representations;
import be.icc.reservation.entity.RepresentationsUsers;
import be.icc.reservation.entity.Users;
import be.icc.reservation.form.PlaceForm;
import be.icc.reservation.form.RepresentationForm;
import be.icc.reservation.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;


@Controller
public class ReservationController {

    @Autowired
    RepresentationService representationService;
    @Autowired
    LocationsService locationsService;
    @Autowired
    ShowService showService;
    @Autowired
    UserService userService;
    @Autowired
    RepresentationsUsersService representationsUsersService;

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

        Set<RepresentationsUsers> representationsUsersSet = representationsUsersService.findByUser(user.getId());
        model.addAttribute("Reservations", representationsUsersSet);
        return "reservationList";
    }

    @RequestMapping(value = "/admin/representation/add/{idShow}")
    public String addRepresentation(Model model, @PathVariable("idShow") int showId) {
        RepresentationForm form = new RepresentationForm();
        form.setShow(showId);
        model.addAttribute("representationForm", form);
        Map<String, String> locationList = new LinkedHashMap<String, String>();
        for (Locations location : locationsService.findAllLocations()) {
            locationList.put(String.valueOf(location.getId()), location.getCompleteAddress());
        }
        model.addAttribute("locationsList", locationList);
        return "admin/addRepresentation";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/admin/representation/save")
    public String saveRepresentation(@ModelAttribute("representationForm") @Valid RepresentationForm representationForm, BindingResult result, RedirectAttributes attr, Model model) {
        if (result.hasErrors()) {
            attr.addFlashAttribute("org.springframework.validation.BindingResult.showForm", result);
            attr.addFlashAttribute("representationForm", representationForm);
            Map<String, String> locationList = new LinkedHashMap<String, String>();
            for (Locations location : locationsService.findAllLocations()) {
                locationList.put(String.valueOf(location.getId()), location.getCompleteAddress());
            }
            model.addAttribute("locationsList", locationList);
            return "admin/addRepresentation";
        }
        Representations representation = new Representations();
        representation.setLocation(locationsService.findLocationsById(representationForm.getLocation()));
        int hour = Integer.parseInt(representationForm.getWhenTime().substring(0, 2));
        int minute = Integer.parseInt(representationForm.getWhenTime().substring(3, 5));
        Calendar date = Calendar.getInstance();
        date.setTime(representationForm.getWhenDate());
        date.set(Calendar.HOUR, hour);
        date.set(Calendar.MINUTE, minute);
        Timestamp time = new Timestamp(date.getTime().getTime());
        representation.setWhenDate(time);
        representation.setShow(showService.findById(representationForm.getShow()));
        representationService.saveRepresentation(representation);
        return "redirect:/show/showDetail/" + representationForm.getShow();
    }

    @RequestMapping(value = "/reservation/booking/{representationId}")
    public String bookShow(Model model, @PathVariable("representationId") int representationId, @ModelAttribute("placeForm") @Valid PlaceForm placeForm) {

        if ("anonymousUser".equals(SecurityContextHolder.getContext().getAuthentication().getPrincipal())) {
            return "redirect:/connect";
        }
        Users user = (Users) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Representations representation = representationService.findById(representationId);
        RepresentationsUsers representationsUsers = new RepresentationsUsers();
        representationsUsers.setRepresentation(representation);
        representationsUsers.setUser(user);
        representationsUsers.setPlaces(placeForm.getPlace());
        representation.setRepresentationsUsers(Stream.of(representationsUsers).collect(Collectors.toSet()));
        user.setRepresentationsUsers(Stream.of(representationsUsers).collect(Collectors.toSet()));
        representationService.saveRepresentation(representation);
        userService.save(user);
        representationsUsersService.save(representationsUsers);
        return "redirect:/reservation";
    }
}
