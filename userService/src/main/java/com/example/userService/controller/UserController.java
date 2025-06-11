package com.example.userService.controller;

import com.example.userService.dto.UpdateUserRequest;
import com.example.userService.model.User;
import com.example.userService.service.UserService;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;





import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<User> getAll() {
        return userService.getAllUsers();
    }

    @PostMapping
    public ResponseEntity<User> create(@RequestBody @Valid User user) {
        User savedUser = userService.saveUser(user);
        return ResponseEntity
            .status(HttpStatus.CREATED)
            .body(savedUser);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        userService.deleteUser(id);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<User>> getUserById(@PathVariable String id) {
        Optional<User> user = userService.getUserById(id);
        return ResponseEntity.ok(user);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable String id, @RequestBody UpdateUserRequest updatedUser) {
        User user = userService.updateUser(id, updatedUser);
        return ResponseEntity.ok(user);
    }

}
