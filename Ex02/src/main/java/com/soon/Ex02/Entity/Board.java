package com.soon.Ex02.Entity;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Data
@Entity
public class Board {

	@Id // 프라이머리 키임을 지정 // import-springframework (x) , jakarta (o)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	// @GeneratedValue - 시퀀스를 지정. IDENTITY- 이 컬럼만의 고유한 시퀀스로 생성
	// 					 기본 키(primary key) 값의 자동생성
	// strategy : 
	//      - GenerationType.AUTO (기본값) : 생략가능!   
	//         JPA 구현체(예: Hibernate, EclipseLink)가 데이터베이스의 종류와 설정에 따라 자동으로 적절한 전략을 선택
	//         단, 개발초기 단계에서는 문제가 없어보일 수 있으나 데이터베이스 변경시 문제가 발생할 수 있음
	//      - GenerationType.SEQUENCE : 시퀀스 사용 - <Oracle, H2>
	//              @SequenceGenerator 애노테이션과 함께 사용될 수 있어 시퀀스의 이름, 초기값, 증가값 등을 지정 가능
	//      - GenerationType.IDENTITY : 자동 증가(auto-increment) 컬럼을 사용 -<MySQL, H2>
	//      - GenerationType.TABLE : 별도의 테이블을 사용하여 기본 키 값을 생성
	//            @TableGenerator 애노테이션과 함께 사용하여 테이블 이름, 컬럼 이름 등을 지정 가능
	//            시퀀스나 자동 증가 기능을 제공하지 않는 데이터베이스에서 사용	   
	//       ex) @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer boardNum;

	@Column(length = 100) // 게시글 제목 길이 제한두기 , 문자열 100자까지 제한
	private String boardTitle;

	private String boardCon;

	// LocalDateTime - 자바 객체 // LocalDateTime.now() - 현재 시간
	private LocalDateTime boardDate;

	// mappedBy - 참조하는 엔티티의 속성명을 알려줌
	@OneToMany(mappedBy = "board", cascade = CascadeType.REMOVE)
	private List<Reple> repleList;

	
	// @Column(unique = ) -> 이메일 등 중복되면 안되는 컬럼에 적용
}
