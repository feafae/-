package net.softsociety.exam.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import net.softsociety.exam.domain.Board;
import net.softsociety.exam.domain.Reply;

/**
 * ê²Œì‹œ?Œ ê´?? ¨ ë§¤í¼
 */
@Mapper
public interface BoardMapper {
	public int saveBoard(Board board);
	public List<Board> findAllBoards();
	public int getTotal(String searchText);
	
	
}
