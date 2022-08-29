package net.softsociety.exam.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;


import lombok.RequiredArgsConstructor;
import net.softsociety.exam.dao.BoardMapper;
import net.softsociety.exam.domain.Board;
import net.softsociety.exam.domain.Reply;

@Transactional(readOnly = true)
@RequiredArgsConstructor
@Service
public class BoardService {

	private final BoardMapper boardMapper;
	
	@Transactional
	public void saveBoard(Board board) {
		boardMapper.saveBoard(board);
    }
	public List<Board> findAllBoards() {
        List<Board> boards = boardMapper.findAllBoards();
        if (boards == null || boards.size() == 0) {
            return null;
        }
        return boards;
    }
}
