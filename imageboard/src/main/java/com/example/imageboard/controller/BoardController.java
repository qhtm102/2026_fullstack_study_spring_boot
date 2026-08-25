package com.example.imageboard.controller;

import com.example.imageboard.dto.BoardCreateRequest;
import com.example.imageboard.dto.BoardResponse;
import com.example.imageboard.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping(path = { "/boards" })
@RequiredArgsConstructor // final 및 @NonNull annotation이 적용된 필드를 전달인자로 하는 생성자 메서드 자동 구현
public class BoardController {

    private final BoardService boardService;

    /** 게시글 목록 */
    @GetMapping(path = { "", "/", "/list" })
    public String list(Model model) {
        List<BoardResponse> boards = boardService.findAll();
        model.addAttribute("boards", boards); // Model 타입 전달인자에 데이터를 저장하면 View에서 사용할 수 있습니다.
//        return "board/list-old";           // templates/board/list-old.html
        return "board/list";           // templates/board/list-old.html
    }

    /** 게시글 상세 */
    @GetMapping("/{id}")
    public String detail(@PathVariable(name = "id") Long id, Model model) {
        BoardResponse board = boardService.findById(id);
        model.addAttribute("board", board);
        return "board/detail";         // templates/board/detail.html
    }

    /** 게시글 작성 폼 */
    @GetMapping("/create")
    public String createForm(Model model) {
        model.addAttribute("boardCreateRequest", new BoardCreateRequest());
        return "board/create";         // templates/board/create.html
    }

    /** 게시글 저장 */
    @PostMapping
    public String create(BoardCreateRequest request, Model model) {
        System.out.println(request.getTitle() + " / " + request.getContent());
        Long id = boardService.create(request);
        return "redirect:/boards/" + id;
    }

}