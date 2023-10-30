package com.soon.Ex02;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication // 스프링 부트의 자동설정, 스프링 Bean 읽기와 생성을 모두 자동으로 설정됨 ,
					   // @SpringBootApplication 이 있는 위치부터 설정을 읽어가기 때문에 이 클래스는 항상 프로젝트의 최상단에 위치해야 함
public class Ex02Application {

	public static void main(String[] args) {
		SpringApplication.run(Ex02Application.class, args); // SpringApplication.run -> 내장 WAS(Web Application Server) 를 실행 => 톰캣 설치 필요 없음 
																// (외장 WAS를 설치 안하니까 배포 시, 종류 버전등 다른 사람들과 일치시킬 필요 없어서 편함)
	}

}
