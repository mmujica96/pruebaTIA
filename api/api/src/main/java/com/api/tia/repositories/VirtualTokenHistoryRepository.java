package com.api.tia.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.tia.models.VirtualToken;
import com.api.tia.models.VirtualTokenHistory;

public interface VirtualTokenHistoryRepository extends JpaRepository<VirtualTokenHistory, Integer> {
	
	List<VirtualTokenHistory> findByVirtualTokenUserIdentification(String identification);
	List<VirtualTokenHistory> findByVirtualTokenOtpToken(String otpToken);
}
