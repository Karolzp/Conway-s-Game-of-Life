package com.Model;

public class Board {
    private Cell[][] boardOfCells;
    private int numberOfRows = 38;
    private int numberOfColumns = 38;

    public Board() {
        boardOfCells = new Cell[numberOfRows][numberOfColumns];
        fillBoardWithCells();
    }

    public Cell[][] getboardOfCells() {
        return boardOfCells;
    }

    public int getNumberOfRows() {
        return numberOfRows;
    }

    public int getNumberOfColumns() {
        return numberOfColumns;
    }

    private void fillBoardWithCells() {
        for (int y = 0; y < numberOfRows; y++) {
            for (int x = 0; x < numberOfColumns; x++) {
                boardOfCells[y][x] = new Cell();
            }
        }
    }

    public void newGeneration() {
        for (int y = 0; y < numberOfRows; y++) {
            for (int x = 0; x < numberOfColumns; x++) {
                countNeighboursForCell(x, y);
            }
        }
        for (int y = 0; y < numberOfRows; y++) {
            for (int x = 0; x < numberOfColumns; x++) {
                Cell actualCell = boardOfCells[y][x];

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

    private void countNeighboursForCell(int x, int y) {
        Cell actualCell = boardOfCells[y][x];
        int neighbours = 0;

        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                if (y + i >= 0 && y + i < numberOfRows && x + j >= 0 && x + j < numberOfColumns) {
                    Cell neighbourCell = boardOfCells[y + i][x + j];
                    if (neighbourCell.isAlive() && neighbourCell != actualCell) {
                        neighbours++;
                    }
                }
            }
        }
        actualCell.setNeighbours(neighbours);
    }
}
