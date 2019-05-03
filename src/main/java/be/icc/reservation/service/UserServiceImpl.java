package be.icc.reservation.service;

import be.icc.reservation.entity.Roles;
import be.icc.reservation.entity.Users;
import be.icc.reservation.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RolesService rolesService;

    @Override
    public Users findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public Users save(Users user) {
        return userRepository.save(user);
    }

    @Override
    public Users findById(int id) {
        return userRepository.findById(id);
    }

    @Override
    public Users signUp(Users user) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String hashedPassword = encoder.encode(user.getPassword());
        user.setPassword(hashedPassword);
        Roles role = rolesService.createOrgetIfExists("ROLE_USER");
        user.setRole(role);
        user = userRepository.save(user);
        return user;
    }

    @Override
    public Users findByLoginAndPassword(String login, String password) {

        Users user = userRepository.findByLogin(login);

        if (user == null) {
            return null;
        }

        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        boolean passwordsMatch = encoder.matches(password, user.getPassword());

        if (!passwordsMatch) {
            return null;
        }

        return user;
    }

    @Override
    public Users findByLogin(String login) {

        Users user = userRepository.findByLogin(login);
        return user;
    }

    @Override
    public Users update(Users user) {
        return userRepository.save(user);
    }
}
