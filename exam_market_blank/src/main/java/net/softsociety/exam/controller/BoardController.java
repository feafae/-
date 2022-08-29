package net.softsociety.exam.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.springboot_board_v4.model.board.WriteBoardForm;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.softsociety.exam.domain.Board;
import net.softsociety.exam.domain.Reply;
import net.softsociety.exam.service.BoardService;

/**
 * �긽�뭹寃뚯떆�뙋 愿��젴 肄섑듃濡ㅻ윭
 */
@RequiredArgsConstructor
@RequestMapping("board")
@Controller
public class BoardController {
	private final BoardService boardService;
	
	@GetMapping(value = "/write")
    public String writeForm(Model model) {
        model.addAttribute("writeBoardForm", new WriteBoardForm());
        return "board/writeForm";
    }

}
