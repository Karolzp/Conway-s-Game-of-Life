package com.Model;

public class Board {
    private Cell[][] boardOfCells;
    private int numberOfRows = 45;
    private int numberOfColumns = 45;

    public Board() {
        boardOfCells = new Cell[numberOfRows][numberOfColumns];
        fillBoardWithCells();
    }

    public Cell[][] getBoardOfCells() {
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
                } else if (!actualCell.isAlive() && actualCell.getNeighbours() == 3) {
                    actualCell.setAlive(true);
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

    public void createGosperGliderGun() {
        fillBoardWithCells();
        int[][] cords = {{1, 5}, {1, 6}, {2, 5}, {2, 6}, {11, 5},
                {11, 6}, {11, 7}, {12, 4}, {12, 8}, {13, 3},
                {13, 9}, {14, 3}, {14, 9}, {15, 6}, {16, 4},
                {16, 8}, {17, 5}, {17, 6}, {17, 7}, {18, 6},
                {21, 3}, {21, 4}, {21, 5}, {22, 3}, {22, 4},
                {22, 5}, {23, 2}, {23, 6}, {25, 1}, {25, 2},
                {25, 6}, {25, 7}, {35, 3}, {35, 4}, {36, 3}, {36, 4}};

        for (int[] cord : cords) {
            this.boardOfCells[cord[1]][cord[0]].setAlive(true);
        }
    }
}

