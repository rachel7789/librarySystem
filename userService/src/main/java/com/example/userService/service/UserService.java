package com.example.userService.service;

import com.example.userService.dto.UpdateUserRequest;
import com.example.userService.model.User;
import com.example.userService.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Page<User> getAllUsers(Pageable pageable) {
        return userRepository.findAll(pageable);
    }

    public User saveUser(User user) {
        return userRepository.save(user);
    }

    public void deleteUser(String id) {
        userRepository.deleteById(id);
    }

    public Optional<User> getUserById(String id) {
        return userRepository.findById(id);
    }

    public User updateUser(String id, UpdateUserRequest dto) {
        User existingUser = userRepository.findById(id).get();

        if (dto.getId() != null) {
        	existingUser.setId(dto.getId());
        }
		if (dto.getName() != null) {
			existingUser.setName(dto.getName());
		}
        if (dto.getPhone() != null) {
        	existingUser.setPhone(dto.getPhone());
        }
        if (dto.getAddress() != null) {
        	existingUser.setAddress(dto.getAddress());
        }

        return userRepository.save(existingUser);
    }
}
