package be.icc.reservation.repository;

import be.icc.reservation.entity.RepresentationsUsers;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface RepresentationsUsersRepository extends JpaRepository<RepresentationsUsers, Integer> {

    Set<RepresentationsUsers> findByUserId(int userId);
}
