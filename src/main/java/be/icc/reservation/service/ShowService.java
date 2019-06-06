package be.icc.reservation.service;


import be.icc.reservation.entity.Shows;

import java.util.List;

public interface ShowService {

    List<Shows> findAllShows();
    Shows saveShow(Shows show);
    void deleteShow(Shows show);
    Shows findById(int id);
    Shows updateShow(Shows show);
    Shows showDetail(int id);
}
