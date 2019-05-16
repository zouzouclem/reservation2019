package be.icc.reservation.service;

import be.icc.reservation.entity.Locations;
import be.icc.reservation.repository.LocationsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class LocationsServiceImpl implements LocationsService {

    @Autowired
    private LocationsRepository locationsRepository;

    @Override
    public List<Locations> findAllLocations() {
        return locationsRepository.findAll();
    }

    @Override
    public Locations findLocationsById(int idLoc) {
        return locationsRepository.findById(idLoc);
    }

    @Override
    public Locations findById(Integer id) {
        return locationsRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Locations newLocation) {
        locationsRepository.save(newLocation);
    }
}