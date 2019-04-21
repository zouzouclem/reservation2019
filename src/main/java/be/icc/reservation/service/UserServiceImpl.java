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
    UserRepository userRepository;
    @Autowired
    RolesService rolesService;

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
        user.setRoleId(role.getId());
        Users userDto = userRepository.save(user);
        return userDto;
    }
}
