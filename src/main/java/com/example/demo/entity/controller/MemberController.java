package com.example.demo.entity.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Member;
import com.example.demo.entity.service.MemberService;

@RestController
public class MemberController {
	
	@Autowired
	private MemberService memberService;
	
	@RequestMapping("/members")
	public List<Member> getAllMembers() {
		return memberService.getAllMembers();
	}	
	
	@RequestMapping("/members/{id}")
	public Member getMember(@PathVariable String id) {
		return memberService.getMember(id);
	}
	
	@RequestMapping(method=RequestMethod.POST,value="/members")
	public Member addTopic(@RequestBody Member member) {
		memberService.addMember(member);
		return member;
	}
	
	@RequestMapping(method=RequestMethod.PUT,value="/members/{id}")
	public Member updateTopic(@RequestBody Member member, @PathVariable String id) {
		memberService.updateMember(id,member);
		return member;
	}
	
	@RequestMapping(method=RequestMethod.DELETE,value="/members/{id}")
	public void deleteTopic(@PathVariable String id) {
		memberService.deleteMember(id);
	}
}
