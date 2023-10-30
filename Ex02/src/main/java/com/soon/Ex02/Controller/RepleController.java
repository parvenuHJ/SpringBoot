package com.soon.Ex02.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.soon.Ex02.Entity.Board;
import com.soon.Ex02.Entity.Reple;
import com.soon.Ex02.Service.BoardService;
import com.soon.Ex02.Service.RepleService;

import ch.qos.logback.core.model.Model;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor //서비스는 레파지토리를 주입받고, 컨트롤러는 서비스를 주입받음 - 아래에 주입받을 것을 final로 적어줘야함
public class RepleController {

	private final BoardService boardService;
	private final RepleService repleService;
	
	// 댓글 다는 기능
	@PostMapping("/reple/create/{boardNum}") // "/reple/create/{boardNum}" -> PathVarible -> 사용자가 보는 url 
	public String createReple(@PathVariable("boardNum")Integer boardNum, @RequestParam String repleCon) { // @RequestParam - 컨트롤러 메서드에서 HTTP 요청의 매개변수를 추출
		Board board = this.boardService.selectBoard(boardNum);															//   주로 get, post 요청에서 url 매개변수, 요청 매개변수를 추출하는데 사용
		this.repleService.createReple(board, repleCon);													// board_detail.html 에서 id = "repleCon"을 받아오려고!!
		return "redirect:/board/detail/"+boardNum; // String 형식으로 적어야되니까 +boardNum;
		
	}
	
}
