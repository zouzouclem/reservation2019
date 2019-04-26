package be.icc.reservation.service;


import be.icc.reservation.entity.Users;

public interface UserService {
    Users findByEmail(String email);
    Users save(Users user);
    Users findById(int id);

    Users signUp(Users user);
    Users findByLoginAndPassword(String login, String password);
}
