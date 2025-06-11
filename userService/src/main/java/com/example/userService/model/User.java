package com.example.userService.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;
import com.example.userService.validation.ValidId;




@Entity
@Data
public class User {

    @Id
    @Column(length = 9, unique = true)
    @ValidId
//    @Pattern(regexp = "\\d{9}", message = "ID must be exactly 9 digits")
    private String id; // ת"ז

    @NotBlank(message = "employee name can't be left empty")
    @Size(min = 2, message = "Minimum 2 letters")
    private String name;
    @Pattern(regexp = "\\d{10}", message = "Phone number must be exactly 10 digits")
//    @Column(length = 10)
    private String phone;

    @Size(
        min = 10, max = 100,
        message= "Address should have a length between 10 and 100 characters.")
    private String address;

	public Object map(Object object) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public String getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	public String getPhone() {
		return phone;
	}
	
	public String getAddress() {
		return address;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
}
