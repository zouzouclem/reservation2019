package be.icc.reservation.service;

import be.icc.reservation.entity.RepresentationsUsers;
import be.icc.reservation.repository.RepresentationsUsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

@Service
@Transactional
public class RepresentationsUsersServiceImpl implements RepresentationsUsersService {

    @Autowired
    RepresentationsUsersRepository representationsUsersRepository;

    @Override
    public Set<RepresentationsUsers> findByUser(int userId) {
        return representationsUsersRepository.findByUserId(userId);
    }

    @Override
    public RepresentationsUsers save(RepresentationsUsers representationsUsers) {
        return representationsUsersRepository.save(representationsUsers);
    }
}
