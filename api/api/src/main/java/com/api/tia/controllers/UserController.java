package com.api.tia.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.api.tia.infraestructure.ResponseHandler;
import com.api.tia.models.Dto.UserDto;
import com.api.tia.services.imp.UserServiceImp;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class UserController {

    @Autowired 
    private UserServiceImp userServiceImp;
    
    // Save operation
    @PostMapping(value = "/users")
    public ResponseEntity<Object> saveUser(@RequestBody UserDto userDto)
    {
    	List<UserDto> existsUser = null;
    	try {
    		
    		userDto = this.userServiceImp.saveUser(userDto);
    		
    		return ResponseHandler.generateResponse(false, 0, "Successfully added data!", HttpStatus.OK, userDto);
		} catch (Exception e) {
			return ResponseHandler.generateResponse(true, 99, e.getMessage(), HttpStatus.MULTI_STATUS, null);
		}
    }
    
    // Read operation
    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public ResponseEntity<Object> fetchUserList()
    {
        try {
        	
        	List<UserDto> users = null;
        	users = this.userServiceImp.fetchUserList();
        	if(users == null || users.isEmpty()) {
        		return ResponseHandler.generateResponse(true, 1, "No Data Found ", HttpStatus.OK, null);
        	}
        	
        	return ResponseHandler.generateResponse(false, 0, "OK", HttpStatus.OK, users);
    	} catch (Exception e) {
			return ResponseHandler.generateResponse(true, 99, e.getMessage(), HttpStatus.MULTI_STATUS, null);
		}
    }
    
    // Update operation
    @RequestMapping(value = "/users/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Object> updateUser(@RequestBody UserDto userDto, @PathVariable("id") Integer userId)
    {
    	try {
    		userDto = this.userServiceImp.updateUser(userDto, userId);
    		return ResponseHandler.generateResponse(false, 0, "Successfully updated data!", HttpStatus.OK, userDto);
		} catch (Exception e) {
			// TODO: handle exception
			return ResponseHandler.generateResponse(true, 99, e.getMessage(), HttpStatus.MULTI_STATUS, null);
		}
    }
    
    // Delete operation
    @RequestMapping(value = "/users/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> deleteUserById(@PathVariable("id") Integer userId)
    {
    	try {
    		this.userServiceImp.deleteUserById(userId);
    		return ResponseHandler.generateResponse(false, 0, "Successfully deleted data!", HttpStatus.OK, null);
    	}
    	catch (Exception e) {
			return ResponseHandler.generateResponse(true, 99, e.getMessage(), HttpStatus.MULTI_STATUS, null);
		}
        
    }
}
