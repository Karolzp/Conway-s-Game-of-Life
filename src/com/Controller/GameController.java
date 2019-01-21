package com.Controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.layout.BorderPane;

import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.net.URL;
import java.util.EventListener;
import java.util.ResourceBundle;

public class GameController implements Initializable {

    public Button startBtn;
    public Slider speedSlider;
    public BorderPane MainStage;

    public static BorderPane StaticMainStage;

    private BoardController boardController;
    private GameLoop gameLoop;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        this.StaticMainStage = this.MainStage;
        this.boardController = new BoardController();
        this.gameLoop = new GameLoop(boardController);
    }

    @FXML
    void handleStartBtn(){
        this.gameLoop.handleStartBtn(startBtn);
    }


}
