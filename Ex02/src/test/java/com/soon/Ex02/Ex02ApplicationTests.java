package com.soon.Ex02;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.soon.Ex02.Entity.Board;
import com.soon.Ex02.Repository.BoardRepository;



@SpringBootTest // 여기는 코드 테스트하는 곳임
class Ex02ApplicationTests {
	
	// 의존성을 주입해줌
	@Autowired // 스프링부트에서는 이렇게 의존성 주입을 안하지만, 테스트에서는 이렇게 함
	private BoardRepository boardRepository;
	
	// 테스트코드를 실행할 때는 로컬서버를 중지하고 실행해야 한다
	// 테스트코드를 실행할 때는 주입받는 파일이 같은 패키지 위치에 있어야 한다.(이름이 같음 / 지금은 com.soon.Ex02)
	@Test
	void contextLoads() {
		Board b1 = new Board();
		b1.setBoardTitle("스프링부트가 뭐냐?");
		b1.setBoardCon("그게 뭔데");
		b1.setBoardDate(LocalDateTime.now());
		this.boardRepository.save(b1); // 데이터 넣을때는 save
		
		Board b2 = new Board();
		b2.setBoardTitle("다희킴 집중하세요");
		b2.setBoardCon("훈종킴도!");
		b2.setBoardDate(LocalDateTime.now());
		this.boardRepository.save(b2);
		
	}

}
