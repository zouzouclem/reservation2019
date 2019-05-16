package be.icc.reservation.service;


import be.icc.reservation.entity.Locations;

import java.util.List;

public interface LocationsService {

    List<Locations> findAllLocations();

    Locations findLocationsById(int idLoc);

    Locations findById(Integer id);

    void save(Locations newLocation);
}
