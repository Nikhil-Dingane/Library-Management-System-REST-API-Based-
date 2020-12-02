package com.example.demo.entity.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Member;

@Service
public class MemberService {
	
	private List<Member> members = new ArrayList<>(Arrays.asList(
			new Member("1","Kaustubh Wadagavi","9689798879","Kadegaon"),	
			new Member("2","Nikhil Dingane","9370481188","Kadegaon")
		));
	
	public List<Member> getAllMembers() {
		return members;
	}
	
	public Member getMember(String id) {
		for(int i=0; i<members.size();i++) {
			Member m = members.get(i);
			if(m.getMemberId().equals(id)) {
				return m;
			}
		}
		return null;
	}
	
	public void addMember(Member member) {
		members.add(member);
	}
	
	public Member updateMember(String id, Member member) {
		for(int i=0; i<members.size();i++) {
			Member m = members.get(i);
			if(m.getMemberId().equals(id)) {
				members.set(i, member);
				return member;
			}
		}
		return null;
	}

	public Member deleteMember(String Id) {
		for(int i = 0; i < members.size(); i++) {
			if(members.get(i).getMemberId().contentEquals(Id)) {
				return members.remove(i);
			}
		}
		return null;
	}	
}


