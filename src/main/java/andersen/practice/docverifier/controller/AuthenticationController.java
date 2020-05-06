package andersen.practice.docverifier.controller;

import andersen.practice.docverifier.domain.user.User;
import andersen.practice.docverifier.dto.AuthRequest;
import andersen.practice.docverifier.security.jwt.JwtTokenProvider;
import andersen.practice.docverifier.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.*;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/auth")
public class AuthenticationController {

    private AuthenticationManager authenticationManager;

    private JwtTokenProvider tokenProvider;

    private UserService userService;

    @Autowired
    public AuthenticationController(AuthenticationManager authenticationManager,
                                    JwtTokenProvider tokenProvider,
                                    UserService userService) {
        this.authenticationManager = authenticationManager;
        this.tokenProvider = tokenProvider;
        this.userService = userService;
    }

    @PostMapping("/token")
    public ResponseEntity<?> getToken(@RequestBody AuthRequest request){
        try {
            String username = request.getUsername();
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            username, request.getPassword()));
            User user = userService.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("Пользователь " + username + " не найден"));
            String token = tokenProvider.generateToken(user);

            Map<Object, Object> response = new HashMap<>();
            response.put("username", username);
            response.put("token", token);
            return ResponseEntity.ok(response);
        } catch (LockedException e){
            return ResponseEntity.status(HttpStatus.LOCKED).body("Пользователь заблокирован");
        } catch (AuthenticationException e) {
            return ResponseEntity.badRequest().body("Неверные имя пользователя или пароль");
        }

    }

}
