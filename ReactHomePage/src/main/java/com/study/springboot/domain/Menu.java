package com.study.springboot.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import lombok.Data;

@Data
@Entity
public class Menu {
	@Id
	@SequenceGenerator (
			name = "myMenuSEQ",
			sequenceName="Menu_SEQ",
			allocationSize=1
	)
	@GeneratedValue(generator="myMenuSEQ")
	private Long id;
	
	private String restaurant;  // 음식점
	private String name;		// 메뉴이름
	private Long price;
	
	@Enumerated(EnumType.STRING)
	private Type type;    // 한식, 중식, 일식
	
	@Enumerated(EnumType.STRING)
	private Taste taste;  // 순한맛, 매운맛
	
	
}
