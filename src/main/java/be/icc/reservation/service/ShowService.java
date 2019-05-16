package be.icc.reservation.service;


import be.icc.reservation.entity.Shows;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ShowService {

    Page<Shows> findAllShows(Pageable pageable);
    Shows saveShow(Shows show);
    void deleteShow(Shows show);
    Shows findById(int id);
    Shows updateShow(Shows show);
}
