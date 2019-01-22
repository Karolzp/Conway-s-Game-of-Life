package com.Controller;

import com.Model.Board;
import com.View.BoardView;
import com.View.CellView;

public class BoardController {

    private Board board;
    private BoardView boardView;

    public BoardController() {
        this.board = new Board();
        this.boardView = new BoardView(board.getNumberOfRows(), board.getNumberOfColumns());
        setUpOnMouseEvents();
    }

    public void newGeneration() {
        board.newGeneration();
        boardView.updateBoardView(board.getboardOfCells());
    }

    public void clearBoard() {
        this.board = new Board();
        boardView.updateBoardView(board.getboardOfCells());
    }

    public void setUpOnMouseEvents() {
        CellView[][] cellViewArray = this.boardView.getCellViewArray();
        for (int y = 0; y < board.getNumberOfRows(); y++) {
            for (int x = 0; x < board.getNumberOfColumns(); x++) {
                int finalY = y;
                int finalX = x;
                cellViewArray[y][x].getCellGraphicRepresentation().setOnMouseClicked(event -> handleClickedCell(finalX, finalY));
            }
        }
    }

    private void handleClickedCell(int x, int y) {
        if (board.getboardOfCells()[y][x].isAlive()) {
            board.getboardOfCells()[y][x].setAlive(false);
            boardView.getCellViewArray()[y][x].makeCellDead();
        } else {
            board.getboardOfCells()[y][x].setAlive(true);
            boardView.getCellViewArray()[y][x].makeCellAlive();
        }
    }

    public void createGosperGliderGun() {
        board.createGosperGliderGun();
        boardView.updateBoardView(board.getboardOfCells());
    }
}
