package com.Model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BoardTest {
    private  Board boardModel;

    @BeforeEach
    void init(){
        boardModel = new Board(100,100);
    }

    @Test
    @DisplayName("Check next generation of glider")
    void newGenerationForGliderTest() {
        boardModel.getBoard()[2][3].setAlive(true);
        boardModel.getBoard()[3][4].setAlive(true);
        boardModel.getBoard()[4][2].setAlive(true);
        boardModel.getBoard()[4][3].setAlive(true);
        boardModel.getBoard()[4][4].setAlive(true);

        boardModel.newGeneration();

//        "Should create correct generation, set proper cell alive or not"
        assertEquals(false ,boardModel.getBoard()[2][3].isAlive());
        assertEquals(true ,boardModel.getBoard()[3][4].isAlive());
        assertEquals(false ,boardModel.getBoard()[4][2].isAlive());
        assertEquals(true ,boardModel.getBoard()[4][3].isAlive());
        assertEquals(true ,boardModel.getBoard()[4][4].isAlive());
        assertEquals(true ,boardModel.getBoard()[5][3].isAlive());
        assertEquals(true ,boardModel.getBoard()[3][2].isAlive());


    }
}