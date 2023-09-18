package com.api.tia.services.imp;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Random;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.tia.models.User;
import com.api.tia.models.VirtualToken;
import com.api.tia.models.Dto.UserDto;
import com.api.tia.models.Dto.VirtualTokenDto;
import com.api.tia.repositories.UserRepository;
import com.api.tia.repositories.VirtualTokenRepository;
import com.api.tia.services.VirtualTokenService;

@Service
public class VirtualTokenServiceImp implements VirtualTokenService {
	
	@Autowired
	private VirtualTokenRepository virtualTokenRepository;
	
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public VirtualTokenDto saveVirtualToken(VirtualTokenDto virtualTokenDto) {
		virtualTokenDto.setUserid(virtualTokenDto.getUser().getId());
		Date date = new Date();
		virtualTokenDto.setCreatedate(date);
		
		
		Date expiredDate = (Date) date.clone();
		expiredDate.setMinutes(date.getMinutes() + 1);
		virtualTokenDto.setExpireddate(expiredDate);
		
		Random rnd = new Random();
	    int number = rnd.nextInt(999999);
	    virtualTokenDto.setOtpToken(String.format("%06d", number));
	    
		VirtualToken virtualToken = this.modelMapper.map(virtualTokenDto, VirtualToken.class);
		virtualToken.setUser(this.modelMapper.map(virtualTokenDto.getUser(), User.class));
		return this.modelMapper.map(this.virtualTokenRepository.save(virtualToken), VirtualTokenDto.class);
	}

	@Override
	public List<VirtualTokenDto> findByOtpToken(String otpToken) {
		return this.modelMapper.map(this.virtualTokenRepository.findByOtpToken(otpToken), new TypeToken<List<VirtualTokenDto>>() {}.getType());
	}

	@Override
	public List<VirtualTokenDto> findByUserIdAndOtpToken(Integer userId, String otpToken) {
		// TODO Auto-generated method stub
		return this.modelMapper.map(
				this.virtualTokenRepository.findByUserIdAndOtpTokenAndExpireddateGreaterThanEqual(userId, otpToken, new Date()), 
				new TypeToken<List<VirtualTokenDto>>() {}.getType()
			);
	}

}
