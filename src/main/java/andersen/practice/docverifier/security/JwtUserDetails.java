package andersen.practice.docverifier.security;

import andersen.practice.docverifier.domain.user.UserStatus;
import lombok.Builder;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.*;

@Builder
public class JwtUserDetails implements UserDetails {

    private final String id;

    private final String username;

    private final String password;

    private final UserStatus status;

    private final boolean enabled;

    private final GrantedAuthority authority;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Arrays.asList(authority);
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return !status.getCode().equals("LOCKED");
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
