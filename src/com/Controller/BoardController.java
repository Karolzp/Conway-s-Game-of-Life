package com.Controller;

import com.Model.Board;
import com.View.BoardView;

public class BoardController {

    private Board board;
    private BoardView boardView;

    public BoardController(){
        this.board = new Board();
        this.boardView = new BoardView(this.board);

    }

    public void newGeneration(){

    }
}
