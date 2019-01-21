package com.View;

import com.Controller.GameController;
import com.Model.Cell;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.GridPane;

public class BoardView {

    private int numberOfRows;
    private int numberOfColumns;
    private CellView[][] cellViewArray;
    private GridPane gridPane = new GridPane();

    public BoardView(int numberOfRows, int numberOfColumns) {
        this.numberOfRows = numberOfRows;
        this.numberOfColumns = numberOfColumns;
        cellViewArray = new CellView[numberOfRows][numberOfColumns];
        setUpGrid();
        displayBoardInGridPane();
    }

    public CellView[][] getCellViewArray() {
        return cellViewArray;
    }

    private void setUpGrid() {
        gridPane.setStyle("-fx-background-color: grey");
        gridPane.setHgap(1);
        gridPane.setVgap(1);
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setPadding(new Insets(5));
        GameController.StaticMainStage.setCenter(gridPane);
    }

    private void displayBoardInGridPane() {
        for (int y = 0; y < numberOfColumns; y++) {
            for (int x = 0; x < numberOfRows; x++) {
                CellView cellView = new CellView();
                cellViewArray[y][x] = cellView;
                gridPane.add(cellView.getCellGraphicRepresentation(), x, y);
            }
        }
    }

    public void updateBoardView(Cell[][] boardOfCells) {
        for (int y = 0; y < numberOfColumns; y++) {
            for (int x = 0; x < numberOfRows; x++) {
                if (boardOfCells[y][x].isAlive()) {
                    cellViewArray[y][x].makeCellAlive();
                } else {
                    cellViewArray[y][x].makeCellDead();
                }
            }
        }
    }
}
