package com.api.tia.services.imp;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.tia.models.VirtualToken;
import com.api.tia.models.VirtualTokenHistory;
import com.api.tia.models.Dto.VirtualTokenHistoryDto;
import com.api.tia.models.Dto.GetAllVirtualTokenHistoryDto;
import com.api.tia.repositories.VirtualTokenHistoryRepository;
import com.api.tia.repositories.VirtualTokenRepository;
import com.api.tia.services.VirtualTokenHistoryService;

@Service
public class VirtualTokenHistoryServiceImp implements VirtualTokenHistoryService {
	
	@Autowired
	private VirtualTokenHistoryRepository virtualTokenHistoryRepository;
	
	@Autowired
	private VirtualTokenRepository VirtualTokenRepository;
	
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public VirtualTokenHistoryDto saveVirtualToken(VirtualTokenHistoryDto virtualTokenHistoryDto) {
		VirtualTokenHistory virtualTokenHistory = this.modelMapper.map(virtualTokenHistoryDto, VirtualTokenHistory.class);
		
		return this.modelMapper.map(virtualTokenHistoryRepository.save(virtualTokenHistory), VirtualTokenHistoryDto.class);
	}

	@Override
	public List<GetAllVirtualTokenHistoryDto> getAllVirtualTokenHistoryByIdentification(String identification) {
		// TODO Auto-generated method stub
		
		List<VirtualToken> virtualTokens = this.VirtualTokenRepository.findByUserIdentification(identification);
		List<GetAllVirtualTokenHistoryDto> getAllVirtualTokenHistories = new ArrayList<GetAllVirtualTokenHistoryDto>();
		virtualTokens.forEach(item -> {
			GetAllVirtualTokenHistoryDto des = new GetAllVirtualTokenHistoryDto();
			List<VirtualTokenHistory> virtualTokenHistories = this.virtualTokenHistoryRepository.findByVirtualTokenOtpToken(item.getOtpToken());
			des.setId(item.getId());
			des.setOtpToken(item.getOtpToken());
			des.setCreatedate(item.getCreatedate());
			des.setExpireddate(item.getExpireddate());
			des.setFirstname(item.getUser().getFirstname());
			des.setLastname(item.getUser().getLastname());
			des.setIdentification(item.getUser().getIdentification());
			if(!virtualTokenHistories.isEmpty()) {
				virtualTokenHistories.forEach(itemhistory -> {
					GetAllVirtualTokenHistoryDto deshistory = new GetAllVirtualTokenHistoryDto();
					deshistory = des;
					deshistory.setDate(itemhistory.getDate());
					deshistory.setTransaction(itemhistory.getTransaction());
					getAllVirtualTokenHistories.add(deshistory);
				});
			}
			else {
				getAllVirtualTokenHistories.add(des);
			}
		});
		
		return getAllVirtualTokenHistories;
	}

}
