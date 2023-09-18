package com.api.tia.services;

import java.util.Date;
import java.util.List;

import com.api.tia.models.VirtualToken;
import com.api.tia.models.Dto.VirtualTokenDto;

public interface VirtualTokenService {

	 VirtualTokenDto saveVirtualToken(VirtualTokenDto virtualTokenDto);
	 
	 List<VirtualTokenDto> findByOtpToken(String otpToken);
	 
	 List<VirtualTokenDto> findByUserIdAndOtpToken(Integer userId, String otpToken);
}
