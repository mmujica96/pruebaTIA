package com.api.tia.models.Dto;


import java.util.Date;

public class VirtualTokenHistoryDto {

	private Integer id;
	
	private Date date;
	
	private String transaction;
	
	private Integer virtualtokenid;

	private VirtualTokenDto virtualToken;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getTransaction() {
		return transaction;
	}

	public void setTransaction(String transaction) {
		this.transaction = transaction;
	}

	public Integer getVirtualtokenid() {
		return virtualtokenid;
	}

	public void setVirtualtokenid(Integer virtualtokenid) {
		this.virtualtokenid = virtualtokenid;
	}

	public VirtualTokenDto getVirtualToken() {
		return virtualToken;
	}

	public void setVirtualToken(VirtualTokenDto virtualToken) {
		this.virtualToken = virtualToken;
	}

	
	
}
