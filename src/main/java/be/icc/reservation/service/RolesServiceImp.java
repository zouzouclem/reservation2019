package be.icc.reservation.service;

import be.icc.reservation.entity.Roles;
import be.icc.reservation.repository.RolesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Scohier Dorian on 21-04-19.
 */
@Service
@Transactional
public class RolesServiceImp implements RolesService {

    @Autowired
    RolesRepository rolesRepository;

    @Override
    public Roles createOrgetIfExists(String role) {
        Roles foundRole = rolesRepository.findByRole(role);
        if(foundRole==null){
            Roles createRoles= new Roles();
            createRoles.setRole(role);
            return rolesRepository.save(createRoles);
        }else {
            return foundRole;
        }
    }
}
