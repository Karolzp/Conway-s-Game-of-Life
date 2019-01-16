package com.Model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BoardTest {
    private  Board boardModel;

    @BeforeEach
    void init(){
        boardModel = new Board();
    }

    @Test
    @DisplayName("Check next generation of glider")
    void newGenerationForGliderTest() {
        boardModel.getboardOfCells()[2][3].setAlive(true);
        boardModel.getboardOfCells()[3][4].setAlive(true);
        boardModel.getboardOfCells()[4][2].setAlive(true);
        boardModel.getboardOfCells()[4][3].setAlive(true);
        boardModel.getboardOfCells()[4][4].setAlive(true);

        boardModel.newGeneration();

//        "Should create correct generation, set proper cell alive or not"
        assertEquals(false ,boardModel.getboardOfCells()[2][3].isAlive());
        assertEquals(true ,boardModel.getboardOfCells()[3][4].isAlive());
        assertEquals(false ,boardModel.getboardOfCells()[4][2].isAlive());
        assertEquals(true ,boardModel.getboardOfCells()[4][3].isAlive());
        assertEquals(true ,boardModel.getboardOfCells()[4][4].isAlive());
        assertEquals(true ,boardModel.getboardOfCells()[5][3].isAlive());
        assertEquals(true ,boardModel.getboardOfCells()[3][2].isAlive());


    }
}