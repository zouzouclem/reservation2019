package be.icc.reservation.service;


import be.icc.reservation.entity.Roles;

/**
 * Created by Scohier Dorian on 21-04-19.
 */
public interface RolesService {

    Roles createOrgetIfExists(String role);
}
