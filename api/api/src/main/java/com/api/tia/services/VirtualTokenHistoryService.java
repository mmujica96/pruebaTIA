package com.api.tia.services;

import java.util.List;

import com.api.tia.models.Dto.GetAllVirtualTokenHistoryDto;
import com.api.tia.models.Dto.VirtualTokenHistoryDto;

public interface VirtualTokenHistoryService {

	VirtualTokenHistoryDto saveVirtualToken(VirtualTokenHistoryDto virtualTokenHistoryDto);
	
	List<GetAllVirtualTokenHistoryDto> getAllVirtualTokenHistoryByIdentification(String identification);
}
