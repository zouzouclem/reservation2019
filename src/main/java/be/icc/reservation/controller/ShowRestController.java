package be.icc.reservation.controller;

import be.icc.reservation.entity.Shows;
import be.icc.reservation.service.ShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
class ShowRestController {

   @Autowired
   ShowService showService;


    @GetMapping("/allShows")
    List<Shows> allShows() {
        return showService.findAll();
    }}
