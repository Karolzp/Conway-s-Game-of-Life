package com.Model;

public class Board {
    private Cell[][] board;
    int numberOfColumns;
    int numberOfRows;

    public Board(int numberOfColumns, int numberOfRows){
        board = new Cell[numberOfRows][numberOfColumns];
        this.numberOfColumns = numberOfColumns;
        this.numberOfRows = numberOfRows;
        fillBoardWithCells();
    }

    public Cell[][] getBoard() {
        return board;
    }

    private void fillBoardWithCells(){
        for(int y = 0; y < numberOfRows; y++){
            for (int x = 0; x < numberOfColumns; x++){
                board[y][x] = new Cell();
            }
        }
    }

    public void newGeneration(){
        for(int y = 0; y < numberOfRows; y++) {
            for (int x = 0; x < numberOfColumns; x++) {
                countNeighboursForCell(x, y);
            }
        }
        for(int y = 0; y < numberOfRows; y++){
            for (int x = 0; x < numberOfColumns; x++){

                Cell actualCell = board[y][x];

                if (actualCell.isAlive() && (actualCell.getNeighbours() == 2 || actualCell.getNeighbours() == 3)) {
                    continue;

                    //new dot is born
                } else if (!actualCell.isAlive() && actualCell.getNeighbours() == 3) {
                    actualCell.setAlive(true);

                    //dot dies due to overpopulation, underpopulation or just doesn't born.
                } else {
                    actualCell.setAlive(false);
                }
            }
        }
    }

    private void countNeighboursForCell(int x, int y){
        Cell actualCell = board[y][x];
        int neighbours = 0;

        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {

                if (y + i >= 0 && y + i < numberOfRows && x + j >= 0 && x + j < numberOfColumns) {

                    Cell neighbourCell = board[y + i][x + j];
                    if (neighbourCell.isAlive() && neighbourCell != actualCell) {
                        neighbours++;
                    }
                }
            }
        }
        actualCell.setNeighbours(neighbours);
    }

}
