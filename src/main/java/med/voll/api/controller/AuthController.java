package med.voll.api.controller;

import med.voll.api.domain.user.AuthData;
import med.voll.api.domain.user.entity.User;
import med.voll.api.infra.security.JTWData;
import med.voll.api.infra.security.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager manager;

    @Autowired
    private TokenService tokenService;

    @PostMapping
    public ResponseEntity<?> login(@RequestBody AuthData data) {
        var authToken = new UsernamePasswordAuthenticationToken(data.login(), data.password());
        var auth = manager.authenticate(authToken);
        var jwtToken = tokenService.generate((User) auth.getPrincipal());
        return ResponseEntity.ok(new JTWData(jwtToken));
    }

}
