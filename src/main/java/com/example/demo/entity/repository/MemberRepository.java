package com.example.demo.entity.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.entity.Member;

public interface MemberRepository extends CrudRepository<Member,Long> {

}
