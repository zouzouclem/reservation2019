package be.icc.reservation.controller;

import be.icc.reservation.entity.Locations;
import be.icc.reservation.entity.Shows;
import be.icc.reservation.entity.Users;
import be.icc.reservation.form.FileForm;
import be.icc.reservation.form.ShowForm;
import be.icc.reservation.service.LocationsService;
import be.icc.reservation.service.ShowService;
import be.icc.reservation.utils.CSVExporter;
import be.icc.reservation.utils.CSVImporter;
import be.icc.reservation.utils.RSSExporter;
import be.icc.reservation.utils.RSSImporter;
import be.icc.reservation.utils.CSVExporter;
import be.icc.reservation.utils.CSVImporter;
import be.icc.reservation.utils.RSSExporter;
import be.icc.reservation.utils.RSSImporter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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
import java.math.BigDecimal;
import java.util.LinkedHashMap;
import java.util.Map;


@Controller
public class ShowController {

    @Autowired
    private ShowService showService;
    @Autowired
    private LocationsService locationsService;

    @ModelAttribute("styleColor")
    public String getStyleColor(HttpServletRequest request) {
        return (String) request.getSession().getAttribute("styleColor");
    }

    @RequestMapping(value = "/show")
    public String home(Model model) {
        Pageable sortedByName = PageRequest.of(0, 20, Sort.by("title"));
        Page<Shows> showsList = showService.findAllShows(sortedByName);
        model.addAttribute("showList", showsList.getContent());
        return "show/showList";
    }

    @RequestMapping(value = "/show/importCSV", method = RequestMethod.GET)
    public String showImportCSV(Model model) {
        model.addAttribute("fileForm", new FileForm());
        return "show/importCSV";
    }

    @RequestMapping(value = "/show/importCSV", method = RequestMethod.POST)
    public String importCSV(@ModelAttribute("fileForm") @Valid FileForm fileForm, BindingResult result,
                            RedirectAttributes attr, Model model) {
        if (result.hasErrors()) {
            attr.addFlashAttribute("org.springframework.validation.BindingResult.fileForm", result);
            attr.addFlashAttribute("fileForm", fileForm);
            return "show/importCSV";
        }

        String fileUrl = fileForm.getFile().getAbsolutePath()
                .replace("\\reservation2019", ""); //cheat
        CSVImporter.importShows(fileUrl);
        model.addAttribute("success", "success.shows.showsAdded");
        return "redirect:/show";
    }

    @RequestMapping(value = "/show/exportCSV", method = RequestMethod.GET)
    public String exportCSV(Model model) {
        CSVExporter.exportShows();
        return "show/exportCSV";
    }

    @RequestMapping(value = "/show/importRSS", method = RequestMethod.GET)
    public String showImportRSS(Model model) {
        model.addAttribute("fileForm", new FileForm());
        return "show/importRSS";
    }

    @RequestMapping(value = "/show/importRSS", method = RequestMethod.POST)
    public String importRSS(@ModelAttribute("fileForm") @Valid FileForm fileForm, BindingResult result,
                            RedirectAttributes attr, Model model) {
        if (result.hasErrors()) {
            attr.addFlashAttribute("org.springframework.validation.BindingResult.fileForm", result);
            attr.addFlashAttribute("fileForm", fileForm);
            return "show/importRSS";
        }

        String fileUrl = fileForm.getFile().getAbsolutePath()
                .replace("\\reservation2019", ""); //cheat
        RSSImporter.importShows(fileUrl);
        model.addAttribute("success", "success.shows.showsAdded");
        return "redirect:/show";
    }

    @RequestMapping(value = "/show/exportRSS")
    public String exportRSS(Model model) {
        RSSExporter.exportShows();
        return "show/exportRSS";
    }

    @RequestMapping(value = "/show/add")
    public String addSpectacle(Model model) {
        model.addAttribute("showForm", new ShowForm());
        Map<String, String> locationList = new LinkedHashMap<>();
        for (Locations location : locationsService.findAllLocations()) {
            locationList.put(String.valueOf(location.getId()), location.getCompleteAddress());
        }
        model.addAttribute("locationsList", locationList);
        Users loggedIn = (Users) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        boolean isAdmin = loggedIn != null || loggedIn.getRole().getRole()
                .equalsIgnoreCase("ROLE_ADMIN");
        model.addAttribute("isAdmin", isAdmin);
        return "show/addShow";
    }

    @RequestMapping(value = "/show/add", method = RequestMethod.POST)
    public String addShowDB(@ModelAttribute("showForm") @Valid ShowForm showForm, BindingResult result,
                            RedirectAttributes attr, Model model) {
        if (result.hasErrors()) {
            attr.addFlashAttribute("org.springframework.validation.BindingResult.showForm", result);
            attr.addFlashAttribute("showForm", showForm);
            Map<String, String> locationList = new LinkedHashMap<String, String>();
            for (Locations location : locationsService.findAllLocations()) {
                locationList.put(String.valueOf(location.getId()), location.getCompleteAddress());
            }
            model.addAttribute("locationsList", locationList);
            return "show/addShow";
        }

        Shows s = convertShowFormInShows(null, showForm);
        showService.saveShow(s);
        model.addAttribute("success", "success.shows.showsAdded");
        return "redirect:/show";
    }

    private Shows convertShowFormInShows(Shows s, ShowForm showForm) {
        if (s == null) {
            s = new Shows();
        }
        s.setSlug(showForm.getSlug());
        Locations loc = locationsService.findLocationsById(showForm.getLocation());
        s.setLocation(loc);
        s.setBookable(showForm.isBookable());
        s.setPosterUrl(showForm.getPosterURL());
        s.setPrice(showForm.getPrice());
        s.setTitle(showForm.getTitle());
        return s;
    }

    @RequestMapping(value = "/show/update/{id}")
    public String modifyShow(Model model, @PathVariable int id) {
        Shows sho = showService.findById(id);
        ShowForm showForm = new ShowForm();
        showForm.setId(sho.getId());
        showForm.setSlug(sho.getSlug());
        showForm.setTitle(sho.getTitle());
        showForm.setPosterURL(sho.getPosterUrl());
        showForm.setLocation(sho.getLocation().getId());
        showForm.setBookable(sho.isBookable());
        showForm.setPrice(sho.getPrice());
        model.addAttribute("showForm", showForm);

        Map<String, String> locationList = new LinkedHashMap<>();
        for (Locations location : locationsService.findAllLocations()) {
            locationList.put(String.valueOf(location.getId()), location.getCompleteAddress());
        }

        model.addAttribute("locationsList", locationList);
        return "show/updateShow";
    }

    @RequestMapping(value = "/show/update", method = RequestMethod.POST)
    public String updateSpectacleDB(@ModelAttribute("showForm") @Valid ShowForm showForm, BindingResult result,
                                    RedirectAttributes attr, Model model) {
        if (result.hasErrors()) {
            attr.addFlashAttribute("org.springframework.validation.BindingResult.showForm", result);
            attr.addFlashAttribute("showForm", showForm);
            return "redirect:/show/updateShow";
        }

        Shows s = showService.findById(showForm.getId());
        s = convertShowFormInShows(s, showForm);
        showService.updateShow(s);
        model.addAttribute("success", "success.shows.showsUpdated");
        return "redirect:/show/";
    }


    @RequestMapping(value = "/show/showDetail/{id}")
    public String showDetail(Model model, @PathVariable int id) {

        Shows show = showService.findById(id);
        model.addAttribute("show", show);
        return "show/showDetail";
    }

    @RequestMapping(value = "/show/delete/{id}")
    public String delete(Model model, @PathVariable int id) {

        showService.deleteShow(showService.findById(id));
        return "redirect:/show";
    }

    private void setIsAdminBoolean(Model model) {
        if (SecurityContextHolder.getContext().getAuthentication().getPrincipal() instanceof Users) {
            Users loggedIn = (Users) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            boolean isAdmin = loggedIn != null || loggedIn.getRole().getRole()
                    .equalsIgnoreCase("ROLE_ADMIN");
            model.addAttribute("isAdmin", isAdmin);
        } else {
            model.addAttribute("isAdmin", false);
        }
    }
}
