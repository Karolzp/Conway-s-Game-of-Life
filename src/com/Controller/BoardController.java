package com.Controller;

import com.Model.Board;
import com.View.BoardView;

public class BoardController {

    private Board board;
    private BoardView boardView;
    private int numerOfRows = 100;
    private int numberOfColumns = 100;

    public BoardController(){
        this.board = new Board(numberOfColumns, numerOfRows);
        this.boardView = new BoardView(this.board);

    }

    public void newGeneration(){
        board.newGeneration();
//        boardView.updateBoard();

    }
}
