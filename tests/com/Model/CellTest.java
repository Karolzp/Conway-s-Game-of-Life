package com.Model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CellTest {
    private  Cell cell;

    @BeforeEach
    void init() {
        cell = new Cell();
    }

    @Test
    @DisplayName("New cell is dead.")
    void isAliveTest() {
        assertFalse(cell.isAlive(), "New cell should be dead.");
    }

    @Test
    @DisplayName("Cell can be set alive and dead.")
    void setAliveTest() {
        cell.setAlive(true);
        assertTrue(cell.isAlive(), "Cell should alive after setting alive true.");
        cell.setAlive(false);
        assertFalse(cell.isAlive(), "Cell should dead after setting alive false.");
    }

    @Test
    @DisplayName("New cell has no neighbours")
    void getNeighboursTEst(){
        assertEquals(0,cell.getNeighbours());
    }
}