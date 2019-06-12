package be.icc.reservation.repository;

import be.icc.reservation.entity.Representations;
import be.icc.reservation.entity.Shows;
import be.icc.reservation.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public interface RepresentationRepository extends JpaRepository<Representations, Integer>{

    Representations findById(int id);
    ArrayList<Representations> findByShow(Shows s);

}
