package andersen.practice.docverifier.service.impl;

import andersen.practice.docverifier.domain.user.User;
import andersen.practice.docverifier.domain.user.UserRole;
import andersen.practice.docverifier.domain.user.UserStatus;
import andersen.practice.docverifier.repository.user.RoleRepository;
import andersen.practice.docverifier.repository.user.StatusRepository;
import andersen.practice.docverifier.repository.user.UserRepository;
import andersen.practice.docverifier.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private final RoleRepository roleRepository;

    private final StatusRepository statusRepository;

    private final BCryptPasswordEncoder passwordEncoder;

    @Autowired
    public UserServiceImpl(UserRepository userRepository,
                           RoleRepository roleRepository,
                           StatusRepository statusRepository,
                           BCryptPasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.statusRepository = statusRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public User register(User user) {
        UserRole role = roleRepository.findByCode("USER");
        UserStatus status = statusRepository.findByCode("ACTIVE");
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRole(role);
        user.setStatus(status);

        return userRepository.save(user);
    }

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public Optional<User> findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public Optional<User> findById(String id) {
        return userRepository.findById(id);
    }

    @Override
    public void delete(String id) {
        userRepository.deleteById(id);
    }
}
