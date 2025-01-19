package com.example.nob2v2.security.jwt;

import com.example.nob2v2.security.CustomUser;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    private final AuthenticationManager manager;

    public LoginController(AuthenticationManager authenticationManager) {
        this.manager = authenticationManager;
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody CustomUser user){
        UsernamePasswordAuthenticationToken token  = new UsernamePasswordAuthenticationToken(
                user.getUsername(),
                user.getPassword()
        );
        // this will fault if the credentials no valid
        System.out.println("HEJ HOJ 1");
        Authentication authentication = manager.authenticate(token);
        System.out.println("HEJ HOJ 2");
        SecurityContextHolder.getContext().setAuthentication(authentication);
        System.out.println("HEJ HOJ 3");
        String jwtToken = JWTUtil.generateToken((User) authentication.getPrincipal());
        return ResponseEntity.ok(jwtToken);


    }
}
