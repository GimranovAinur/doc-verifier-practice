package andersen.practice.docverifier.security;

import andersen.practice.docverifier.domain.user.User;
import andersen.practice.docverifier.security.jwt.JwtUserConverter;
import andersen.practice.docverifier.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class JwtUserDetailsService implements UserDetailsService {

    private final UserService userService;

    @Autowired
    public JwtUserDetailsService(UserService userService) {
        this.userService = userService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userService.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException(
                                "Пользователя с именем " + username + "не существует"));

        return JwtUserConverter.convert(user);
    }
}
