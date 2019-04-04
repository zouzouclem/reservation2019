package be.icc.reservation.service;


import be.icc.reservation.entity.Representations;

import java.util.List;

public interface RepresentationService {
    List<Representations> findAllRepresentations();
    Representations saveRepresentation(Representations rep);
    void deleteRepresentation(Representations rep_id);
}