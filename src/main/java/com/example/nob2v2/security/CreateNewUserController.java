package com.example.nob2v2.security;

import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class CreateNewUserController {

    private final PasswordEncoder encoder;

    private final CustomUserRepository customUserRepository;

    public CreateNewUserController(PasswordEncoder encoder, CustomUserRepository customUserRepository) {
        this.encoder = encoder;
        this.customUserRepository = customUserRepository;
    }

    @PostMapping("/createnewuser")

    public ResponseEntity<String> createNewUser(@RequestBody CustomUser user){

        Optional<CustomUser> optinalUser = customUserRepository.findById(user.getUsername());
        if(!optinalUser.isPresent()){
            customUserRepository.save(new CustomUser(user.getUsername(), encoder.encode(user.getPassword())));
            return ResponseEntity.ok("Success");

        }

        return ResponseEntity.badRequest().body("Failure");
    }

}
