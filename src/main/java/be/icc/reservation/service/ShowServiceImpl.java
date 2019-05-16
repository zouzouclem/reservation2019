package be.icc.reservation.service;

import be.icc.reservation.entity.Shows;
import be.icc.reservation.repository.ShowRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class ShowServiceImpl implements ShowService {

    @Autowired
    ShowRepository showRepository;

    public Page<Shows> findAllShows(Pageable pageable) {
        return showRepository.findAll(pageable);
    }

    @Override
    public Shows saveShow(Shows show) {
        return showRepository.save(show);
    }

    @Override
    public void deleteShow(Shows show) {
        showRepository.delete(show);
    }

    @Override
    public Shows findById(int id) {
        return showRepository.findById(id);
    }

    @Override
    public Shows updateShow(Shows show) { return showRepository.save(show); }
}