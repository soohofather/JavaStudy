package com.example.boardwithhan.controller;

import org.springframework.ui.Model;
import com.example.boardwithhan.entity.Board;
import com.example.boardwithhan.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class BoardController {

    @Autowired
    private BoardService boardService;

    @GetMapping("/board/write")
    public String boardWriterForm() {

        return "boardwrite";
    }

    @PostMapping("/board/writepro")
//    public String boardWritePro(String title, String content) {
    public String boardWritePro(Board board) {

        boardService.write(board);

        return "";
    }

    @GetMapping("board/list")
    public String boardList(Model model) {

        model.addAttribute("list", boardService.boardList());

        return "boardlist";
    }

    @GetMapping("/board/view")
    public String boardView(Model model, Integer id) {

        model.addAttribute("board", boardService.boardView(id));

        return "boardview";
    }

}
