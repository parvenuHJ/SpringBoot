package com.soon.Ex02.Controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.soon.Ex02.Entity.Board;
import com.soon.Ex02.Repository.BoardRepository;
import com.soon.Ex02.Service.BoardService;

import lombok.RequiredArgsConstructor;

@RequestMapping("/board")

// 서비스는 레파지토리를 주입받고, 컨트롤러는 서비스를 주입받음 - 아래에 주입받을 것을 final로 적어줘야함
@RequiredArgsConstructor // RequiredArgsConstructor - final이 붙은 속성을 포함하는 생성자를 자동으로 생성해 줌 - 의존성 주입의 한 방법 (@autowired 같은느낌 -@autowired 는 주입할 것마다 적어줘야함 / 이거는 final만 붙이면됨)
@Controller
public class BoardController {

	// 의존성 주입
    private final BoardRepository boardRepository;
	private final BoardService boardService;
	
	@GetMapping("/main")
	public String goBoardMain(Model model) {
		List<Board> boardList = this.boardRepository.findAll();
		model.addAttribute(boardList);
		return "board_main";
	}
	
	
	@GetMapping("/")
	public String boardHome(Model model) {
		// findAll - 테이블의 모든 데이터를 조회
		List<Board> boardList = this.boardService.selectList();
		model.addAttribute(boardList);
		return "board_home";
	}

	// 게시글 상세조회
	@GetMapping("/board/detail/{boardNum}")
	public String boardDetail(Model model, @PathVariable("boardNum") Integer boardNum) {
		Board board = this.boardService.selectBoard(boardNum);
		model.addAttribute(board);
		return "board_detail";
	}

	// 게시글 등록화면으로 이동
	@GetMapping("/board/create")
	public String createBoard() {
		return "create_board";
	}
	
	// 게시글 등록
	@PostMapping("/board/create")
	public String createBoard(@RequestParam String boardCon, @RequestParam String boardTitle) {
		this.boardService.writeBoard(boardCon, boardTitle);
		return "redirect:/board";
	}
}
