package com.study.springboot.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.study.springboot.domain.Member;
import com.study.springboot.dto.UserDto;
import com.study.springboot.repository.MemberRepository;

@Service
public class MemberRestService {
	
	@Autowired
	MemberRepository memberRepository;
	
	@Autowired
	PasswordEncoder pEncoder;

	public Member saveUserDto(UserDto userDto) {
		Member member = new Member();
		member.setId(userDto.getId());
		member.setName(userDto.getName());
		member.setPassword(pEncoder.encode("1234"));
		
		return memberRepository.save(member);
	}
	
	// 확인해볼것
	public UserDto getUserById(String id) {
		return null;
	}
	
	public List<Member> getUserAll() {
		return memberRepository.findAll();
	}
	
	public List<UserDto> getUserDtoAll() {
		// List<Member> mList = memberRepository.findAll();
		List<UserDto> uList = new ArrayList<>();
		for(Member m : memberRepository.findAll()) {
			uList.add(new UserDto(m));
		}
		return uList;
	}

	
	
	

}