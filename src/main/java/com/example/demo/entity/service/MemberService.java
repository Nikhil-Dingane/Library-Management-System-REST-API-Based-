package com.example.demo.entity.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Member;
import com.example.demo.entity.repository.MemberRepository;

@Service
public class MemberService {
	
	@Autowired
	private MemberRepository memberRepository;
	
	public List<Member> getAllMembers() {
		List<Member> members = new ArrayList<>();
		memberRepository.findAll()
		.forEach(members::add);
		return members;
	}
	
	public Optional<Member> getMember(String id) {
		return memberRepository.findById(id);
	}
	
	public void addMember(Member member) {
		memberRepository.save(member);
	}
	
	public Member updateMember(String id, Member member) {
		return memberRepository.save(member);
	}

	public void deleteMember(String Id) {
		memberRepository.deleteById(Id);
	}	
}


