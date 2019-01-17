package com.Controller;

import javafx.application.Platform;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class GameLoop {

    private BoardController boardController;
    private int speed = 1000;
    private ScheduledExecutorService service;


    public GameLoop(BoardController boardController){
        this.boardController = boardController;
        startLoop();
    }

    public void startLoop() {
        service = Executors.newScheduledThreadPool(1);
        service.scheduleAtFixedRate(oneStep(), 0, speed, TimeUnit.MILLISECONDS);
    }

    private Runnable oneStep() {
        Runnable runnable = () -> {
            try {
                Platform.runLater(() -> boardController.newGeneration());
            } catch (Exception e) {
                System.out.println(e);
            }
        };
        return runnable;
    }
}
