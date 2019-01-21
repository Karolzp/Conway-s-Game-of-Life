package com.Controller;

import javafx.application.Platform;
import javafx.scene.control.Button;

import java.awt.event.ActionEvent;
import java.util.EventListener;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class GameLoop {

    private  boolean isRunning = false;
    private BoardController boardController;
    private int speed = 500;
    private ScheduledExecutorService service;


    public GameLoop(BoardController boardController){
        this.boardController = boardController;
    }

    public void handleStartBtn(Button startBtn){
        if(isRunning){
            stopGame();
            startBtn.setText("START");
        }else {
            startGame();
            startBtn.setText("STOP");
        }
    }

    private void startGame(){
        startLoop();
        this.isRunning = true;

    }

    private void stopGame(){
        service.shutdown();
        this.isRunning = false;
    }

    private void startLoop() {
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
