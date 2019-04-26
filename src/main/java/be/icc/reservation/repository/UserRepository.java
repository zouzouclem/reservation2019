package be.icc.reservation.repository;

import be.icc.reservation.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends JpaRepository<Users, Integer> {
    Users findByEmail(String email);
    Users findById(int id);
    Users findByLogin(String login);
}
