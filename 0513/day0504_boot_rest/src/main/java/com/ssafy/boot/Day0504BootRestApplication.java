package com.ssafy.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication // com.ssafy.boot 라는 root 패키지의 하위 패키지를 모두 스캔중
public class Day0504BootRestApplication {

	public static void main(String[] args) {
		SpringApplication.run(Day0504BootRestApplication.class, args);
	}

}
