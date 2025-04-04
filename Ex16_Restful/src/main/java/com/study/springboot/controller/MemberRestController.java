package com.study.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.study.springboot.domain.Member;
import com.study.springboot.dto.ResponseDto;
import com.study.springboot.dto.UserDto;
import com.study.springboot.service.MemberRestService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequestMapping("/rest")
public class MemberRestController {

	@Autowired
	MemberRestService memberRestService;

	//  http://localhost:8080/rest/test
	@GetMapping("/test")
	public String test() {
		log.info("test");
		return "test입니다.";
	}

	//  http://localhost:8080/rest/user
	//  http://localhost:8080/rest/user?id=10
	@GetMapping("/user")
	public String getMember(@RequestParam(value = "id", defaultValue = "1") String id) {
		log.info("id : {}", id);
		return "ok : " + id;
	}

	@GetMapping("/user/{id}")
	public String getId(@PathVariable("id") String id) {
		log.info("id : {}", id);
		return "ok : " + id;
	}

	//  http://localhost:8080/rest/user/10
	@PostMapping("/userdto")
	public ResponseDto saveUserDto(@RequestBody UserDto userDto) {
		Member m = memberRestService.saveUserDto(userDto);
		ResponseDto responseDto = new ResponseDto();

		if (m.getId() != null) {
			responseDto.setMessage("ok");
		} else {
			responseDto.setMessage("fail");
		}
		return responseDto;
	}

	/*
	// http://localhost:8080/swagger-ui.html
	@PostMapping("/userdto")
	public UserDto saveUserDto(@RequestBody UserDto userDto) {
		
		Member m = memberRestService.saveUserDto(userDto);
		UserDto uDto = new UserDto(m);
		
		UserDto uDto = new UserDto(memberRestService.saveUserDto(userDto));
		return uDto;
		
		
		return new UserDto(memberRestService.saveUserDto(userDto));
	}
	*/
	@GetMapping("/usetdto")
	public UserDto getUser(@RequestParam("id") String id) {
		log.info("id : {}", id);
		return memberRestService.getUserById(id);
	}

	@GetMapping("/usetdto/{id}")
	public UserDto getUserDto(@PathVariable("id") String id) {
		log.info("id : {}", id);
		return memberRestService.getUserById(id);
	}

	@GetMapping("/userall")
	public List<Member> getUserAll() {
		return memberRestService.getUserAll();
	}
}
