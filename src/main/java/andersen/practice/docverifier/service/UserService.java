package andersen.practice.docverifier.service;

import andersen.practice.docverifier.domain.user.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    User register(User user);

    List<User> getAll();

    Optional<User> findByUsername(String username);

    Optional<User> findById(String id);

    void delete(String id);

}
