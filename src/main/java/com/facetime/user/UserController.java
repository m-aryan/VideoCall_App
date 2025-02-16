package com.facetime.user;

import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
@Slf4j
public class UserController {

    private final UserService service;

    @PostMapping
    public void register(User user) {
        service.register(user);
    }

    // Login a User
    @PostMapping("/login")
    public User login(User user) {
        return service.login(user);
    }


    // Logout a User
    @PostMapping("/logout")
    public void logout(String email){
        service.logout(email);
    }


    @GetMapping
    public List<User> findAll() {
        return service.findAll();
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handle(Exception e){
        e.printStackTrace();
        return ResponseEntity
            .status(INTERNAL_SERVER_ERROR)
            .body(e.getMessage());
    }

}
