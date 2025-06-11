package com.example.userService.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class UpdateUserRequest {
	private String id;
	private String name;
    private String phone;
    private String address;
    
    // Getters & Setters
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id; //?????
    }
    
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
}

