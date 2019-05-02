package be.icc.reservation.service;

import be.icc.reservation.entity.Shows;
import be.icc.reservation.repository.ShowRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ShowServiceImpl implements ShowService {

    @Autowired
    ShowRepository showRepository;

    @Override
    public List<Shows> findAllShows() {
        return showRepository.findAll();
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
}



