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
// 기본값으로 카멜케이스이름 -> 언더스코어이름 으로 매칭함 (ex) SalesManager.java -> sales_manager table)
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
						  // 테이블의 칼럼을 나타내며, 굳이 선언하지 않더라도 해당 클래스의 필드는 모두 컬림이 됨
						  // 사용하는 이유 : 기본값 외에 추가로 변경이 필요한 옵션이 있으면 사용
						  // 문자열의 경우 varchar(255)가 기본값
	private String boardTitle;

	private String boardCon;

	// LocalDateTime - 자바 객체 // LocalDateTime.now() - 현재 시간
	private LocalDateTime boardDate;

	// mappedBy - 참조하는 엔티티의 속성명을 알려줌
	@OneToMany(mappedBy = "board", cascade = CascadeType.REMOVE)
	private List<Reple> repleList;

	
	// @Column(unique = ) -> 이메일 등 중복되면 안되는 컬럼에 적용
}
