package net.softsociety.exam.domain;

import lombok.Data;


@Data
public class WriteBoardForm {
    private String title;
    private String content;

    public Board toBoard() {
        Board board = new Board();
        board.setTitle(title);
        board.setContent(content);
        return board;
    }
}