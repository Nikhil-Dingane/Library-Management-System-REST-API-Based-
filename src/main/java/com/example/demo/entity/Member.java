package com.example.demo.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Member {
	
	@Id
	private String memberId;
	private String memberName;
	private String phoneNumber;
	private String memberAddress;
	
	public Member() {
		
	}

	public Member(String memberId, String memberName, String phoneNumber, String address) {
		super();
		this.memberId = memberId;
		this.memberName = memberName;
		this.phoneNumber = phoneNumber;
		this.memberAddress = address;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
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
