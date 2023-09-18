package com.api.tia.repositories;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.tia.models.VirtualToken;

public interface VirtualTokenRepository extends JpaRepository<VirtualToken, Integer> {

	List<VirtualToken> findByUserIdentification(String identification);
	List<VirtualToken> findByOtpToken(String otpToken);
	List<VirtualToken> findByUserIdAndOtpTokenAndExpireddateGreaterThanEqual(Integer userId, String otpToken, Date date);
}
