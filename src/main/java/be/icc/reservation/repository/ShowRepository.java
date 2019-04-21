package be.icc.reservation.repository;

import be.icc.reservation.entity.Shows;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShowRepository extends JpaRepository <Shows, Integer> {



}

