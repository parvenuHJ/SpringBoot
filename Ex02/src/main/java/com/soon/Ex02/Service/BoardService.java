package com.soon.Ex02.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.soon.Ex02.DataIsNull;
import com.soon.Ex02.Entity.Board;
import com.soon.Ex02.Repository.BoardRepository;

import lombok.RequiredArgsConstructor;

//서비스는 레파지토리를 주입받고, 컨트롤러는 서비스를 주입받음 - 아래에 주입받을 것을 final로 적어줘야함
@RequiredArgsConstructor // service는 레파지토리를 주입받는다 , controller는 service를 주입받는다.
@Service
public class BoardService {
	
	private final BoardRepository boardRepository;
	
	// 게시판 전체 조회
	public List<Board> selectList(){
		return this.boardRepository.findAll(); 
	}
	
	// 게시글 상세조회
	public Board selectBoard(Integer boardNum) {
		// Optional 타입으로 받아야 함!
		// Optional 타입 = null 처리를 유연하게 하기 위해 사용하는 클래스
		// 				= isPresnt로 null 인지 아닌지를 확인한 후
		// 				  실제 객체 값을 받음
		// findById - id는 프라이머리키를 의미(프라이머리 키로 조회)
		Optional<Board> board = this.boardRepository.findById(boardNum);
		if(board.isPresent()) {
			// null 이 아닌경우
			return board.get();
			// 현재 board는 Optional 객체 - 실제 객체 내용은 get()을 통해 가져옴 / get() 은 optional이 갖고있는 내장 메소드
		}else {
			throw new DataIsNull("없는 게시글"); // null인 경우는 에러처리를 하겠다.DataIsNull() 은 내가 만든 메소드 , 만들어줘야함
		}
		
	}


	

		
	// 게시글 작성
	public void writeBoard(String boardCon, String boardTitle) {
		Board board = new Board();
		board.setBoardCon(boardCon);
		board.setBoardTitle(boardTitle);
		board.setBoardDate(LocalDateTime.now());
		this.boardRepository.save(board);
		
	}
	
	
	
	
	
	
	
	

}
