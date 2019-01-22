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
        boardView.updateBoardView(board.getBoardOfCells());
    }

    public void clearBoard() {
        this.board = new Board();
        boardView.updateBoardView(board.getBoardOfCells());
    }

    public void createGosperGliderGun() {
        board.createGosperGliderGun();
        boardView.updateBoardView(board.getBoardOfCells());
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
        if (board.getBoardOfCells()[y][x].isAlive()) {
            board.getBoardOfCells()[y][x].setAlive(false);
            boardView.getCellViewArray()[y][x].makeCellDead();
        } else {
            board.getBoardOfCells()[y][x].setAlive(true);
            boardView.getCellViewArray()[y][x].makeCellAlive();
        }
    }
}
