package be.icc.reservation.service;

import be.icc.reservation.entity.*;
import be.icc.reservation.repository.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

import javax.transaction.*;
import java.util.*;

@Service
@Transactional
public class RepresentationServiceImpl implements RepresentationService {
    @Autowired
    RepresentationRepository representationRepository;
    @Autowired
    UserRepository userRepository;

    @Override
    public List<Representations> findAllRepresentations()
    {
        return representationRepository.findAll();
    }

    @Override
    public Representations findById(int id) {
        return representationRepository.findById(id);
    }

    @Override
    public Representations saveRepresentation(Representations rep)
    {
        return representationRepository.save(rep);
    }

    @Override
    public void deleteRepresentation(Representations rep_id){ representationRepository.delete(rep_id); }

    @Override
    public ArrayList<Representations> findRepresentationsByShow(Shows shows) {
        return representationRepository.findByShow(shows);
    }


}