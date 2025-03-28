package com.study.springboot.controller;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.study.springboot.domain.Member;
import com.study.springboot.service.MemberService;

@Controller
public class MemberController {
	@Autowired
	MemberService memberService;
	
	@RequestMapping("/")
	public String root() {
		return "menu";
	}
	
	@RequestMapping("/insert")
	public String insert(@RequestParam("username") String name, Model model) {
		/*
			Member member2 = new Member();
			member2.setUsername(name);
			member2.setCreateDate(LocalDate.now());
		*/
		Member member = Member.builder()
							  .username(name)
							  .createDate(LocalDate.now())
							  .build();
		Member result =  memberService.insert(member);
		
		model.addAttribute("member", result);
		
		return "insert";
	}
	
	@RequestMapping("/select")
	public String select(@RequestParam("id") Long id, Model model) {
		
		/*
			Optional<T> : NullpointException 발생을 방지하기 위해
						  기존의 반환 값 타입 T에 Opional<T>를 wrapping하여,
						  null 대신 Opional 안에 빈 타입 객체를 돌려주는 기법
				ex) Member member = memberRepository.findById("user01"); => 없는 아이디
					member.getUserName(); => NullpointException
		*/
		
		Optional<Member> result =  memberService.select(id);
		if(result.isPresent()) {  // .isPresent() : 데이터가 있는지 없는지 체크
			model.addAttribute("member", result.get());
		} else {
			model.addAttribute("member", null);
		}
		return "select";
	}
	
	@RequestMapping("/selectAll")
	public String selectAll(Model model) {
		List<Member> result = memberService.selectAll();
		model.addAttribute("members", result);
		return "selectAll";
	}
	
	@RequestMapping("/delete")
	public String delete(@RequestParam(value = "id", required = false)Long id, Model model) {
		if (id != null) {
	        memberService.delete(id);
	    }
	    List<Member> members = memberService.selectAll();
	    model.addAttribute("members", members);
		return "selectAll";
	}
	
}
