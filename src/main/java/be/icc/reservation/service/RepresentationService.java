package be.icc.reservation.service;


import be.icc.reservation.entity.Representations;
import be.icc.reservation.entity.Shows;

import java.util.ArrayList;
import java.util.List;

public interface RepresentationService {

    List<Representations> findAllRepresentations();
    Representations findById(int id);
    Representations saveRepresentation(Representations rep);
    void deleteRepresentation(Representations rep_id);
    ArrayList<Representations> findRepresentationsByShow(Shows shows);

}