package com.api.tia.models;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="virtualtokenhistories")
public class VirtualTokenHistory  {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	private Date date;
	
	private String transaction;
	
	@Column(name="virtualtokenid", insertable=false, updatable=false, nullable=false)
	private Integer virtualtokenid;

	@ManyToOne
	@JoinColumn(name="virtualtokenid")
	private VirtualToken virtualToken;

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

	public VirtualToken getVirtualToken() {
		return virtualToken;
	}

	public void setVirtualToken(VirtualToken virtualToken) {
		this.virtualToken = virtualToken;
	}

	
}
