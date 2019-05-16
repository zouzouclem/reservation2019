package be.icc.reservation.repository;

import be.icc.reservation.entity.Locations;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocationsRepository extends JpaRepository<Locations, Integer> {

    Locations findById(int id);
}