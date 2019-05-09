package be.icc.reservation.service;


import be.icc.reservation.entity.Locations;

import java.util.List;

public interface LocationsService {

    List<Locations> findAllLocations();

    Locations findLocationsById(int idLoc);

    void save(Locations newLocation);
}
