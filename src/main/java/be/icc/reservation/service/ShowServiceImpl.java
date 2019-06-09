package be.icc.reservation.service;

import be.icc.reservation.entity.Shows;
import be.icc.reservation.repository.ShowRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@Transactional
public class ShowServiceImpl implements ShowService {

    @Autowired
    ShowRepository showRepository;

    @Override
    public List<Shows> findAll() {
        return StreamSupport.stream(showRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }

    @Override
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
    public Shows updateShow(Shows show) {
        return showRepository.save(show);
    }

    @Override
    public Shows showDetail(int id) {
        return showRepository.findById(id);
    }


}