package andersen.practice.docverifier.security.jwt;

import andersen.practice.docverifier.domain.user.User;
import andersen.practice.docverifier.domain.user.UserRole;
import andersen.practice.docverifier.security.JwtUserDetails;
import lombok.experimental.UtilityClass;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

@UtilityClass
public class JwtUserConverter {

    public JwtUserDetails convert(User user) {
        return JwtUserDetails.builder()
                .id(user.getId())
                .username(user.getUsername())
                .password(user.getPassword())
                .status(user.getStatus())
                .authority(convertAuthority(user.getRole()))
                .build();
    }

    private static GrantedAuthority convertAuthority(UserRole role) {
        return new SimpleGrantedAuthority(role.getCode());
    }

}
