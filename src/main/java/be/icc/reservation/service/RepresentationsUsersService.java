package be.icc.reservation.service;

import be.icc.reservation.entity.RepresentationsUsers;

import java.util.Set;

public interface RepresentationsUsersService {

    Set<RepresentationsUsers> findByUser(int userId);

    RepresentationsUsers save(RepresentationsUsers representationsUsers);
}
