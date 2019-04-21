package be.icc.reservation.repository;

import be.icc.reservation.entity.Roles;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Scohier Dorian on 21-04-19.
 */
public interface RolesRepository extends CrudRepository<Roles,Long> {

    Roles findByRole(String role);

}
