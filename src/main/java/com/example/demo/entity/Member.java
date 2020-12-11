package com.example.demo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Member {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String memberId;
	private String memberFirstName;
	private String memberMiddleName;
	private String memberLastName;
	private String phoneNumber;
	private String memberAddress;
	
	public Member() {
		
	}

	public Member(long id, String memberId, String memberFirstName, String memberMiddleName, String memberLastName,
			String phoneNumber, String memberAddress) {
		super();
		this.id = id;
		this.memberId = memberId;
		this.memberFirstName = memberFirstName;
		this.memberMiddleName = memberMiddleName;
		this.memberLastName = memberLastName;
		this.phoneNumber = phoneNumber;
		this.memberAddress = memberAddress;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getMemberFirstName() {
		return memberFirstName;
	}

	public void setMemberFirstName(String memberFirstName) {
		this.memberFirstName = memberFirstName;
	}

	public String getMemberMiddleName() {
		return memberMiddleName;
	}

	public void setMemberMiddleName(String memberMiddleName) {
		this.memberMiddleName = memberMiddleName;
	}

	public String getMemberLastName() {
		return memberLastName;
	}

	public void setMemberLastName(String memberLastName) {
		this.memberLastName = memberLastName;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getMemberAddress() {
		return memberAddress;
	}

	public void setMemberAddress(String memberAddress) {
		this.memberAddress = memberAddress;
	}
	
}
