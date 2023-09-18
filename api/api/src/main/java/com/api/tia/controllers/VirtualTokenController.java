package com.api.tia.controllers;

import java.util.Date;
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
import com.api.tia.models.Dto.GetAllVirtualTokenHistoryDto;
import com.api.tia.models.Dto.UserDto;
import com.api.tia.models.Dto.VirtualTokenDto;
import com.api.tia.models.Dto.VirtualTokenHistoryDto;
import com.api.tia.services.imp.UserServiceImp;
import com.api.tia.services.imp.VirtualTokenHistoryServiceImp;
import com.api.tia.services.imp.VirtualTokenServiceImp;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class VirtualTokenController {
	
	@Autowired 
    private VirtualTokenServiceImp virtualTokenServiceImp;
	
	@Autowired
	private VirtualTokenHistoryServiceImp virtualTokenHistoryServiceImp;
	
	@Autowired
	private UserServiceImp userServiceImp;
	
	
    @RequestMapping(value = "/tokens/{identification}", method = RequestMethod.GET)
    public ResponseEntity<Object> generateToken(@PathVariable("identification") String identification)
    {
    	try {
    		List<UserDto> userExists = userServiceImp.findByIdentification(identification);
    		
    		if(userExists.isEmpty()) {
    			return ResponseHandler.generateResponse(true, 1, "user does not exists ", HttpStatus.OK, null);
    		}
    		
    		VirtualTokenDto virtualTokenDto = new VirtualTokenDto();
    		UserDto user =  new UserDto();
    		user.setId(userExists.get(0).getId());
    		virtualTokenDto.setUser(user);
    		virtualTokenDto = this.virtualTokenServiceImp.saveVirtualToken(virtualTokenDto);
    		
    		return ResponseHandler.generateResponse(false, 0, "OK", HttpStatus.OK, virtualTokenDto);
    		
		} catch (Exception e) {
			return ResponseHandler.generateResponse(true, 99, e.getMessage(), HttpStatus.MULTI_STATUS, null);
		}
    }
    
    @RequestMapping(value = "/usar-tokens/{identification}/{token}", method = RequestMethod.GET)
    public ResponseEntity<Object> generateToken(@PathVariable("identification") String identification,
    		@PathVariable("token") String token)
    {
    	try {
    		List<UserDto> userExists = userServiceImp.findByIdentification(identification);
    		
    		if(userExists.isEmpty()) {
    			return ResponseHandler.generateResponse(true, 1, "user does not exists ", HttpStatus.OK, null);
    		}
    		
    		List<VirtualTokenDto> tokenValid = this.virtualTokenServiceImp.findByUserIdAndOtpToken(userExists.get(0).getId(), token);
    		
    		if(tokenValid.isEmpty()) {
    			return ResponseHandler.generateResponse(true, 1, "token expired", HttpStatus.OK, null);
    		}
    		
    		VirtualTokenHistoryDto virtualTokenHistoryDto = new VirtualTokenHistoryDto();
    		virtualTokenHistoryDto.setVirtualToken(tokenValid.get(0));
    		virtualTokenHistoryDto.setDate(new Date());
    		virtualTokenHistoryDto.setTransaction("usado");
    		virtualTokenHistoryDto = this.virtualTokenHistoryServiceImp.saveVirtualToken(virtualTokenHistoryDto);
    		
    		return ResponseHandler.generateResponse(false, 0, "Successfully added data!", HttpStatus.OK, virtualTokenHistoryDto);
		} catch (Exception e) {
			// TODO: handle exception
			return ResponseHandler.generateResponse(true, 99, e.getMessage(), HttpStatus.MULTI_STATUS, null);
		}
    }
    
    @RequestMapping(value = "/token-history/{identification}", method = RequestMethod.GET)
    public ResponseEntity<Object> tokenHistory(@PathVariable("identification") String identification)
    {
    	try {
    		List<GetAllVirtualTokenHistoryDto> getAllVirtualTokenHistories = this.virtualTokenHistoryServiceImp.getAllVirtualTokenHistoryByIdentification(identification);
    		
    		return ResponseHandler.generateResponse(false, 0, "OK", HttpStatus.OK, getAllVirtualTokenHistories);
    	} catch (Exception e) {
    		// TODO: handle exception
    		return ResponseHandler.generateResponse(true, 99, e.getMessage(), HttpStatus.MULTI_STATUS, null);
    	}
    }

}
