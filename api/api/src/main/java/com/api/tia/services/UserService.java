package com.api.tia.services;

import java.util.List;

import com.api.tia.models.User;
import com.api.tia.models.Dto.UserDto;

public interface UserService {
	// Save operation
	UserDto saveUser(UserDto userDto);
 
    // Read operation
    List<UserDto> fetchUserList();
 
    // Update operation
    UserDto updateUser(UserDto userDto, Integer userId);
 
    // Delete operation
    void deleteUserById(Integer userId);
    
    List<UserDto> findByMail(String mail);
    
    List<UserDto> findByMailAndPassword(String mail, String pass);
    
    List<UserDto> findByIdentification(String identification);
}
