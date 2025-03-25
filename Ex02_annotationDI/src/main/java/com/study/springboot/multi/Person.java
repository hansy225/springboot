package com.study.springboot.multi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

// 명시적으로 이름을 등록하지 않으면 소문자인 person으로 등록이 됨
@Component
public class Person {
	@Value("더조은")
	private String name; // = "더조은"
	
	@Value("학원")
	private String nickname; // = "학원"
	
	@Autowired 			    // 자동으로 객체를 찾아서 bean으로 등록해줌. 하나일 때는 자동으로 등록해줌
	@Qualifier("printerA")  // 하나 이상일 때는 명시해 줘야 됨
	private Printer printer;
	
	public Person() { }

	public Person(String name, String nickname, Printer printer) {
		this.name = name;
		this.nickname = nickname;
		this.printer = printer;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public Printer getPrinter() {
		return printer;
	}

	public void setPrinter(Printer printer) {
		this.printer = printer;
	}
	
	public void print() {
		printer.print("Hello " + name + ": " + nickname);
	}
}
